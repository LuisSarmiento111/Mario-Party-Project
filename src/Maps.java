import java.util.ArrayList;
import java.util.Arrays;

public class Maps {

    private String map;
    private int maxSpaces;
    private int startingSpace;
    private ArrayList<Integer> blueSpaces;
    private ArrayList<Integer> redSpaces;
    private int starSpace;
    private ArrayList<Integer> bowserSpaces;
    private ArrayList<Integer> luckySpaces;
    private ArrayList<Integer> itemSpaces;

    public Maps() {
    }

    public Maps(String map) {
        this.map = map.toLowerCase();
    }

    public void setUpMap() {
        startingSpace = 0;
        if (map.equals("lava castle")) {
            maxSpaces = 92;
            blueSpaces = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 7, 9, 10, 13, 14, 15, 16, 17, 19, 21, 23, 25, 26,
                    28, 30, 32, 34, 36, 37, 40, 41, 43, 47, 48, 49, 51, 52, 53, 54, 56, 58, 59, 61, 63, 64, 67, 68, 69,
                    71, 72, 74, 76, 77, 78, 79, 83, 84, 86, 89, 91, 92));
            redSpaces = new ArrayList<Integer>(Arrays.asList(1, 8, 18, 29, 35, 45, 62, 80));
            bowserSpaces = new ArrayList<Integer>(Arrays.asList(12, 31, 55, 88));
            luckySpaces = new ArrayList<Integer>(Arrays.asList(5, 6, 11, 20, 24, 27, 33, 38, 39, 44, 46, 50, 57, 60, 66, 70, 73,
                    75, 81, 82, 85, 90));
            starSpace = (int) (Math.random() * (maxSpaces - 30)) + 15;
            itemSpaces = new ArrayList<Integer>(Arrays.asList(22, 42, 65, 87));
            if (blueSpaces.contains(starSpace)) {
                blueSpaces.remove(blueSpaces.indexOf(starSpace));
            }
            if (redSpaces.contains(starSpace)) {
                redSpaces.remove(redSpaces.indexOf(starSpace));
            }
            if (bowserSpaces.contains(starSpace)) {
                bowserSpaces.remove(bowserSpaces.indexOf(starSpace));
            }
            if (luckySpaces.contains(starSpace)) {
                luckySpaces.remove(luckySpaces.indexOf(starSpace));
            }
            if (itemSpaces.contains(starSpace)) {
                itemSpaces.remove(itemSpaces.indexOf(starSpace));
            }
        }
    }

    public ArrayList<Integer> getBlueSpaces() {
        return blueSpaces;
    }

    public String newStarSpace() {
        String starMovedTo = "The star moved to space ";
        if (map.equals("lava castle")) {
            maxSpaces = 92;
            blueSpaces = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 7, 9, 10, 13, 14, 15, 16, 17, 19, 21, 23, 25, 26,
                    28, 30, 32, 34, 36, 37, 40, 41, 43, 47, 48, 49, 51, 52, 53, 54, 56, 58, 59, 61, 63, 64, 67, 68, 69,
                    71, 72, 74, 76, 77, 78, 79, 83, 84, 86, 89, 91, 92));
            redSpaces = new ArrayList<Integer>(Arrays.asList(1, 8, 18, 29, 35, 45, 62, 80));
            bowserSpaces = new ArrayList<Integer>(Arrays.asList(12, 31, 55, 88));
            luckySpaces = new ArrayList<Integer>(Arrays.asList(5, 6, 11, 20, 24, 27, 33, 38, 39, 44, 46, 50, 57, 60, 66, 70, 73,
                    75, 81, 82, 85, 90));
            starSpace = (int) (Math.random() * (maxSpaces - 30)) + 15;
            itemSpaces = new ArrayList<Integer>(Arrays.asList(22, 42, 65, 87));
            if (blueSpaces.contains(starSpace)) {
                blueSpaces.remove(blueSpaces.indexOf(starSpace));
            }
            if (redSpaces.contains(starSpace)) {
                redSpaces.remove(redSpaces.indexOf(starSpace));
            }
            if (bowserSpaces.contains(starSpace)) {
                bowserSpaces.remove(bowserSpaces.indexOf(starSpace));
            }
            if (luckySpaces.contains(starSpace)) {
                luckySpaces.remove(luckySpaces.indexOf(starSpace));
            }
            if (itemSpaces.contains(starSpace)) {
                itemSpaces.remove(itemSpaces.indexOf(starSpace));
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

    public ArrayList<Integer> getBowserSpaces() {
        return bowserSpaces;
    }

    public ArrayList<Integer> getLuckySpaces() {
        return luckySpaces;
    }

    public ArrayList<Integer> getItemSpaces() {
        return itemSpaces;
    }

    public String getMap() {
        return map;
    }

    public String mapDetails() {
        return "Welcome to " + map + ".\n\u001B[34mThere are blue spaces at: "
                + getBlueSpaces() + "\033[0m\n\u001B[31mThere are red spaces at: "
                + getRedSpaces() + "\033[0m\n\u001B[32mThere are lucky spaces at: " + getLuckySpaces() +
                "\033[0m\n\u001B[35mThere are bowser spaces at: " + getBowserSpaces() +
                "\033[0m\n\u001B[36mThere are item spaces at: " + getItemSpaces() +
                "\033[0m\n\u001B[33mThe star space is currently located at: " + getStarSpace() + "\033[0m";
    }

    public String showMapWithPlayers() {
        return "testing"; //
    }
}
