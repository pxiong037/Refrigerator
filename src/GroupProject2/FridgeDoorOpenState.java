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
public class FridgeDoorOpenState extends RefrigeratorState implements FridgeDoorCloseListener, 
	FridgeTimerTickedListener, FridgeTimerRanOutListener{
	private static FridgeDoorOpenState instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeDoorOpenState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		FridgeDoorCloseManager.instance().removeFridgeDoorCloseListener(this);
		FridgeTimerTickedManager.instance().removeFridgeTimerTickedListener(this);
		FridgeTimerRanOutManager.instance().removeFridgeTimerRanOutListener(this);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FridgeDoorOpenState instance() {
		if (instance == null) {
			instance = new FridgeDoorOpenState();
		}
		return instance;
	}
	
	/**
	 * Process door closed event
	 */
	@Override
	public void fridgeDoorClosed(FridgeDoorCloseEvent event) {
		context.changeCurrentFridgeState(FridgeDoorCloseState.instance());
	}

	@Override
	public void fridgeTimerRanOut(FridgeTimerRanOutEvent event) {
		FridgeTimer.instance().addTimeValue(fridgeRateLossDoorOpen);
		display.fridgeTimer(FridgeTimer.instance().getTimeValue());
		if(fridgeTemp < roomTemperature) {
			increaseFridgeTemp(1);
		}
		display.fridgeTemp(fridgeTemp);
	}

	@Override
	public void fridgeTimerTicked(FridgeTimerTickedEvent event) {
		display.fridgeTimer(FridgeTimer.instance().getTimeValue());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		FridgeTimer.instance().setTimeValue(fridgeRateLossDoorOpen);
		display.fridgeTimer(FridgeTimer.instance().getTimeValue());
		FridgeDoorCloseManager.instance().addFridgeDoorCloseListener(this);
		FridgeTimerTickedManager.instance().addFridgeTimerTickedListener(this);
		FridgeTimerRanOutManager.instance().addFridgeTimerRanOutListener(this);
		display.turnFridgeLightOn();
		display.fridgeDoorOpened();
		display.fridgeIdle();
	}

}