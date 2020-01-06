package in.blogspot.tecnopandit.tutorialsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class BlankFragment2 extends Fragment{
    public interface  senddata{
        void inputdata(String input);
    }
    ImageView iv,iv1,iv2;
    Bundle bundle;
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_blank_fragment2,container,false);
        // Inflate the layout for this fragment
        iv2=rootview.findViewById(R.id.imageView10);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickview(v);
            }
        });
        iv1=rootview.findViewById(R.id.imageView9);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickview(v);
            }
        });
        iv=rootview.findViewById(R.id.imageView8);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickview(v);
            }
        });
        return rootview;
    }
    public void onclickview(View view)
    {
        iv=(ImageView) view;
        String x=iv.getTag().toString();
        bundle=new Bundle();
        bundle.putString("text",x);
        VideoListFrag frag=new VideoListFrag();
        frag.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment2,frag).commit();
        /*Toast.makeText(getContext(),x,Toast.LENGTH_SHORT).show();*/
    }


}
