package mobads.sprite.com.myeventbus;

/**
 * Created by jihongwen on 15/10/11.
 */
public class MyEventBus {

    private static MyEventBus defaultInstance;

    /**
     * Convenience singleton for apps using a process-wide EventBus instance.
     */
    public static MyEventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (MyEventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new MyEventBus();
                }
            }
        }
        return defaultInstance;
    }

}
