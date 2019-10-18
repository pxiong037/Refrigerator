package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
 
public class GUIDisplay extends RefrigeratorDisplay implements ActionListener {
	private static SimpleDisplay frame;
	/**
	 * Creates the frame and displays it.
	 */
	private GUIDisplay() {
		frame = new SimpleDisplay();
		initialize();
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
	 * Inner class because the outer class extends RefrigeratorDisplay.
	 *
	 */
	private class SimpleDisplay extends JFrame {		
		private static final long serialVersionUID = 1L;
		private GUIButton setRoomTemp= new SetRoomTempButton("Set room temp");
		private GUIButton setDesiredFridgeTemp= new SetDesiredFridgeTempButton("Set desired fridge temp");
		private GUIButton setDesiredFreezerTemp= new SetDesiredFreezerTempButton("Set desired freezer temp");
		private GUIButton doorFridgeCloser = new FridgeDoorCloseButton("close fridge door");
		private GUIButton doorFreezerCloser = new FreezerDoorCloseButton("close freezer door");
		private GUIButton doorFridgeOpener = new FridgeDoorOpenButton("open fridge door");
		private GUIButton doorFreezerOpener = new FreezerDoorOpenButton("open freezer door");

		private JTextField setRoomTempField = new JTextField(10);
		private JTextField setFridgeTempField = new JTextField(10);
		private JTextField setFreezerTempField = new JTextField(10);
		
		private JLabel roomTemp = new JLabel("Room temp");
		private JLabel desiredFridgeTemp = new JLabel("Desired fridge temp");
		private JLabel desiredFreezerTemp = new JLabel("Desired freezer temp");
		private JLabel fridgeDoorStatus = new JLabel("Fridge Door Closed");
		private JLabel freezerDoorStatus = new JLabel("Freezer Door Closed"); 
		private JLabel fridgeLightStatus = new JLabel("Fridge Light Off");
		private JLabel freezerLightStatus = new JLabel("Freezer Light Off");
		private JLabel desiredFridgesTemperature = new JLabel("Desired Fridge Temp: " );
		private JLabel desiredFreezersTemperature = new JLabel("Desire Freezer Temp: " );
		private JLabel fridgesTemperature = new JLabel("Fridge Temp: " );
		private JLabel freezersTemperature = new JLabel("Freezer Temp: " );
		private JLabel fridgeCoolingStatus = new JLabel("Fridge idle");
		private JLabel freezerCoolingStatus = new JLabel("Freezer idle");
		private JLabel fridgeTimer = new JLabel("Fridge Timer: ");
		private JLabel freezerTimer = new JLabel("Freezer Timer: ");

		/**
		 * Set up the JFrame
		 */
		private SimpleDisplay() {
			super("Refrigerator");
			getContentPane().setLayout(new BorderLayout());
				
			JPanel setTempPanel = new JPanel();
			GridLayout setTempGrid = new GridLayout (3,6, 30, 30);
			TitledBorder setTempBorder = new TitledBorder("Temperature Control");
			setTempBorder.setTitleFont(new Font("Arial", Font.PLAIN, 16));
			setTempBorder.setTitleColor(Color.red);
			setTempPanel.setBorder(setTempBorder);
			setTempPanel.setLayout(setTempGrid);
			
			setTempPanel.add(roomTemp);
			setTempPanel.add(setRoomTempField);
			setTempPanel.add(setRoomTemp);
			setTempPanel.add(desiredFridgeTemp);
			setTempPanel.add(setFridgeTempField);
			setTempPanel.add(setDesiredFridgeTemp);
			setTempPanel.add(desiredFreezerTemp);
			setTempPanel.add(setFreezerTempField);
			setTempPanel.add(setDesiredFreezerTemp);
			
			setRoomTemp.addActionListener(GUIDisplay.this);
			setDesiredFridgeTemp.addActionListener(GUIDisplay.this);
			setDesiredFreezerTemp.addActionListener(GUIDisplay.this);

			setRoomTemp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					roomTempField = setRoomTempField.getText();
				}
			});
			
