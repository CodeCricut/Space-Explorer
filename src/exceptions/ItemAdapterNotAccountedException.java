package exceptions;

public class ItemAdapterNotAccountedException extends Exception {
    public ItemAdapterNotAccountedException(){
        super("The item that was sent intot he item adapter is not valid or was missing from the switch statement");
    }
}
