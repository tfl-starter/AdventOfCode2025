
public class IDRange {
    int low = 0;
    int high = 0;

    public IDRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public boolean contains(int id) {
        return (id >= low && id <= high);
    }

}
