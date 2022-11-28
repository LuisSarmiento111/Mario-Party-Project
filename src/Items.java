import java.util.ArrayList;

public class Items {

    private ArrayList<String> gameItems;
    private ArrayList<Player> players;

    public Items(ArrayList<Player> players) {
        gameItems = new ArrayList<>();
        gameItems.add("Mushroom");
        gameItems.add("Double Dice");
        gameItems.add("Triple Dice");
        gameItems.add("Warp Block");
        gameItems.add("Cursed Dice Block");
        gameItems.add("Halfway Dice");
        players = new ArrayList<>();
    }

    public Items() {
        gameItems = new ArrayList<>();
        gameItems.add("Mushroom");
        gameItems.add("Double Dice");
        gameItems.add("Triple Dice");
        gameItems.add("Warp Block");
        gameItems.add("Cursed Dice Block");
        gameItems.add("Halfway Dice");
    }


    public ArrayList<String> getGameItems() {
        return gameItems;
    }

    public int getAmountOfItems() {
        return gameItems.size();
    }

    public void addItem(String item) {

    }

    public String itemEffects(String item, Player player) {
        if (item.equals("Mushroom")) {
            player.changeSpacesMoved(5);
            return player.getName() + " has used a mushroom. They have added +5 to their next turn.\n";
        }
        if (item.equals("Double Dice")) {
            player.changeSpacesMoved((int) (Math.random() * 10) + 1);
            return player.getName() + " has used a Double Dice. They will roll two dice on their next turn.\n";
        }
        if (item.equals("Triple Dice")) {
            player.changeSpacesMoved(((int) (Math.random() * 10) + 1) + ((int) (Math.random() * 10) + 1));
            return player.getName() + " has used a Triple Dice. They will roll three dice on their next turn.\n";
        }
        if (item.equals("Cursed Dice Block")) {
            Player selectedPlayer = players.get((int) (Math.random() * 3));
            while (selectedPlayer.equals(player)) {
                selectedPlayer = players.get((int) (Math.random() * 3));
            }
            selectedPlayer.cursedBlockActive();
            return player.getName() + " has used a Cursed Dice. " + selectedPlayer.getName() + " was randomly chosen and " +
                    "will only roll a 1-3 their next turn.\n";
        }
        if (item.equals("Warp Block")) {
            Player selectedPlayer = players.get((int) (Math.random() * 3));
            while (selectedPlayer.equals(player)) {
                selectedPlayer = players.get((int) (Math.random() * 3));
            }
            int selectedPlayerSpace = selectedPlayer.currentPlayerSpace();
            selectedPlayer.setPlayerSpace(player.currentPlayerSpace());
            player.setPlayerSpace(selectedPlayerSpace);
            return player.getName() + " has used a Warp Block. They have randomly swapped places with"
                    + selectedPlayer.getName() + "\n";
        }
        if (item.equals("Halfway Dice")) {
            player.halfwayDiceActive();
            return player.getName() + " has used a Halfway Dice. Their next roll was randomly chosen and " +
                    "will only roll a 1-3 their next turn.\n";
        } else {
            return "";
        }
    }
}
