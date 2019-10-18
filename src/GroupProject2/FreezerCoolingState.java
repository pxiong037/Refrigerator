package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
/**
 * Represents the state of the refrigerator when the door is closed. When the
 * refrigerator has its door closed, the run method of this class is called. After
 * that, when an event occurs, the handle method is invoked.
 */
public class FreezerCoolingState extends RefrigeratorState implements FreezerDoorOpenListener,
	FreezerTimerTickedListener, FreezerTimerRanOutListener{
	private static FreezerCoolingState instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerCoolingState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		FreezerDoorOpenManager.instance().removeFreezerDoorOpenListener(this);
		FreezerTimerTickedManager.instance().removeFreezerTimerTickedListener(this);
		FreezerTimerRanOutManager.instance().removeFreezerTimerRanOutListener(this);
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static FreezerCoolingState instance() {
		if (instance == null) {
			instance = new FreezerCoolingState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */
	@Override
	public void freezerDoorOpened(FreezerDoorOpenEvent event) {
		context.changeCurrentFreezerState(FreezerDoorOpenState.instance());
	}

	@Override
	public void freezerTimerRanOut(FreezerTimerRanOutEvent event) {
		decreaseFreezerTemp(1);
		FreezerTimer.instance().addTimeValue(freezerCoolRate);
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
		if(freezerTemp == desiredFreezerTemp) {
			context.changeCurrentFreezerState(FreezerIdleState.instance());
		} 
		display.freezerTemp(freezerTemp);
	}

	@Override
	public void freezerTimerTicked(FreezerTimerTickedEvent event) {
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void run() {
		FreezerTimer.instance().setTimeValue(freezerCoolRate);
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
		FreezerDoorOpenManager.instance().addFreezerDoorOpenListener(this);
		FreezerTimerTickedManager.instance().addFreezerTimerTickedListener(this);
		FreezerTimerRanOutManager.instance().addFreezerTimerRanOutListener(this);
		display.freezerDoorClosed();
		display.turnFreezerLightOff();
		display.freezerCooling();
	}
}