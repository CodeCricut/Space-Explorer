package states.encounters;

import exceptions.ItemDoesNotExist;
import exceptions.NotEnoughItemsException;
import exceptions.NotEnoughMoneyException;
import model.factories.ItemFactory;
import model.items.Item;
import model.people.Player;
import model.people.Trader;
import model.factories.TreasureFactory;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import states.PlanetIdling;
import states.State;
import ui.Game;

public class Trading extends State {

    private Player player = Game.getPlayer();
    private Trader trader = new Trader();

    @Override
    public void advance() {
        Delimiter.printCharDelimiter('$');
        System.out.println("You encountered a trader");
        trade();
        Delimiter.printCharDelimiter('$');
    }

    //General Trading Methods

    private void trade() {
        while (Trading.class.equals(Game.getState().getClass())) {
            printInventories();
            presentTradingOptions();
            processTradingOptions();
        }
    }

    private void printInventories() {
        Delimiter.printCharDelimiter('-');
        System.out.println("Trader inventory:");
        trader.getInventory().listItems();
        Delimiter.printCharDelimiter('-');

        System.out.println("Player inventory:");
        System.out.println("$" + player.getMoney());
        player.getInventory().listItems();
        Delimiter.printCharDelimiter('-');
        TimeDelayer.delaySeconds();
    }

    private void presentTradingOptions() {
        System.out.println("How would you like to proceed?");
        System.out.println("1. Buy items");
        System.out.println("2. Sell items");
        System.out.println("3. Continue Exploring");
    }

    private void processTradingOptions() {
        String tradingOption = Game.askForUserInput("> ");
        switch (tradingOption){
            case "1":
                buyItems();
                break;
            case "2":
                sellItems();
                break;
            case "3":
                Game.setState(new PlanetIdling());
                break;
            default:
                System.out.println("Not a valid option.");
        }
    }

    //Buying Methods

    private void buyItems() {
        presentBuyingOptions();
        processBuyingOptions();
        TimeDelayer.delaySeconds();
        Delimiter.printEmptyConsole();
    }

    private void presentBuyingOptions(){
        System.out.println("Type the name of the item you would like to buy, or 'Cancel' to cancel.");
    }

    private void processBuyingOptions(){
        String buyingOption = Game.askForUserInput("> ");
        if (buyingOption.equals("Cancel")){
            return;
        }
        try {
            Item buyingItem = ItemFactory.convertItemNameToItem(buyingOption);
            int numOfItem;
            do {
                numOfItem = getNumOfItems();
            } while( numOfItem == -1);
            buyNumOfItem(buyingItem, numOfItem);
        } catch (ItemDoesNotExist e) {
            System.out.println("Item does not exist.");
        } catch (NotEnoughMoneyException e) {
            System.out.println("Not enough money.");
        } catch (NotEnoughItemsException e) {
            System.out.println("Trader does not have that many items of that type.");
        }
    }

    private void buyNumOfItem(Item buyingItem, int numOfItem) throws NotEnoughMoneyException, NotEnoughItemsException {
        player.buyItems(buyingItem, numOfItem);
        trader.sellNumOfItem(buyingItem, numOfItem);
        System.out.println("Bought " + numOfItem + " " + buyingItem.getName() + " for $" + buyingItem.getWorth() * numOfItem);
    }

    //Selling Methods

    private void sellItems() {
        presentSellingOptions();
        processSellingOptions();
        TimeDelayer.delaySeconds();
        Delimiter.printEmptyConsole();
    }

    private void presentSellingOptions(){
        System.out.println("Type the name of the item you would like to sell, or 'Cancel' to cancel.");
    }

    private void processSellingOptions(){
        String sellingOption = Game.askForUserInput("> ");
        if (sellingOption.equals("Cancel")){
            return;
        }
        try {
            Item sellingItem = ItemFactory.convertItemNameToItem(sellingOption);
            int numOfItem;
            do {
                numOfItem = getNumOfItems();
            } while( numOfItem == -1);
            sellNumOfItem(sellingItem, numOfItem);
        } catch (ItemDoesNotExist e) {
            System.out.println("Item does not exist. Try again.");
        } catch (NotEnoughItemsException e) {
            System.out.println("Not enough items of that type in inventory.");
        }
    }

    private void sellNumOfItem(Item sellingItem, int numOfItem) throws NotEnoughItemsException {
        player.sellItems(sellingItem, numOfItem);
        trader.getInventory().addItems(sellingItem, numOfItem);
        System.out.println("Sold " + numOfItem + " " + sellingItem.getName() + "(s) for " + sellingItem.getWorth() * numOfItem);
    }

    //Get Number of Items methods

    private int getNumOfItems(){
        System.out.print("How many? ");
        String numOfItems = Game.askForUserInput("");
        if (! isInteger(numOfItems) || Integer.parseInt(numOfItems) < 1){
            System.out.println("Input is not an integer. Try again.");
            return -1;
        }
        return Integer.parseInt(numOfItems);
    }

    private static boolean isInteger(String s) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),10) < 0) return false;
        }
        return true;
    }
}




