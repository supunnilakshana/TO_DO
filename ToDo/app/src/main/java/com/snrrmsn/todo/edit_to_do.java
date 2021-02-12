package com.snrrmsn.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.security.PrivateKey;

public class edit_to_do extends AppCompatActivity {
    private EditText title,des;
    private Button edit;
    private DbHandler dbHandler;
    private Context context;
    private Long updateDate;
    private DatePicker picker;
    String Tag="ccs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Tag,"11111111111111");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);
        Log.i(Tag,"11111111111111");

            context = this;
            dbHandler = new DbHandler(context);
        Log.i(Tag,"11111111111111");
            title = findViewById(R.id.editToDoeditTextTitle);
            des = findViewById(R.id.editToDoeditTextDescription);
            edit = findViewById(R.id.editToDobuttonAdd);
            picker= findViewById(R.id.datePicker_edit);
        Log.i(Tag,"11111111111111");


            final String id = getIntent().getStringExtra("id");
        Log.i(Tag,"11111111111111");
        ToDo todo = dbHandler.getSingleToDo(Integer.parseInt(id));


            title.setText(todo.getTitle());
            des.setText(todo.getDescription());

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String titleText = title.getText().toString();
                    String decText = des.getText().toString();
                    updateDate = System.currentTimeMillis();
                    String Date=String.valueOf(picker.getDayOfMonth());
                    ToDo toDo = new ToDo(Integer.parseInt(id),titleText,decText,Date,updateDate,0);
                    int state = dbHandler.updateSingleToDo(toDo);
                    System.out.println(state);
                    startActivity(new Intent(context,MainActivity.class));
                }
            });
        }
    }
