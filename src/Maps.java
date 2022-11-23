import java.util.ArrayList;
import java.util.Arrays;

public class Maps {

    private String map;
    private int maxSpaces;
    private int startingSpace;
    private ArrayList<Integer> blueSpaces;
    private ArrayList<Integer> redSpaces;
    private ArrayList<Integer> eventSpaces;
    private int starSpace;
    private int barrelCannon;

    public Maps(String map) {
        this.map = map.toLowerCase();
    }

    public void setUpMap() {
        startingSpace = 0;
        if (map.equals("lava castle")) {
            maxSpaces = 52;
            blueSpaces = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20,
                    21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 32, 33, 34, 36, 37, 38, 39, 40, 41, 42, 43, 44, 46, 47, 48, 49, 50, 51, 52));
            redSpaces = new ArrayList<Integer>(Arrays.asList(1, 8, 18, 29, 35, 45));
            starSpace = (int) (Math.random() * (maxSpaces - 10)) + 10;
            System.out.println(starSpace);
            if (blueSpaces.contains(starSpace)) {
                blueSpaces.remove(blueSpaces.indexOf(starSpace));
            }
            if (redSpaces.contains(starSpace)) {
                redSpaces.remove(redSpaces.indexOf(starSpace));
            }
        }
    }

    public ArrayList<Integer> getBlueSpaces() {
        return blueSpaces;
    }

    public String newStarSpace() {
        String starMovedTo = "The star moved to space ";
        if (map.equals("lava castle")) {
            maxSpaces = 86;
            blueSpaces = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20,
                    21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 32, 33, 34, 36, 37, 38, 39, 40, 41, 42, 43, 44, 46, 47, 48, 49, 50, 51, 52,
                    53, 54, 55, 56, 57, 58, 59, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 79, 80, 81, 82, 83,
                    84, 85, 86));
            redSpaces = new ArrayList<Integer>(Arrays.asList(1, 8, 18, 29, 35, 45, 60, 78));
            starSpace = (int) (Math.random() * (maxSpaces - 10)) + 10;
            System.out.println(starSpace);
            if (blueSpaces.contains(starSpace)) {
                blueSpaces.remove(blueSpaces.indexOf(starSpace));
            }
            if (redSpaces.contains(starSpace)) {
                redSpaces.remove(redSpaces.indexOf(starSpace));
            }
            starMovedTo += starSpace;
        }
        return starMovedTo;
    }

    public ArrayList<Integer> getRedSpaces() {
        return redSpaces;
    }

    public int getStarSpace() {
        return starSpace;
    }

    public int getMaxSpaces() {
        return maxSpaces;
    }

    public String getMap() {
        return map;
    }

    public String mapDetails() {
        if (map.equals("lava castle")) {
            return "Welcome to Lava Castle.\nLanding on a blue space makes you gain 3 coins.\nThere are blue spaces at: "
                    + getBlueSpaces() + "\nLanding on a red space makes you lose 3 coins.\nThere are red spaces at: "
                    + getRedSpaces() + "\nAnd finally if you land on a star space. You can buy a star for 20 coins." +
                    "\nThe star space is currently located at: " + getStarSpace();
        }
        return "";
    }
}
