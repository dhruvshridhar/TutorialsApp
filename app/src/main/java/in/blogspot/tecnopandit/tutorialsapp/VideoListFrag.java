package in.blogspot.tecnopandit.tutorialsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class VideoListFrag extends Fragment {
    Bundle b;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_video_list,container,false);
        b=this.getArguments();
        String y=b.getString("text");
        Toast.makeText(getContext(),y,Toast.LENGTH_SHORT).show();
        tv=view.findViewById(R.id.subjectvids);
        tv.setText(y);
        return view;
    }

}
