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

public class add_to_do extends AppCompatActivity {

    private EditText title, desc;
    private Button add;
    private DbHandler dbHandler;
    private Context context;
    private DatePicker picker;
    String Tag="ccs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        title = findViewById(R.id.editTextTitle);
        desc = findViewById(R.id.editTextDescription);
        add = findViewById(R.id.buttonAdd);
        picker =findViewById(R.id.datePicker_add);
        context = this;

        dbHandler = new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userTitle = title.getText().toString();
                String userDesc = desc.getText().toString();
                long started = System.currentTimeMillis();
                String Date= picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear();
                Log.i(Tag,Date);

                ToDo toDo = new ToDo(userTitle,userDesc,Date,started,0);

                dbHandler.addToDo(toDo);
                Log.i(Tag,toDo.getDate()+"2bd");

                startActivity(new Intent(context,MainActivity.class));
            }
        });
    }
}