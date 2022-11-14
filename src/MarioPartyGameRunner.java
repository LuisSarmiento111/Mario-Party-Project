import java.util.Scanner;

public class MarioPartyGameRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        MarioPartyGame MarioPartyGame = new MarioPartyGame(4,"taco",40);
        System.out.println("Welcome to Mario Party!");
        System.out.println("How many bots do you want to play with? (Up to three bots)");
        int players = Integer.parseInt(userInput.nextLine());
        System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
        System.out.println("Which map would you like to play?");
        String map = userInput.nextLine();
        while (MarioPartyGame.isMap(map) == false){
            System.out.println("That is not an option");
            System.out.println("The maps you can play are Lava Castle..."); // work on maps I guess
            System.out.println("Which map would you like to play?");
            map = userInput.nextLine();
        }
        System.out.println(MarioPartyGame.diceRoll());
        PlayerInventory player1 = new PlayerInventory();
        player1.addToInventory("taco");
        System.out.println(player1.getPlayerInventory());
        player1.addToInventory("burger");
        System.out.println(player1.getPlayerInventory());
        player1.addToInventory("salad");
        System.out.println(player1.getPlayerInventory());
        MarioPartyGame.itemUsage(player1.getPlayerInventory(),"taco");
        System.out.println(player1.getPlayerInventory());
    }

}
