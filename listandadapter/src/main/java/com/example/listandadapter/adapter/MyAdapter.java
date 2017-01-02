package com.example.listandadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.listandadapter.R;
import com.example.listandadapter.example.Msg;

import java.util.List;

/**
 * Created by fountian on 2017/1/1.
 */
public class MyAdapter extends ArrayAdapter<Msg> {
    private int resourceId;

    public MyAdapter(Context context, int textViewResourceId, List<Msg> objects) {
        super(context, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.Layout_left = (LinearLayout) view.findViewById(R.id.layout_left);
            viewHolder.Layout_right = (LinearLayout) view.findViewById(R.id.layout_right);
            viewHolder.Msg_ldeft= (TextView) view.findViewById(R.id.msg_left);
            viewHolder.Msg_right= (TextView) view.findViewById(R.id.msg_right);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        if (msg.getType()==Msg.TYPE_RECEIVED){
            viewHolder.Layout_left.setVisibility(View.VISIBLE);
            viewHolder.Layout_right.setVisibility(View.GONE);
            viewHolder.Msg_ldeft.setText(msg.getContent());
        }else {
            viewHolder.Layout_left.setVisibility(View.GONE);
            viewHolder.Layout_right.setVisibility(View.VISIBLE);
            viewHolder.Msg_right.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder {
        LinearLayout Layout_left;
        LinearLayout Layout_right;
        TextView Msg_ldeft;
        TextView Msg_right;
    }
}
