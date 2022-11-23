import java.util.ArrayList;

public class Player {

    private ArrayList<String> playerInventory;
    private int playerCoins;
    private int playerSpace;
    private String name;
    private Maps map;
    private boolean doubled;
    private boolean onStar;
    private int stars;

    public Player(Maps currentMap) {
        playerInventory = new ArrayList<>();
        playerSpace = 0;
        playerCoins = 0;
        map = currentMap;
        onStar = false;
        stars = 0;
    }

    public ArrayList<String> getPlayerInventory() {
        return playerInventory;
    }

    public void addToInventory(String item) {
        playerInventory.add(item);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String updatePlayerSpace(int spacesMoved) {
        String returnString = "";
        playerSpace += spacesMoved;
        returnString += name + " has moved " + spacesMoved + " spaces.\n";
        if (playerSpace > map.getMaxSpaces()) {
            playerSpace = playerSpace - map.getMaxSpaces();
        }
        if (map.getBlueSpaces().contains(playerSpace)) {
            if (doubled) {
                playerCoins += 6;
                returnString += name + " landed on a blue space.\nYou get 6 coins.";
            } else {
                playerCoins += 3;
                returnString += name + " landed on a blue space.\nYou get 3 coins.";
            }
        }
        if (map.getRedSpaces().contains(playerSpace)) {
            if (doubled) {
                playerCoins -= 6;
                returnString += name + " landed on a red space.\nYou lose 6 coins.";
            } else {
                playerCoins -= 3;
                returnString += name + " landed on a red space.\nYou lose 3 coins.";
            }
        }
        if (playerSpace == map.getStarSpace()) {
            returnString = "";
        }
        if (map.getStarSpace() == playerSpace) {
            onStar = true;
        } else {
            onStar = false;
        }
        returnString += "\n" + name + " currently has " + playerCoins + " coins.\n" + name +
                " is currently on space " + playerSpace;
        return returnString;
    }

    public int currentPlayerSpace() {
        return playerSpace;
    }

    public boolean isOnStar() {
        return onStar;
    }

    public void updatePlayerCoins(int coins) {
        playerCoins += coins;
    }

    public int amountOfCoins() {
        return playerCoins;
    }

    public boolean haveItem(String item) {
        boolean haveItem = false;
        if (playerInventory.indexOf(item) != -1) {
            haveItem = true;
        }
        return haveItem;
    }

    public int amountOfStars() {
        return stars;
    }

    public void updateStars() {
        stars++;
    }

    public String buyStar(String answer) {
        if (answer.equals("yes")) {
            updatePlayerCoins(-20);
            updateStars();
            return "You have bought a star for 20 coins!" + map.newStarSpace();
        } else {
            return "You have decided not to buy a coin";
        }
    }

    public String useItem(String item) {
        if (playerInventory.contains(item)) {
            playerInventory.remove(playerInventory.indexOf(item));
            return "You have used a " + item;
        } else {
            return "You do not have a " + item + " in your inventory";
        }
    }
}

