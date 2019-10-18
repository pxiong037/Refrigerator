package GroupProject2;

public class SetDesiredFreezerTempButton extends GUIButton {
	/**
	 * Crates the button with the required label
	 * 
	 * @param string
	 *            the label
	 */
	public SetDesiredFreezerTempButton(String string) {
		super(string);
	}

	/**
	 * Tell the context to send it to the right listener
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		SetDesiredFreezerTempManager.instance().processEvent(new SetDesiredFreezerTempEvent(source));
	}
}