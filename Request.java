package bbsr.iiit.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class Request extends AppCompatActivity {
Button submit;
    Bundle bundle;
    EditText ed1,ed2,ed3,ed4;
    String hosp_name,loc,b_group,hosp_id;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        submit=(Button)findViewById(R.id.button3);
        i=new Intent(getApplicationContext(),GetDonors.class);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hosp_name=ed1.getText().toString().trim();
                b_group=ed2.getText().toString().trim();
                loc=ed3.getText().toString().trim();
                hosp_id=ed4.getText().toString().trim();
                bundle.putString(hosp_name,"hosp_name");
                bundle.putString(b_group,"b_group");
                bundle.putString(loc,"loc");
                bundle.putString(hosp_id,"hosp_id");
                i.putExtras(bundle);
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                startActivity(i);
            }
        });
    }
}
