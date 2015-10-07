// Generated code from Butter Knife. Do not modify!
package jhw.eventbusdemo.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class EventTestFragment$$ViewBinder<T extends jhw.eventbusdemo.fragment.EventTestFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492949, "field 'eventShow'");
    target.eventShow = finder.castView(view, 2131492949, "field 'eventShow'");
    view = finder.findRequiredView(source, 2131492948, "field 'eventText'");
    target.eventText = finder.castView(view, 2131492948, "field 'eventText'");
    view = finder.findRequiredView(source, 2131492947, "method 'onClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.eventShow = null;
    target.eventText = null;
  }
}
