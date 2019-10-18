package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * Orchestrates clicks on the Door Open button. It maintains a list of listeners
 * for the DoorOpenEvent and invokes their doorOpened method when the button is
 * clicked.
 *
 */
public class FridgeDoorOpenManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FridgeDoorOpenManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeDoorOpenManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeDoorOpenManager instance() {
		if (instance == null) {
			instance = new FridgeDoorOpenManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFridgeDoorOpenListener(FridgeDoorOpenListener listener) {
		listenerList.add(FridgeDoorOpenListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFridgeDoorOpenListener(FridgeDoorOpenListener listener) {
		listenerList.remove(FridgeDoorOpenListener.class, listener);
	}

	/**
	 * Handles the request to open the door.
	 * 
	 * @param event
	 *            the FridgeDoorOpenListener object
	 */
	public void processEvent(FridgeDoorOpenEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeDoorOpenListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeDoorOpenListener) listeners[index]).fridgeDoorOpened(event);
		}
	}
}

