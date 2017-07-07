package com.example.abin.attendance;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> names=new ArrayList<>();
    ListView list;
    ArrayAdapter<String>array;
    EditText t1,t2;
    TextView textView;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dataBaseHelper=new DataBaseHelper(this);

    }
//    public void viewAttendance(View view)
//    {
//        t1=(EditText)findViewById(R.id.editText);
//        t2=(EditText)findViewById(R.id.editText2);
//        textView=(TextView)findViewById(R.id.textView);
//        String result=dataBaseHelper.viewData(t1.getText().toString(),t2.getText().toString());
//        textView.setText(result);
//
//    }
    public void load(View view){
        DataBaseHelper d=new DataBaseHelper(this);
        list=(ListView)findViewById(R.id.list);
        Cursor c=d.all();
        while(c.moveToNext())
        {
            names.add(c.getString(0));
        }
        array=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        list.setAdapter(array);
    }
}
