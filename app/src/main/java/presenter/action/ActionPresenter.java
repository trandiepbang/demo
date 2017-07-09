package presenter.action;

import bangdieptran.demo.view.action.IActionView;
import model.MvpModel;

/**
 * Created by darklegend on 7/7/17.
 */

public class ActionPresenter implements IActionPresenter {

  private final IActionView iActionView;

  private final MvpModel mvpModel;

  public ActionPresenter(IActionView iActionView, MvpModel mvpModel) {
    this.iActionView = iActionView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void addData(String title) {
    this.mvpModel.addTask(title);
    this.iActionView.onDataReturn(this.mvpModel.getTask());
    this.iActionView.sayHello2();
  }

  @Override
  public void deleteData(String title) {
    this.mvpModel.deleteTask(title);
    this.iActionView.onDataReturn(this.mvpModel.getTask());
    this.iActionView.sayHello2();
  }

}
