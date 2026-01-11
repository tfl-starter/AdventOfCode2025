import java.util.ArrayList;

public class Duplicate implements Subject {
    private ArrayList<Observer> observers;
    private String log;
    private long sumOfInvalidIds = 0;
    private long startTimeInMs;
    private long endTimeInMs;

    public Duplicate() {
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
            String[] ranges = line.split(",");
            for (String range : ranges) {
                out = range + ": ";
                String[] bounds = range.split("-");
                long firstId = Long.parseLong(bounds[0]);
                long lastId = Long.parseLong(bounds[1]);

                for (long i = firstId; i <= lastId; i++) {
                    String idStr = Long.toString(i);
                    DuplicatesCheck rangeObj = new DuplicatesCheck();
                    if (!rangeObj.isValid(idStr)) {
                        out = out + idStr + ", ";
                        sumOfInvalidIds += i;
                    }
                }
                log(out);
            }
        }
    }
    public long subOfInvalidIds() {
        return sumOfInvalidIds;
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
