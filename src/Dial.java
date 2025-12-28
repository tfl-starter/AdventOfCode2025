import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;

public class Dial implements Subject {
    private ArrayList<Observer> observers;
    private int location = 50;
    private int zero_counter = 0;
    private String log;

    public Dial() {
        observers = new ArrayList<Observer>();
    }

    public int location() {
        return location;
    }

    public void rotate(String rotation) {
        int distance = distance(rotation);
        int zeroCounter = 0;

        if (isLeft(rotation)) {
            location -= distance;
        } else {
            location += distance;
        }
        zeroCounter += reduceLocation();
        zeroCounter += increaseLocation();
        // if (location == 0) {
        // zero_counter++;
        // }
        // log("The dial is rotated " + rotation + " to point at " + location + ".");
        if (zeroCounter > 0) {
            log("The dial is rotated " + rotation + " to point at " + location
                    + "; during this rotation, it points at 0 " + zeroCounter + " time(s).");
        } else {
            log("The dial is rotated " + rotation + " to point at " + location + ".");
        }
        this.zero_counter += zeroCounter;
    }

    private int reduceLocation() {
        if (location < 100)
            return 0;
        location -= 100;
        return 1 + reduceLocation();
    }

    private int increaseLocation() {
        if (location >= 0)
            return 0;
        location += 100;
        return 1 + increaseLocation();
    }

    private void log(String message) {
        log = message;
        modifyObservers();
    }

    public String direction(String rotation) {
        String direction = "";
        direction = rotation.substring(0, 1);

        if (!direction.matches("[L,R]"))
            throw new UnsupportedCharsetException("Unexpected direction indicator");
        return direction;
    }

    public int distance(String rotation) {
        String distanceString = "";
        distanceString = rotation.substring(1, rotation.length());

        if (!distanceString.matches("[0-9]+"))
            throw new UnsupportedCharsetException("Unexpected distance value");

        return Integer.valueOf(distanceString);
    }

    public boolean isLeft(String rotation) {
        String direction = direction(rotation);
        if (direction.startsWith("L"))
            return true;
        return false;
    }

    public int zero_counter() {
        log("The dial has pointed at 0 a total of " + zero_counter + " times.");
        return zero_counter;
    }

    public void combination(String[] combinations) {
        for (String s : combinations) {
            rotate(s);
        }
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
}
