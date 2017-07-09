package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import model.MvpModel;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

  MvpModel mvpModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    mvpModel = new MvpModel(getApplicationContext());
    setBaseView(this);
  }

  public final MvpModel getModel() {
    return mvpModel;
  }

  protected abstract int getLayoutId();

  Object view;

  @Override
  public void setBaseView(Object view) {
    this.view = view;

  }

  @Override
  public Object getBaseView() {
    return view;
  }

  @Override
  public void destoryBaseView() {
    view = null;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    destoryBaseView();
  }
}
