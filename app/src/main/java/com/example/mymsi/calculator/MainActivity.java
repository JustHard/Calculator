package com.example.mymsi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    //各个button
    private Button btnBinary,btnOctal,btnRelation,btnHexadecimal,btnC,btnCE,btnLeftParenthesis,btnRightParenthesis,btnSin,btnCos,
                    btnSquare, btnCube,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
                    btnAdd,btnMinus,btnMultiply,btnDivision,btnPoint,btnEquals;
    TextView textView = null;
    char operator = ' ';
    double result = 0.0;
    double number = 0.0;
    String strings = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("标准计算器");
        //获取布局控件
        textView = (TextView)findViewById(R.id.textViewResult);
        btnBinary = (Button)findViewById(R.id.buttonBinary);
        btnOctal = (Button)findViewById(R.id.buttonOctal);
        btnHexadecimal = (Button)findViewById(R.id.buttonHexadecimal);
        btnRelation = (Button)findViewById(R.id.buttonRelation);
        btnC = (Button)findViewById(R.id.buttonC);
        btnCE = (Button)findViewById(R.id.buttonCE);
        btnLeftParenthesis = (Button)findViewById(R.id.buttonLeftParenthesis);
        btnRightParenthesis = (Button)findViewById(R.id.buttonRightParenthesis);
        btnSin = (Button)findViewById(R.id.buttonSin);
        btnCos = (Button)findViewById(R.id.buttonCos);
        btnSquare = (Button) findViewById(R.id.buttonSquare);
        btnCube = (Button)findViewById(R.id.buttonCube);
        btn1 = (Button)findViewById(R.id.buttonOne);
        btn2 = (Button)findViewById(R.id.buttonTow);
        btn3 = (Button)findViewById(R.id.buttonThree);
        btn4 = (Button)findViewById(R.id.buttonFour);
        btn5 = (Button)findViewById(R.id.buttonFive);
        btn6 = (Button)findViewById(R.id.buttonSix);
        btn7 = (Button)findViewById(R.id.buttonSeven);
        btn8 = (Button)findViewById(R.id.buttonEight);
        btn9 = (Button)findViewById(R.id.buttonNine);
        btn0 = (Button)findViewById(R.id.buttonZero);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnMinus = (Button)findViewById(R.id.buttonMinus);
        btnMultiply = (Button)findViewById(R.id.buttonMultiply);
        btnDivision = (Button)findViewById(R.id.buttonDivision);
        btnPoint = (Button)findViewById(R.id.buttonPoint);
        btnEquals = (Button)findViewById(R.id.buttonEquals);
        //设置监按钮听器
        btnBinary.setOnClickListener(this);
        btnOctal.setOnClickListener(this);
        btnHexadecimal.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnRelation.setOnClickListener(this);
        btnLeftParenthesis.setOnClickListener(this);
        btnRightParenthesis.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnCube.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEquals.setOnClickListener(this);

        //进制转换页面
        Button btnChange = (Button)findViewById(R.id.buttonChange);
        btnChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this,AnotherActivity.class);//显示启动
                Intent intent = new Intent();
                intent.setAction("UnitConversions");
                startActivity(intent);
                finish();
            }
        });

        //十进制转换页面
        Button btnChangeConversion = (Button)findViewById(R.id.buttonDecimalism);
        btnChangeConversion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this,AnotherActivity.class);//显示启动
                Intent intent = new Intent();
                intent.setAction("DecimalConversion");
                startActivity(intent);
                finish();
            }
        });

    //亲戚关系转换页面
    Button btnChangeRelation = (Button)findViewById(R.id.buttonRelation);
        btnChangeRelation.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //  Intent intent = new Intent(MainActivity.this,AnotherActivity.class);//显示启动
            Intent intent = new Intent();
            intent.setAction("Relation");
            startActivity(intent);
            finish();
        }
    });
}
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //进制转换
            case R.id.buttonBinary:
                strings = Integer.toBinaryString((int)Double.parseDouble(textView.getText().toString()));
                textView.setText(strings);//二进制串
                break;

            case R.id.buttonOctal:
                strings = Integer.toOctalString((int)Double.parseDouble(textView.getText().toString()));
                textView.setText(strings);//八进制串
                break;

            case R.id.buttonHexadecimal:
                strings = Integer.toHexString((int)Double.parseDouble(textView.getText().toString()));
                textView.setText(strings);//十六进制串
                break;

            //CE和C
            case R.id.buttonCE:
                if(strings.length()>=1)//当至少已经输入了一个符号才执行
                {
                    strings=strings.substring(0,strings.length()-1);
                }
                textView.setText(strings);
                break;

            case R.id.buttonC:
                strings="";      //变量全部初始化
                number=0;
                result=0;
                operator=' ';
                textView.setText(strings);
                break;

            //各个按钮
            case R.id.buttonLeftParenthesis:
                strings = AddString('(');
                textView.setText(strings);
                break;

            case R.id.buttonRightParenthesis:
                strings = AddString(')');
                textView.setText(strings);
                break;
            case R.id.buttonSquare:
                number = Double.parseDouble(strings);
                if (number < 0) {
                    textView.setText("负数没有平方根！");
                } else {
                    textView.setText(Math.sqrt(number) + "");
                    strings = String.valueOf(Math.sqrt(number));
                }
                break;

            case R.id.buttonCube:
                number = Double.parseDouble(strings);
                if (number < 0) {
                    textView.setText("负数没有立方根！");
                } else {
                    textView.setText(Math.pow(number, 1.0 / 3) + "");
                    strings = String.valueOf(Math.pow(number, 1.0 / 3));
                }
                break;

            case R.id.buttonSin:
                textView.setText(String.valueOf(Math.sin(Double.parseDouble(strings)*Math.PI/180)));
                strings = String.valueOf(Math.sin(Double.parseDouble(strings)*Math.PI/180));
                break;

            case R.id.buttonCos:
                textView.setText(String.valueOf(Math.cos(Double.parseDouble(strings)*Math.PI/180)));
                strings = String.valueOf(Math.cos(Double.parseDouble(strings)*Math.PI/180));
                break;

            case R.id.buttonZero:
                strings = AddString('0');
                textView.setText(strings);
                break;

            case R.id.buttonOne:
                strings = AddString('1');
                textView.setText(strings);
                break;

            case R.id.buttonTow:
                strings = AddString('2');
                textView.setText(strings);
                break;

            case R.id.buttonThree:
                strings = AddString('3');
                textView.setText(strings);
                break;

            case R.id.buttonFour:
                strings = AddString('4');
                textView.setText(strings);
                break;

            case R.id.buttonFive:
                strings = AddString('5');
                textView.setText(strings);
                break;

            case R.id.buttonSix:
                strings = AddString('6');
                textView.setText(strings);
                break;

            case R.id.buttonSeven:
                strings = AddString('7');
                textView.setText(strings);
                break;

            case R.id.buttonEight:
                strings = AddString('8');
                textView.setText(strings);
                break;

            case R.id.buttonNine:
                strings = AddString('9');
                textView.setText(strings);
                break;

            case R.id.buttonPoint:
                strings = AddString('.');
                textView.setText(strings);
                break;

            //确定加减乘除运算符
            case R.id.buttonAdd:
                strings = AddString('+');
                textView.setText(strings);
                operator = '+';
                break;

            case R.id.buttonMinus:
                strings = AddString('-');
                textView.setText(strings);
                operator = '-';
                break;

            case R.id.buttonMultiply:
                strings = AddString('*');
                textView.setText(strings);
                operator = '*';
                break;

            case R.id.buttonDivision:
                strings = AddString('/');
                textView.setText(strings);
                operator = '/';
                break;

            case R.id.buttonEquals:
                strings = AddString('=');
                Calculate calculate = new Calculate();
                result = calculate.calculateExpression(strings);
                //result= Expression.toValue(Expression.toPostfix(strings));
                strings = strings + String.valueOf(result);
                textView.setText(strings);//显示数字运算符和结果
                strings = String.valueOf(result); //保存运算结果，以便再直接输入一个运算符和一个数字进行下一次运算
                break;

            default:
                break;

        }
    }

    //添加并记录一个输入的数字或符号
    public String AddString(char c) {
        strings=strings + String.valueOf(c);
        return strings;
    }

    //注册选项菜单
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.OptionsMenuHelp:
                Toast.makeText(this, "这是帮助。", Toast.LENGTH_SHORT).show();
                break;

            case R.id.OptionsMenuExit:
                System.exit(0);

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
