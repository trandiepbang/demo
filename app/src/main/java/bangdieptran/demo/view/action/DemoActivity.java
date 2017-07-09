package bangdieptran.demo.view.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bangdieptran.demo.R;
import bangdieptran.demo.view.BaseActivity;
import bangdieptran.demo.view.query.DemoGetDataActivity;
import butterknife.BindView;
import presenter.action.ActionPresenter;

public class DemoActivity extends BaseActivity implements IActionView {

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

  ActionPresenter actionPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    actionPresenter = new ActionPresenter((IActionView) getBaseView(), getModel());

    createButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        actionPresenter.addData("tran diep bang");
      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        actionPresenter.deleteData("tran diep bang");
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

  @Override
  public void sayHello2() {
    Toast.makeText(getApplicationContext(), "Say hleloo", Toast.LENGTH_LONG).show();
  }


}
