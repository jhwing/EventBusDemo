package jhw.eventbusdemo.fragment;

import jhw.eventbusdemo.event.BaseEvent;

/**
 * Created by jihongwen on 15/9/17.
 */
public class DataBindingFragment extends EventBusBaseFragment {


    @Override
    protected int getViewLayoutResource() {
        return 0;
    }

    @Override
    public void eventDelegation(Object o) {

    }

    @Override
    public void asyncEventDelegation(BaseEvent event) {

    }

}
