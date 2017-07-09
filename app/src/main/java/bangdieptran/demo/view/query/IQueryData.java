package bangdieptran.demo.view.query;

import java.util.List;

import bangdieptran.demo.view.IBaseView;

/**
 * Created by darklegend on 7/7/17.
 */

public interface IQueryData extends IBaseView {

  void sayHello();

  void onDataReturn(final List<String> data);
}
