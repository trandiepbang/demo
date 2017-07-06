package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import model.mvcmodel;

/**
 * Created by darklegend on 7/6/17.
 */

public class controller {
    private mvcmodel model;
    private List<String> tasks;

    public controller (final Context context) {
        model = new mvcmodel(context);
        tasks = new ArrayList<>();
    }
    public void addTask (final String title) {
        final ContentValues data = new ContentValues();
        data.put("title", title);
        model.addTask(data);
    }

    public void deleteTask (final String title) {
        model.deleteTask("title='" + title + "'");
    }

    public List<String> getTasks() {
        Cursor c = model.getTask();
        tasks.clear();
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
