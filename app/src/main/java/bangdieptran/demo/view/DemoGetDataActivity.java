package bangdieptran.demo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import bangdieptran.demo.R;
import butterknife.BindView;

public class DemoGetDataActivity extends BaseActivity {

  @Nullable
  @BindView(R.id.data_created) TextView dataCreatedText;

  @Nullable
  @BindView(R.id.createButton) Button createButton;

  @Nullable
  @BindView(R.id.deleteButton) Button deleteButton;

  public static Intent newIntent(Activity activity) {
    return new Intent(activity, DemoGetDataActivity.class);
  }

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

  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_demo_get_data;
  }

  @Override
  public void onDataReturn(List<String> data) {
    dataCreatedText.setText(data.toString());
  }
}
