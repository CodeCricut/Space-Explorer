package model.utilities;

public class Delimiter {

    private static final int amtOfChars = 100;

    public static void printCharDelimiter(char c){
        for (int i = 0; i < amtOfChars; i++){
            System.out.print(c);
        }
        System.out.println();
    }

    public static void printEmptyConsole(){
        for (int i = 0; i < 100; i++){
            System.out.print("\n\n\n\n\n");
        }
    }

    public static void printEmtpyLines(int lines){
        for (int i = 0; i < lines; i++){
            System.out.println();
        }
    }
}
