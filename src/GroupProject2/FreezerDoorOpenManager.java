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
public class FreezerDoorOpenManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerDoorOpenManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerDoorOpenManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerDoorOpenManager instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFreezerDoorOpenListener(FreezerDoorOpenListener listener) {
		listenerList.add(FreezerDoorOpenListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFreezerDoorOpenListener(FreezerDoorOpenListener listener) {
		listenerList.remove(FreezerDoorOpenListener.class, listener);
	}

	/**
	 * Handles the request to open the door.
	 * 
	 * @param event
	 *            the FreezerDoorOpenEvent object
	 */
	public void processEvent(FreezerDoorOpenEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerDoorOpenListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerDoorOpenListener) listeners[index]).freezerDoorOpened(event);
		}
	}
}

