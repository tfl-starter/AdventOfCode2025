import java.util.ArrayList;

public class Range {
    private ArrayList<Observer> observers;
    private String log;
    Integer[] invalidIds;
    
    public Range() {
        observers = new ArrayList<Observer>();
    }

    public Integer[] parseInvalidIds(int firstId, int lastId) {
        String ids = "";
        for (int i = firstId; i <= lastId; i++) {
            // Here we would normally add the invalid ID to a list or similar structure
            // For simplicity, we are just simulating this process
            ids += i + ", ";
        }
        invalidIds = ids.split(", ").length > 0 ? new Integer[]{firstId, lastId} : new Integer[]{};
        return invalidIds;
    }

    public boolean isValid(String id) {
        // An ID is considered invalid if it has an odd number of digits
        if (id.length() % 2 != 0) {
            return true;
        }
        String left = id.substring(0, id.length() / 2);
        String right = id.substring(id.length() / 2);
        if (left.equals(right)) {
            return false;
        }

        return true;
    }

}
