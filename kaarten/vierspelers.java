package com.example.kaarten;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class vierspelers extends AppCompatActivity {
    public int bl;
    public int r;
    public boolean force = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vierspelers);
        setContentView(R.layout.vierspelers);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ImageButton opslsl = (ImageButton) findViewById(R.id.imageButton4);
        opslsl.setEnabled(false);
        opslsl.getBackground().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.MULTIPLY);
        ImageButton opslst = (ImageButton) findViewById(R.id.imageButton2);
        opslst.setEnabled(true);
        opslst.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY);

        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        int x = pref.getInt("4xnu", 0);
        if (x != 0) {
            SharedPreferences pref3 = getSharedPreferences("4x" + x, MODE_PRIVATE);
            String te = pref3.getString("naam", "");
            if (te.length() <1){
                TextView tussen = (TextView) findViewById(R.id.textView17);
                String t = "Geen actief pofiel";
                tussen.setText(t);
                SharedPreferences pref4 = getSharedPreferences("standaard", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref4.edit();
                editor.putInt("4xnu", 0);
                editor.commit();

                bl = pref.getInt("blauw", 0);
                r = pref.getInt("rood", 0);

                TextView tbl = (TextView) findViewById(R.id.textView);
                tbl.setText(Integer.toString(bl));
                TextView rbl = (TextView) findViewById(R.id.textView2);
                rbl.setText(Integer.toString(r));
            }
            else {
                String z = Integer.toString(x);
                SharedPreferences pref2 = getSharedPreferences("4x" + z, MODE_PRIVATE);
                bl = pref2.getInt("bl", 0);
                r = pref2.getInt("r", 0);
                String a = pref2.getString("naam", "");
                TextView tussen = (TextView) findViewById(R.id.textView17);
                String t = "Actief pofiel: " + a;
                tussen.setText(t);
                TextView ttbl = (TextView) findViewById(R.id.textView);
                ttbl.setText(Integer.toString(bl));
                TextView trbl = (TextView) findViewById(R.id.textView2);
                trbl.setText(Integer.toString(r));
            }

        }
        else {
            TextView tussen = (TextView) findViewById(R.id.textView17);
            String t = "Geen actief pofiel";
            tussen.setText(t);

            bl = pref.getInt("blauw", 0);
            r = pref.getInt("rood", 0);

            TextView tbl = (TextView) findViewById(R.id.textView);
            tbl.setText(Integer.toString(bl));
            TextView rbl = (TextView) findViewById(R.id.textView2);
            rbl.setText(Integer.toString(r));
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (force == false) {
                    finish();
                }
            }
        });

    }

    public void Kiesmenu(View view) {
        if (force == false) {
            finish();
        }
    }

    public void  eenbl(View view){
        if (force == false) {
            bl += 1;
            update();
        }
    }
    public void  zevenbl(View view){
        if (force == false) {
            bl += 7;
            update();
        }
    }
    public void  viernegenbl(View view){
        if (force == false) {
            bl += 49;
            update();
        }
    }
    public void  eenr(View view){
        if (force == false) {
            r += 1;
            update();
        }
    }
    public void  zevenr(View view){
        if (force == false) {
            r += 7;
            update();
        }
    }
    public void  viernegenr(View view){
        if (force == false) {
            r += 49;
            update();
        }
    }
    public void reset(View view){
            bl = 0;
            r = 0;
            update();

    }
    public  void test(){
        LinearLayout details = findViewById(R.id.main);

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
        LinearLayout details = findViewById(R.id.bew);

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
    public  void test3(){
        LinearLayout details = findViewById(R.id.opsl);

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

    public void rest(View view){
        if (force == false) {
            View tab1 = (View) findViewById(R.id.tab1);
            tab1.setAlpha(1);
            View tab2 = (View) findViewById(R.id.tab2);
            tab2.setAlpha(1);
            View fill = (View) findViewById(R.id.view39);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
            fill.setLayoutParams(p);
            test();


            SharedPreferences pref3 = getSharedPreferences("standaard", MODE_PRIVATE);
            int x = pref3.getInt("4xnu", 0);
            if (x != 0) {
                ImageButton opslsl = (ImageButton) findViewById(R.id.imageButton4);
                opslsl.setEnabled(true);
                opslsl.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY);
                ImageButton opslst = (ImageButton) findViewById(R.id.imageButton2);
                opslst.setEnabled(false);
                opslst.getBackground().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.MULTIPLY);
            }
            force = true;
        }
    }
    public void sluitrest(View view){
        View tab1 = (View)findViewById(R.id.tab1);
        tab1.setAlpha(0);
        View tab2 = (View)findViewById(R.id.tab2);
        tab2.setAlpha(0);
        View fill = (View) findViewById(R.id.view39);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,100);
        fill.setLayoutParams(p);
        force = false;
    }

    public void update(){
        SharedPreferences pref3 = getSharedPreferences("standaard", MODE_PRIVATE);
        int x = pref3.getInt("4xnu", 0);
        if (x != 0) {
            String z = Integer.toString(x);
            SharedPreferences pref2 = getSharedPreferences("4x" + z, MODE_PRIVATE);
            SharedPreferences.Editor editor2 = pref2.edit();
            editor2.putInt("bl", bl);
            editor2.putInt("r", r);
            editor2.commit();


            String a = pref2.getString("naam", "");
            TextView tussen = (TextView) findViewById(R.id.textView17);
            String t = "Actief pofiel: " + a;
            tussen.setText(t);

        }




        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("blauw", bl);
        editor.putInt("rood", r);
        editor.commit();
        TextView tbl = (TextView)findViewById(R.id.textView);
        tbl.setText(Integer.toString(bl));
        TextView rbl = (TextView)findViewById(R.id.textView2);
        rbl.setText(Integer.toString(r));
    }
    public void delen(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Stand: " + Integer.toString(bl) +"-" + Integer.toString(r));
        sendIntent.setType("text/*");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void bewerken(View view){
        LinearLayout bew = (LinearLayout) findViewById(R.id.bew);
        LinearLayout main = (LinearLayout) findViewById(R.id.main);
        View fill = (View) findViewById(R.id.view39);
        View fill2 = (View) findViewById(R.id.view27);
        EditText tab1 = (EditText) findViewById(R.id.editTextNumber);
        EditText tab2 = (EditText) findViewById(R.id.editTextNumber2);
        tab1.setText(Integer.toString(bl));
        tab2.setText(Integer.toString(r));

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,60);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,20);
        LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        main.setLayoutParams(r);
        bew.setLayoutParams(p);
        fill.setLayoutParams(p);
        fill2.setLayoutParams(q);
        test2();

    }
    public void bewerkenleave(View view){
        LinearLayout bew = (LinearLayout) findViewById(R.id.bew);
        View fill = (View) findViewById(R.id.view39);

        EditText in = (EditText) findViewById(R.id.editTextNumber);
        String x = in.getText().toString();
        if (x.length() <1 ){

        }else {
            EditText in2 = (EditText) findViewById(R.id.editTextNumber2);
            String y = in2.getText().toString();
            if (y.length() <1){

            }
            else {
                bl = Integer.parseInt(in.getText().toString());
                r = Integer.parseInt(in2.getText().toString());
                update();
                in.setText("");
                in2.setText("");

                View fill2 = (View) findViewById(R.id.view27);

                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0);
                bew.setLayoutParams(p);
                fill2.setLayoutParams(p);
                LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
                fill.setLayoutParams(q);
                LinearLayout main = (LinearLayout) findViewById(R.id.main);
                LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,60);
                main.setLayoutParams(r);
                test();
            }
        }

    }
    public void bewerkensluiten(View view){
        EditText in = (EditText) findViewById(R.id.editTextNumber);
        EditText in2 = (EditText) findViewById(R.id.editTextNumber2);
        LinearLayout bew = (LinearLayout) findViewById(R.id.bew);
        View fill = (View) findViewById(R.id.view39);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        bew.setLayoutParams(p);
        View fill2 = (View) findViewById(R.id.view27);
        fill2.setLayoutParams(p);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,20);
        fill.setLayoutParams(q);
        in.setText("");
        in2.setText("");
        LinearLayout main = (LinearLayout) findViewById(R.id.main);
        LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        main.setLayoutParams(r);
        test();

    }
    public void opslop(View view){
        LinearLayout mainn = (LinearLayout) findViewById(R.id.main);
        View tusse = (View) findViewById(R.id.view39);
        View tussen = (View) findViewById(R.id.view25);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,20);
        tussen.setLayoutParams(q);
        mainn.setLayoutParams(p);
        tusse.setLayoutParams(p);
        test3();
    }
    public void opslleave(View view){
        LinearLayout mainn = (LinearLayout) findViewById(R.id.main);
        View tusse = (View) findViewById(R.id.view39);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,60);
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,20);
        View tussen = (View) findViewById(R.id.view25);
        LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,100);
        tussen.setLayoutParams(r);
        mainn.setLayoutParams(p);
        tusse.setLayoutParams(q);
        EditText ops = (EditText) findViewById(R.id.editText);
        ops.setText("");
        test();
    }
    public void opslsl(View view){
        EditText in2 = (EditText) findViewById(R.id.editText);
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
            EditText in = (EditText) findViewById(R.id.editText);
            editor2.putString("naam", in.getText().toString());
            editor2.putInt("bl", bl);
            editor2.putInt("r", r);
            editor2.commit();

            TextView tussen = (TextView) findViewById(R.id.textView17);
            String k = in.getText().toString();
            String t = "Actief pofiel: " + k;
            tussen.setText(t);
            View tussenn = (View) findViewById(R.id.view25);
            LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,100);
            tussenn.setLayoutParams(r);


            LinearLayout mainn = (LinearLayout) findViewById(R.id.main);
            View tusse = (View) findViewById(R.id.view39);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 60);
            LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 20);
            mainn.setLayoutParams(p);
            tusse.setLayoutParams(q);
            EditText ops = (EditText) findViewById(R.id.editText);
            ops.setText("");
            SharedPreferences pref3 = getSharedPreferences("standaard", MODE_PRIVATE);
            int l = pref3.getInt("4xnu", 0);
            if (l != 0) {
                ImageButton opslsl = (ImageButton) findViewById(R.id.imageButton4);
                opslsl.setEnabled(true);
                opslsl.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY);
                ImageButton opslst = (ImageButton) findViewById(R.id.imageButton2);
                opslst.setEnabled(false);
                opslst.getBackground().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.MULTIPLY);
            }
            test();
        }
    }

    public void opslafsluiten(View view){


        SharedPreferences pref3 = getSharedPreferences("standaard", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref3.edit();
        editor2.putInt("4xnu",0);
        editor2.commit();
        TextView tussen = (TextView) findViewById(R.id.textView17);
        String t = "Geen actief pofiel";
        tussen.setText(t);
        ImageButton opslsl = (ImageButton) findViewById(R.id.imageButton4);
        opslsl.setEnabled(false);
        opslsl.getBackground().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.MULTIPLY);
        ImageButton opslst = (ImageButton) findViewById(R.id.imageButton2);
        opslst.setEnabled(true);
        opslst.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY);

    }


}

