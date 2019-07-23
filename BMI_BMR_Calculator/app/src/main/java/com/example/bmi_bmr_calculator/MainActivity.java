package com.example.bmi_bmr_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button_calculate;
    private Button button_clear ;

    private EditText editText_name;
    private EditText editText_height;
    private EditText editText_weight;
    private EditText editText_age;

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
        editText_name =findViewById(R.id.editText_name);
        editText_height =findViewById(R.id.editText_height) ;
        editText_weight =findViewById(R.id.editText_weight) ;
        editText_age =findViewById(R.id.editText_age) ;
    }
    //Here to set listen events
    public void setlistensers(){

    }
}
