package bangdieptran.demo.view.query;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bangdieptran.demo.R;
import bangdieptran.demo.view.BaseActivity;
import butterknife.BindView;
import presenter.query.QueryPresenter;

public class DemoGetDataActivity extends BaseActivity implements IQueryData {

  @Nullable
  @BindView(R.id.showDataTextView) TextView showDataTextView;

  @Nullable
  @BindView(R.id.showButton) Button showButton;

  public static Intent newIntent(Activity activity) {
    return new Intent(activity, DemoGetDataActivity.class);
  }

  QueryPresenter iPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    iPresenter = new QueryPresenter(this, getModel());

    showButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        iPresenter.showData();
      }
    });
  }


  @Override
  protected int getLayoutId() {
    return R.layout.activity_demo_get_data;
  }

  @Override
  public void onDataReturn(List<String> data) {
    showDataTextView.setText(data.toString());
  }

  @Override
  public void sayHello() {
    Toast.makeText(getApplicationContext(), "Say Helllo", Toast.LENGTH_LONG).show();
  }

}
