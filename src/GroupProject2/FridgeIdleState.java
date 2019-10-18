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
public class FridgeIdleState extends RefrigeratorState implements FridgeDoorOpenListener, 
FridgeTimerTickedListener, FridgeTimerRanOutListener{
	private static FridgeIdleState instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeIdleState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		FridgeDoorOpenManager.instance().removeFridgeDoorOpenListener(this);
		FridgeTimerTickedManager.instance().removeFridgeTimerTickedListener(this);
		FridgeTimerRanOutManager.instance().removeFridgeTimerRanOutListener(this);
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static FridgeIdleState instance() {
		if (instance == null) {
			instance = new FridgeIdleState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */
	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		context.changeCurrentFridgeState(FridgeDoorOpenState.instance());
	}

	@Override
	public void fridgeTimerRanOut(FridgeTimerRanOutEvent event) {
		increaseFridgeTemp(1);
		if(fridgeTemp < desiredFridgeTemp + fridgeCompressorStartDiff) {
			FridgeTimer.instance().addTimeValue(fridgeRateLossDoorClosed);
			display.fridgeTimer(FridgeTimer.instance().getTimeValue());
		} else {
			context.changeCurrentFridgeState(FridgeCoolingState.instance());
		}
		display.fridgeTemp(fridgeTemp);
	}

	@Override
	public void fridgeTimerTicked(FridgeTimerTickedEvent event) {
		display.fridgeTimer(FridgeTimer.instance().getTimeValue());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void run() {
		FridgeTimer.instance().setTimeValue(fridgeRateLossDoorClosed);
		display.fridgeTimer(FridgeTimer.instance().getTimeValue());
		FridgeDoorOpenManager.instance().addFridgeDoorOpenListener(this);
		FridgeTimerTickedManager.instance().addFridgeTimerTickedListener(this);
		FridgeTimerRanOutManager.instance().addFridgeTimerRanOutListener(this);
		display.fridgeDoorClosed();
		display.turnFridgeLightOff();
		display.fridgeIdle();
	}
}