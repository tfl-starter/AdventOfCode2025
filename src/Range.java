import java.util.ArrayList;

public class Range {
    private ArrayList<Observer> observers;
    private String log;
    Integer[] invalidIds;
    
    public Range() {
        observers = new ArrayList<Observer>();
    }

   public boolean isValid(String id) {
        return isValid3(id);

        // // An ID is considered invalid if it has an odd number of digits
        // if (id.length() % 2 != 0) {
        //     return true;
        // }
        // String left = id.substring(0, id.length() / 2);
        // String right = id.substring(id.length() / 2);
        // if (left.equals(right)) {
        //     return false;
        // }
        
        // return true;
    }
    
    public boolean isValid3(String id) {
        if (id.length() <= 1) {
            return true;
        }
        for (int sequence = 1; sequence <= id.length() / 2; sequence++) {
            if (hasOnlySequence(id.substring(0, sequence), id)) 
                return false;
        }
        return true;
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

    Boolean hasOnlySequence(String sequence, String id) {
        int idLength = id.length();
        int seqLength = sequence.length();

            // if (seqLength > idLength) 
            //     return false;

            String idSubString = id.substring(0, seqLength);

            if (!idSubString.equals(sequence))
                return false;

            if (seqLength == idLength && sequence.equals(id))
                return true;

            return hasOnlySequence(sequence, id.substring(1));
            // return false;
        }

        public boolean isValid2(String id) {
        int len = id.length();
        if (len < 2) {
            return true;
        }   

        for (int subLen = 1; subLen <= len / 2; subLen++) {
            for (int start = 0; start <= len - 2 * subLen; start++) {
                String left = id.substring(start, start + subLen);
                String right = id.substring(start + subLen, start + 2 * subLen);

                // String left = id.substring(0, subLen);
                // String right = id.substring(subLen, subLen);
                if (left.equals(right)) {
                    return false;
                }
            }
        }
        return true;
    }

}
