package presenter;

import bangdieptran.demo.view.IBaseView;

/**
 * Created by darklegend on 7/6/17.
 */

public abstract class Presenter implements IPresenter {

  IBaseView iBaseView;
  public Presenter(IBaseView iBaseView) {
    this.iBaseView = iBaseView;
    init();
  }

  public void init() {
    iBaseView.chaoBan();
  }
}
