package in.blogspot.tecnopandit.tutorialsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    EditText userid, password,regusername,reguserid,regpin;
    TextView reqmsg;
    SqlHelperClass db;
    String user;int pin;
    Button login,register,userregister,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);
        login=(Button)findViewById(R.id.loginbutton);
        reqmsg=(TextView)findViewById(R.id.textView2);
        register=(Button)findViewById(R.id.register);
        regusername=(EditText)findViewById(R.id.entername);
        reguserid=(EditText)findViewById(R.id.enterid);
        userregister=(Button)findViewById(R.id.button);
        back=(Button)findViewById(R.id.back);
        regpin=(EditText)findViewById(R.id.enterpin);
        db = new SqlHelperClass(this);
        getSupportActionBar().hide();
    }

    public void login(View view) {
        user = userid.getText().toString();
        pin = Integer.parseInt(password.getText().toString());
        HashMap<String, Integer> hashMap = db.verify();
        Iterator<HashMap.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> basemap = iterator.next();
            String dbuser = basemap.getKey();
            int dbpass = Integer.parseInt(basemap.getValue().toString());
            Log.i("Values: ",dbuser+" "+dbpass);

            if (dbpass==pin&&dbuser.equals(user)) {
                Intent intent = new Intent(this, CoursewithNav.class);
                Bundle b= new Bundle();
                b.putString("username",dbuser);
                intent.putExtras(b);
                startActivity(intent);
                Toast.makeText(this, "Welcome back @" + dbuser, Toast.LENGTH_SHORT).show();
                break;
            } else {
                Toast.makeText(this, "Wrong Username or PIN", Toast.LENGTH_SHORT).show();
            }
        }}


    public void register1(View view) {
        userid.animate().alpha(0).setDuration(500);
        userid.setEnabled(false);
        password.animate().alpha(0).setDuration(500);
        password.setEnabled(false);
        login.animate().alpha(0).setDuration(500);
        login.setEnabled(false);
        password.setEnabled(false);
        reqmsg.animate().alpha(0).setDuration(500);
        register.animate().alpha(0).setDuration(500);
        regusername.setEnabled(true);
        reguserid.setEnabled(true);
        regpin.setEnabled(true);
        userregister.setEnabled(true);
        regpin.animate().alpha(1).setDuration(500);
        reguserid.animate().alpha(1).setDuration(500);
        regusername.animate().alpha(1).setDuration(500);
        userregister.animate().alpha(1).setDuration(500);
        back.animate().alpha(1).setDuration(500);
        back.setEnabled(true);

    }
    public void registeruser(View view)
    {
        HashMap<String, Integer> hashMap = db.verify();
        Iterator<HashMap.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        boolean isdatapresent=false;
        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> basemap = iterator.next();
            String dbuser = basemap.getKey();
            int dbpass = Integer.parseInt(basemap.getValue().toString());
            Log.i("users ",dbuser+dbpass);
            if (dbpass==Integer.parseInt(regpin.getText().toString())&&dbuser.equals(reguserid.getText().toString())) {
                isdatapresent=true;
            }
            else {

            }
        }
        if (isdatapresent==true)
        {
            Toast.makeText(this,"User is already registerd!",Toast.LENGTH_SHORT).show();
        }
        else
        {
           Long x= db.register(regusername.getText().toString(),reguserid.getText().toString(),Integer.parseInt(regpin.getText().toString()));
           if (x==-1)
           {
               Toast.makeText(this,"An Error Occured",Toast.LENGTH_SHORT).show();
           }
           else
               Toast.makeText(this,"Registration Successful!",Toast.LENGTH_SHORT).show();
           userid.animate().alpha(1).setDuration(500);
            userid.setEnabled(true);
            password.animate().alpha(1).setDuration(500);
            login.animate().alpha(1).setDuration(500);
            login.setEnabled(true);
            password.setEnabled(true);
            reqmsg.animate().alpha(1).setDuration(500);
            register.animate().alpha(1).setDuration(500);
            regusername.setEnabled(false);
            reguserid.setEnabled(false);
            regpin.setEnabled(false);
            userregister.setEnabled(false);
            regpin.animate().alpha(0).setDuration(500);
            reguserid.animate().alpha(0).setDuration(500);
            regusername.animate().alpha(0).setDuration(500);
            userregister.animate().alpha(0).setDuration(500);
            back.animate().alpha(0).setDuration(500);
            back.setEnabled(false);
        }
    }
    public void back(View view)
    {
        userid.animate().alpha(1).setDuration(500);
        userid.setEnabled(true);
        password.animate().alpha(1).setDuration(500);
        login.animate().alpha(1).setDuration(500);
        login.setEnabled(true);
        password.setEnabled(true);
        reqmsg.animate().alpha(1).setDuration(500);
        register.animate().alpha(1).setDuration(500);
        regusername.setEnabled(false);
        reguserid.setEnabled(false);
        regpin.setEnabled(false);
        userregister.setEnabled(false);
        regpin.animate().alpha(0).setDuration(500);
        reguserid.animate().alpha(0).setDuration(500);
        regusername.animate().alpha(0).setDuration(500);
        userregister.animate().alpha(0).setDuration(500);
        back.animate().alpha(0).setDuration(500);
        back.setEnabled(false);

    }

}
