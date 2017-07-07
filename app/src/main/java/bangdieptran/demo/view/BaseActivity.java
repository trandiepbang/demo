package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import model.MvpModel;

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
  }

  public MvpModel getModel() {
    return new MvpModel(getApplicationContext());
  }

  protected abstract int getLayoutId();

}
