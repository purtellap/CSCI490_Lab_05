package com.austin.lab5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    EditText t2;
    EditText t3;
    Button save;

    String name = "Name";
    String pass = "Password";
    String email = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.editText);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        save = findViewById(R.id.button);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        t1.setText(sharedPreferences.getString(name,""));
        t2.setText(sharedPreferences.getString(pass,""));
        t3.setText(sharedPreferences.getString(email,""));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = t1.getText().toString();
                String pw = t2.getText().toString();
                String e = t3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(name, n);
                editor.putString(pass, pw);
                editor.putString(email, e);

                editor.commit();



            }
        });

    }
}
