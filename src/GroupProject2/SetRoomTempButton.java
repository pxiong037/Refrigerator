package GroupProject2;

public class SetRoomTempButton extends GUIButton {
	/**
	 * Crates the button with the required label
	 * 
	 * @param string
	 *            the label
	 */
	public SetRoomTempButton(String string) {
		super(string);
	}

	/**
	 * Tell the context to send it to the right listener
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		SetRoomTempManager.instance().processEvent(new SetRoomTempEvent(source));
	}
}
