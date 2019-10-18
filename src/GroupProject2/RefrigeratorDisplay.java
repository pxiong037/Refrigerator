package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.util.Observable;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public abstract class RefrigeratorDisplay extends Observable {
	protected static RefrigeratorContext context;
	protected static RefrigeratorDisplay instance;
	protected String roomTempField;
	protected String fridgeTempField;
	protected String freezerTempField;

	/**
	 * Initializes the context and instance
	 */
	protected RefrigeratorDisplay() {
		instance = this;
		context = RefrigeratorContext.instance();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static RefrigeratorDisplay instance() {
		return instance;
	}

	/**
	 * Do the initializations to make the context an observer
	 */
	public void initialize() {
		context.initialize();
	}
	
	public String getRoomTempField() {
		return roomTempField;
	}


	public void setRoomTempField(String roomTempField) {
		this.roomTempField = roomTempField;
	}


	public String getFridgeTempField() {
		return fridgeTempField;
	}


	public void setFridgeTempField(String fridgeTempField) {
		this.fridgeTempField = fridgeTempField;
	}


	public String getFreezerTempField() {
		return freezerTempField;
	}


	public void setFreezerTempField(String freezerTempField) {
		this.freezerTempField = freezerTempField;
	}

	/**
	 * Indicate that the fridge light is off
	 */
	public abstract void turnFridgeLightOff();

	/**
	 * Indicate that the fridge light is on
	 */
	public abstract void turnFridgeLightOn();

	/**
	 * Indicate that the freezer light is off
	 */
	public abstract void turnFreezerLightOff();

	/**
	 * Indicate that the freezer light is on
	 */
	public abstract void turnFreezerLightOn();


	/**
	 * Indicate that the fridge door is now closed
	 */
	public abstract void fridgeDoorClosed();

	/**
	 * Indicate that the fridge door is now open
	 */
	public abstract void fridgeDoorOpened();

	/**
	 * Indicate that the freezer door is now open
	 */
	public abstract void freezerDoorClosed();
	/**
	 * Indicate that the freezer door is now open
	 */
	
	public abstract void freezerDoorOpened();
	
	public abstract void fridgeCooling();
	
	public abstract void fridgeIdle();
	
	public abstract void freezerCooling();
	
	public abstract void freezerIdle();
	
	public abstract void desiredFridgeTemp(int fridgeTemp);
	
	public abstract void desiredFreezerTemp(int freezerTemp);
	
	public abstract void fridgeTemp(int fridgeTemp);
	
	public abstract void freezerTemp(int freezerTemp);
	
	public abstract void fridgeTimer(int time);
	
	public abstract void freezerTimer(int time);
	
//	public abstract void fridgeCoolingTimer(int time);
//	
//	public abstract void freezerCoolingTimer(int time);
//	
//	public abstract void fridgeIdleTimer(int time);
//	
//	public abstract void freezerIdleTimer(int time);
}