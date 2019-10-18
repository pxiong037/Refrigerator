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
 * Orchestrates clicks on the Door Close button. It maintains a list of
 * listeners for the DoorCloseEvent and invokes their doorClosed method when the
 * button is clicked.
 *
 */
public class SetDesiredFridgeTempManager {
	private EventListenerList listenerList = new EventListenerList();
	private static SetDesiredFridgeTempManager instance;

	/**
	 * Private to make it a singleton
	 */
	private SetDesiredFridgeTempManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static SetDesiredFridgeTempManager instance() {
		if (instance == null) {
			instance = new SetDesiredFridgeTempManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addSetDesiredFridgeTempListener(SetDesiredFridgeTempListener listener) {
		listenerList.add(SetDesiredFridgeTempListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeSetDesiredFridgeTempListener(SetDesiredFridgeTempListener listener) {
		listenerList.remove(SetDesiredFridgeTempListener.class, listener);
	}

	/**
	 * Handles the request to close the door.
	 * 
	 * @param event
	 *            the SetDesiredFridgeTempEvent object
	 */
	public void processEvent(SetDesiredFridgeTempEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(SetDesiredFridgeTempListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((SetDesiredFridgeTempListener) listeners[index]).setDesiredFridgeTemp(event);
		}
	}
}
