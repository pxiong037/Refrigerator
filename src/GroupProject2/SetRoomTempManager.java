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
public class SetRoomTempManager {
	private EventListenerList listenerList = new EventListenerList();
	private static SetRoomTempManager instance;

	/**
	 * Private to make it a singleton
	 */
	private SetRoomTempManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static SetRoomTempManager instance() {
		if (instance == null) {
			instance = new SetRoomTempManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addSetRoomTempListener(SetRoomTempListener listener) {
		listenerList.add(SetRoomTempListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeSetRoomTempListener(SetRoomTempListener listener) {
		listenerList.remove(SetRoomTempListener.class, listener);
	}

	/**
	 * Handles the request to close the door.
	 * 
	 * @param event
	 *            the SetRoomTempEvent object
	 */
	public void processEvent(SetRoomTempEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(SetRoomTempListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((SetRoomTempListener) listeners[index]).setRoomTemp(event);
		}
	}
}
