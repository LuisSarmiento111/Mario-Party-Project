import java.util.ArrayList;

public class Items {

    private ArrayList<String> gameItems;
    private ArrayList<String> listOfCandies;

    public Items() {
        gameItems = new ArrayList<>();
        gameItems.add("Mushroom");
        gameItems.add("Taco");
        gameItems.add("Triple Die");

    }

    public ArrayList<String> ItemsBeingUsed(){
        return gameItems;
    }
    public void addItem(String item){

    }
}
