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
 * Represents the state of the refrigerator when the door is open. When the
 * refrigerator has its door opened, the run method of this class is called. After
 * that, when an event occurs, the handle method is invoked.
 */
public class FreezerDoorOpenState extends RefrigeratorState implements FreezerDoorCloseListener, 
	FreezerTimerTickedListener, FreezerTimerRanOutListener{
	private static FreezerDoorOpenState instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerDoorOpenState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		FreezerDoorCloseManager.instance().removeFreezerDoorCloseListener(this);
		FreezerTimerTickedManager.instance().removeFreezerTimerTickedListener(this);
		FreezerTimerRanOutManager.instance().removeFreezerTimerRanOutListener(this);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FreezerDoorOpenState instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenState();
		}
		return instance;
	}
	
	/**
	 * Process door closed event
	 */
	@Override
	public void freezerDoorClosed(FreezerDoorCloseEvent event) {
		context.changeCurrentFreezerState(FreezerDoorCloseState.instance());
	}

	@Override
	public void freezerTimerRanOut(FreezerTimerRanOutEvent event) {
		FreezerTimer.instance().addTimeValue(freezerRateLossDoorOpen);
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
		if(freezerTemp < roomTemperature) {
			increaseFreezerTemp(1);
		}		
		display.freezerTemp(freezerTemp);
	}

	@Override
	public void freezerTimerTicked(FreezerTimerTickedEvent event) {
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		FreezerTimer.instance().setTimeValue(freezerRateLossDoorOpen);
		display.freezerTimer(FreezerTimer.instance().getTimeValue());
		FreezerDoorCloseManager.instance().addFreezerDoorCloseListener(this);
		FreezerTimerTickedManager.instance().addFreezerTimerTickedListener(this);
		FreezerTimerRanOutManager.instance().addFreezerTimerRanOutListener(this);
		display.turnFreezerLightOn();
		display.freezerDoorOpened();
		display.freezerIdle();
	}
}