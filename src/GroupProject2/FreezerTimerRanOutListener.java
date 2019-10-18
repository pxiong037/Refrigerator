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
 * Any class that wants to listen to timer going off should implement this
 * interface.
 *
 */
public interface FreezerTimerRanOutListener extends EventListener {
	/**
	 * This method should implement the functionality to handle the situation of
	 * the timer running out.
	 * 
	 * @param event
	 *            the description of the event
	 */
	public void freezerTimerRanOut(FreezerTimerRanOutEvent event);
}
