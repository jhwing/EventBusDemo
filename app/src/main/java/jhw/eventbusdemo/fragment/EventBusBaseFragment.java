package jhw.eventbusdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jhw.eventbusdemo.event.BaseEvent;

/**
 * Created by jihongwen on 15/9/17.
 */
public abstract class EventBusBaseFragment<Event, AsyncEvent extends BaseEvent> extends Fragment {

    @SuppressWarnings("unused")
    public void onEventMainThread(Event event) {
        eventDelegation(event);
    }

    @SuppressWarnings("unused")
    public void onEvnetBackground(AsyncEvent event) {
        asyncEventDelegation(event);
    }

    public abstract void eventDelegation(Event event);

    public abstract void asyncEventDelegation(AsyncEvent event);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getViewLayoutResource(), container, false);
    }

    protected abstract int getViewLayoutResource();
}
