package jhw.eventbusdemo;

import android.os.Bundle;

import jhw.eventbusdemo.fragment.EventTestFragment;
import jhw.eventbusdemo.fragment.MainFragment;

/**
 * Created by jihongwen on 15/9/21.
 */
public class EXMainActivity extends BottomTabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addTabContent(R.id.page1, "one", MainFragment.newInstance());
        addTabContent(R.id.page2, "two", EventTestFragment.newInstance());
        setCurrentTab("one");
    }


}
