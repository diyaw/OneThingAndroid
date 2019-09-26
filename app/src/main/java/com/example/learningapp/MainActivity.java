package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //now we will make reference variable to hold button and textview
    Button button;
    EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(EditText) findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);

        final SharedPreferences sharedPref= getPreferences(Context.MODE_PRIVATE);
        String oldItem = sharedPref.getString("oldItem","Nothing created yet ...");

        textView.setText(oldItem);

        button.setOnClickListener(new View.OnClickListener() {
            // this is going to run every time we click the button
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= sharedPref.edit();
                editor.putString("oldItem",textView.getText().toString());
                editor.commit();

                Animation animation = new AlphaAnimation(1.0f,0.0f);
                animation.setDuration(1000);
                button.startAnimation(animation);

            }
        });
    }
}
