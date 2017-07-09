package presenter.query;

import bangdieptran.demo.view.query.IQueryData;
import model.MvpModel;
import presenter.BasePresenter;

/**
 * Created by darklegend on 7/7/17.
 */

public class QueryPresenter extends BasePresenter implements IQueryPresenter {

  private final IQueryData iQueryData;

  private final MvpModel mvpModel;

  public QueryPresenter(IQueryData iQueryData, MvpModel mvpModel) {
    super();
    this.iQueryData = iQueryData;
    this.mvpModel = mvpModel;
  }

  @Override
  public void showData() {
    this.iQueryData.onDataReturn(mvpModel.getTask());
    this.iQueryData.sayHello();
  }
}
