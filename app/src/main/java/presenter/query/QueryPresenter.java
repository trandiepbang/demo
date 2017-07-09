package presenter.query;

import bangdieptran.demo.view.query.IQueryData;
import model.MvpModel;
import presenter.Presenter;

/**
 * Created by darklegend on 7/7/17.
 */

public class QueryPresenter extends Presenter implements IQueryPresenter {

  private final IQueryData iGetDataView;

  private final MvpModel mvpModel;

  public QueryPresenter(IQueryData iGetDataView, MvpModel mvpModel) {
    super(iGetDataView);
    this.iGetDataView = iGetDataView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void showData() {
    this.iGetDataView.onDataReturn(mvpModel.getTask());
    this.iGetDataView.sayHello();
  }
}
