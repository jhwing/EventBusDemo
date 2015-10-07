package jhw.eventbusdemo.event;

/**
 * Created by jihongwen on 15/9/17.
 */
public class BaseEvent {

    public enum Type {
        REFRESH,
        USER_UPDATE,
        DOWNLOAD
    }

    public Type type;

    public Object data;

    public BaseEvent(Type action, Object data) {
        this.type = action;
        this.data = data;
    }
}
