package states;

import exceptions.ItemDoesNotExist;
import model.Inventory;
import model.factories.ConsumableFactory;
import model.items.consumables.Consumable;
import model.people.Player;
import model.utilities.Delimiter;
import ui.Game;

public class UsingConsumable extends State {

    private Player player = Game.getPlayer();
    private Inventory inventory = player.getInventory();

    @Override
    public void advance() {
        Delimiter.printCharDelimiter('~');
        printConsumablesInventory();

        while(UsingConsumable.class.equals(Game.getState().getClass())) {
            presentOptions();
            processOption();
        }
        Delimiter.printCharDelimiter('~');
    }

    private void printConsumablesInventory() {
        System.out.println("Money: $" + player.getMoney());
        System.out.println("Health: " + player.getCurrHealth() + " / " + player.getMaxHealth());
        System.out.println("Damage: " + player.getWeapon().getDamage());
        Delimiter.printCharDelimiter('-');
        inventory.listConsumables();
        Delimiter.printCharDelimiter('-');
    }

    private void presentOptions() {
        System.out.println("Type the name of the consumable you would like to use, or 'Cancel' to cancel.");
    }

    private void processOption() {
        String input = Game.askForUserInput("> ");
        if (input.equals("Cancel")){
            Game.setState(new ViewingInventory());
            return;
        }
        try {
            Consumable consumable = ConsumableFactory.convertConsumableNameToConsumable(input);

            if (inventory.hasItem(consumable)) {
                consumeItem(consumable);
            }
            else{
                System.out.println("Inventory does not contain that consumable. Try again.");
            }
        } catch (ItemDoesNotExist itemDoesNotExist) {
            System.out.println("Item does not exist. Try again.");
        }
    }

    private void consumeItem(Consumable consumable) {
        consumable.consume();
        inventory.useNumOfItem(consumable, 1);
        Game.setState(new ViewingInventory());
    }
}
