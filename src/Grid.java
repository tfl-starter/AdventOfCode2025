import java.util.ArrayList;
import java.util.List;

public class Grid implements Subject {

    private ArrayList<Observer> observers;
    private String log;
    private long startTimeInMs;
    private long endTimeInMs;

    public Grid() {
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
    public List<List<Character>> toGrid(String content) {
        String[] lines = content.split("\r?\n");

        // make grid ...
        List<List<Character>> grid = new ArrayList<List<Character>>();

        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            List<Character> yLine = new ArrayList<Character>();
            for (int x = 0; x < line.length(); x++ ) {
                yLine.add(line.charAt(x));
            }
            grid.add(yLine);
        }
        return grid;
    }

    public boolean paperRoleReadyToPick(int y, int x, List<List<Character>> grid) {
        if (!isCoordinatePaperRole(y, x, grid)) return false;

        int count = 0;

        if (isNorth(y, x, grid)) count++;
        if (isSouth(y, x, grid)) count++;
        if (isEast(y, x, grid)) count++;
        if (isWest(y, x, grid)) count++;
        if (isNorthEast(y, x, grid)) count++;
        if (isNorthWest(y, x, grid)) count++;
        if (isSouthEast(y, x, grid)) count++;
        if (isSouthWest(y, x, grid)) count++;
     
        if (count < 4) return true;

        return false;
    }

    private boolean isNorth(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y-1, x, grid);
    }
    private boolean isSouth(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x, grid);
    }
    private boolean isEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y, x+1, grid);
    }
    private boolean isWest(int y, int x, List<List<Character>> grid) {
         return isCoordinatePaperRole(y, x-1, grid);
    }
    private boolean isNorthEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y-1, x+1, grid);
    }
    private boolean isNorthWest(int y, int x, List<List<Character>> grid) {
       return isCoordinatePaperRole(y-1, x-1, grid);
    }
    private boolean isSouthEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x+1, grid);
    }
    private boolean isSouthWest(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x-1, grid);
    }

    public boolean isCoordinatePaperRole(int y, int x, List<List<Character>> grid) {
        // Out of bounds ...
        int yMax = grid.size() - 1;
        int xMax = grid.get(0).size() - 1;
        if (y < 0 || y > yMax) return false;
        if (x < 0 || x > xMax) return false;

        char coordinate = grid.get(y).get(x);
        if (coordinate == '.') return false;
        return true;
    }

    public int pickablePaperRols(List<List<Character>> grid) {
        int countPickablePaperRols = 0;
        int ySize = grid.size();
        int xSize = grid.get(0).size();
        
        List<List<Character>> reducedGrid = new ArrayList<List<Character>>();

        for (int y = 0; y < ySize; y++) {
            List<Character> yLine = new ArrayList<Character>();
            for (int x = 0; x < xSize; x++ ) {
                if (paperRoleReadyToPick(y, x, grid)) {
                    countPickablePaperRols++;
                    yLine.add('.');
                } else {
                    yLine.add(grid.get(y).get(x));
                }
            }
            reducedGrid.add(yLine);
        }
        if (countPickablePaperRols > 0) {
            countPickablePaperRols += pickablePaperRols(reducedGrid);
        }
        return countPickablePaperRols;
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
