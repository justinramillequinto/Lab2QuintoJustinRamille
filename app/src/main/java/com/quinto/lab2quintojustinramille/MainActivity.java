package com.quinto.lab2quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText[] courses = new EditText[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses[0] = findViewById(R.id.editText);
        courses[1] = findViewById(R.id.editText2);
        courses[2] = findViewById(R.id.editText3);
        courses[3] = findViewById(R.id.editText4);
        courses[4] = findViewById(R.id.editText5);
        courses[5] = findViewById(R.id.editText6);
        courses[6] = findViewById(R.id.editText7);
        courses[7] = findViewById(R.id.editText8);
    }

    public void saveData(View v) {
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);
        Editor editor = sp.edit();

        String[] coursesStr = new String[courses.length];

        for(int i = 0; i < coursesStr.length; i++) {
            coursesStr[i] = courses[i].getText().toString();
            editor.putString("course"+i, coursesStr[i]);
        }
        editor.commit();

        Toast.makeText(this, "Courses were saved", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
