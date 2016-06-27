package com.jasonhezz.github.statelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jasonhezz.github.library.StateLayout;

public class MainActivity extends AppCompatActivity {
  private StateLayout mStateLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mStateLayout = (StateLayout) findViewById(R.id.state_layout);
    mStateLayout.setState(StateLayout.TYPE_ERROR);
  }
}
