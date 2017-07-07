package presenter;

import bangdieptran.demo.view.IGetDataView;
import model.MvpModel;

/**
 * Created by darklegend on 7/7/17.
 */

public class QueryPresenter extends Presenter {

  private final IGetDataView iGetDataView;

  private final MvpModel mvpModel;

  public QueryPresenter(IGetDataView iGetDataView, MvpModel mvpModel) {
    this.iGetDataView = iGetDataView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void showData() {
    this.iGetDataView.onDataReturn(mvpModel.getTask());
  }
}
