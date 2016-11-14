package bbsr.iiit.bloodbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Print extends AppCompatActivity {
    Bundle bundle;
    TextView tv;
    String name,contact,email,location,bloodgroup;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        tv=(TextView)findViewById(R.id.textView);
        bundle=getIntent().getExtras();
        createDatabase();
        name=bundle.getString("name");
        contact=bundle.getString("contact");
        email=bundle.getString("email");
        location=bundle.getString("location");
        bloodgroup=bundle.getString("bloodgroup");
        insertIntoDB();

    }
    protected void createDatabase(){
        db=openOrCreateDatabase("Blood_Donation", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS donors(name VARCHAR,contact NUMBER, email VARCHAR, location VARCHAR, bloodgroup VARCHAR);");

    }
    protected void insertIntoDB(){
        if(name.equals("")){
            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }
        String query = "INSERT INTO donors (name,contact,email,location,bloodgroup) VALUES('"+name+"', '"+contact+"','"+email+"','"+location+"','"+bloodgroup+"');";
        db.execSQL(query);
        tv.setText("Donor successfully registered");

    }
}
