import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IngredientID {
    List<IDRange> freshProducts = new ArrayList<IDRange>();
    
    public boolean isFresh(String id) {
        if (id == " ") return false;
        
        return isInRange(id);
    }
    
    private boolean isInRange(String id) {
        int id_number = Integer.parseInt(id);
        for (Iterator<IDRange> i = freshProducts.iterator(); i.hasNext();) {
            if (i.next().contains(id_number)) return true;
        }
        return false;
    }
    
    public void addRange(String s) {
        String[] elements = s.split("-");
        if (elements.length != 2) throw new IllegalArgumentException();
        
        int low = Integer.parseInt(elements[0]);
        int high = Integer.parseInt(elements[1]);
        IDRange range = new IDRange(low, high);

        freshProducts.add(range);
    }

}
