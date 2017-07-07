package presenter;

import bangdieptran.demo.view.IView;
import model.MvpModel;

/**
 * Created by darklegend on 7/7/17.
 */

public class QueryPresenter implements IQueryPresenter {

  private final IView iView;

  private final MvpModel mvpModel;

  public QueryPresenter(IView iView, MvpModel mvpModel) {
    this.iView = iView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void showData() {
    this.iView.onDataReturn(mvpModel.getTask());
  }
}
