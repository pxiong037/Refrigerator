package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.util.EventObject;

/**
 * The class represents the ticking of a timer.

 *
 */
public class FreezerTimerTickedEvent extends EventObject {
	/**
	 * Creates an instance. Does not store any info.
	 * 
	 * @param source
	 *            the creator
	 */
	public FreezerTimerTickedEvent(Object source) {
		super(source);
	}

}
