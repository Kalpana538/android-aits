package  com.example.myformvalidation;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout name,email,phn;
    RadioButton Ma,Fe;
    CheckBox l1,l2,l3,l4;
    Spinner Branch;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.uname);
        email=findViewById(R.id.uemail);
        phn=findViewById(R.id.umob);
        Ma=findViewById(R.id.Male);
        Fe=findViewById(R.id.Female);
        l1=findViewById(R.id.Lang1);
        l2=findViewById(R.id.Lang2);
        l3=findViewById(R.id.Lang3);
        l4=findViewById(R.id.Lang4);
        Branch=findViewById(R.id.spinner);
        b1=findViewById(R.id.Button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myname=name.getEditText().toString();
                String myemail=email.getEditText().toString();
                String myphn=phn.getEditText().toString();
                if(myname.isEmpty()||myemail.isEmpty()||myphn.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill Details", Toast.LENGTH_SHORT).show();
                } else{
                }
                StringBuilder sb=new StringBuilder();
                sb.append(myname +"\n" + myemail +"\n" + myphn);
                Toast.makeText(MainActivity.this, "The Details are "+myname+""+myemail, Toast.LENGTH_SHORT).show();
               /* StringBuilder str=new StringBuilder();
                str.append(myname+"\n"+myemail+"\n"+myphn);
                Toast.makeText(MainActivity.this, "The Details are "+str, Toast.LENGTH_SHORT).show();*/
            }
        });
    }
}


