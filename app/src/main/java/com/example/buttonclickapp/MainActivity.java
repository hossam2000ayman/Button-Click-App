package com.example.buttonclickapp;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //fields

    private EditText userInput;

    private Button addbtn;

    private TextView textView;

    private Button removebtn;

    private int numTimesClicked = 0;

    //logt
    private static final String TAG = "MainActivity";

    private final String TEXT_CONTENTS = "Text Contents";


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");

        super.onRestoreInstanceState(savedInstanceState);

        //String saveString  = savedInstanceState.getString(TEXT_CONTENTS);
        //textView.setText(saveString);

        //shortcut
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);

        userInput.setText("");

        addbtn = (Button) findViewById(R.id.add);

        textView = (TextView) findViewById(R.id.textView);

        removebtn = (Button) findViewById(R.id.remove);

        textView.setText("");

        // make textview scrollable
        textView.setMovementMethod(new ScrollingMovementMethod());


        //add buttons
        View.OnClickListener addOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);

                userInput.setText("");
            }
        };


            addbtn.setOnClickListener(addOnClickListener);




        //remove buttons
        View.OnClickListener removeOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = userInput.getText().toString();

                textView.setText(result);
                userInput.setText("");
            }
        };


            removebtn.setOnClickListener(removeOnClickListener);

        Log.d(TAG, "onCreate: out");



    }
}