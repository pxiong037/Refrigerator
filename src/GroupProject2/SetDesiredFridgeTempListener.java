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
public interface SetDesiredFridgeTempListener extends EventListener {
	public void setDesiredFridgeTemp(SetDesiredFridgeTempEvent event);
}
