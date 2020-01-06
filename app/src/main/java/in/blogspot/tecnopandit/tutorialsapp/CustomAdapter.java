package in.blogspot.tecnopandit.tutorialsapp;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Activity mContext;
    private String[]  Title;
    private Integer[] imge;

    public CustomAdapter(Activity context, String[] text1,Integer[] imageIds) {
        mContext = context;
        Title = text1;
        imge = imageIds;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.length;
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View row;
        row = inflater.inflate(R.layout.listlayout,null,true);
        TextView title;
        ImageView i1;
        i1 = (ImageView) row.findViewById(R.id.listiv);
        title = (TextView) row.findViewById(R.id.listtext);
        title.setText(Title[position]);
        i1.setImageResource(imge[position]);

        return (row);
    }
}