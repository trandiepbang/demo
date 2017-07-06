package presenter;

import bangdieptran.demo.view.IView;
import controller.Controller;

/**
 * Created by darklegend on 7/6/17.
 */

public class Presenter implements IPresenter {

  private IView iView;

  private Controller controller;

  public Presenter(final IView iView, final Controller controller) {
    this.iView = iView;
    this.controller = controller;
  }

  @Override
  public void addData(String title) {
    this.controller.addTask(title);
    this.returnData();
  }

  @Override
  public void deleteData(String title) {
    this.controller.deleteTask(title);
    this.returnData();
  }

  @Override
  public void returnData() {
    this.iView.onDataReturn(this.controller.getTasks());
  }
}
