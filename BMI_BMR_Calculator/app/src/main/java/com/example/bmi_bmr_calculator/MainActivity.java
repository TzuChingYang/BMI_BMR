package com.example.bmi_bmr_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private Button button_calculate;
    private Button button_clear ;

    private RadioButton radioButton_male;
    private RadioButton radioButton_female;
    private RadioGroup radioGroup;

    private TextView textView_debugger;
    private EditText editText_name;
    private EditText editText_height;
    private EditText editText_weight;
    private EditText editText_age;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect object + set listen events
        initialize_component();
        setlistensers();

    }

    // Here to connect object with its id
    public void initialize_component(){
        button_calculate =findViewById(R.id.button_calculate);
        button_clear =findViewById(R.id.button_clear) ;

        radioButton_male =findViewById(R.id.radioButton_male);
        radioButton_female =findViewById(R.id.radioButton_female) ;
        radioGroup =findViewById(R.id.radioGroup) ;

        textView_debugger = findViewById(R.id.debugger) ;
        editText_name =findViewById(R.id.editText_name);
        editText_height =findViewById(R.id.editText_height) ;
        editText_weight =findViewById(R.id.editText_weight) ;
        editText_age =findViewById(R.id.editText_age) ;
    }
    //Here to set listen events
    public void setlistensers(){
        button_calculate.setOnClickListener(calculate_and_turnPAGE);
        button_clear.setOnClickListener(Clear);
    }
    //Here to send data to another page
    private void send_data(){
        intent = new Intent() ;
        intent.setClass(MainActivity.this,ReportActivity.class) ;
        startActivity(intent);
        //bundle = new Bundle() ;
    }

    //Listen Event Set
    private View.OnClickListener calculate_and_turnPAGE =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // First step -> Calculate BMI
            try {
                DecimalFormat nf = new DecimalFormat("0.00");
                double height = Double.parseDouble(editText_height.getText().toString())/100;
                double weight = Double.parseDouble(editText_weight.getText().toString());
                double age =  Double.parseDouble(editText_age.getText().toString());
                double BMI = weight / (height*height);
                double BMR =0.00;

                // Second step -> Calculate BMR
                // Check is Male or Female
                switch (radioGroup.getCheckedRadioButtonId()){
                    // If Male
                    case R.id.radioButton_male:
                        BMR= 66+(13.7*weight)+(5.0*height*100)-(6.8*age) ;
                        textView_debugger.setText("male BMI:"+nf.format(BMI)+" BMR:"+nf.format(BMR));
                        send_data();
                        break;

                    //If Female
                    case R.id.radioButton_female:
                        BMR= 655+(9.6*weight)+(1.8*height*100)-(4.7*age) ;
                        textView_debugger.setText("female BMI:"+nf.format(BMI)+" BMR:"+nf.format(BMR));
                        send_data();
                        break;
                }

                //Now get -> BMI, BMR
                //Third step-> change page and send data to the page
            }catch (Exception obj){
                Toast.makeText(MainActivity.this,"Please input all information",Toast.LENGTH_SHORT).show();
            }

        }
    };
    private View.OnClickListener Clear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Main to clear
            editText_name.setText("");
            editText_height.setText("");
            editText_weight.setText("");
            editText_age.setText("");
        }
    };
}

//switch radio button
//switch (radioGroup.getCheckedRadioButtonId()){
//                case R.id.radioButton_male:
//                    textView_debugger.setText("male");
//                    break;
//                case R.id.radioButton_female:
//                    textView_debugger.setText("female");
//                    break;
//            }

// output BMI
//            textView_debugger.setText(nf.format(BMI));
