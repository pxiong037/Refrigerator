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
public interface SetRoomTempListener extends EventListener {
	public void setRoomTemp(SetRoomTempEvent event);
}
