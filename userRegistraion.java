package com.example.sahil.registration;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class userRegistraion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private String text;
    private EditText Name;
    private EditText Email;
    private EditText Phoneno;
    private EditText Amount;
    private Toolbar toolbar;
    private Button Done;





    DatabaseReference databasemember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registraion);

        Spinner spinner = findViewById(R.id.spev);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Events,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Name = (EditText)findViewById(R.id.etnewname);
        Email = (EditText)findViewById(R.id.etemail);
        Phoneno =(EditText)findViewById(R.id.etphone);
        Amount = (EditText)findViewById(R.id.etamount);

        Button register = (Button) findViewById(R.id.btnRegister);
        Done = (Button)findViewById(R.id.btnmail);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databasemember = FirebaseDatabase.getInstance().getReference("newMember");

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               next();


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Addnew();

            }
        });



    }

    @SuppressLint("IntentReset")
    private void Addnew()
    {
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String phone = Phoneno.getText().toString();
        String amount = Amount.getText().toString();
         Intent chooser = null;

         if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Please enter a valid email");
            Email.requestFocus();

        }
        if(Email.length() > 40) {
            Email.setError("Maximum Length of Email should be 25");
            Email.requestFocus();
        }
        if(Name.length() > 24) {
            Name.setError("Maximum Length of Name should be 24");
            Name.requestFocus();
        }
        if(Phoneno.length() > 10) {
            Phoneno.setError(" Length of Phone no. should be 10");
            Phoneno.requestFocus();
        }
        if(Amount.length() > 3 ) {
            Amount.setError("Maximum Length of Amount should be 3 digit");
            Amount.requestFocus();
        }


        if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(phone) || !TextUtils.isEmpty(amount) || !TextUtils.isEmpty(text))

        {

            String id = databasemember.push().getKey();

            Newmember member = new Newmember(id,name,email,phone,text,amount);

            assert id != null;
            databasemember.child(id).setValue(member);


            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Registered Successfully");
            emailIntent.putExtra(Intent.EXTRA_TEXT,"Hi"+" "+name +"."+"The id created for your registration is"+id +".This Email is to in form you that you have registered successfully for the event:"+text+"."+"Total amount paid by you is:"+amount+"."+"I hope you will enjoy the event"+"."+"\nThank you!" );
            emailIntent.setDataAndType(Uri.parse("message"),"rfc822");
            startActivity(Intent.createChooser(emailIntent,"Send email"));
            emailIntent.setType("text/plain");
            startActivity(emailIntent);

            Toast.makeText(this,"Participant registered successfully",Toast.LENGTH_SHORT).show();

        }else
            {
            Toast.makeText(this,"You should enter complete details ",Toast.LENGTH_SHORT).show();
        }

        }

    private void next()
    {
        Intent myintent = new Intent(userRegistraion.this,userRegistraion.class);
        startActivity(myintent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menulogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(userRegistraion.this,Mainpage.class));
                break;


        }


        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

