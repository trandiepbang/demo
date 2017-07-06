package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import bangdieptran.demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import controller.Controller;
import presenter.Presenter;

public class DemoDesignPattern extends AppCompatActivity implements IView {

  @Nullable
  @BindView(R.id.data_created) TextView created;

  @Nullable
  @BindView(R.id.data_deleted) TextView deleted;
  Presenter presenter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo_design_pattern);
    presenter = new Presenter(this,new Controller(DemoDesignPattern.this));
    presenter.addData("tran diep bang");

  }

  @Override
  public void onDataReturn(List<String> data) {
    created.setText(data.toString());
  }
}
