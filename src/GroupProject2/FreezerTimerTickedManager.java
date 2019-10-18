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
 * This class manages the listeners associated with states that must act when
 * the timer ticks.

 *
 */
public class FreezerTimerTickedManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerTimerTickedManager instance;

	/**
	 * The constructor is private to ensure that it is a singleton
	 */
	private FreezerTimerTickedManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerTimerTickedManager instance() {
		if (instance == null) {
			instance = new FreezerTimerTickedManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addFreezerTimerTickedListener(FreezerTimerTickedListener listener) {
		listenerList.add(FreezerTimerTickedListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeFreezerTimerTickedListener(FreezerTimerTickedListener listener) {
		listenerList.remove(FreezerTimerTickedListener.class, listener);
	}

	/**
	 * Processes the event by calling the freezerTimerTicked method of each listener
	 * 
	 * @param event
	 */
	public void processEvent(FreezerTimerTickedEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerTimerTickedListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerTimerTickedListener) listeners[index]).freezerTimerTicked(event);
		}
	}
}
