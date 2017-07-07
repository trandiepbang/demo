package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import bangdieptran.demo.R;
import butterknife.BindView;
import presenter.IPresenter;

public class DemoActivity extends BaseActivity {

  @Override
  protected int getLayoutId() {
    return R.layout.activity_demo_design_pattern;
  }

  @Nullable
  @BindView(R.id.data_created) TextView dataCreatedText;

  @Nullable
  @BindView(R.id.createButton) Button createButton;

  @Nullable
  @BindView(R.id.deleteButton) Button deleteButton;

  @Nullable
  @BindView(R.id.startButton) Button startButton;

  IPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = getPresenter();
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

    startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(DemoGetDataActivity.newIntent(DemoActivity.this));
      }
    });
  }

  @Override
  public void onDataReturn(List<String> data) {
    dataCreatedText.setText(data.toString());
  }
}
