package GroupProject2;
import javax.swing.JOptionPane;

/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
/**
 * Super class for all states
 * 
 *
 */
public abstract class RefrigeratorState implements SetDesiredFridgeTempListener, 
SetDesiredFreezerTempListener, SetRoomTempListener {
	protected static RefrigeratorContext context;
	protected static RefrigeratorDisplay display;
	protected static Integer fridgeTemp;
	protected static int desiredFridgeTemp;
	protected static int fridgeLow;
	protected static int fridgeHigh;
	protected static int fridgeRateLossDoorOpen;
	protected static int fridgeCompressorStartDiff;
	protected static int tempFridgeCompressorStartDiff;
	protected static int fridgeCoolRate;
	protected static int fridgeRateLossDoorClosed;
	protected static Integer freezerTemp;
	protected static int desiredFreezerTemp;
	protected static int freezerLow;
	protected static int freezerHigh;
	protected static int freezerRateLossDoorOpen;
	protected static int freezerCompressorStartDiff;
	protected static int freezerCoolRate;
	protected static int freezerRateLossDoorClosed;
	protected static Integer roomTemperature;
	protected static int roomLow;
	protected static int roomHigh;
	protected static boolean desiredFreezerTempExecuted;
	protected static boolean desiredFridgeTempExecuted;
	protected static boolean roomTempExecuted;

	/**
	 * Initializes the context and display
	 */
	protected RefrigeratorState() {
		context = RefrigeratorContext.instance();
		display = context.getDisplay();
		SetDesiredFridgeTempManager.instance().addSetDesiredFridgeTempListener(this); 
		SetDesiredFreezerTempManager.instance().addSetDesiredFreezerTempListener(this);
		SetRoomTempManager.instance().addSetRoomTempListener(this);
		GetPropertyValues properties = new GetPropertyValues();
		fridgeLow = properties.getFridgeLow();
		fridgeHigh = properties.getFridgeHigh();
		fridgeRateLossDoorClosed = properties.getFridgeRateLossDoorClosed();
		fridgeRateLossDoorOpen = properties.getFridgeRateLossDoorOpen();
		fridgeCompressorStartDiff = properties.getFridgeCompressorStartDiff();
		fridgeCoolRate = properties.getFridgeCoolRate();
		freezerLow = properties.getFreezerLow();
		freezerHigh = properties.getFreezerHigh();
		freezerRateLossDoorClosed = properties.getFreezerRateLossDoorClosed();
		freezerRateLossDoorOpen = properties.getFreezerRateLossDoorOpen();
		freezerCompressorStartDiff = properties.getFreezerCompressorStartDiff();
		freezerCoolRate = properties.getFreezerCoolRate();
		roomLow = properties.getRoomLow();
		roomHigh = properties.getRoomHigh();
	}

	@Override
	public void setRoomTemp(SetRoomTempEvent event) {
		try {
			int roomTemp = Integer.parseInt(display.roomTempField);
			setRoomTemperature(roomTemp);
			if(desiredFreezerTempExecuted == true && desiredFridgeTempExecuted == true && roomTempExecuted == false) {
				FridgeTimer.instance().setTimeValue(fridgeCoolRate);
				FreezerTimer.instance().setTimeValue(freezerCoolRate);
				RefrigeratorState.roomTempExecuted = true;
			} else if(desiredFreezerTempExecuted == true && roomTempExecuted == false){
				RefrigeratorState.fridgeTemp = roomTemp;
				RefrigeratorState.freezerTemp = roomTemp;
				display.fridgeTemp(RefrigeratorState.fridgeTemp);
				display.freezerTemp(RefrigeratorState.freezerTemp);
				FreezerTimer.instance().setTimeValue(freezerCoolRate);
				RefrigeratorState.roomTempExecuted = true;
			} else if(desiredFridgeTempExecuted == true && roomTempExecuted == false) {
				RefrigeratorState.fridgeTemp = roomTemp;
				RefrigeratorState.freezerTemp = roomTemp;
				display.fridgeTemp(RefrigeratorState.fridgeTemp);
				display.freezerTemp(RefrigeratorState.freezerTemp);
				FridgeTimer.instance().setTimeValue(fridgeCoolRate);
				RefrigeratorState.roomTempExecuted = true;
			}
			
			if(!roomTempExecuted) {
				RefrigeratorState.roomTempExecuted = true;
				RefrigeratorState.fridgeTemp = roomTemp;
				RefrigeratorState.freezerTemp = roomTemp;
				display.fridgeTemp(RefrigeratorState.fridgeTemp);
				display.freezerTemp(RefrigeratorState.freezerTemp);
			}
		} catch(Exception e){
			if(e instanceof NumberFormatException) {
				infoBox("Please enter an integer.", "NumberFormatException");
			} else if(e instanceof IllegalArgumentException){
				infoBox("The room temperature cannot exceed the room high of " + RefrigeratorState.roomHigh +
						" and the room temperature cannot be less than the room low of " + RefrigeratorState.roomLow, "IllegalArgumentException");
			}
		}
	}

	@Override
	public void setDesiredFreezerTemp(SetDesiredFreezerTempEvent event) {
		try {
			int freezerTemp = Integer.parseInt(display.freezerTempField);
			setDesiredFreezerTemp(freezerTemp);
			display.desiredFreezerTemp(RefrigeratorState.desiredFreezerTemp);
			if(roomTempExecuted == true && desiredFreezerTempExecuted == false) {
				FreezerTimer.instance().setTimeValue(1);
			}else if(!desiredFreezerTempExecuted) {
				RefrigeratorState.desiredFreezerTempExecuted = true;
			}
		} catch(Exception e){
			if(e instanceof NumberFormatException) {
				infoBox("Please enter an integer.", "NumberFormatException");
			} else if(e instanceof IllegalArgumentException){
				infoBox("The desired freezer temperature cannot be lower than the fridge low of " + RefrigeratorState.freezerLow +
						" and higher than the freezer high of " + RefrigeratorState.freezerHigh, "IllegalArgumentException");
			}
		}
	}

	@Override
	public void setDesiredFridgeTemp(SetDesiredFridgeTempEvent event) {
		try {
			int fridgeTemp = Integer.parseInt(display.fridgeTempField);
			setDesiredFridgeTemp(fridgeTemp);
			display.desiredFridgeTemp(RefrigeratorState.desiredFridgeTemp);
			if(roomTempExecuted == true && desiredFridgeTempExecuted == false) {
				FridgeTimer.instance().setTimeValue(1);
			}else if(!desiredFridgeTempExecuted) {
				RefrigeratorState.desiredFridgeTempExecuted = true;
			}
		} catch(Exception e) {
			if(e instanceof NumberFormatException) {
				infoBox("Please enter an integer.", "NumberFormatException");
			} else if(e instanceof IllegalArgumentException){
				infoBox("The desired fridge temperature cannot be lower than the fridge low of " + RefrigeratorState.fridgeLow +
						" and higher than the fridge high of " + RefrigeratorState.fridgeHigh, "IllegalArgumentException");
			}
		}
	}

	public void setDesiredFridgeTemp(int fridgeTemp) {
		if(fridgeTemp > RefrigeratorState.fridgeHigh || fridgeTemp < RefrigeratorState.fridgeLow) {
			throw new IllegalArgumentException();
		} else {
			RefrigeratorState.desiredFridgeTemp = fridgeTemp;
		}
	}

	public static void infoBox(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public void setDesiredFreezerTemp(int freezerTemp) {
		if(freezerTemp > RefrigeratorState.freezerHigh || freezerTemp < RefrigeratorState.freezerLow) {
			throw new IllegalArgumentException();
		} else {
			RefrigeratorState.desiredFreezerTemp = freezerTemp;
		}
	}

	public void setRoomTemperature(int roomTemperature) {
		if(roomTemperature < RefrigeratorState.roomLow || roomTemperature > RefrigeratorState.roomHigh) {
			throw new IllegalArgumentException();
		} else {
			RefrigeratorState.roomTemperature = roomTemperature;
		}
	}
	
	public void increaseFridgeTemp(int amount) {
		fridgeTemp += amount;
	}
	
	public void decreaseFridgeTemp(int amount) {
		fridgeTemp -= amount;
	}
	
	public void increaseFreezerTemp(int amount) {
		freezerTemp += amount;
	}
	
	public void decreaseFreezerTemp(int amount) {
		freezerTemp -= amount;
	}

	public abstract void run();

	public abstract void leave();

}
