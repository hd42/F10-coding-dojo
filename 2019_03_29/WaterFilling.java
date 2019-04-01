import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class WaterFilling {
	
	public static long maxVolume(int[] terrain) {
		int width = terrain.length;
		IntSummaryStatistics summaryStatistics = Arrays.stream(terrain).summaryStatistics();
		int highest = summaryStatistics.getMax();
		int lowest = summaryStatistics.getMin();

		long volume = 0;

		for (int layer = highest; layer >= lowest; layer--) {
			boolean inPuddle = false;
			int layerVolume = 0;
			for (int column = 0; column < width; column++) {
				if (terrain[column] >= layer) {
					if (inPuddle) {
						volume += layerVolume;
						layerVolume = 0;
					}
					inPuddle = true;
				} else {
					if (inPuddle) {
						layerVolume++;
					}
				}
			}
		}

		return volume;
	}
	
}
