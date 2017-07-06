package bangdieptran.demo.view;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bangdieptran.demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import controller.Controller;
import event.MessageEvent;
import model.MvcModel;

public class DemoDesignPattern extends AppCompatActivity {

  @Nullable
  @BindView(R.id.data_created) TextView created;

  @Nullable
  @BindView(R.id.createButton) Button createButton;

  @Nullable
  @BindView(R.id.deleteButton) Button deleteButton;


  private Controller controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo_design_pattern);
    ButterKnife.bind(this);

    controller = new Controller(new MvcModel(getApplicationContext()));
    createButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        controller.addTask("tran diep bang");
      }
    });
    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        controller.deleteTask("tran diep bang");
      }
    });
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onMessageEvent(MessageEvent event) {
    created.setText(event.message);
  }


  @Override
  public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override
  public void onStop() {
    super.onStop();
    EventBus.getDefault().unregister(this);
  }

}
