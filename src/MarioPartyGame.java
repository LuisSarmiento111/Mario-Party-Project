import java.util.ArrayList;

public class MarioPartyGame {
    private int players;
    private int bots;
    private String map;
    private int maxTurns;
    private int firstPlayer;
    private int currentTurn;
    private ArrayList<String> maps;

    public MarioPartyGame(){
        maps = new ArrayList<>();
        maps.add("Lava Castle");
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
            if (maps.get(mapsIndex).equals(map)) {
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
                gameLog += ("\nplayer" + ( 1 + numPlayer) + " has " + simulateTurn(players.get(numPlayer)));
            }
            currentTurn++;
        }
        return gameLog; // change for something cooler
    }

    public String simulateTurn(Player player){
        return player.updatePlayerSpace(diceRoll());
    }

    public void determineFirst(ArrayList<Player> players){
        ArrayList<String> playerDiceRollNums = new ArrayList<>();
        int highestNum = 0;
        for (int i = 0; i < players.size(); i++){
            playerDiceRollNums.add(Integer.toString(diceRoll()));
            if (Integer.parseInt(playerDiceRollNums.get(i)) > highestNum){
                highestNum = Integer.parseInt(playerDiceRollNums.get(i));
                firstPlayer = i + 1;
            }
        }
        System.out.println(playerDiceRollNums);
        System.out.println(firstPlayer);
    }
}
