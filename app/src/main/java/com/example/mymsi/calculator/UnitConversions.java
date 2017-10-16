package com.example.mymsi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UnitConversions extends AppCompatActivity {
    public static String id = "";
    public static String id1 = "";
    public static  String id2 ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconversions );
        Button buttonReturn = (Button)findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnitConversions.this, MainActivity.class);//显示启动
                startActivity(intent);
                finish();
            }
        });
        final TextView textView = (TextView)findViewById(R.id.textViewAll);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerAll);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(UnitConversions.this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //下拉列表选择事件监听器

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView1, View view, int i, long l) {


                if(i>=0)
                    id = adapterView1.getItemAtPosition(i).toString();
              switch (id){
                  case "长度":
                      textView.setText("长度");
                      final EditText editTextLength1= (EditText)findViewById(R.id.editText1);
                      final EditText editTextLength2 = (EditText)findViewById(R.id.editText2);


                      final Spinner spinnerLength1 = (Spinner) findViewById(R.id.spinner1);
                      final ArrayAdapter<CharSequence> adapterLength1 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemslength, android.R.layout.simple_spinner_item);
                      adapterLength1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerLength1.setAdapter(adapterLength1);
                      //下拉列表选择事件监听器

                      spinnerLength1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                              if(i>=0)
                                  id1 = adapterView.getItemAtPosition(i).toString();
                              editTextLength1.setText("");
                              editTextLength2.setText("");

                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Spinner spinnerLength2 = (Spinner) findViewById(R.id.spinner2);
                      final ArrayAdapter<CharSequence> adapterLength2 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemslength, android.R.layout.simple_spinner_item);
                      adapterLength2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerLength2.setAdapter(adapterLength2);
                      //下拉列表选择事件监听器

                      spinnerLength2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                              if(i>=0)
                                  id2 = adapterView.getItemAtPosition(i).toString();
                              editTextLength1.setText("");
                              editTextLength2.setText("");

                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Button btnChangeLength = (Button)findViewById(R.id.buttonChange);
                      btnChangeLength.setOnClickListener(new View.OnClickListener(){
                          @Override
                          public void onClick(View view) {
                              String s1 = editTextLength1.getText().toString();
                              String s2 = editTextLength2.getText().toString();
                              if(s1.length()!=0&&s2.length()==0){
                                  switch (id1){
                                      case "英寸":
                                          switch (id2){
                                              case "英寸":editTextLength2.setText(editTextLength1.getText().toString());

                                                  break;
                                              case "米":editTextLength2.setText(String.valueOf(Double.parseDouble(editTextLength1.getText().toString())*0.0254));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "米":
                                          switch (id2){
                                              case "英寸":editTextLength2.setText(String.valueOf(Double.parseDouble(editTextLength1.getText().toString())/0.0254));

                                                  break;
                                              case "米":editTextLength2.setText(editTextLength1.getText().toString());
                                                  break;

                                              default:
                                                  break;
                                          }
                                          default:
                                          break;
                                  }
                              }
                              else if(s1.length()==0&&s2.length()!=0){
                                  switch (id2){
                                      case "英寸":
                                          switch (id1){
                                              case "英寸":editTextLength1.setText(editTextLength2.getText().toString());
                                                  break;
                                              case "米":editTextLength1.setText(String.valueOf(Double.parseDouble(editTextLength2.getText().toString())*0.0254));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "米":
                                          switch (id1){
                                              case "英寸":editTextLength1.setText(String.valueOf(Double.parseDouble(editTextLength2.getText().toString())/0.0254));
                                                  break;
                                              case "米":editTextLength1.setText(editTextLength2.getText().toString());
                                                  break;
                                              default:
                                                  break;
                                          }
                                          break;

                                      default:
                                          break;
                                  }
                              }
                              else   if(s1.length()!=0&&s2.length()!=0){
                                  Toast.makeText(UnitConversions.this,"参数错误!",Toast.LENGTH_LONG).show();
                              }
                              else   if(s1.length()==0&&s2.length()==0){
                                  editTextLength1.setText("");
                                  editTextLength2.setText("");
                                  Toast.makeText(UnitConversions.this,"请输入要转换的数量!",Toast.LENGTH_LONG).show();

                              }
                          }
                      });
                        break;


                  case "重量":
                      textView.setText("重量");
                      final EditText editTextWeight1 = (EditText)findViewById(R.id.editText1);
                      final EditText editTextWeight2 = (EditText)findViewById(R.id.editText2);


                      final Spinner spinnerWeight1 = (Spinner) findViewById(R.id.spinner1);
                      final ArrayAdapter<CharSequence> adapterWeight1 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemsweight, android.R.layout.simple_spinner_item);
                      adapterWeight1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerWeight1.setAdapter(adapterWeight1);
                      //下拉列表选择事件监听器

                      spinnerWeight1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                              if(i>=0)
                                  id1 = adapterView.getItemAtPosition(i).toString();
                              editTextWeight1.setText("");
                              editTextWeight2.setText("");
                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Spinner spinnerWeight2 = (Spinner) findViewById(R.id.spinner2);
                      final ArrayAdapter<CharSequence> adapterWeight2 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemsweight, android.R.layout.simple_spinner_item);
                      adapterWeight2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerWeight2.setAdapter(adapterWeight2);
                      //下拉列表选择事件监听器

                      spinnerWeight2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                              if(i>=0)
                                  id2 = adapterView.getItemAtPosition(i).toString();
                              editTextWeight1.setText("");
                              editTextWeight2.setText("");

                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Button btnChangeWeight = (Button)findViewById(R.id.buttonChange);

                      btnChangeWeight.setOnClickListener(new View.OnClickListener(){
                          @Override
                          public void onClick(View view) {
                              String s1 = editTextWeight1.getText().toString();
                              String s2 = editTextWeight2.getText().toString();
                              if(s1.length()!=0&&s2.length()==0){
                                  switch (id1){
                                      case "磅":
                                          switch (id2){
                                              case "磅":editTextWeight2.setText(editTextWeight1.getText().toString());
                                                  break;
                                              case "千克":editTextWeight2.setText(String.valueOf(Double.parseDouble(editTextWeight1.getText().toString())/2.2046));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "千克":
                                          switch (id2){
                                              case "磅":editTextWeight2.setText(String.valueOf(Double.parseDouble(editTextWeight1.getText().toString())*2.2046));
                                                  break;
                                              case "千克":editTextWeight2.setText(editTextWeight1.getText().toString());
                                                  break;
                                          }
                                          break;

                                      default:
                                          break;
                                  }
                              }
                              else if(s1.length()==0&&s2.length()!=0){
                                  switch (id2){
                                      case "磅":
                                          switch (id1){
                                              case "磅":editTextWeight1.setText(editTextWeight2.getText().toString());
                                                  break;
                                              case "千克":editTextWeight1.setText(String.valueOf(Double.parseDouble(editTextWeight2.getText().toString())/2.2046));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "千克":
                                          switch (id1){
                                              case "磅":editTextWeight1.setText(String.valueOf(Double.parseDouble(editTextWeight2.getText().toString())*2.2046));
                                                  break;
                                              case "千克":editTextWeight1.setText(editTextWeight2.getText().toString());
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;

                                      default:
                                          break;
                                  }
                              }
                              else   if(s1.length()!=0&&s2.length()!=0){
                                  Toast.makeText(UnitConversions.this,"参数错误!",Toast.LENGTH_LONG).show();
                              }
                              else   if(s1.length()==0&&s2.length()==0){
                                  editTextWeight1.setText("");
                                  editTextWeight2.setText("");
                                  Toast.makeText(UnitConversions.this,"请输入要转换的数量!",Toast.LENGTH_LONG).show();

                              }
                          }
                      });
                      break;

                  case "面积":
                      textView.setText("面积");
                      final EditText editTextArea1 = (EditText)findViewById(R.id.editText1);
                      final EditText editTextArea2 = (EditText)findViewById(R.id.editText2);


                      final Spinner spinnerArea1 = (Spinner) findViewById(R.id.spinner1);
                      final ArrayAdapter<CharSequence> adapterArea1 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemsarea, android.R.layout.simple_spinner_item);
                      adapterArea1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerArea1.setAdapter(adapterArea1);
                      //下拉列表选择事件监听器

                      spinnerArea1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                              if(i>=0)
                                  id1 = adapterView.getItemAtPosition(i).toString();
                              editTextArea1.setText("");
                              editTextArea2.setText("");

                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Spinner spinnerArea2 = (Spinner) findViewById(R.id.spinner2);
                      final ArrayAdapter<CharSequence> adapterArea2 = ArrayAdapter.createFromResource(UnitConversions.this, R.array.itemsarea, android.R.layout.simple_spinner_item);
                      adapterArea2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                      spinnerArea2.setAdapter(adapterArea2);
                      //下拉列表选择事件监听器

                      spinnerArea2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                          @Override
                          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                              if(i>=0)
                                  id2 = adapterView.getItemAtPosition(i).toString();
                              editTextArea1.setText("");
                              editTextArea2.setText("");

                          }
                          @Override
                          public void onNothingSelected(AdapterView<?> adapterView) {

                          }

                      });

                      final Button btnChangeArea = (Button)findViewById(R.id.buttonChange);

                      btnChangeArea.setOnClickListener(new View.OnClickListener(){
                          @Override
                          public void onClick(View view) {
                              String s1 = editTextArea1.getText().toString();
                              String s2 = editTextArea2.getText().toString();
                              if(s1.length()!=0&&s2.length()==0){
                                  switch (id1){
                                      case "平方英尺":
                                          switch (id2){
                                              case "平方英尺":editTextArea2.setText(editTextArea1.getText().toString());
                                                  break;
                                              case "平方米":editTextArea2.setText(String.valueOf(Double.parseDouble(editTextArea1.getText().toString())/10.764));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "平方米":
                                          switch (id2){
                                              case "平方英尺":editTextArea2.setText(String.valueOf(Double.parseDouble(editTextArea1.getText().toString())*10.764));
                                                  break;
                                              case "平方米":editTextArea2.setText(editTextArea1.getText().toString());
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;

                                      default:
                                          break;
                                  }
                              }
                              else if(s1.length()==0&&s2.length()!=0){
                                  switch (id2){
                                      case "平方英尺":
                                          switch (id1){
                                              case "平方英尺":editTextArea1.setText(editTextArea2.getText().toString());
                                                  break;
                                              case "平方米":editTextArea1.setText(String.valueOf(Double.parseDouble(editTextArea2.getText().toString())/10.764));
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;
                                      case "平方米":
                                          switch (id1){
                                              case "平方英尺":editTextArea1.setText(String.valueOf(Double.parseDouble(editTextArea2.getText().toString())*10.764));
                                                  break;
                                              case "平方米":editTextArea1.setText(editTextArea2.getText().toString());
                                                  break;

                                              default:
                                                  break;
                                          }
                                          break;

                                      default:
                                          break;
                                  }
                              }
                              else   if(s1.length()!=0&&s2.length()!=0){
                                  Toast.makeText(UnitConversions.this,"参数错误!",Toast.LENGTH_LONG).show();
                              }
                              else   if(s1.length()==0&&s2.length()==0){
                                  editTextArea1.setText("");
                                  editTextArea2.setText("");
                                  Toast.makeText(UnitConversions.this,"请输入要转换的数量!",Toast.LENGTH_LONG).show();

                              }
                          }
                      });
                      break;
                  default:
                      break;
              }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }

}

