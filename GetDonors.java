package bbsr.iiit.bloodbank;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetDonors extends Activity {
    Bundle b;
    private TextView tv;
    Button b1;
    private EditText editTextName;
    private EditText editTextAdd;
    private EditText editTextId;
    private Cursor c;
    private SQLiteDatabase db;
    String hosp_name,loc,b_group,hosp_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_donors);
        openDatabase();
        tv=(TextView)findViewById(R.id.textView2);
        b=getIntent().getExtras();
        hosp_name=b.getString("hosp_name");
        loc=b.getString("loc");
        b_group=b.getString("b_group");
        hosp_id=b.getString("hosp_id");
        b1=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           c = db.rawQuery("SELECT * from donors where bloodgroop=b_group and location=loc", null);
           c.moveToFirst();
            display();
        }
                              });
    }
    protected void openDatabase() {
        db = openOrCreateDatabase("Blood_Donation", Context.MODE_PRIVATE, null);
    }
    protected void display(){
        while(true){
            String a=c.getString(0);
            String b=c.getString(1);
            String x=c.getString(2);
            String y=c.getString(3);
            tv.append(a+b+x+y+"\n");
            if(!c.isLast()){
                c.moveToNext();
            }
            else return;
        }
    }
}
