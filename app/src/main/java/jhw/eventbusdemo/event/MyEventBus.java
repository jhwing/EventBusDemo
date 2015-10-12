package jhw.eventbusdemo.event;

import de.greenrobot.event.EventBus;

/**
 * Created by jihongwen on 15/10/12.
 */
public class MyEventBus {

    private static EventBus defaultInstance = null;

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = EventBus.builder().eventInheritance(false).build();
                }
            }
        }
        return defaultInstance;
    }
}