			setDesiredFridgeTemp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fridgeTempField = setFridgeTempField.getText();
				}
			});
			
			setDesiredFreezerTemp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					freezerTempField = setFreezerTempField.getText();
				}
			});
			
			JPanel buttonPanel = new JPanel();
	    	GridLayout buttonGrid = new GridLayout(0, 2, 10, 10);
	    	buttonPanel.setLayout(buttonGrid);    	
		
			buttonPanel.add(doorFridgeOpener);
			buttonPanel.add(doorFridgeCloser);
			buttonPanel.add(doorFreezerOpener);
			buttonPanel.add(doorFreezerCloser);	
			
			doorFridgeCloser.addActionListener(GUIDisplay.this);
			doorFreezerCloser.addActionListener(GUIDisplay.this);
			doorFridgeOpener.addActionListener(GUIDisplay.this);
			doorFreezerOpener.addActionListener(GUIDisplay.this);
			doorFreezerOpener.addActionListener(GUIDisplay.this);		
			
			JPanel statusPanel = new JPanel();
			TitledBorder statusBorder = new TitledBorder("Status");
			statusBorder.setTitleFont(new Font("Arial", Font.PLAIN, 16));
			statusBorder.setTitleColor(Color.red);
			statusPanel.setBorder(statusBorder);
			GridLayout statusGrid = new GridLayout(6, 2, 50, 20);
			statusPanel.setLayout(statusGrid);    	

			statusPanel.add(fridgeDoorStatus);
			statusPanel.add(freezerDoorStatus);
			statusPanel.add(fridgeLightStatus);
			statusPanel.add(freezerLightStatus);
			statusPanel.add(fridgesTemperature);
			statusPanel.add(freezersTemperature);
			statusPanel.add(desiredFridgesTemperature);
			statusPanel.add(desiredFreezersTemperature);
			statusPanel.add(fridgeCoolingStatus);
			statusPanel.add(freezerCoolingStatus);
			statusPanel.add(fridgeTimer);
			statusPanel.add(freezerTimer);
			
			getContentPane().add(setTempPanel, BorderLayout.PAGE_START);
			getContentPane().add(buttonPanel, BorderLayout.CENTER);
			getContentPane().add(statusPanel, BorderLayout.PAGE_END);
			
			pack();
			setVisible(true);
		}
	}
	
	   
    /**
	 * No conditionals. Let the clicked button do the hard work.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		((GUIButton) event.getSource()).inform(this);
	}

	
	/**
	 * Display a text indicating that the fridge light is off
	 */
	@Override
	public void turnFridgeLightOff() {
		frame.fridgeLightStatus.setText("Fridge Light Off");
	}
	/**
	 * Display a text indicating that the fridge light is off
	 */
	@Override
	public void turnFridgeLightOn() {
		frame.fridgeLightStatus.setText("Fridge Light On");
	}
	
	/**
	 * Display a text indicating that the fridge light is off
	 */
	@Override
	public void turnFreezerLightOn() {
		frame.freezerLightStatus.setText("Freezer Light On");
	}

	/**
	 * Display a text indicating that the freezer light is off
	 */
	@Override
	public void turnFreezerLightOff() {
		frame.freezerLightStatus.setText("Freezer Light Off");
	}
	
	/**
	 * Display a text indicating that the door is closed
	 */
	@Override
	public void fridgeDoorClosed() {
		frame.fridgeDoorStatus.setText("Fridge Door Closed");
	}

	/**
	 * Display a text indicating that the door is closed
	 */
	@Override
	public void fridgeDoorOpened() {
		frame.fridgeDoorStatus.setText("Fridge Door Opened");
	}
	/**
	 * Display a text indicating that the door is closed
	 */
	@Override
	public void freezerDoorClosed() {
		frame.freezerDoorStatus.setText("Freezer Door Closed");
	}
	/**
	 * Display a text indicating that the door is closed
	 */
	@Override
	public void freezerDoorOpened() {
		frame.freezerDoorStatus.setText("Freezer Door Opened");
	}
	
	public void fridgeCooling() {
		frame.fridgeCoolingStatus.setText("Fridge Cooling");
	}
	
	public void fridgeIdle() {
		frame.fridgeCoolingStatus.setText("Fridge Idle");
	}
	
	public void freezerCooling() {
		frame.freezerCoolingStatus.setText("Freezer Cooling");
	}
	
	public void freezerIdle() {
		frame.freezerCoolingStatus.setText("Freezer Idle");
	}
	
	public void desiredFridgeTemp(int fridgeTemp) {
		frame.desiredFridgesTemperature.setText("Desired Fridge Temp: " + fridgeTemp);
	}
	
	public void desiredFreezerTemp(int freezerTemp) {
		frame.desiredFreezersTemperature.setText("Desired Freezer Temp: " + freezerTemp);
	}
	
	public void fridgeTemp(int fridgeTemp) {
		frame.fridgesTemperature.setText("Fridge Temp: " + fridgeTemp);
	}
	
	public void freezerTemp(int freezerTemp) {
		frame.freezersTemperature.setText("Freezer Temp: " + freezerTemp);
	}
	
	@Override
	public void fridgeTimer(int time) {
		frame.fridgeTimer.setText("Fridge Timer: " + time);
	}

	@Override
	public void freezerTimer(int time) {
		frame.freezerTimer.setText("Freezer Timer: " + time);
	}
     
	/**
	 * Start the whole show
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		GetPropertyValues properties = new GetPropertyValues();
		try {
			properties.getPropValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RefrigeratorDisplay display = new GUIDisplay();
	}
}