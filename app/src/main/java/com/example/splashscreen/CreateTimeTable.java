package com.example.splashscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateTimeTable extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnAddData;
    AutoCompleteTextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_courses);
        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.search);

        String[] courses = getResources().getStringArray(R.array.courses);

        editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, courses);

        editText.setAdapter(adapter);
        AddData();

    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                      boolean isInserted =  myDb.insertData(editText.getText().toString());

                      if(isInserted == true)
                          Toast.makeText(CreateTimeTable.this, "Data Inserted", Toast.LENGTH_LONG).show();
                      else
                          Toast.makeText(CreateTimeTable.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}

