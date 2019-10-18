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

/**
 * To be implemented by any class that waits for timer ticks

 *
 */
public interface FreezerTimerTickedListener extends EventListener {
	/**
	 * When the timer ticks, this method gets called
	 * 
	 * @param event
	 *            the event object
	 */
	public void freezerTimerTicked(FreezerTimerTickedEvent event);
}
