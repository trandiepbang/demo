package bangdieptran.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
  }

  public final MvpModel getModel() {
    return mvpModel;
  }

  protected abstract int getLayoutId();

  @Override
  public void chaoBan() {
    Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
  }
}
