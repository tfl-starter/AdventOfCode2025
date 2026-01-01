import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatteryBank implements Subject {
    private ArrayList<Observer> observers;
    private String log;
    private long startTimeInMs;
    private long endTimeInMs;
    private long totalSumJoltage = 0;

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
            long maxJoltage = maxJoltage(line);
            out = line + " -> " + maxJoltage;
            totalSumJoltage += maxJoltage;
            log(out);
        }
    }

    public long maxJoltage(String string) {
        int keep = 12;
        if (string.length() < keep) {
            return 0; // Fallback if fewer than 12 digits
        }
        int toRemove = string.length() - keep;
        StringBuilder result = new StringBuilder();
        for (char digit : string.toCharArray()) {
            while (result.length() > 0 && result.charAt(result.length() - 1) < digit && toRemove > 0) {
                result.deleteCharAt(result.length() - 1);
                toRemove--;
            }
            result.append(digit);
        }
        // Remove any remaining digits from the end if needed
        if (toRemove > 0) {
            result.setLength(result.length() - toRemove);
        }
        return Long.parseLong(result.toString());
    }
    public int positionOfMaxValue(String string, int startPosition) {
        int positionOfHMaxValue = 0;
        int maxValue = 0;
        for (int i = startPosition; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            Integer currentValue = Character.getNumericValue(currentChar);
            if (maxValue < currentValue) {
                maxValue = currentValue;
                positionOfHMaxValue = i;
            }
        }
        return positionOfHMaxValue;
    }

    public long totalSumJoltage() {
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
