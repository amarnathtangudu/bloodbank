package bbsr.iiit.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Spinner spinner;
    Button b;
    Intent i;
    EditText ed1,ed2,ed3,ed4;
    String name,contact,email,location,bloodgroup;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.contact);
        ed3=(EditText)findViewById(R.id.email);
        ed4=(EditText)findViewById(R.id.location);
        bundle=new Bundle();
        spinner=(Spinner)findViewById(R.id.bloodgroup);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    i = new Intent(getApplicationContext(), Print.class);
                    name = ed1.getText().toString().trim();
                    contact = ed2.getText().toString().trim();
                    email = ed3.getText().toString().trim();
                    location = ed4.getText().toString().trim();
                    bloodgroup = spinner.getSelectedItem().toString();
                    if (name==null){
                        Toast.makeText(getApplicationContext(),"Enter valid name",Toast.LENGTH_LONG).show();
                        ed1.requestFocus();
                    }
                    if(contact==null){
                        Toast.makeText(getApplicationContext(),"Enter valid contact no",Toast.LENGTH_LONG).show();
                        ed2.requestFocus();
                    }
                    if(email==null){
                         Toast.makeText(getApplicationContext(),"Enter valid email id",Toast.LENGTH_LONG).show();
                        ed3.requestFocus();
                    }
                    if(location==null){
                        Toast.makeText(getApplicationContext(),"Enter valid location",Toast.LENGTH_LONG).show();
                        ed4.requestFocus();
                    }
                    bundle.putString("name", name);
                    bundle.putString("contact", contact);
                    bundle.putString("email", email);
                    bundle.putString("location", location);
                    bundle.putString("bloodgroup", bloodgroup);
                    i.putExtras(bundle);
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    startActivity(i);
                }
            }
        );
    }
}
