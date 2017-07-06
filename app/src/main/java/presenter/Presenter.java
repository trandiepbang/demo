package presenter;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import bangdieptran.demo.view.IView;
import model.MvpModel;

/**
 * Created by darklegend on 7/6/17.
 */

public class Presenter implements IPresenter {

  private IView iView;

  private MvpModel mvpModel;

  public Presenter(final IView iView, final MvpModel mvpModel) {
    this.iView = iView;
    this.mvpModel = mvpModel;
  }

  @Override
  public void addData(String title) {
    final ContentValues data = new ContentValues();
    data.put("title", title);
    this.mvpModel.addTask(data);
    this.returnData();
  }

  @Override
  public void deleteData(String title) {
    this.mvpModel.deleteTask("title='" + title + "'");
    this.returnData();
  }


  private List<String> getTasks() {
    List<String> task = new ArrayList<>();
    Cursor c = this.mvpModel.getTask();
    if (c != null) {
      c.moveToFirst();
      while (c.isAfterLast() == false) {
        task.add(c.getString(0));
        c.moveToNext();
      }
      c.close();
    }
    return task;

  }

  @Override
  public void returnData() {
    this.iView.onDataReturn(getTasks());
  }
}
