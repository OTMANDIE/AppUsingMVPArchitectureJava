package com.example.fragmentsactivityusingmvp.View;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fragmentsactivityusingmvp.Model.Model;
import com.example.fragmentsactivityusingmvp.Presenter.Presenter;
import com.example.fragmentsactivityusingmvp.R;
import com.example.fragmentsactivityusingmvp.Util.Contract;

public class MainActivity extends AppCompatActivity implements Contract.View {


    private TextView textView;
    private Button button;
    private ProgressBar progressBar;

    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar);
        presenter=new Presenter(this,new Model());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setString(String string) {
        textView.setText(string);
    }
}