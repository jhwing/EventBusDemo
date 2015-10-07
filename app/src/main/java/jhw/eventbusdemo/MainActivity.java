package jhw.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jhw.databinding.activity.RoboBindingTestActivity;
import jhw.eventbusdemo.fragment.EventTestFragment;
import jhw.eventbusdemo.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    SparseArray<Fragment> mFragments = new SparseArray<>();

    int curTab = R.id.page1;

    @OnClick({R.id.page1, R.id.page2})
    @SuppressWarnings("unused")
    public void onClick(View view) {
        if (curTab == view.getId()) {
            return;
        }
        Fragment fragment = mFragments.get(curTab);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }

        curTab = view.getId();
        Fragment nextFragment = mFragments.get(view.getId());
        if (nextFragment == null) {

            switch (view.getId()) {
                case R.id.page1:
                    nextFragment = MainFragment.newInstance();
                    break;
                case R.id.page2:
                    nextFragment = EventTestFragment.newInstance();
                    break;
            }
            mFragments.append(view.getId(), nextFragment);
            fragmentTransaction.add(R.id.content, nextFragment);
        } else {
            fragmentTransaction.show(nextFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startActivity(new Intent(this, RoboBindingTestActivity.class));
        finish();
        //initMainFragment();
    }

    private void initMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = mFragments.get(curTab);
        mFragments.append(R.id.page1, MainFragment.newInstance());
        fragmentTransaction.add(R.id.content, mFragments.get(R.id.page1), "main");
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
