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
 * Represents the door close request
 *
 */
public class FridgeDoorCloseEvent extends EventObject {
	public FridgeDoorCloseEvent(Object source) {
		super(source);
	}
}
