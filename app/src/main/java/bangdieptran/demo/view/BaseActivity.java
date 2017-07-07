package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import model.MvpModel;
import presenter.Presenter;

public abstract class BaseActivity extends AppCompatActivity implements IView {

  MvpModel mvpModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    mvpModel = new MvpModel(getApplicationContext());
  }

  public final MvpModel getModel() {
    return mvpModel;
  }

  protected abstract Presenter getPresenter();

  protected abstract int getLayoutId();

}
