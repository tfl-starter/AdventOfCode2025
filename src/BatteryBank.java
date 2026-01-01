import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatteryBank implements Subject {
    private ArrayList<Observer> observers;
    private String log;
    private long startTimeInMs;
    private long endTimeInMs;
    private int totalSumJoltage = 0;

    public BatteryBank() {
         observers = new ArrayList<Observer>();       
    }
    public void startWatch() {
        startTimeInMs = System.currentTimeMillis();
    }
    public void stopWatch() {
        endTimeInMs = System.currentTimeMillis();
    }
    public long elapsedTimeMillis() {
        return endTimeInMs - startTimeInMs;
    }

    public void detect(String[] lines) {
        String out = "";
        for (String line : lines) {
            int maxJoltage = maxJoltage(line);
            out = line + " -> " + maxJoltage;
            totalSumJoltage += maxJoltage;
            log(out);
        }
    }

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
    public int totalSumJoltage() {
        return totalSumJoltage;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void modifyObservers() {
        for (Observer observer : observers) {
            observer.update(log);
        }
    }

    private void log(String message) {
        log = message;
        modifyObservers();
    }
}
