package com.example.patientappactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1;
    String getmobno,getname,getaddress,getdocname;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText)findViewById(R.id.mobnum);
        ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.addss);
        ed4=(EditText)findViewById(R.id.docrname);

        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1=(AppCompatButton)findViewById(R.id.searchbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getmobno = ed1.getText().toString();
                Cursor c=mydb.searchpatient(getmobno);
                if (c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "NO SUCH PATIENT FOUND", Toast.LENGTH_SHORT).show();
                }
          else
                {
                    while (c.moveToNext()){
                        getname=c.getString(2);
                        getaddress=c.getString(3);
                        getdocname=c.getString(4);;
                    }
                    ed2.setText(getname);
                    ed3.setText(getname);
                    ed4.setText(getname);
                }
            }

        });
    }
}