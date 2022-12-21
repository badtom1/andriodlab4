package com.example.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1;
    ProgressBar p1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        ConstraintLayout cn = findViewById(R.id.layout1);
         p1 = new ProgressBar(this);
        cn.addView(p1);
        p1.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        display1();
                    }
                },3000);
            }
        });
    }
    public void display1(){
        p1.setVisibility(View.INVISIBLE);
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setMessage("You want see alret msg");
        b.setTitle("alert");
        b.setIcon(R.mipmap.ic_launcher_round);
        b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Alert rvce",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Alert no",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = b.create();
        alertDialog.show();
    }
}
