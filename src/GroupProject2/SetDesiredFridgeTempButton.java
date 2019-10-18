package GroupProject2;

public class SetDesiredFridgeTempButton extends GUIButton {
	/**
	 * Crates the button with the required label
	 * 
	 * @param string
	 *            the label
	 */
	public SetDesiredFridgeTempButton(String string) {
		super(string);
	}

	/**
	 * Tell the context to send it to the right listener
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		SetDesiredFridgeTempManager.instance().processEvent(new SetDesiredFridgeTempEvent(source));
	}
}