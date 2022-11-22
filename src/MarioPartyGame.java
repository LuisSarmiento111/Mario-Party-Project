import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MarioPartyGame {
    private int players;
    private int bots;
    private String map;
    private int maxTurns;
    private int firstPlayer;
    private int currentTurn;
    private ArrayList<String> maps;
    private ArrayList<Player> playerOrder;

    public MarioPartyGame(){
        maps = new ArrayList<>();
        maps.add("lava castle");
        maps.add("test1");
        maps.add("test2");
        maps.add("test3");
        maps.add("test4");
    }

    public MarioPartyGame(int players, String map, int maxTurns){
        this.players = players;
        this.map = map;
        this.maxTurns = maxTurns;
    }

    public boolean isMap(String map){
        boolean isMap = false;
        int mapsIndex = 0;
        while (mapsIndex < 5) {
            if (maps.get(mapsIndex).equals(map.toLowerCase())) {
                isMap = true;
            }
            mapsIndex++;
        }
        return isMap;
    }

    public boolean validAmountOfTurns(int turns){
        boolean valid = true;
        if (turns % 5 != 0) {
            valid = false;
        }
        if (turns > 40) {
            valid = false;
        }
        if (turns < 10) {
            valid = false;
        }
        return valid;
    }

    public int diceRoll() {
        int spacesMove = (int) (Math.random() * 10) + 1;
        return spacesMove;
    }

    public String simulateGame(ArrayList<Player> players){
        String gameLog = "";
        while (currentTurn < maxTurns){
            for (int numPlayer = 0; numPlayer < players.size(); numPlayer++) {
                if (playerOrder.get(numPlayer).getName().contains("Bot")) {

                }
                gameLog += ("\n" + playerOrder.get(numPlayer).getName() + " has " + simulateTurn(players.get(numPlayer)));
            }
            currentTurn++;
        }
        return gameLog; // change for something cooler
    }

    public boolean gameOver(){
        if (currentTurn == maxTurns) {
            return true;
        }
        return false;
    }

    public String simulateTurn(Player player){
        return player.updatePlayerSpace(diceRoll());
    }

    public String determineFirst(ArrayList<Player> players){
        ArrayList<String> playerDiceRollNums = new ArrayList<>();
        int highestNum = 0;
        ArrayList<String> sortedPlayerDiceRollNums = new ArrayList<>();
        playerOrder = new ArrayList<>();
        for (int i = 0; i < players.size(); i++){
            playerDiceRollNums.add(Integer.toString(diceRoll()));
        }
        for (int i = 0; i < playerDiceRollNums.size(); i++) {
            sortedPlayerDiceRollNums.add(playerDiceRollNums.get(i));
        }
        for (int i = 0; i <= playerDiceRollNums.size(); i++) {
            Collections.sort(sortedPlayerDiceRollNums, Collections.reverseOrder());
        }
        for (int i = 0; i < players.size(); i++) {
                playerOrder.add(players.get(playerDiceRollNums.indexOf(sortedPlayerDiceRollNums.get(i))));
                playerDiceRollNums.set(playerDiceRollNums.indexOf(sortedPlayerDiceRollNums.get(i)), "0");
            }
        firstPlayer = (players.indexOf(playerOrder.get(0))) + 1;
        String orderOfPlayers = "";
        orderOfPlayers += "\n" + playerOrder.get(0).getName() + " is first";
        orderOfPlayers += "\n" + playerOrder.get(1).getName() + " is second";
        orderOfPlayers += "\n" + playerOrder.get(2).getName() + " is third";
        orderOfPlayers += "\n" + playerOrder.get(3).getName() + " is fourth";
        return "Alright let's see who goes first!" + orderOfPlayers;
    }
}
