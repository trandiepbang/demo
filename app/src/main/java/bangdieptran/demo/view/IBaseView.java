package bangdieptran.demo.view;

/**
 * Created by darklegend on 7/7/17.
 */

public interface IBaseView<T> {

  void setBaseView(T view);

  T getBaseView();

  void destoryBaseView();
}
