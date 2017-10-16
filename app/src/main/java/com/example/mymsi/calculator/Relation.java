package com.example.mymsi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by My msi on 2017/10/1.
 */

public class Relation extends AppCompatActivity {
    String id1 = "";
    String id2 = "";
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation );
        final Button buttonReturn = (Button)findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relation.this, MainActivity.class);//显示启动
                startActivity(intent);
                finish();
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.itemsrelation, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        //下拉列表选择事件监听器
        final TextView textView = (TextView)findViewById(R.id.textView3);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
        View view, int i, long l) {
                if(i>=0)
                    id1 = adapterView.getItemAtPosition(i).toString();
                switch (id1){
                    case "爸爸":

                        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Relation.this, R.array.itemsrehighlation, android.R.layout.simple_spinner_item);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(adapter2);
                        //下拉列表选择事件监听器
                        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if(i>=0)
                                    id2 = adapterView.getItemAtPosition(i).toString();
                                switch (id2){
                                    case "爸爸":
                                        textView.setText("爷爷");
                                        break;

                                    case "妈妈":
                                        textView.setText("奶奶");
                                        break;

                                    default:
                                        break;
                                }

                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;

                    case "妈妈":

                        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner2);
                        final ArrayAdapter<CharSequence> adapter3= ArrayAdapter.createFromResource(Relation.this, R.array.itemsrehighlation, android.R.layout.simple_spinner_item);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(adapter3);
                        //下拉列表选择事件监听器
                        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if(i>=0)
                                    id2 = adapterView.getItemAtPosition(i).toString();
                                switch (id2){
                                    case "爸爸":
                                        textView.setText("外公");
                                        break;

                                    case "妈妈":
                                        textView.setText("外婆");
                                        break;

                                    default:
                                        break;
                                }

                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;




                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
