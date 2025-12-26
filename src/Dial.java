import java.nio.charset.UnsupportedCharsetException;

public class Dial {
    private int location = 50;

    public int location() {
        return location;
    }

    public void rotate(String rotation) {
        int distance = distance(rotation);

        if (isLeft(rotation)) { 
            location -= distance;
        } else { 
            location += distance;
        }
        if (location > 100) {
            location -= 100;
        } 

        if (location < 0){ 
            location += 100;
        }
    }

    public String direction(String rotation) {
        String direction = "";
        direction = rotation.substring(0,1);
        
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
        if (direction.startsWith("L")) return true;
        return false;
    }

}
