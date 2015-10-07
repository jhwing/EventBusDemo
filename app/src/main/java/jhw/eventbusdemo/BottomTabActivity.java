package jhw.eventbusdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jihongwen on 15/9/21.
 */
public abstract class BottomTabActivity extends AppCompatActivity implements View.OnClickListener {

    protected SparseArray<String> mTabFragments = new SparseArray<>();

    protected Map<String, Fragment> mFragments = new HashMap<>();

    protected String mCurTab = "";

    protected String mLastTab = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void setCurrentTab(int resourceId) {
        setCurrentTab(mTabFragments.get(resourceId));
    }

    protected void setCurrentTab(String curTab) {
        mCurTab = curTab;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!mLastTab.equals("")) {
            Fragment fragment = fragmentManager.findFragmentByTag(mLastTab);
            if (fragment != null) {
                fragmentTransaction.hide(fragment);
            }
        }
        Fragment fragment = fragmentManager.findFragmentByTag(curTab);
        if (fragment == null) {
            fragment = mFragments.get(curTab);
            fragmentTransaction.add(R.id.content, fragment, curTab);
        } else {
            fragmentTransaction.show(fragment);
        }
        mLastTab = mCurTab;
        fragmentTransaction.commitAllowingStateLoss();
    }

    protected void addTabContent(int resourceId, String tab, Fragment fragment) {
        mFragments.put(tab, fragment);
        mTabFragments.append(resourceId, tab);
        findViewById(resourceId).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setCurrentTab(v.getId());
    }
}
