package bangdieptran.demo.view.action;

import java.util.List;

import bangdieptran.demo.view.IBaseView;

/**
 * Created by darklegend on 7/6/17.
 */

public interface IActionView extends IBaseView {

  void sayHello2();

  void onDataReturn(final List<String> data);

}
