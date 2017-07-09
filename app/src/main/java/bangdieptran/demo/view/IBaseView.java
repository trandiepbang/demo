package bangdieptran.demo.view;

import java.util.List;


/**
 * Created by darklegend on 7/7/17.
 */

public interface IBaseView {

  void onDataReturn(final List<String> data);

  void chaoBan();

}
