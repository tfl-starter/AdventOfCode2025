
public class Ranges {
    String product_ID_ranges = "";

    public Ranges(String string) {
        this.product_ID_ranges = string;
    }

    public String[] toRanges() {
        if (product_ID_ranges.isEmpty()) {
            return new String[0];
        }
        String[] parts = product_ID_ranges.split(",");
        return parts;
    }

}
