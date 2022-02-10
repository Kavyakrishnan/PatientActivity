package com.example.patientappactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddpatientActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    AppCompatButton b1;
    String getpcode,getname,getaddress,getmobno,getdoctrname;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpatient);
        ed1=(EditText)findViewById(R.id.pcode);
       ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.address);
        ed4=(EditText)findViewById(R.id.mobno);
        ed5=(EditText)findViewById(R.id.docname);
b1=(AppCompatButton)findViewById(R.id.submit);
mydb=new DbHelper(this);
mydb.getWritableDatabase();
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getpcode=ed1.getText().toString();
        getname=ed2.getText().toString();
        getaddress=ed3.getText().toString();
        getmobno=ed4.getText().toString();
        getdoctrname=ed5.getText().toString();
        boolean status=mydb.insertPatient(getpcode,getname,getaddress,getmobno,getdoctrname);

        if (status==true)
        {
            Toast.makeText(getApplicationContext(), "SUCCESSFULLY INSERTED", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
        }

    }
});



}
}




