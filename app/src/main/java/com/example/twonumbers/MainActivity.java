package com.example.twonumbers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etA, etB;
    private Button btnAdd, btnMinus, btnTimes, btnDivided;
    private ListView lvHistory;
    private ArrayList<Float> arrayList;
    private ArrayAdapter<Float> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = findViewById(R.id.a_edittext);
        etB = findViewById(R.id.b_edittext);

        btnAdd = findViewById(R.id.add_btn);
        btnMinus = findViewById(R.id.minus_btn);
        btnTimes = findViewById(R.id.times_btn);
        btnDivided = findViewById(R.id.divided_btn);

        lvHistory = findViewById(R.id.lv_history);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lvHistory.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!etA.getText().equals(null) & !etB.getText().equals(null)) {
                        float a = Float.parseFloat(etA.getText().toString());
                        float b = Float.parseFloat(etB.getText().toString());
                        float result = a + b;

                        arrayList.add(result);
                        arrayAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Notification!");
                    builder.setMessage("Please fill in the number in the blank !");
                    builder.setPositiveButton("Ok", null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!etA.getText().equals(null) & !etB.getText().equals(null)) {
                        float a = Float.parseFloat(etA.getText().toString());
                        float b = Float.parseFloat(etB.getText().toString());
                        float result = a - b;

                        arrayList.add(result);
                        arrayAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Notification!");
                    builder.setMessage("Please fill in the number in the blank !");
                    builder.setPositiveButton("Ok", null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        btnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!etA.getText().equals(null) && !etB.getText().equals(null)) {
                        float a = Float.parseFloat(etA.getText().toString());
                        float b = Float.parseFloat(etB.getText().toString());
                        float result = a * b;

                        arrayList.add(result);
                        arrayAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Notification!");
                    builder.setMessage("Please fill in the number in the blank !");
                    builder.setPositiveButton("Ok", null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        btnDivided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!etA.getText().equals(null) & !etB.getText().equals(null)) {
                        float a = Float.parseFloat(etA.getText().toString());
                        float b = Float.parseFloat(etB.getText().toString());
                        float result = a / b;

                        arrayList.add(result);
                        arrayAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Notification!");
                    builder.setMessage("Please fill in the number in the blank !");
                    builder.setPositiveButton("Ok", null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        lvHistory.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

//                builder.setMessage("");
                builder.setTitle("Do you want to remove this?");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    arrayList.remove(position);
                    arrayAdapter.notifyDataSetChanged();
                });

                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();

                return false;
            }
        });
    }
}