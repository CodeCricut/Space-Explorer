package exceptions;

public class ItemDoesNotExist extends Exception {
    public ItemDoesNotExist(){
        super("The item that was sent intot he item adapter is not valid or was missing from the switch statement");
    }
}
