
public class IDRange {
    long low = 0;
    long high = 0;

    public IDRange(long low, long high) {
        this.low = low;
        this.high = high;
    }

    public boolean contains(long id) {
        return (id >= low && id <= high);
    }

}
