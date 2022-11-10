import java.util.ArrayList;

public class MarioPartyGame {
    private int players;
    private String map;
    private int maxTurns;
    private int playerCoins;
    private int currentTurn;
    private int playerSpace;

    public MarioPartyGame(int players, String map, int maxTurns){
        this.players = players;
        this.map = map;
        this.maxTurns = maxTurns * players;
        this.playerSpace = 0;
    }

    public boolean isMap(String map){
        boolean isMap = false;
        ArrayList<String> maps = new ArrayList<String>();
        ArrayList<String> mapGiven = new ArrayList<String>();
        mapGiven.add(map);
        maps.add("Lava Castle");
        maps.add("test1");
        maps.add("test2");
        maps.add("test3");
        maps.add("test4");
        int mapsIndex = 0;
        while (mapsIndex < 5) {
            if (maps.get(mapsIndex) == map) {
                isMap = true;
            }
        }
        return isMap;
    }
    public int diceRoll() {
        int spacesMove = (int) (Math.random() * 10) + 1;
        return spacesMove;
    }

    public void simulateTurn(){
        playerSpace += diceRoll();
    }

    public int goingFirst(){
        return 1;
    }

    public String itemUsage(ArrayList<String> item){ //Work on this later
        return "You have used ...";
    }

}
