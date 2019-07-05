package model.utilities;

import java.util.concurrent.TimeUnit;

public class TimeDelayer {

    public static void delaySeconds(int delay){
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delaySeconds(){
        delaySeconds(2);
    }
}
