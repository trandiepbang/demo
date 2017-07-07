package presenter;

import bangdieptran.demo.view.IView;
import model.MvpModel;

/**
 * Created by darklegend on 7/7/17.
 */

public class ActionPresenter extends Presenter {

  private final IView iView;

  private final MvpModel mvpModel;

  public ActionPresenter(IView iView, MvpModel mvpModel) {
    this.iView = iView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void addData(String title) {
    this.mvpModel.addTask(title);
    this.iView.onDataReturn(this.mvpModel.getTask());
  }

  @Override
  public void deleteData(String title) {
    this.mvpModel.deleteTask(title);
    this.iView.onDataReturn(this.mvpModel.getTask());
  }
}
