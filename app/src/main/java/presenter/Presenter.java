package presenter;

import android.content.ContentValues;

import bangdieptran.demo.view.IView;
import model.MvpModel;

/**
 * Created by darklegend on 7/6/17.
 */

public class Presenter implements IPresenter {

  private final IView iView;

  private final MvpModel mvpModel;

  public Presenter(IView iView, MvpModel mvpModel) {
    this.iView = iView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void addData(String title) {
    final ContentValues data = new ContentValues();
    data.put("title", title);
    this.mvpModel.addTask(data);
    this.iView.onDataReturn(this.mvpModel.getTask());
  }

  @Override
  public void deleteData(String title) {
    this.mvpModel.deleteTask(title);
    this.iView.onDataReturn(this.mvpModel.getTask());
  }
}
