package jhw.databinding.PresentationModel;

import android.util.Log;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.property.PropertyChangeListener;

/**
 * Created by jihongwen on 15/9/21.
 */
@PresentationModel
public class RoboBindingPresentationModel implements HasPresentationModelChangeSupport {

    final TestView testView;

    private final PresentationModelChangeSupport changeSupport;

    public RoboBindingPresentationModel(TestView testView) {
        this.testView = testView;
        changeSupport = new PresentationModelChangeSupport(this);
        changeSupport.addPropertyChangeListener("eventShow", new PropertyChangeListener() {
            @Override
            public void propertyChanged() {
                Log.d("jihongwen", "eventshow changed");
            }
        });
    }

    String hello = "";

    public void setHello(String hello) {
        this.hello = hello;
    }

    String defHello = "hello roboBinding";

    public String getHello() {
        if (hello.equals("")) {
            return defHello;
        }
        return hello;
    }

    public void setEventShow(String hello) {

    }

    public String getEventShow() {
        return hello;
    }

    public void sendEvent() {
        changeSupport.firePropertyChange("eventShow");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
