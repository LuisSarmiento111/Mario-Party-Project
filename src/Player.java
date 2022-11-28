import java.util.ArrayList;

public class Player {

    private ArrayList<String> playerInventory;
    private int playerCoins;
    private int playerSpace;
    private String name;
    private Maps map;
    private boolean doubled;
    private boolean passedStar;
    private int stars;
    private boolean turnOver;

    private MarioPartyGame gameLogic;
    boolean isBot;
    private Items itemLogic;
    public int currentSpacesMoved;
    private boolean cursedBlockActive;

    public boolean halfwayDiceActive;

    public Player(Maps currentMap, boolean isBot) {
        playerInventory = new ArrayList<>();
        playerSpace = 0;
        playerCoins = 0;
        map = currentMap;
        passedStar = false;
        stars = 0;
        turnOver = false;
        gameLogic = new MarioPartyGame();
        this.isBot = isBot;
        currentSpacesMoved = 0;
    }

    public ArrayList<String> getPlayerInventory() {
        return playerInventory;
    }

    public void addToInventory(String item) {
        playerInventory.add(item);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String updatePlayerSpace(int spacesMoved, Player player) {
        String returnString = "";
        int previousSpace = playerSpace;
        final String resetColor = "\u001B[0m";
        String textColor = "";
        spacesMoved += currentSpacesMoved;
        if (cursedBlockActive) {
            spacesMoved = (int) (Math.random() * 3) + 1;
        }
        playerSpace += spacesMoved;
        returnString += name + " has moved " + spacesMoved + " spaces.\n";
        if (playerSpace > map.getMaxSpaces()) {
            playerSpace = playerSpace - map.getMaxSpaces();
        }
        if (map.getBlueSpaces().contains(playerSpace)) {
            textColor = "\u001B[34m";
            if (doubled) {
                playerCoins += 6;
                returnString += textColor + name + " landed on a blue space.\nYou get 6 coins." + resetColor;
            } else {
                playerCoins += 3;
                returnString += textColor + name + " landed on a blue space.\nYou get 3 coins." + resetColor;
            }
        }
        if (map.getRedSpaces().contains(playerSpace)) {
            textColor = "\u001B[31m";
            if (doubled) {
                playerCoins -= 6;
                returnString += textColor + name + " landed on a red space.\nYou lose 6 coins." + resetColor;
            } else {
                playerCoins -= 3;
                returnString += textColor + name + " landed on a red space.\nYou lose 3 coins." + resetColor;
            }
        }
        if (map.getBowserSpaces().contains(playerSpace)) {
            textColor = "\u001B[35m";
            returnString += textColor + name + " landed on a bowser space. You have a chance to: \nLose a random amount of coins" +
                    "\nLose half your coins\nLose a star\nGet 100 stars!!!!!!!\n\nA wheel will be spun to determine what you get.\n"
                    + bowserSpaceResults() + resetColor;
        }
        if (map.getLuckySpaces().contains(playerSpace)) {
            textColor = "\u001B[32m";
            returnString += textColor + name + " landed on a lucky space. You have a chance to: \nGain a random amount of coins" +
                    "\nGet a mushroom\nGet a Double Dice\nTeleport 10-20 spaces behind the star space." +
                    "\nA wheel will be spun to determine what you get.\n" + luckySpaceResults() + resetColor;
            previousSpace = playerSpace;
        }
        if (map.getItemSpaces().contains(playerSpace)) {
            textColor = "\u001B[36m";
            returnString += textColor + name + " landed on a item space. You will randomly receive an item from the item pool.\n" +
                    itemSpaceResults() + resetColor;
        }
        if (playerCoins < 0) {
            playerCoins = 0;
        }
        if (map.getStarSpace() > previousSpace && map.getStarSpace() <= playerSpace) {
            passedStar = true;
        } else {
            passedStar = false;
        }
        returnString += "\n" + name + " currently has " + playerCoins + " coins.\n" + name +
                " is currently on space " + playerSpace;
        turnOver = true;
        currentSpacesMoved = 0;
        return returnString;
    }

    public int currentPlayerSpace() {
        return playerSpace;
    }

    public boolean passedStar() {
        return passedStar;
    }

    public void updatePlayerCoins(int coins) {
        playerCoins += coins;
    }

    public int amountOfCoins() {
        return playerCoins;
    }

    public boolean haveItem(String item) {
        boolean haveItem = false;
        if (playerInventory.indexOf(item) != -1) {
            haveItem = true;
        }
        return haveItem;
    }

    public int amountOfStars() {
        return stars;
    }

    public void updateStars() {
        stars++;
    }

    public String bowserSpaceResults() {
        String results = "";
        int probabilityNum = (int) (Math.random() * 10) + 1;
        if (probabilityNum <= 5) {
            int coinsLost = (int) (Math.random() * 25) + 1;
            playerCoins -= coinsLost;
            if (playerCoins < 0) {
                playerCoins = 0;
            }
            results = "Bowser decided to take " + coinsLost + " coins!";
        } else if (probabilityNum > 5 && probabilityNum < 9) {
            playerCoins /= 2;
            results = "Bowser decided to take half of your coins!";
        } else if (probabilityNum == 9) {
            stars--;
            results = "Bowser decided to take one of your stars!";
        } else {
            results = "Bowser says nothing and runs away.";
        }
        return results;
    }

    public String luckySpaceResults() {
        String results = "";
        int probabilityNum = (int) (Math.random() * 10) + 1;
        if (probabilityNum <= 5) {
            int coinsGained = (int) (Math.random() * 25) + 1;
            playerCoins += coinsGained;
            results = name + " gained " + coinsGained + " coins!";
        } else if (probabilityNum > 5 && probabilityNum < 8) {
            playerInventory.add("Mushroom");
            results = name + " got a mushroom!";
        } else if (probabilityNum == 8 || probabilityNum == 9) {
            playerInventory.add("Double Dice");
            results = name + " got a double dice!";
        } else {
            playerSpace = map.getStarSpace() - ((int) (Math.random() * 10) + 10);
            results = name + " got teleported closer to the star!";
        }
        return results;
    }

    public String itemSpaceResults() {
        itemLogic = new Items();
        String results = "";
        String itemAdded = itemLogic.getGameItems().get((int) (Math.random() * (itemLogic.getAmountOfItems() - 1)));
        addToInventory(itemAdded);
        results += name + " randomly got a " + itemAdded;
        return results;
    }

    public String buyStar(String answer) {
        if (answer.equals("yes")) {
            updatePlayerCoins(-20);
            updateStars();
            return "You have bought a star for 20 coins!" + map.newStarSpace();
        } else {
            return "You have decided not to buy a star";
        }
    }

    public boolean isTurnOver() {
        return turnOver;
    }

    public String actionSelected(int actionNum, Player player) {
        String actionDoneByPlayer = "";
        if (actionNum == 1) {
            actionDoneByPlayer = updatePlayerSpace(gameLogic.diceRoll(), player);
        }
        if (actionNum == 2) {

        }
        if (actionNum == 3) {
            Maps playerMap = new Maps();
            actionDoneByPlayer = playerMap.showMapWithPlayers();
        }
        return actionDoneByPlayer;
    }

    public void endOfTurn() {
        turnOver = false;
    }

    public String botAction(Player bot, ArrayList<Player> players) {
        itemLogic = new Items(players);
        String botActionResults = "";
        int previousSpace = playerSpace;
        if (playerInventory.size() > 0) {
            int probabilityOfDoing = (int) (Math.random() * 4) + 1;
            if (probabilityOfDoing > 1) {
                botActionResults += useItem(playerInventory.get((int) (Math.random() * playerInventory.size())), bot, players);
                botActionResults += updatePlayerSpace((int) (Math.random() * 10) + 1, bot) + "\n";
            } else {
                botActionResults += updatePlayerSpace((int) (Math.random() * 10) + 1, bot) + "\n";
            }
        } else {
            botActionResults += updatePlayerSpace((int) (Math.random() * 10) + 1, bot) + "\n";
        }
        if (map.getStarSpace() > previousSpace && map.getStarSpace() <= playerSpace) {
            passedStar = true;
        } else {
            passedStar = false;
        }
        if (passedStar == true && playerCoins >= 20) {
            botActionResults += name + " passed by a star space. They bought it for 20 coins.";
            stars++;
        } else if (passedStar == true) {
            botActionResults += name + " passed by a star space.\nUnfortunately they do not have enough coins to buy a star.";
        }
        isBot = true;
        return botActionResults + "\n";
    }

    public String useItem(String item, Player player, ArrayList<Player> players) {
        itemLogic = new Items();
        String itemResults = "";
        itemResults = itemLogic.itemEffects(item, player);
        playerInventory.remove(playerInventory.indexOf(item));
        return itemResults;
    }

    public void changeSpacesMoved(int change) {
        currentSpacesMoved += change;
    }

    public void cursedBlockActive() {
        cursedBlockActive = true;
    }

    public void halfwayDiceActive() {
        halfwayDiceActive = true;
    }

    public void setPlayerSpace(int space) {
        playerSpace = space;
    }
}

