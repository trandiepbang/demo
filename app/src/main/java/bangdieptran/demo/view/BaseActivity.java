package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import model.MvpModel;
import presenter.IPresenter;
import presenter.Presenter;

public abstract class BaseActivity extends AppCompatActivity implements IView {

  public IPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    presenter = new Presenter(this, new MvpModel(getApplicationContext()));

  }

  final protected IPresenter getPresenter() {
    return presenter;
  }

  protected abstract int getLayoutId();

}
