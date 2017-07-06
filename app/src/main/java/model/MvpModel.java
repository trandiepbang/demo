package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import value.DefaultValue;

/**
 * Created by darklegend on 7/6/17.
 */

public class MvpModel {

  private final SQLiteOpenHelper helper;

  private static final String DB_CREATE_QUERY = "CREATE TABLE " + DefaultValue.value.DB_table_name
      + " (id integer primary key autoincrement, title text not null);";

  private final SQLiteDatabase database;

  public MvpModel(final Context mContext) {
    this.helper = new SQLiteOpenHelper(mContext, DefaultValue.value.DB_NAME, null, DefaultValue.value.DB_version) {
      @Override
      public void onCreate(SQLiteDatabase db) {
        Log.d("On create table", DB_CREATE_QUERY);
        db.execSQL(DB_CREATE_QUERY);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d("On upgrade table", "");
        db.execSQL("DROP TABLE IF EXISTS " + DefaultValue.value.DB_table_name);
        this.onCreate(db);
      }

    };
    this.database = this.helper.getWritableDatabase();
  }


  public void addTask(ContentValues data) {
    this.database.insert(DefaultValue.value.DB_table_name, null, data);
  }

  public void deleteTask(final String field_params) {
    this.database.delete(DefaultValue.value.DB_table_name, field_params, null);
  }

  public Cursor getTask() {
    final Cursor c = this.database.query(DefaultValue.value.DB_table_name, new String[]{"title"}, null, null, null, null, null);
    return c;
  }
}
