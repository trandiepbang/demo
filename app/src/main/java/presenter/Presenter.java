package presenter;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import bangdieptran.demo.view.IView;
import model.MvcModel;

/**
 * Created by darklegend on 7/6/17.
 */

public class Presenter implements IPresenter {

  private IView iView;

  private MvcModel mvcModel;

  public Presenter(final IView iView, final MvcModel mvcModel) {
    this.iView = iView;
    this.mvcModel = mvcModel;
  }

  @Override
  public void addData(String title) {
    final ContentValues data = new ContentValues();
    data.put("title", title);
    this.mvcModel.addTask(data);
    this.returnData();
  }

  @Override
  public void deleteData(String title) {
    this.mvcModel.deleteTask("title='" + title + "'");
    this.returnData();
  }


  private List<String> getTasks() {
    List<String> task = new ArrayList<>();
    Cursor c = this.mvcModel.getTask();
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
