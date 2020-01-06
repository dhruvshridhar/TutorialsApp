package in.blogspot.tecnopandit.tutorialsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class sujectactivity extends AppCompatActivity {
ListView lv;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    Integer[] imgid={
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
            R.drawable.engineering,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sujectactivity);
        getSupportActionBar().hide();
        lv=(ListView)findViewById(R.id.listview);
        CustomAdapter adapter=new CustomAdapter(this,itemname,imgid);
        lv.setAdapter(adapter);
        }
}

