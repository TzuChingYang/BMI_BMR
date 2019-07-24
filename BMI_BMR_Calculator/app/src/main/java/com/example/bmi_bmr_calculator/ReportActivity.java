package com.example.bmi_bmr_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {

    private Button button_previous;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        initialize_component();
        setlistensers();
    }

    // Initialize component(Connect component)
    private void initialize_component(){
        button_previous = findViewById(R.id.button_previous) ;

    }
    // set the connection between component and method f
    private void setlistensers(){
        button_previous.setOnClickListener(backPage);
    }

    // Listen Event
    // This Event is used to
    private View.OnClickListener backPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // This event is main to change page
            intent = new Intent() ;
            intent.setClass(ReportActivity.this,MainActivity.class) ;
            startActivity(intent);
        }
    };
}
