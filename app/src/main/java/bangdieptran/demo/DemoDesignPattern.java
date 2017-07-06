package bangdieptran.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import controller.Controller;

public class DemoDesignPattern extends AppCompatActivity {


  private Controller mvcController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo_design_pattern);
    mvcController = new Controller(DemoDesignPattern.this);
    mvcController.addTask("tran diep bang");
    Log.d("data ", mvcController.getTasks().toString());
    mvcController.deleteTask("tran diep bang");
    Log.d("data after deleted", mvcController.getTasks().toString());


  }
}
