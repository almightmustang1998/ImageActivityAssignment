package edu.temple.imageactivityassignment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] imageRes;

    public ImageAdapter(Context context, ArrayList items, int[] imageRes) {
        this.context = context;
        this.items = items;
        this.imageRes = imageRes;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        if (convertView == null) {
            linearLayout = new LinearLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);

            textView.setPadding(10, 15, 15, 15);
            textView.setTextSize(22);
            linearLayout.setOrientation(linearLayout.HORIZONTAL);

            imageView.setLayoutParams(new ViewGroup.LayoutParams(120, 100));
            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;

            linearLayout.addView(textView);

        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        }

        imageView.setImageResource(imageRes[position]);
        textView.setText(items.get(position));

        return linearLayout;

    }
}
