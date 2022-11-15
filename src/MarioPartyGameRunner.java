import java.util.ArrayList;
import java.util.Scanner;

public class MarioPartyGameRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        MarioPartyGame setup = new MarioPartyGame();
        System.out.println("Welcome to Mario Party!");
        System.out.println("How many bots do you want to play with? (Up to three bots)");
        int playerAmount = Integer.parseInt(userInput.nextLine());
        System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
        System.out.println("Which map would you like to play?");
        String userMap = userInput.nextLine();
        while (setup.isMap(userMap) == false){
            System.out.println("That is not an option");
            System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
            System.out.println("Which map would you like to play?");
            userMap = userInput.nextLine();
        }
        System.out.println("How many turns do you guys want to play up to? (Min is 10, Max is 40, must be divisible by 5)"); // check to ensure max/min
        int maxTurns = Integer.parseInt(userInput.nextLine());
        while (setup.validAmountOfTurns(maxTurns) == false) {
            System.out.println("That is not a valid amount of turns");
            System.out.println("How many turns do you guys want to play up to? (Min is 10, Max is 40, must be divisible by 5)");
            maxTurns = Integer.parseInt(userInput.nextLine());
        }
        MarioPartyGame MarioPartyGame = new MarioPartyGame(playerAmount,userMap,maxTurns);
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i <= playerAmount; i++)
        {
            players.add(new Player());
        }
        System.out.println(players);
        MarioPartyGame.determineFirst();
        players.get(1).addToInventory("taco");
        System.out.println(players.get(1).getPlayerInventory());
        players.get(1).addToInventory("burger");
        System.out.println(players.get(1).getPlayerInventory());
        players.get(1).addToInventory("salad");
        System.out.println(players.get(1).getPlayerInventory());
        System.out.println(players.get(1).useItem("taco"));
        System.out.println(players.get(1).getPlayerInventory());
    }
}
