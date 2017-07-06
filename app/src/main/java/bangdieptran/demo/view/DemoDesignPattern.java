package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import bangdieptran.demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import controller.Controller;

public class DemoDesignPattern extends AppCompatActivity {


  private Controller mvcController;

  @Nullable
  @BindView(R.id.data_created) TextView created;

  @Nullable
  @BindView(R.id.data_deleted) TextView deleted;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo_design_pattern);
    ButterKnife.bind(this);
    mvcController = new Controller(DemoDesignPattern.this);
    mvcController.addTask("tran diep bang");
    //Log.d("data ", mvcController.getTasks().toString());

    created.setText(mvcController.getTasks().toString());
    mvcController.deleteTask("tran diep bang");

    Log.d("data after deleted", mvcController.getTasks().toString());

    deleted.setText(mvcController.getTasks().toString());



  }
}
