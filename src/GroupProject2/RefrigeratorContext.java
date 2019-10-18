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
 * The context is an obserer for the clock and stores the context info for
 * states
 *
 */
public class RefrigeratorContext {
	private static RefrigeratorDisplay refrigeratorDisplay;
	private RefrigeratorState fridgeCurrentState;
	private RefrigeratorState freezerCurrentState;
	private static RefrigeratorContext instance;

	/**
	 * Make it a singleton
	 */
	private RefrigeratorContext() {
		instance = this;
		refrigeratorDisplay = RefrigeratorDisplay.instance();
		fridgeCurrentState = FridgeDoorCloseState.instance();
		freezerCurrentState = FreezerDoorCloseState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static RefrigeratorContext instance() {
		if (instance == null) {
			instance = new RefrigeratorContext();
		}
		return instance;
	}

	/**
	 * lets door closed state be the starting state adds the object as an
	 * observable for clock
	 */
	public void initialize() {
		instance.changeCurrentFridgeState(FridgeDoorCloseState.instance());
		instance.changeCurrentFreezerState(FreezerDoorCloseState.instance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentFridgeState(RefrigeratorState nextState) {
		fridgeCurrentState.leave();
		fridgeCurrentState = nextState;
		nextState.run();
	}
	
	public void changeCurrentFreezerState(RefrigeratorState nextState) {
		freezerCurrentState.leave();
		freezerCurrentState = nextState;
		nextState.run();
	}

	/**
	 * Gets the display
	 * 
	 * @return the display
	 */
	public RefrigeratorDisplay getDisplay() {
		return refrigeratorDisplay;
	}
}