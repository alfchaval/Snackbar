package com.example.usuario.snackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShow, btnChange, btnParent;
    CoordinatorLayout coordinatorLayout;
    LinearLayout parentLinearLayout;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button)findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        btnChange = (Button)findViewById(R.id.btnChange);
        btnChange.setOnClickListener(this);
        btnParent = (Button)findViewById(R.id.btnParent);
        btnParent.setOnClickListener(this);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        coordinatorLayout.setOnClickListener(this);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parentLinearLayout);
    }

    @Override
    public void onClick(View view) {
        if (view == btnShow) {
            snackbar = Snackbar.make(coordinatorLayout, "Mensaje en coordinator", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
        else if(view == btnChange) {
            snackbar = Snackbar.make(coordinatorLayout, "Mensaje de otro color", Snackbar.LENGTH_INDEFINITE);
            snackbar.setActionTextColor(Color.RED);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
            snackbar.show();
        }
        else if (view == btnParent) {
            snackbar = Snackbar.make(parentLinearLayout, "Mensaje en parent", Snackbar.LENGTH_INDEFINITE);
            snackbar.setActionTextColor(Color.RED);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(Color.GRAY);
            snackbar.show();
        }
        else if (snackbar != null){
            snackbar.dismiss();
        }
    }
}
