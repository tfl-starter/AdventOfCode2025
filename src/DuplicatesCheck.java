import java.util.ArrayList;

public class DuplicatesCheck implements Subject {
    private ArrayList<Observer> observers;
    private String log;
    Integer[] invalidIds;
    
    public DuplicatesCheck() {
        observers = new ArrayList<Observer>();
    }

   public boolean isValid(String id) {
        return !containOnlySubstrings(id);
    }
    
    public boolean containOnlySubstrings(String id) {
        return ( (id + id).indexOf(id, 1) != id.length() );
    }

    public boolean isValid4(String id) {
        
        return !hasRepeatingString(id);
        
    }

    private boolean hasRepeatingString(String id) {
        // System.out.print(id + " - ");
        for (int i = 1; i < id.length(); i++) {
            String left = id.substring(0,i);
            // System.out.println();
            // System.out.print("length=" + id.length() + " ");
            // System.out.print(" i=" + i + " ");
            // System.out.print("left=" + left + " ");
            
            boolean isOk = false;
            for (int j = 1; j < id.length(); j++) {
                int subStringBegin = i * j;
                int subStringEnd   = subStringBegin + i;
                if (subStringEnd > id.length()) {
                    // end has not been reached, then it cannot be OK
                    if (subStringBegin < id.length()) {
                        isOk = false;
                    }
                    break;
                }
                String right = id.substring(subStringBegin, subStringEnd);
                // System.out.print("vs right=" + right + " ");
                // System.out.print("j=" + j + " ");
                // System.out.print("begin=" + subStringBegin + " end="+ subStringEnd + " ");
                if (left.equals(right)) {
                    // System.out.print("TRUE ");
                    isOk = true;
                    // break;
                } else {
                    // System.out.print("FALSE ");
                    isOk = false;
                    break;
                }
            }  
            if (isOk) 
                return true;          
        }
        return false;
    }

    private void log(String message) {
        log = message;
        modifyObservers();
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