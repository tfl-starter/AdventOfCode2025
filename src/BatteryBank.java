import java.util.HashMap;
import java.util.Map;

public class BatteryBank {

    public int maxJoltage(String string) {
        int maxBattery = 0;
        int leftLocation = 0;
        int rightLocation = 0;

        for (int i = 0; i < string.length(); i++) {
            char leftChar = string.charAt(i);
            Integer leftBattery = Character.getNumericValue(leftChar);
            for (int j = i + 1; j < string.length(); j++) {
                char rightChar = string.charAt(j);
                Integer rightBattery = Character.getNumericValue(rightChar);

                int currentBattery = leftBattery * 10 + rightBattery;
                if (maxBattery < currentBattery) {
                    maxBattery = currentBattery;
                    leftLocation = i;
                    rightLocation = j;
                }
            }
        }

        return maxBattery;
    }

}
