package com.rambalidev.kaarten;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class zesspelers extends AppCompatActivity {
    public int n;
    public int nbl;
    public int nr;
    public boolean force = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zesspelers);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.zesspelers);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton opslsl = (ImageButton) findViewById(R.id.imageButton4);
        opslsl.setEnabled(false);
        opslsl.getBackground().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.MULTIPLY);
        ImageButton opslst = (ImageButton) findViewById(R.id.imageButton2);
        opslst.setEnabled(true);
        opslst.getBackground().setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY);

        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        int r = pref.getInt("6xnu", 0);
        if (r != 0) {
            SharedPreferences pref3 = getSharedPreferences("6x" + r, MODE_PRIVATE);
            String te = pref3.getString("naam", "");
            if (te.length() <1) {
                TextView tussen = (TextView) findViewById(R.id.textView17);
                String t = "Geen actief pofiel";
                tussen.setText(t);

                SharedPreferences pref2 = getSharedPreferences("standaard", MODE_PRIVATE);
                n = pref2.getInt("neutraal", 0);
                nbl = pref2.getInt("neutraalbl", 0);
                nr = pref2.getInt("neutraalr", 0);
                SharedPreferences.Editor editor = pref2.edit();
                editor.putInt("6xnu", 0);
                editor.commit();

                TextView tbl = (TextView)findViewById(R.id.textView);
                String x = Integer.toString(nbl);
                tbl.setText("Kap: " + x);
                TextView rbl = (TextView)findViewById(R.id.textView2);
                String y = Integer.toString(nr);
                rbl.setText("Kap: " + y);
                TextView tn = (TextView)findViewById(R.id.textView12);
                String z = Integer.toString(n);
                tn.setText("Score: " + z);
            }
            else {
                String z = Integer.toString(r);
                SharedPreferences pref2 = getSharedPreferences("6x" + z, MODE_PRIVATE);
                nbl = pref2.getInt("bl", 0);
                nr = pref2.getInt("r", 0);
                n = pref2.getInt("n", 0);
                String a = pref2.getString("naam", "");

                TextView tussen = (TextView) findViewById(R.id.textView17);
                String t = "Actief pofiel: " + a;
                tussen.setText(t);

                TextView tbl = (TextView) findViewById(R.id.textView);
                String x = Integer.toString(nbl);
                tbl.setText("Kap: " + x);
                TextView rbl = (TextView) findViewById(R.id.textView2);
                String y = Integer.toString(nr);
                rbl.setText("Kap: " + y);
                TextView tn = (TextView) findViewById(R.id.textView12);
                String s = Integer.toString(n);
                tn.setText("Score: " + s);
            }


        }
        else {
            TextView tussen = (TextView) findViewById(R.id.textView17);
            String t = "Geen actief pofiel";
            tussen.setText(t);

            SharedPreferences pref2 = getSharedPreferences("standaard", MODE_PRIVATE);
            n = pref2.getInt("neutraal", 0);
            nbl = pref2.getInt("neutraalbl", 0);
            nr = pref2.getInt("neutraalr", 0);

            TextView tbl = (TextView)findViewById(R.id.textView);
            String x = Integer.toString(nbl);
            tbl.setText("Kap: " + x);
            TextView rbl = (TextView)findViewById(R.id.textView2);
            String y = Integer.toString(nr);
            rbl.setText("Kap: " + y);
            TextView tn = (TextView)findViewById(R.id.textView12);
            String z = Integer.toString(n);
            tn.setText("Score: " + z);
        }
    }

    public void Kiesmenu(View view) {
        if (force == false) {
            Intent i = new Intent(this, Kiesmenu.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }
    }

    public void  vijfbl(View view){
        if (force == false) {
            n += 5;
            update();
        }
    }
    public void  zesbl(View view){
        if (force == false) {
            n += 6;
            update();
        }
    }
    public void  zevenbl(View view){
        if (force == false) {
            n += 7;
            update();
        }
    }
    public void  achtbl(View view){
        if (force == false) {
            n += 8;
            update();
        }
    }
    public void  vijfr(View view){
        if (force == false) {
            n -= 5;
            update();
        }
    }
    public void  zesr(View view){
        if (force == false) {
            n -= 6;
            update();
        }
    }
    public void  zevenr(View view){
        if (force == false) {
            n -= 7;
            update();
        }
    }
    public void  achtr(View view){
        if (force == false) {
            n -= 8;
            update();
        }
    }
    public void reset(View view){
            nbl = 0;
            nr = 0;
            n = 0;
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
            int x = pref3.getInt("6xnu", 0);
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
        if(n>=49){
            n -=49;
            nbl+=1;
        }
        if(n<= -49){
            n +=49;
            nr+=1;
        }

        SharedPreferences pref3 = getSharedPreferences("standaard", MODE_PRIVATE);
        int p = pref3.getInt("6xnu", 0);
        if (p != 0) {
            String q = Integer.toString(p);
            SharedPreferences pref2 = getSharedPreferences("6x" + q, MODE_PRIVATE);
            SharedPreferences.Editor editor2 = pref2.edit();
            editor2.putInt("bl", nbl);
            editor2.putInt("r", nr);
            editor2.putInt("n", n);
            editor2.commit();

            String a = pref2.getString("naam", "");
            TextView tussen = (TextView) findViewById(R.id.textView17);
            String t = "Actief pofiel: " + a;
            tussen.setText(t);

        }
        SharedPreferences pref = getSharedPreferences("standaard", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("neutraalbl", nbl);
        editor.putInt("neutraalr", nr);
        editor.putInt("neutraal", n);
        editor.commit();
        TextView tbl = (TextView)findViewById(R.id.textView);
        String x = Integer.toString(nbl);
        tbl.setText("Kap: " + x);
        TextView rbl = (TextView)findViewById(R.id.textView2);
        String y = Integer.toString(nr);
        rbl.setText("Kap: " + y);
        TextView tn = (TextView)findViewById(R.id.textView12);
        String z = Integer.toString(n);
        tn.setText("Score: " + z);
    }
    public void delen(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Stand: " + Integer.toString(n) +" en aantal kap: " + Integer.toString(nbl) +"-" + Integer.toString(nr));
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
        tab1.setText(Integer.toString(nbl));
        tab2.setText(Integer.toString(nr));
        EditText tab3 = (EditText) findViewById(R.id.editTextNumber3);
        tab3.setText(Integer.toString(n));

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
        if (x.length() <1){

        }else {
            EditText in2 = (EditText) findViewById(R.id.editTextNumber2);
            String y = in2.getText().toString();
            if (y.length() <1){


            }
            else {
                EditText in3 = (EditText) findViewById(R.id.editTextNumber3);
                String z = in3.getText().toString();
                if (z.length()<1){}
                else {
                    int k = Integer.parseInt((in3.getText().toString()));
                    if (k >=49){}
                    else {
                        if (k<=-49){}
                        else {

                            nbl = Integer.parseInt(in.getText().toString());
                            nr = Integer.parseInt(in2.getText().toString());
                            n = Integer.parseInt(in3.getText().toString());
                            update();
                            in.setText("");
                            in2.setText("");
                            in3.setText("");

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
            }
        }


    }
    public void bewerkensluiten(View view){
        EditText in = (EditText) findViewById(R.id.editTextNumber);
        EditText in2 = (EditText) findViewById(R.id.editTextNumber2);
        EditText in3 = (EditText) findViewById(R.id.editTextNumber3);
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
        in3.setText("");
        LinearLayout main = (LinearLayout) findViewById(R.id.main);
        LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0);
        main.setLayoutParams(r);
        test();
    }
    public void opslop(View view){
        LinearLayout mainn = (LinearLayout) findViewById(R.id.main);
        View tusse = (View) findViewById(R.id.view39);
        View tussen = (View) findViewById(R.id.view38);
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
        View tussen = (View) findViewById(R.id.view38);
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
            int x = pref.getInt("6xmax", 0);
            int y = pref.getInt("6xnu", 0);
            x += 1;
            editor.putInt("6xmax", x);
            editor.putInt("6xnu", x);
            editor.commit();

            String z = Integer.toString(x);
            SharedPreferences pref2 = getSharedPreferences("6x" + z, MODE_PRIVATE);
            SharedPreferences.Editor editor2 = pref2.edit();
            EditText in = (EditText) findViewById(R.id.editText);
            editor2.putString("naam", in.getText().toString());
            editor2.putInt("bl", nbl);
            editor2.putInt("r", nr);
            editor2.putInt("n", n);
            editor2.commit();

            TextView tussen = (TextView) findViewById(R.id.textView17);
            String k = in.getText().toString();
            String t = "Actief pofiel: " + k;
            tussen.setText(t);
            View tussenn = (View) findViewById(R.id.view38);
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
            int l = pref3.getInt("6xnu", 0);
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
        editor2.putInt("6xnu",0);
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



    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }
}
