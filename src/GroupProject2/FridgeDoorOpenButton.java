package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
/**
 * The button that represents door open
 *
 */
public class FridgeDoorOpenButton extends GUIButton {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string
	 *            the text to be put
	 */
	public FridgeDoorOpenButton(String string) {
		super(string);
	}

	/**
	 * Create the DoorOpenEvent and tell the context that the button has been
	 * clicked.
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeDoorOpenManager.instance().processEvent(new FridgeDoorOpenEvent(source));
	}
}