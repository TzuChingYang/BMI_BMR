package com.example.bmi_bmr_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ReportActivity extends AppCompatActivity {

    private TextView textView_name ;
    private TextView textView_bmi;
    private TextView textView_bmr;

    private Button button_previous;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        initialize_component();
        setlistensers();
        showData();
    }

    // Initialize component(Connect component)
    private void initialize_component(){
        textView_name = findViewById(R.id.textView_name);
        textView_bmi = findViewById(R.id.textView_bmi) ;
        textView_bmr = findViewById(R.id.textView_bmr) ;

        button_previous = findViewById(R.id.button_previous) ;

    }
    // set the connection between component and method f
    private void setlistensers(){
        button_previous.setOnClickListener(backPage);
    }

    //Handle data from previous page -> Show it
    private void showData(){
        //test first
        Bundle bundle = this.getIntent().getExtras();
        DecimalFormat nf = new DecimalFormat("0.00");

        try{
            // Show name
            textView_name.setText(bundle.getString("key_name"));
            // Show BMI
            textView_bmi.setText(nf.format(bundle.getDouble("key_bmi")));
            // Show BMR
            textView_bmr.setText(nf.format(bundle.getDouble("key_bmr")));

        }catch (Exception e){
            Toast.makeText(this,R.string.error_message,Toast.LENGTH_SHORT).show();
        }
    }


    // Listen Event
    // This Event is used to turn page to previous one
    private View.OnClickListener backPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // This event is main to change page
            ReportActivity.this.finish();
        }
    };
}
