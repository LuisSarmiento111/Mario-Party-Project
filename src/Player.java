import java.util.ArrayList;

public class Player {

    private ArrayList<String> playerInventory;
    private int playerCoins;
    private int playerTurn;

    public Player() {
        playerInventory = new ArrayList<>();
        playerTurn = 0;
        playerCoins = 0;
    }

    public ArrayList<String> getPlayerInventory() {
        return playerInventory;
    }

    public void addToInventory(String item) {
        playerInventory.add(item);
    }

    public boolean haveItem(String item) {
        boolean haveItem = false;
        if (playerInventory.indexOf(item) != -1) {
            haveItem = true;
        }
        return haveItem;
    }

    public String useItem(String item) {
        if (playerInventory.contains(item)) {
            playerInventory.remove(playerInventory.indexOf(item));
            return "You have used a " + item;
        }
        else {
            return "You do not have a " + item + " in your inventory";
        }
    }
}

