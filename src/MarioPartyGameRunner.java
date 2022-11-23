import java.util.ArrayList;
import java.util.Scanner;

public class MarioPartyGameRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        MarioPartyGame setup = new MarioPartyGame();
        System.out.println("Welcome to Mario Party!");
        System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
        System.out.println("Which map would you like to play?");
        String userMap = userInput.nextLine();
        while (setup.isMap(userMap) == false) {
            System.out.println("That is not an option");
            System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
            System.out.println("Which map would you like to play?");
            userMap = userInput.nextLine();
        }
        Maps currentMap = new Maps(userMap);
        System.out.println("How many people are playing? (Max of 4 players)");
        int playerAmount = Integer.parseInt(userInput.nextLine());
        while (playerAmount > 4 || playerAmount < 1) {
            System.out.println("That is not a valid amount of players");
            System.out.println("How many people are playing? (Max of 4 players)");
            playerAmount = Integer.parseInt(userInput.nextLine());
        }
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<String> playernames = new ArrayList<String>();
        for (int i = 0; i <= playerAmount - 1; i++) {
            players.add(new Player(currentMap)); // make so names cant be the same
            System.out.println("What is player " + (i + 1) + "'s name?");
            players.get(i).setName(userInput.nextLine());
            playernames.add(players.get(i).getName());
        }
        /*
        for (int i = 0; i < 4 - playerAmount; i++) {
            players.add(new Player(currentMap));
            players.get(i + playerAmount).setName("Bot" + (i + 1));
            playernames.add(players.get(i + playerAmount).getName());
        }
        System.out.println(4 - playerAmount + " bots have been added to the player list.\nThese are the people on the player list: " + playernames);
         */
        System.out.println("How many turns do you guys want to play up to? (Min is 20, Max is 50, must be divisible by 5)"); // check to ensure max/min
        int maxTurns = Integer.parseInt(userInput.nextLine());
        while (setup.validAmountOfTurns(maxTurns) == false) {
            System.out.println("That is not a valid amount of turns");
            System.out.println("How many turns do you guys want to play up to? (Min is 10, Max is 40, must be divisible by 5)");
            maxTurns = Integer.parseInt(userInput.nextLine());
        }
        System.out.println("Alright lets get this game started!");
        MarioPartyGame MarioPartyGame = new MarioPartyGame(playerAmount, currentMap, maxTurns);
        currentMap.setUpMap();
        System.out.println(currentMap.mapDetails());
        System.out.println(MarioPartyGame.determineFirst(players));
        System.out.println("Alright now that the turn order has been decided, here are some coins to get you all started!");
        int currentTurn = 1;
        while (MarioPartyGame.gameOver(currentTurn)) {
            for (int j = 0; j < playerAmount; j++) {
                Player currentPlayerTurn = MarioPartyGame.getOrderOfPlayers().get(j);
                System.out.println(MarioPartyGame.simulateDiceRoll(currentPlayerTurn));
                if (currentPlayerTurn.isOnStar() == true && currentPlayerTurn.amountOfCoins() >= 20) {
                    System.out.println(currentPlayerTurn.getName() + " landed on the star space.\nWould you like to buy a star? (yes or no)");
                    String answer = userInput.nextLine().toLowerCase();
                    while (answer.equals("yes") == false && answer.equals("no") == false) {
                        System.out.println("That is not a valid answer.\nWould you like to buy a star? (yes or no)");
                        answer = userInput.nextLine().toLowerCase();
                    }
                    System.out.println(currentPlayerTurn.buyStar(answer));
                } else if (currentPlayerTurn.isOnStar() == true) {
                    System.out.println(currentPlayerTurn.getName() + " landed on the star space.\nUnfortunately you do not have enough coins to " +
                            "buy a star.");
                }
                System.out.println();
            }
            currentTurn++;
        }
        System.out.println("That is the end of all the turns.\nLets see how many stars everyone got!");
        System.out.println(MarioPartyGame.winner());
        // System.out.println(MarioPartyGame.simulateGame(players));
        /*
        players.get(1).addToInventory("taco");
        System.out.println(players.get(1).getPlayerInventory());
        players.get(1).addToInventory("burger");
        System.out.println(players.get(1).getPlayerInventory());
        players.get(1).addToInventory("salad");
        System.out.println(players.get(1).getPlayerInventory());
        System.out.println(players.get(1).useItem("taco"));
        System.out.println(players.get(1).getPlayerInventory());

         */
    }
}
