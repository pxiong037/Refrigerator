package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.util.Observable;
import java.util.Observer;

/**
 * The Timer for the refrigerator
 *
 */
public class FridgeTimer implements Observer {
	private static FridgeTimer instance;
	private int timeValue;

	/**
	 * For singleton
	 */
	private FridgeTimer() {
		instance = this;
		Clock.instance().addObserver(instance);
	}

	/**
	 * For singleton pattern
	 * 
	 * @return the instance
	 */
	public static FridgeTimer instance() {
		if (instance == null) {
			instance = new FridgeTimer();
		}
		return instance;
	}

	/**
	 * Set the time for the timer
	 * 
	 * @param value
	 *            timer initial value
	 */
	public void setTimeValue(int value) {
		timeValue = value;
	}

	/**
	 * Add to the time value
	 * 
	 * @param value
	 *            extra time for the time value
	 */
	public void addTimeValue(int value) {
		timeValue += value;
	}

	/**
	 * Get the remaining time
	 * 
	 * @return
	 */
	public int getTimeValue() {
		return timeValue;
	}

	/**
	 * Get the clock tick and process it
	 */
	@Override
	public void update(Observable clock, Object value) {
		if (--timeValue == 0) {
			FridgeTimerRanOutManager.instance().processEvent(
					new FridgeTimerRanOutEvent(instance));
			
		} else {
			FridgeTimerTickedManager.instance().processEvent(
					new FridgeTimerTickedEvent(instance));
		}
	}
}