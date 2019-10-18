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
public class SetDesiredFreezerTempManager {
	private EventListenerList listenerList = new EventListenerList();
	private static SetDesiredFreezerTempManager instance;

	/**
	 * Private to make it a singleton
	 */
	private SetDesiredFreezerTempManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static SetDesiredFreezerTempManager instance() {
		if (instance == null) {
			instance = new SetDesiredFreezerTempManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addSetDesiredFreezerTempListener(SetDesiredFreezerTempListener listener) {
		listenerList.add(SetDesiredFreezerTempListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeSetDesiredFreezerTempListener(SetDesiredFreezerTempListener listener) {
		listenerList.remove(SetDesiredFreezerTempListener.class, listener);
	}

	/**
	 * Handles the request to close the door.
	 * 
	 * @param event
	 *            the SetDesiredFreezerTempEvent object
	 */
	public void processEvent(SetDesiredFreezerTempEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(SetDesiredFreezerTempListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((SetDesiredFreezerTempListener) listeners[index]).setDesiredFreezerTemp(event);
		}
	}
}
