package com.example.akki.bmi;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.angle;
import static android.R.attr.pivotX;
import static android.R.attr.pivotY;
import static java.sql.Types.NULL;

public class Evaluate extends AppCompatActivity {

    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        TextView re=(TextView)findViewById(R.id.re);
        TextView re1=(TextView)findViewById(R.id.re1);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi",0);
        String prevbmi = intent.getStringExtra("prevBmi");

        if(prevbmi!=null)
        {
         re1.setText(" Previous BMI : " + prevbmi);
        }

        //else re1.setText(" No prev data : " + prevbmi);



        if(bmi<20){
            re.setText(" Your BMI is : " + String.format("%.2f",bmi));
            x=15;

        }

        else if(bmi<25){
            re.setText(" Your BMI is : " + String.format("%.2f",bmi));
            x=55;
        }

        else if(bmi<30){
            re.setText(" Your BMI is : " + String.format("%.2f",bmi));
            x=90;
        }

        else if(bmi<40){
            re.setText(" Your BMI is : " + String.format("%.2f",bmi));
            x=135;
        }

        else if(bmi>40){
            re.setText(" Your BMI is : " + String.format("%.2f",bmi));
            x=168;
        }



        ImageView imageView=(ImageView)findViewById(R.id.imageView);


        RotateAnimation anim = new RotateAnimation(0,x,410,220);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(0);
        anim.setFillEnabled(true);

        anim.setFillAfter(true);
        anim.setDuration(1000);
        imageView.startAnimation(anim);

    }
}
