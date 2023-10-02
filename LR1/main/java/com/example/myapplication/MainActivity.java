package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import org.mariuszgromada.math.mxparser.*;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display = "0";
    private TextView display_text_view;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#383737")));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black_shade_1));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        display_text_view = findViewById(R.id.displayTextView);
        display_text_view.setText(display);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("display", display_text_view.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            String dis = savedInstanceState.getString("display");
            if(display_text_view != null){
                display_text_view.setText(dis);
            }
        }
    }

    private void updateDisplay(String str){

        String old_str = display_text_view.getText().toString();
        String new_str =  "";
        if(old_str.equals("0")){
            new_str = str;
        }
        else {
            new_str = old_str + str;
        }
        display_text_view.setText(new_str);

    }

    public void clear_btn_std(View view) {
        if(display_text_view != null){
            display_text_view.setText(display);
        }
    }

    public void pi_btn_std(View view) {
        Expression exp = new Expression("pi");
        String result = String.valueOf(exp.calculate());
        updateDisplay(result);
    }

    public void zero_btn_std(View view) {
        updateDisplay("0");
    }

    public void dot_btn_std(View view) {
        updateDisplay(".");
    }

    public void equal_btn_std(View view) {
        String userExp = display_text_view.getText().toString();

        userExp = userExp.replaceAll("×", "*");
        userExp = userExp.replaceAll("÷", "/");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display_text_view.setText(result);
    }

    public void one_btn_std(View view) {
        updateDisplay("1");
    }

    public void two_btn_std(View view) {
        updateDisplay("2");
    }

    public void three_btn_std(View view) {
        updateDisplay("3");
    }

    public void plus_btn_std(View view) {
        updateDisplay("+");
    }

    public void four_btn_std(View view) {
        updateDisplay("4");
    }

    public void five_btn_std(View view) {
        updateDisplay("5");
    }

    public void minus_btn_std(View view) {
        updateDisplay("-");
    }

    public void six_btn_std(View view) {
        updateDisplay("6");
    }

    public void seven_btn_std(View view) {
        updateDisplay("7");
    }

    public void eight_btn_std(View view) {
        updateDisplay("8");
    }

    public void nine_btn_std(View view) {
        updateDisplay("9");
    }

    public void mul_btn_std(View view) {
        updateDisplay("×");
    }

    public void percentage_btn_std(View view) {
        updateDisplay("%");
        equal_btn_std(view);
    }

    public void r0_btn_std(View view) {
        equal_btn_std(view);
        String userNum =  display_text_view.getText().toString();
        float num = Float.parseFloat(userNum);
        display_text_view.setText(String.valueOf(Math.round(num)));
    }

    public void r2_btn_std(View view) {
        equal_btn_std(view);
        String userNum =  display_text_view.getText().toString();
        float num = Float.parseFloat(userNum);
        num = (float)Math.round(num * 100) / 100;
        display_text_view.setText(Float.toString(num));
    }

    public void divide_btn_std(View view) {
        updateDisplay("÷");
    }

    public void square_root_btn_std(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "sqrt(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void square_btn_std(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = userExp + "^2";
        display_text_view.setText(userExp);
    }


    public void backspace_btn_std(View view) {
        if(display_text_view != null){
            String dis = display_text_view.getText().toString();
            int dis_len = dis.length();
            if(dis_len != 0){
                String new_str = dis.substring(0, dis_len-1);
                display_text_view.setText(new_str);
            }else {
                display_text_view.setText("");
            }
        }
    }

    public void clear_btn_sci(View view) {
        clear_btn_std(view);
    }

    public void backspace_btn_sci(View view) {
        backspace_btn_std(view);
    }

    public void divide_btn_sci(View view) {
        divide_btn_std(view);
    }

    public void seven_btn_sci(View view) {
        seven_btn_std(view);
    }

    public void eight_btn_sci(View view) {
        eight_btn_std(view);
    }

    public void nine_btn_sci(View view) {
        nine_btn_std(view);
    }

    public void mul_btn_sci(View view) {
        mul_btn_std(view);
    }

    public void four_btn_sci(View view) {
        four_btn_std(view);
    }

    public void five_btn_sci(View view) {
        five_btn_std(view);
    }

    public void six_btn_sci(View view) {
        six_btn_std(view);
    }

    public void minus_btn_sci(View view) {
        minus_btn_std(view);
    }

    public void one_btn_sci(View view) {
        one_btn_std(view);
    }

    public void two_btn_sci(View view) {
        two_btn_std(view);
    }

    public void three_btn_sci(View view) {
        three_btn_std(view);
    }

    public void plus_btn_sci(View view) {
        plus_btn_std(view);
    }

    public void pi_btn_sci(View view) {
        pi_btn_std(view);
    }

    public void dot_btn_sci(View view) {
        dot_btn_std(view);
    }

    public void zero_btn_sci(View view) {
        zero_btn_std(view);
    }

    public void equal_btn_sci(View view) {
        equal_btn_std(view);
    }

    public void log_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "log10(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void sin_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "sin(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void cos_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "cos(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void tan_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "tan(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void sin_inv_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "asin(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void cos_inv_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "acos(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void tan_inv_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "atan(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void open_bracket_btn_sci(View view) {
        updateDisplay("(");
    }

    public void close_bracket_btn_sci(View view) {
        updateDisplay(")");
    }

    public void ln_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "ln(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void square_root_btn_sci(View view) {
        square_root_btn_std(view);
    }

    public void square_btn_sci(View view) {
        square_btn_std(view);
    }

    public void cube_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = userExp + "^3";
        display_text_view.setText(userExp);
    }

    public void e_btn_sci(View view) {
        Expression exp = new Expression("e");
        String result = String.valueOf(exp.calculate());
        updateDisplay(result);
    }

    public void percentage_btn_sci(View view) {
        percentage_btn_std(view);
    }

    public void exp_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = "exp(" + userExp + ")";
        display_text_view.setText(userExp);
        equal_btn_std(view);
    }

    public void fectorial_btn_sci(View view) {
        updateDisplay("!");
    }

    public void change_sign_btn_sci(View view) {
        equal_btn_std(view);
        String userNum =  display_text_view.getText().toString();
        float num = Float.parseFloat(userNum) * -1;
        display_text_view.setText(String.valueOf(num));
    }

    public void x_power_y_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = userExp + "^";
        display_text_view.setText(userExp);
    }

    public void y_root_x_btn_sci(View view) {
        String userExp = display_text_view.getText().toString();
        userExp = userExp + "^1/";
        display_text_view.setText(userExp);
    }
}