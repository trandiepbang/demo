package bangdieptran.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;

public class DemoDesignPattern extends AppCompatActivity {


    private controller.controller mvcController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_design_pattern);
        mvcController = new controller.controller(DemoDesignPattern.this);
        mvcController.addTask("tran diep bang");
        Log.d("data " , mvcController.getTasks().toString());
        mvcController.deleteTask("tran diep bang");
        Log.d("data after deleted",mvcController.getTasks().toString());


    }
}
