import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MarioPartyGame {
    private int players;
    private int bots;
    private Maps map;
    private int maxTurns;
    private int firstPlayer;
    private int currentTurn;
    private ArrayList<String> maps;
    private ArrayList<Player> playerOrder;

    public MarioPartyGame() {
        maps = new ArrayList<>();
        maps.add("lava castle");
        maps.add("test1");
        maps.add("test2");
        maps.add("test3");
        maps.add("test4");
    }

    public MarioPartyGame(int players, Maps map, int maxTurns) {
        this.players = players;
        this.map = map;
        this.maxTurns = maxTurns;
    }

    public boolean isMap(String map) {
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

    public boolean validAmountOfTurns(int turns) {
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

    public String simulateDiceRoll(Player player) {
        return player.updatePlayerSpace(diceRoll());
    }

    public String simulateGame(ArrayList<Player> players) {
        String gameLog = "";
        while (currentTurn < maxTurns) {
            for (int numPlayer = 0; numPlayer < players.size(); numPlayer++) {
                if (playerOrder.get(numPlayer).getName().contains("Bot")) {

                }
                gameLog += ("\n" + playerOrder.get(numPlayer).getName() + " has " + simulateDiceRoll(players.get(numPlayer)));
            }
            currentTurn++;
        }
        return gameLog;
    }

    public boolean gameOver(int currentTurn) {
        if (currentTurn > maxTurns) {
            return false;
        } else {
            return true;
        }
    }

    public String determineFirst(ArrayList<Player> players) {
        ArrayList<String> playerDiceRollNums = new ArrayList<>();
        int highestNum = 0;
        ArrayList<String> sortedPlayerDiceRollNums = new ArrayList<>();
        playerOrder = new ArrayList<>();
        String orderOfPlayers = "";
        for (int i = 0; i < players.size(); i++) {
            playerDiceRollNums.add(Integer.toString(diceRoll()));
            orderOfPlayers += players.get(i).getName() + "  ";
        }
        orderOfPlayers = playerDiceRollNums + "\n " + orderOfPlayers;
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
        for (int i = 0; i < players.size(); i++) {
            if (i == 0) {
                orderOfPlayers += "\n" + playerOrder.get(0).getName() + " is first";
            }
            if (i == 1) {
                orderOfPlayers += "\n" + playerOrder.get(1).getName() + " is second";
            }
            if (i == 2) {
                orderOfPlayers += "\n" + playerOrder.get(2).getName() + " is third";
            }
            if (i == 3) {
                orderOfPlayers += "\n" + playerOrder.get(3).getName() + " is fourth";
            }
        }
        /*
        orderOfPlayers += "\n" + playerOrder.get(0).getName() + " is first";
        orderOfPlayers += "\n" + playerOrder.get(1).getName() + " is second";
        orderOfPlayers += "\n" + playerOrder.get(2).getName() + " is third";
        orderOfPlayers += "\n" + playerOrder.get(3).getName() + " is fourth";
         */
        return "Alright let's see who goes first!\n" + orderOfPlayers;
    }

    public ArrayList<Player> getOrderOfPlayers() {
        return playerOrder;
    }

    public String winner() {
        String winner = "";
        ArrayList<Integer> mostStars = new ArrayList<>();
        ArrayList<Integer> sortedMostStars = new ArrayList<>();
        for (int i = 0; i < playerOrder.size(); i++) {
            mostStars.add(playerOrder.get(i).amountOfStars());
        }
        for (int i = 0; i < playerOrder.size(); i++) {
            sortedMostStars.add(mostStars.get(i));
        }
        System.out.println(sortedMostStars);
        for (int i = 0; i < playerOrder.size(); i++) {
            Collections.sort(sortedMostStars, Collections.reverseOrder());
        }
        System.out.println(sortedMostStars);
        if (sortedMostStars.get(0) == sortedMostStars.get(1)) {
            winner = "It was a tie";
        } else {
            winner = "The winner is " + playerOrder.get(mostStars.indexOf(sortedMostStars.get(0))).getName();
        }
        return winner;
    }
}
