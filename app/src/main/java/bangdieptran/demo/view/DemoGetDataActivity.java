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
import presenter.Presenter;
import presenter.QueryPresenter;

public class DemoGetDataActivity extends BaseActivity implements IGetDataView {

  @Nullable
  @BindView(R.id.showDataTextView) TextView showDataTextView;

  @Nullable
  @BindView(R.id.showButton) Button showButton;

  public static Intent newIntent(Activity activity) {
    return new Intent(activity, DemoGetDataActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    showButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().showData();
      }
    });
  }

  @Override
  protected Presenter getPresenter() {
    return new QueryPresenter(this, getModel());
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_demo_get_data;
  }

  @Override
  public void onDataReturn(List<String> data) {
    showDataTextView.setText(data.toString());
  }

}
