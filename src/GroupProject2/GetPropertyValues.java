package GroupProject2;
/**
 * 
 * @author Prechar Xiong, Thomas Wohlever, and Christopher Corcoran
 * Group Project 2
 * ICS 372-01
 * Summer 2019
 *  
 * */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {
	InputStream inputStream;
	private static String fridgeLow, fridgeHigh, freezerLow, freezerHigh, roomLow, roomHigh, fridgeRateLossDoorClosed,
	fridgeRateLossDoorOpen, freezerRateLossDoorClosed, freezerRateLossDoorOpen, fridgeCompressorStartDiff,
	freezerCompressorStartDiff, fridgeCoolRate, freezerCoolRate;

	public void getPropValues() throws IOException {


		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value 
			fridgeLow = prop.getProperty("FridgeLow");
			fridgeHigh = prop.getProperty("FridgeHigh");
			freezerLow = prop.getProperty("FreezerLow");
			freezerHigh = prop.getProperty("FreezerHigh");
			roomLow = prop.getProperty("RoomLow");
			roomHigh = prop.getProperty("RoomHigh");
			fridgeRateLossDoorClosed = prop.getProperty("FridgeRateLossDoorClosed");
			fridgeRateLossDoorOpen = prop.getProperty("FridgeRateLossDoorOpen");
			freezerRateLossDoorClosed = prop.getProperty("FreezerRateLossDoorClosed");
			freezerRateLossDoorOpen = prop.getProperty("FreezerRateLossDoorOpen");
			fridgeCompressorStartDiff = prop.getProperty("FridgeCompressorStartDiff");
			freezerCompressorStartDiff = prop.getProperty("FreezerCompressorStartDiff");
			fridgeCoolRate = prop.getProperty("FridgeCoolRate");
			freezerCoolRate = prop.getProperty("FreezerCoolRate");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}

	public int getFridgeLow() {
		return Integer.parseInt(fridgeLow);
	}

	public int getFridgeHigh() {
		return Integer.parseInt(fridgeHigh);
	}

	public int getFreezerLow() {
		return Integer.parseInt(freezerLow);
	}

	public int getFreezerHigh() {
		return Integer.parseInt(freezerHigh);
	}

	public int getRoomLow() {
		return Integer.parseInt(roomLow);
	}

	public int getRoomHigh() {
		return Integer.parseInt(roomHigh);
	}

	public int getFridgeRateLossDoorClosed() {
		return Integer.parseInt(fridgeRateLossDoorClosed);
	}

	public int getFridgeRateLossDoorOpen() {
		return Integer.parseInt(fridgeRateLossDoorOpen);
	}

	public int getFreezerRateLossDoorClosed() {
		return Integer.parseInt(freezerRateLossDoorClosed);
	}

	public int getFreezerRateLossDoorOpen() {
		return Integer.parseInt(freezerRateLossDoorOpen);
	}

	public int getFridgeCompressorStartDiff() {
		return Integer.parseInt(fridgeCompressorStartDiff);
	}

	public int getFreezerCompressorStartDiff() {
		return Integer.parseInt(freezerCompressorStartDiff);
	}

	public int getFridgeCoolRate() {
		return Integer.parseInt(fridgeCoolRate);
	}

	public int getFreezerCoolRate() {
		return Integer.parseInt(freezerCoolRate);
	}
	
}
