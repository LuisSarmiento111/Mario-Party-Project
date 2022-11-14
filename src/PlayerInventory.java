import java.util.ArrayList;

public class PlayerInventory {

    private ArrayList<String> playerInventory;

    public PlayerInventory() {
        playerInventory = new ArrayList<>();
    }

    public ArrayList<String> getPlayerInventory() {
        return playerInventory;
    }

    public void addToInventory(String item){
        playerInventory.add(item);
    }

    public boolean haveItem(String item){
        boolean haveItem = false;
        if (playerInventory.indexOf(item) != -1) {
            haveItem = true;
        }
        return haveItem;
    }
}
