import java.util.ArrayList;

public class MarioPartyGame {
    private int players;
    private int bots;
    private String map;
    private int maxTurns;
    private int playerCoins;
    private int currentTurn;
    private int playerSpace;
    private ArrayList<String> gameItems;
    private ArrayList<String> maps;

    public MarioPartyGame(int players, String map, int maxTurns){
        this.players = players;
        this.map = map;
        this.maxTurns = maxTurns * players;
        this.playerSpace = 0;
        maps = new ArrayList<>();
        maps.add("Lava Castle");
        maps.add("test1");
        maps.add("test2");
        maps.add("test3");
        maps.add("test4");
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
    public int diceRoll() {
        int spacesMove = (int) (Math.random() * 10) + 1;
        return spacesMove;
    }

    public void simulateTurn(){
        playerSpace += diceRoll();
    }

    public int goingFirst(){
        for (int i = 1; i <= players; i++){

        }
        return 2;
    }

    public void itemUsage(ArrayList<String> player1, String item){
        PlayerInventory tempPlayer1 = new PlayerInventory();
        for (int i = 0; i < player1.size(); i++) {
            tempPlayer1.addToInventory(player1.get(i));
        }
        if (player1.contains(item)) {
            player1.remove(player1.indexOf(item));
        }
    }
    public void itemAbility(){
    }
}
