package states.encounters;

import exceptions.NotEnoughMoneyException;
import model.utilities.Delimiter;
import model.utilities.ItemAdapter;
import model.items.Item;
import model.people.Player;
import model.people.Trader;
import model.utilities.TimeDelayer;
import states.PlanetIdling;
import states.State;
import ui.Game;

public class Trading extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('$');
        System.out.println("You encountered a trader");
        trade();
        Delimiter.printCharDelimiter('$');
    }

    private void trade(){

        Trader trader = new Trader();
        Player player = Game.getPlayer();

        while(true){
            Delimiter.printCharDelimiter('-');
            System.out.println("Trader items:");
            trader.getInventory().listItems();
            Delimiter.printCharDelimiter('-');
            TimeDelayer.delaySeconds();

            System.out.println("Your items:");
            System.out.println("Money | $" + player.getMoney());
            player.getInventory().listItems();
            Delimiter.printCharDelimiter('-');
            TimeDelayer.delaySeconds();

            System.out.println("\nHow would you like to proceed?");
            System.out.println("1. Buy items");
            System.out.println("2. Sell items");
            System.out.println("3. Continue exploring");

            String input = Game.askForUserInput("> ");
            Delimiter.printEmtpyLines(2);

            switch(input){
                case "1":
                    buyItems(trader);
                    Delimiter.printCharDelimiter('$');
                    Delimiter.printEmtpyLines(2);
                    break;
                case "2":
                    sellItems(trader);
                    Delimiter.printCharDelimiter('$');
                    Delimiter.printEmtpyLines(2);
                    break;
                case "3":
                    Game.setState(new PlanetIdling());
                    Delimiter.printEmtpyLines(2);
                    return;

            }
        }
    }

    private void sellItems(Trader trader) {
        Player player = Game.getPlayer();
        while (true){
            System.out.println("Please type the name of the item you would like to sell, or 'Cancel' to cancel.");
            String input = Game.askForUserInput("> ");
            if (input.equals("Cancel")){
                return;
            }
            else if (player.getInventory().hasItem(input)){
                Item item = ItemAdapter.makeItem(input);
                int numToSell;
                while(true){
                    numToSell = getNumberToTrade();
                    if (numToSell < 0){
                        System.out.println("Amount must be over 0.");
                    }
                    else if (numToSell > player.getInventory().getNumOfItem(item)){
                        System.out.println("You don't have that many items of that type.");
                    }
                    else {
                        break;
                    }
                }
                player.getInventory().useNumOfItem(input, numToSell);
                player.depositFunds(item.getWorth() * numToSell);
                trader.getInventory().addItems(item, numToSell);
                System.out.println("Sold " + numToSell + " " + input + "(s) to trader for " + item.getWorth() * numToSell + ".");
                break;
            }
            else {
                System.out.println("You do not have that item. Please try again.");
            }
            TimeDelayer.delaySeconds();
        }
    }

    private int getNumberToTrade() {
        while (true) {
            System.out.println("How many?");
            String input = Game.askForUserInput("> ");

            if (isInteger(input)){
                return Integer.parseInt(input);
            }
            System.out.println("Not a valid number");
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    private void buyItems(Trader trader) {
        while (true){
            System.out.println("Please type the name of the item you would like to buy, or 'Cancel' to cancel.");
            String input = Game.askForUserInput("> ");
            if (input.equals("Cancel")){
                Game.setState(new Trading());
                return;
            }
            else if (trader.getInventory().hasItem(input)){
                int numToBuy;
                Item item = ItemAdapter.makeItem(input);

                if (item == null){
                    throw new NullPointerException("Item should not be null after passing in inventory condition");
                }

                    numToBuy = getNumberToTrade();
                    if (numToBuy < 0) {
                        System.out.println("Amount must be over 0.");
                        break;
                    } else if (numToBuy < trader.getInventory().getNumOfItem(item)) {
                        System.out.println("The trader doesn't have that many items of that type.");
                        break;
                    } else {
                        try {
                            Game.getPlayer().buyItems(item, numToBuy);
                            trader.getInventory().useNumOfItem(input, numToBuy);
                            return;
                        } catch (NotEnoughMoneyException e) {
                            System.out.println("Not enough money for that item. ");
                            break;
                        }
                    }

            }
            else {
                System.out.println("The trader does not have that item. Please try again.");
            }
        }

    }
}


