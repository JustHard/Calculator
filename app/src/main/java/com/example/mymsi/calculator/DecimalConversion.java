package com.example.mymsi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by My msi on 2017/10/1.
 */

public class DecimalConversion extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimalconversion );
        Button buttonReturn = (Button)findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DecimalConversion.this, MainActivity.class);//显示启动
                startActivity(intent);
                finish();
            }
        });
        final EditText editTextBiarry = (EditText)findViewById(R.id.editTextBinary);
        final EditText editTextOctal = (EditText)findViewById(R.id.editTextOctal);
        final EditText editTextHexadecimal = (EditText)findViewById(R.id.editTextHexadecimal);
        final TextView textViewBinaryResult = (TextView)findViewById(R.id.textViewBinaryResult);
        final TextView textViewOctalResult = (TextView)findViewById(R.id.textViewOctalResult);
        final TextView textViewHexadecimalResult = (TextView)findViewById(R.id.textViewHexadecimalResult);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textViewBinaryResult.setText(Integer.toString(Integer.valueOf(editTextBiarry.getText().toString(),2)));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textViewOctalResult.setText(Integer.toString(Integer.valueOf(editTextOctal.getText().toString(),8)));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textViewHexadecimalResult.setText(Integer.toString(Integer.valueOf(editTextHexadecimal.getText().toString(),16)));
            }
        });

        }
}
