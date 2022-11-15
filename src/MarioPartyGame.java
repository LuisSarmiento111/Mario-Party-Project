import java.util.ArrayList;

public class MarioPartyGame {
    private int players;
    private int bots;
    private String map;
    private int maxTurns;
    private int firstPlayer;
    private int playerTurn;
    private int currentTurn;
    private int playerSpace;
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
        this.maxTurns = maxTurns * players;
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

    public void simulateTurn(){
        playerTurn += diceRoll();
    }
    public void determineFirst(){
        int highestNum = 0;
        int rollNumber = 0;
        for (int i = 1; i <= players; i++){
            rollNumber = diceRoll();
            if (rollNumber > highestNum){
                highestNum = rollNumber;
                firstPlayer = i;
            }
        }
    }
}
