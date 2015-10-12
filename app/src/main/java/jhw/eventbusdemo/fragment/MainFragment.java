package jhw.eventbusdemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import jhw.eventbusdemo.R;
import jhw.eventbusdemo.event.AsyncEvent;
import jhw.eventbusdemo.event.MainEvent;
import jhw.eventbusdemo.event.BaseEvent;
import jhw.eventbusdemo.event.MyEventBus;

/**
 * Created by jihongwen on 15/9/17.
 */
public class MainFragment extends EventBusBaseFragment<MainEvent, AsyncEvent> {

    @Bind(value = R.id.event_text)
    EditText eventText;
    @Bind(value = R.id.sendEvent)
    TextView sendEvent;
    @Bind(value = R.id.eventShow)
    TextView eventShow;

    @OnClick(R.id.sendEvent)
    @SuppressWarnings("unused")
    public void onClick(View view) {
        String text = eventText.getText().toString();
        MyEventBus.getDefault().post(new MainEvent(BaseEvent.Type.REFRESH, text));
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(MainEvent event) {
        eventDelegation(event);
    }

    @SuppressWarnings("unused")
    public void onEventBackgroundThread(AsyncEvent event) {
        asyncEventDelegation(event);
    }

    @Override
    public void eventDelegation(MainEvent event) {
        switch (event.type) {
            case REFRESH:
                eventShow.setText(event.data.toString());
                break;
        }
    }

    @Override
    public void asyncEventDelegation(AsyncEvent event) {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
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

    @Override
    protected int getViewLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        eventShow.setText("page1");
    }
}
