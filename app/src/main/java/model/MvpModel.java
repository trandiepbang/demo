package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darklegend on 7/6/17.
 */

public class MvpModel {

  private static final String DB_NAME = "bang_demo.db";
  private static final int DB_VERSION = 1;
  private static final String DB_TABLE_NAME = "bangbang";
  private final SQLiteOpenHelper helper;

  private static final String DB_CREATE_QUERY =
      "CREATE TABLE " + DB_TABLE_NAME
          + " (id integer primary key autoincrement, title text not null);";

  private final SQLiteDatabase database;

  public MvpModel(final Context context) {
    this.helper = new SQLiteOpenHelper(context.getApplicationContext(), DB_NAME, null, DB_VERSION) {
      @Override
      public void onCreate(SQLiteDatabase db) {
        Log.d("On create table", DB_CREATE_QUERY);
        db.execSQL(DB_CREATE_QUERY);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d("On upgrade table", "");
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        this.onCreate(db);
      }

    };
    this.database = this.helper.getWritableDatabase();
  }

  public long addTask(final String data) {
    final ContentValues contentValues = new ContentValues();
    contentValues.put("title", data);
    return this.database.insert(DB_TABLE_NAME, null, contentValues);
  }

  public long deleteTask(final String data) {
    String data_to_delete = "title='" + data + "'";
    return this.database.delete(DB_TABLE_NAME, data_to_delete, null);
  }

  public List<String> getTask() {
    final Cursor c = this.database.query(DB_TABLE_NAME, new String[]{"title"}, null, null, null, null, null);
    List<String> tasks = new ArrayList<>();
    if (c != null) {
      c.moveToFirst();
      while (c.isAfterLast() == false) {
        tasks.add(c.getString(0));
        c.moveToNext();
      }
      c.close();
    }
    return tasks;
  }
}
