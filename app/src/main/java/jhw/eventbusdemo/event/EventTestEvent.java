package jhw.eventbusdemo.event;

/**
 * Created by jihongwen on 15/10/12.
 */
public class EventTestEvent extends BaseEvent{
    public EventTestEvent(Type action, Object data) {
        super(action, data);
    }
}
