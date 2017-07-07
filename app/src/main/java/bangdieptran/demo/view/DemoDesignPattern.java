package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import bangdieptran.demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.MvpModel;
import presenter.Presenter;

public class DemoDesignPattern extends AppCompatActivity implements IView {

  @Nullable
  @BindView(R.id.data_created) TextView created;

  @Nullable
  @BindView(R.id.createButton) Button createButton;

  @Nullable
  @BindView(R.id.deleteButton) Button deleteButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo_design_pattern);
    ButterKnife.bind(this);
    final Presenter presenter = new Presenter(this, new MvpModel(getApplicationContext()));
    createButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.addData("tran diep bang");

      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.deleteData("tran diep bang");
      }
    });


  }

  @Override
  public void onDataReturn(List<String> data) {
    created.setText(data.toString());
  }
}
