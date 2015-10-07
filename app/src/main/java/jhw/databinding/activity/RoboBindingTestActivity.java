package jhw.databinding.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;

import jhw.databinding.PresentationModel.RoboBindingPresentationModel;
import jhw.databinding.PresentationModel.TestView;
import jhw.eventbusdemo.R;

/**
 * Created by jihongwen on 15/9/21.
 */
public class RoboBindingTestActivity extends AppCompatActivity implements TestView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewBinder viewBinder = createViewBinder();
        View rooView = viewBinder.inflateAndBind(R.layout.robobinding_test_layout, new RoboBindingPresentationModel(this));
        setContentView(rooView);
    }

    private ViewBinder createViewBinder() {
        BinderFactory reusableBinderFactory = new BinderFactoryBuilder().build();
        return reusableBinderFactory.createViewBinder(this);
    }

    @Override
    public void sendEvent() {

    }
}
