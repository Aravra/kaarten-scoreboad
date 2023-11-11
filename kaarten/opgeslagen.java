package com.example.kaarten;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class opgeslagen extends AppCompatActivity {
    public boolean force = false;
    public boolean vier = false;
    public int huidig = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opgeslagen);
        setContentView(R.layout.opgeslagen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        buttoncreator6();
        buttoncreator4();
    }
    public void verwlinear(){
        LinearLayout col2 = (LinearLayout)findViewById(R.id.lin6);
        col2.removeAllViews();
        LinearLayout col3 = (LinearLayout)findViewById(R.id.lin4);
        col3.removeAllViews();
    }
    public void buttoncreator6(){
        LinearLayout linearLayout = findViewById(R.id.lin6);
        int x = 1;
        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        int y = pref.getInt("6xmax", 0);
        if (y == 0){}
        else {
            while (x <= y) {
                String z = Integer.toString(x);
                SharedPreferences pref3 = getSharedPreferences("6x" + z , MODE_PRIVATE);
                String a = pref3.getString("naam", "");
                if (a.length()==0){
                }
                else {
                    Button btnShow = new Button(this);
                    btnShow.setText(a);
                    btnShow.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.SRC_ATOP);
                    btnShow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    final int index = x;
                    btnShow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (force == false) {
                                vier = false;
                                huidig = index;
                                openopsl();
                            }
                        }
                    });

                    // Add Button to LinearLayout
                    if (linearLayout != null) {
                        linearLayout.addView(btnShow);
                    }
                }
                x += 1;
            }
        }


    }
    public void buttoncreator4 (){
        LinearLayout linearLayout = findViewById(R.id.lin4);
        int x = 1;
        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        int y = pref.getInt("4xmax", 0);
        if (y == 0){}
        else {
            while (x <= y) {
                String z = Integer.toString(x);
                SharedPreferences pref3 = getSharedPreferences("4x" + z , MODE_PRIVATE);
                String a = pref3.getString("naam", "");
                if (a.length()==0){
                }
                else {
                    Button btnShow = new Button(this);
                    btnShow.setText(a);
                    btnShow.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.SRC_ATOP);
                    btnShow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    final int index = x;
                    btnShow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (force == false) {
                                vier = true;
                                huidig = index;
                                openopsl();
                            }
                        }
                    });

                    // Add Button to LinearLayout
                    if (linearLayout != null) {
                        linearLayout.addView(btnShow);
                    }
                }
                x += 1;
            }
        }


    }

    public void Kiesmenu(View view) {
        if (force == false) {
            finish();
        }
    }
    public  void test(){
        View details = findViewById(R.id.bew);

        ValueAnimator animator = ValueAnimator.ofFloat(0, 60);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) details.getLayoutParams();
                params.weight = value;
                details.setLayoutParams(params);
            }
        });
        animator.start();
    }
    public  void test2(){
        LinearLayout details1 = findViewById(R.id.opsl);

        ValueAnimator animator1 = ValueAnimator.ofFloat(0, 60);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation1) {
                float value1 = (float) animation1.getAnimatedValue();

                LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) details1.getLayoutParams();
                params1.weight = value1;
                details1.setLayoutParams(params1);
            }
        });
        animator1.start();
    }
    public  void test3(){
        TextView details2 = findViewById(R.id.textView24);

        ValueAnimator animator2 = ValueAnimator.ofFloat(0, 10);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation2) {
                float value2 = (float) animation2.getAnimatedValue();

                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) details2.getLayoutParams();
                params2.weight = value2;
                details2.setLayoutParams(params2);
            }
        });
        animator2.start();
    }
    public  void test4(){
        View details3 = findViewById(R.id.verw);

        ValueAnimator animator3 = ValueAnimator.ofFloat(0, 60);
        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation3) {
                float value3 = (float) animation3.getAnimatedValue();

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) details3.getLayoutParams();
                params3.weight = value3;
                details3.setLayoutParams(params3);
            }
        });
        animator3.start();
    }
    public  void test5(){
        View details4 = findViewById(R.id.textView26);

        ValueAnimator animator4 = ValueAnimator.ofFloat(0, 5);
        animator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation4) {
                float value4 = (float) animation4.getAnimatedValue();

                LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) details4.getLayoutParams();
                params4.weight = value4;
                details4.setLayoutParams(params4);
            }
        });
        animator4.start();
    }
    public void openspel(View view){
        if (force == false) {
            t();
            View tab1 = (View) findViewById(R.id.tab1);
            tab1.setAlpha(1);
            View tab2 = (View) findViewById(R.id.tab);
            tab2.setAlpha(1);
            View t1 = findViewById(R.id.view27);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
            t1.setLayoutParams(p);
            test();
            force = true;
        }
    }
    public void sluit(View view){
        View tab1 = (View)findViewById(R.id.tab1);
        tab1.setAlpha(0);
        View tab2 = (View)findViewById(R.id.tab);
        tab2.setAlpha(0);
        View t1 = findViewById(R.id.view27);
        View t2 = findViewById(R.id.bew);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t1.setLayoutParams(p);
        t2.setLayoutParams(p);
        force = false;
    }
    public void start(View view){
        RadioButton vierr = (RadioButton)findViewById(R.id.radioButton2);
        if (vierr.isChecked()){
            EditText in2 = (EditText) findViewById(R.id.editTextNumber5);
            String e = in2.getText().toString();
            if (e.length()<1){}
            else {
                SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                int x = pref.getInt("4xmax", 0);
                int y = pref.getInt("4xnu", 0);
                x += 1;
                editor.putInt("4xmax", x);
                editor.putInt("4xnu", x);
                editor.commit();

                String z = Integer.toString(x);
                SharedPreferences pref2 = getSharedPreferences("4x" + z, MODE_PRIVATE);
                SharedPreferences.Editor editor2 = pref2.edit();
                EditText in = (EditText) findViewById(R.id.editTextNumber5);
                editor2.putString("naam", in.getText().toString());
                editor2.commit();

                EditText ops = (EditText) findViewById(R.id.editTextNumber5);
                ops.setText("");
                View tab1 = (View)findViewById(R.id.tab1);
                tab1.setAlpha(0);
                View tab2 = (View)findViewById(R.id.tab);
                tab2.setAlpha(0);
                View t1 = findViewById(R.id.view27);
                View t2 = findViewById(R.id.bew);
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
                t1.setLayoutParams(p);
                t2.setLayoutParams(p);
                force = false;
                Intent i = new Intent(this, vierspelers.class);
                finish();
                startActivity(i);
            }
        }
        else {
            EditText in2 = (EditText) findViewById(R.id.editTextNumber5);
            String e = in2.getText().toString();
            if (e.length()<1){}
            else {
                SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                int x = pref.getInt("6xmax", 0);
                int y = pref.getInt("6xnu", 0);
                x += 1;
                editor.putInt("6xmax", x);
                editor.putInt("6xnu", x);
                editor.commit();

                String z = Integer.toString(x);
                SharedPreferences pref2 = getSharedPreferences("6x" + z, MODE_PRIVATE);
                SharedPreferences.Editor editor2 = pref2.edit();
                EditText in = (EditText) findViewById(R.id.editTextNumber5);
                String d = in.getText().toString();
                editor2.putString("naam", d);
                String t = in.getText().toString();
                EditText ops = (EditText) findViewById(R.id.editTextNumber5);
                editor2.commit();
                ops.setText("");

                View tab1 = (View)findViewById(R.id.tab1);
                tab1.setAlpha(0);
                View tab2 = (View)findViewById(R.id.tab);
                tab2.setAlpha(0);
                View t1 = findViewById(R.id.view27);
                View t2 = findViewById(R.id.bew);
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
                t1.setLayoutParams(p);
                t2.setLayoutParams(p);
                force = false;
                Intent i = new Intent(this, zesspelers.class);
                finish();
                startActivity(i);
            }

        }
    }
    public void openopsl(){
        if (force == false) {
            if(vier == true){
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                EditText mEdit = (EditText) findViewById(R.id.editText3);
                mEdit.setEnabled(false);
                mEdit.setAlpha(0);
                String xy = Integer.toString(huidig);
                SharedPreferences pref2 = getSharedPreferences("4x" + xy , MODE_PRIVATE);
                int bl = pref2.getInt("bl", 0);
                int r = pref2.getInt("r", 0);
                String a = pref2.getString("naam", "");
                EditText tab2 = (EditText) findViewById(R.id.editText2);
                tab2.setText(Integer.toString(bl));
                EditText tab1 = (EditText) findViewById(R.id.editText4);
                tab1.setText(Integer.toString(r));
                EditText tab3 = (EditText) findViewById(R.id.editText);
                tab3.setText(a);
            }
            else{
                String xy = Integer.toString(huidig);
                SharedPreferences pref3 = getSharedPreferences("6x" + xy , MODE_PRIVATE);
                int nbl = pref3.getInt("bl", 0);
                int nr = pref3.getInt("r", 0);
                int n = pref3.getInt("n", 0);
                String a = pref3.getString("naam", "");
                EditText tab2 = (EditText) findViewById(R.id.editText2);
                tab2.setText(Integer.toString(nbl));
                EditText tab1 = (EditText) findViewById(R.id.editText4);
                tab1.setText(Integer.toString(nr));
                EditText tab3 = (EditText) findViewById(R.id.editText3);
                tab3.setText(Integer.toString(n));
                EditText tab4 = (EditText) findViewById(R.id.editText);
                tab4.setText(a);
            }
            r();
            View tab1 = (View) findViewById(R.id.tab1);
            tab1.setAlpha(1);
            View tab2 = (View) findViewById(R.id.tab);
            tab2.setAlpha(1);
            View t1 = findViewById(R.id.view38);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
            t1.setLayoutParams(p);
            LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0);
            View t2 = findViewById(R.id.textView24);
            t2.setLayoutParams(q);
            View t3 = findViewById(R.id.verw);
            t3.setLayoutParams(q);
            View t4 = findViewById(R.id.textView26);
            t4.setLayoutParams(q);
            test2();
            force = true;
        }
    }
    public void t(){
        View t2 = findViewById(R.id.textView24);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t2.setLayoutParams(p);
    }
    public void sluitopsl(View view){
        if(vier == true){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            EditText mEdit = (EditText) findViewById(R.id.editText3);
            mEdit.setEnabled(true);
            mEdit.setAlpha(1);
        }
        View tab1 = (View)findViewById(R.id.tab1);
        tab1.setAlpha(0);
        View tab2 = (View)findViewById(R.id.tab);
        tab2.setAlpha(0);
        View t1 = findViewById(R.id.view38);
        View t2 = findViewById(R.id.opsl);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t1.setLayoutParams(p);
        t2.setLayoutParams(p);
        View t3 = findViewById(R.id.textView24);
        t3.setLayoutParams(p);
        force = false;
    }
    public void opslopsl(View view){
        EditText in = (EditText) findViewById(R.id.editText);
        String x = in.getText().toString();
        EditText in2 = (EditText) findViewById(R.id.editText2);
        String y = in2.getText().toString();
        EditText in3 = (EditText) findViewById(R.id.editText3);
        String z = in3.getText().toString();
        EditText in4 = (EditText) findViewById(R.id.editText4);
        String w = in4.getText().toString();
        if (vier == true){
            if (x.length() <1){}
            else {
                if (y.length() <1){}
                else {
                    if (w.length() <1){}
                    else {
                        String xy = Integer.toString(huidig);
                        int bl = Integer.parseInt(in2.getText().toString());
                        int r = Integer.parseInt(in4.getText().toString());
                        SharedPreferences pref2 = getSharedPreferences("4x" + xy , MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = pref2.edit();
                        editor2.putString("naam", in.getText().toString());
                        editor2.putInt("bl", bl);
                        editor2.putInt("r", r);
                        editor2.commit();
                        test3();
                        (new Handler()).postDelayed(this::t, 3000);
                    }

                }
            }
        }
        else {
            if (x.length() <1){}
            else {
                if (y.length() <1){}
                else {
                    if (w.length() <1){}
                    else {
                        if (z.length() <1){}
                        else {
                            String xy = Integer.toString(huidig);
                            int nbl = Integer.parseInt(in2.getText().toString());
                            int n = Integer.parseInt(in3.getText().toString());
                            int nr = Integer.parseInt(in4.getText().toString());
                            SharedPreferences pref2 = getSharedPreferences("6x" + xy , MODE_PRIVATE);
                            SharedPreferences.Editor editor2 = pref2.edit();
                            editor2.putString("naam", in.getText().toString());
                            editor2.putInt("bl", nbl);
                            editor2.putInt("r", nr);
                            editor2.putInt("n", n);
                            editor2.commit();
                            test3();
                            LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0);
                            View t3 = findViewById(R.id.verw);
                            t3.setLayoutParams(q);
                            View t4 = findViewById(R.id.textView26);
                            t4.setLayoutParams(q);
                            View t5 = findViewById(R.id.view76);
                            t5.setLayoutParams(q);
                            (new Handler()).postDelayed(this::t, 3000);
                        }
                    }

                }
            }

        }
    }
    public void spelen(View view){
        View tab1 = (View)findViewById(R.id.tab1);
        tab1.setAlpha(0);
        View tab2 = (View)findViewById(R.id.tab);
        tab2.setAlpha(0);
        View t1 = findViewById(R.id.view38);
        View t2 = findViewById(R.id.opsl);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t1.setLayoutParams(p);
        t2.setLayoutParams(p);
        TextView t3 = findViewById(R.id.textView24);
        t3.setLayoutParams(p);
        if (vier == true){
            SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
            SharedPreferences.Editor editor2 = pref.edit();
            editor2.putInt("4xnu", huidig);
            editor2.commit();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            EditText mEdit = (EditText) findViewById(R.id.editText3);
            mEdit.setEnabled(true);
            mEdit.setAlpha(1);
            force = false;
            Intent i = new Intent(this, vierspelers.class);
            finish();
            startActivity(i);
        }
        else {
            SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
            SharedPreferences.Editor editor2 = pref.edit();
            editor2.putInt("6xnu", huidig);
            editor2.commit();
            force = false;
            Intent i = new Intent(this, zesspelers.class);
            finish();
            startActivity(i);
        }
    }
    public void openver(View view){
        View t1 = findViewById(R.id.view38);
        View t2 = findViewById(R.id.opsl);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t1.setLayoutParams(p);
        t2.setLayoutParams(p);
        TextView t3 = findViewById(R.id.textView24);
        t3.setLayoutParams(p);
        View t4 = findViewById(R.id.view76);
        View t5 = findViewById(R.id.textView26);
        t5.setLayoutParams(p);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,20);
        t4.setLayoutParams(q);
        test4();
    }
    public void vernee(View view){
        View t1 = findViewById(R.id.view38);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
        t1.setLayoutParams(p);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0);
        View t2 = findViewById(R.id.textView24);
        t2.setLayoutParams(q);
        View t3 = findViewById(R.id.verw);
        t3.setLayoutParams(q);
        View t4 = findViewById(R.id.textView26);
        t4.setLayoutParams(q);
        View t5 = findViewById(R.id.view76);
        t5.setLayoutParams(q);
        test2();
    }
    public void r(){
        View t2 = findViewById(R.id.textView26);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t2.setLayoutParams(p);
    }
    public void verwijderen(View view){
        if (vier == true){
            String xy = Integer.toString(huidig);
            SharedPreferences pref2 = getSharedPreferences("4x" + xy , MODE_PRIVATE);
            SharedPreferences.Editor editor = pref2.edit();
            editor.clear();
            editor.commit();
        }
        else {
            String xy = Integer.toString(huidig);
            SharedPreferences pref2 = getSharedPreferences("6x" + xy , MODE_PRIVATE);
            SharedPreferences.Editor editor = pref2.edit();
            editor.clear();
            editor.commit();
        }
        if(vier == true){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            EditText mEdit = (EditText) findViewById(R.id.editText3);
            mEdit.setEnabled(true);
            mEdit.setAlpha(1);
        }
        View tab1 = (View)findViewById(R.id.tab1);
        tab1.setAlpha(0);
        View tab2 = (View)findViewById(R.id.tab);
        tab2.setAlpha(0);
        View t1 = findViewById(R.id.view38);
        View t2 = findViewById(R.id.opsl);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        t1.setLayoutParams(p);
        t2.setLayoutParams(p);
        View t3 = findViewById(R.id.textView24);
        t3.setLayoutParams(p);
        View t5 = findViewById(R.id.verw);
        t5.setLayoutParams(p);
        View t6 = findViewById(R.id.view76);
        t6.setLayoutParams(p);
        force = false;
        test5();
        verwlinear();
        buttoncreator6();
        buttoncreator4();
        (new Handler()).postDelayed(this::r, 3000);
    }
}
