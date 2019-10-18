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

public class FridgeTimerRanOutEvent extends EventObject {
	/**
	 * The event is created with the identity of the
	 * 
	 * @param source
	 *            the object that created the event
	 */
	public FridgeTimerRanOutEvent(Object source) {
		super(source);
	}

}
