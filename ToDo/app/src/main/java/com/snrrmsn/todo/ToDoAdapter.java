package com.snrrmsn.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class ToDoAdapter extends ArrayAdapter<ToDo> {
    Context context;
    int resource;
    List<ToDo> objects;
    public ToDoAdapter(@NonNull Context context, int resource, @NonNull List<ToDo> objects) {

        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.title);
        TextView description = row.findViewById(R.id.description);
        TextView Date = row.findViewById(R.id.Tododate);
        ImageView imageView = row.findViewById(R.id.onGoing);



        // todos [obj1,obj2,obj3]
        ToDo toDo = objects.get(position);
        title.setText(toDo.getTitle());
        description.setText(toDo.getDescription());
        Date.setText("Before should do "+toDo.getDate());
        imageView.setVisibility(row.INVISIBLE);

        if(toDo.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }
        return row;
    }
}
