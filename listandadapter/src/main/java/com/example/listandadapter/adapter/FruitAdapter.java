package com.example.listandadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listandadapter.R;
import com.example.listandadapter.example.Fruit;

import java.util.List;

/**
 * Created by fountian on 2017/1/1.
 *
 *    提高listview的效率的代码
 *    把已加载的布局，缓存到 convertView，可进行重用
 *    把已加载的控件，缓存到 ViewHolder， 可进行重用
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);

            viewHolder=new ViewHolder();
            viewHolder.fruitImage=(ImageView) view.findViewById(R.id.image_1);
            viewHolder.fruitName=(TextView) view.findViewById(R.id.tv_1);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.image_1);
//        TextView fruitName = (TextView) view.findViewById(R.id.tv_1);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
