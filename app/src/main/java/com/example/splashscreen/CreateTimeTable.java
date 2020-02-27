package com.example.splashscreen;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CreateTimeTable extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnAddData;
    Button btnViewAll;
    Button btnDelete;
    AutoCompleteTextView editText;

    /** Create a database OnCreate**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_search_courses);
        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.search);
        btnViewAll = (Button)findViewById(R.id.view);
        btnDelete = (Button)findViewById(R.id.delete);

        String[] courses = getResources().getStringArray(R.array.courses);

        editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, courses);

        editText.setAdapter(adapter);
        AddData();
        ViewAll();
        deleteData();

    }

    /** Add data from user's input**/

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

    public void ViewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            /** When there is no data, show a message **/
                            showMessage("Error","No data found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer(); // going to get the data one by one and store here
                        while(res.moveToNext()){
                            /** Add index 1 of database column to the buffer **/
                            buffer.append("COURSE :" + res.getString(1)+"\n");
                        }

                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    /** alert message for ViewAll method above **/
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    /** delete the data **/
    public void deleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(editText.getText().toString());
                        if(deletedRows >0)
                            Toast.makeText(CreateTimeTable.this, "Data deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CreateTimeTable.this,"Data not deleted", Toast.LENGTH_LONG).show();
                    }

                }
        );
    }

}

