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
 * the timer runs out.
 *
 */
public class FreezerTimerRanOutManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerTimerRanOutManager instance;

	/**
	 * Private for making the class a singleton
	 */
	private FreezerTimerRanOutManager() {
	}

	/**
	 * Returns the instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerTimerRanOutManager instance() {
		if (instance == null) {
			instance = new FreezerTimerRanOutManager();
		}
		return instance;
	}

	/**
	 * Add a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addFreezerTimerRanOutListener(FreezerTimerRanOutListener listener) {
		listenerList.add(FreezerTimerRanOutListener.class, listener);
	}

	/**
	 * Remove a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeFreezerTimerRanOutListener(FreezerTimerRanOutListener listener) {
		listenerList.remove(FreezerTimerRanOutListener.class, listener);
	}

	/**
	 * Process the event by calling the FreezerTimerRanOutEvent method of the listener
	 * 
	 * @param event
	 *            the FreezerTimerRanOutEvent object
	 */
	public void processEvent(FreezerTimerRanOutEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerTimerRanOutListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerTimerRanOutListener) listeners[index]).freezerTimerRanOut(event);
		}
	}
}
