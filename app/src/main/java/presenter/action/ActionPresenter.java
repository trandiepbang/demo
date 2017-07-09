package presenter.action;

import bangdieptran.demo.view.action.IActionView;
import model.MvpModel;
import presenter.BasePresenter;

/**
 * Created by darklegend on 7/7/17.
 */

public class ActionPresenter extends BasePresenter implements IActionPresenter {

  private final IActionView iActionView;

  private final MvpModel mvpModel;

  public ActionPresenter(IActionView iActionView, MvpModel mvpModel) {
    super();
    this.iActionView = iActionView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void addData(String title) {
    this.mvpModel.addTask(title);
    this.iActionView.onDataReturn(this.mvpModel.getTask());
    this.iActionView.sayHello();
  }

  @Override
  public void deleteData(String title) {
    this.mvpModel.deleteTask(title);
    this.iActionView.onDataReturn(this.mvpModel.getTask());
    this.iActionView.sayHello();
  }

}
