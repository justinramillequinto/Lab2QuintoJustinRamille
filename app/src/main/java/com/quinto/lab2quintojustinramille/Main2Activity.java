package com.quinto.lab2quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Validate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        course = findViewById(R.id.editText9);
    }

    public void validate(View v) {
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);
        String[] coursesSP = new String[8];
        Boolean exists = false;

        for(int i = 0; i < coursesSP.length; i++) {
            coursesSP[i] = sp.getString("course"+i, null);
        }

        String checkCourse = course.getText().toString();

        for(String c : coursesSP) {
            if(c.equals(checkCourse)) {
                exists = true;
            }
        }

        if(exists) {
            Toast.makeText(this, "Course is offered in UST", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Course is not offered in UST", Toast.LENGTH_LONG).show();
        }
    }

    public void previousPage(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
