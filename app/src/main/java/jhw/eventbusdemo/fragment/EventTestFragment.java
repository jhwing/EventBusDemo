package jhw.eventbusdemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import jhw.eventbusdemo.R;
import jhw.eventbusdemo.event.AsyncEvent;
import jhw.eventbusdemo.event.EventTestEvent;
import jhw.eventbusdemo.event.MainEvent;
import jhw.eventbusdemo.event.BaseEvent;
import jhw.eventbusdemo.event.MyEventBus;

/**
 * Created by jihongwen on 15/9/17.
 */
public class EventTestFragment extends EventBusBaseFragment<EventTestEvent, AsyncEvent> {

    @Bind(value = R.id.eventShow)
    TextView eventShow;
    @Bind(value = R.id.event_text)
    EditText eventText;

    @OnClick(R.id.sendEvent)
    @SuppressWarnings("unused")
    public void onClick(View view) {
        String text = eventText.getText().toString();
        MyEventBus.getDefault().post(new EventTestEvent(BaseEvent.Type.REFRESH, text));
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(EventTestEvent event) {
        eventDelegation(event);
    }

    @SuppressWarnings("unused")
    public void onEventBackgroundThread(AsyncEvent event) {
        asyncEventDelegation(event);
    }

    @Override
    public void eventDelegation(EventTestEvent event) {
        eventShow.setText(event.data.toString());
    }

    @Override
    public void asyncEventDelegation(AsyncEvent event) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MyEventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyEventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        eventShow.setText("page2");
    }

    @Override
    protected int getViewLayoutResource() {
        return R.layout.fragment_main;
    }

    public static Fragment newInstance() {
        return new EventTestFragment();
    }
}
