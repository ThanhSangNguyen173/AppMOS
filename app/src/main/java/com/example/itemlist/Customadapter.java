package com.example.itemlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customadapter extends BaseAdapter {
    Context context;
    ArrayList<Item> Itemarraylist;

    public Customadapter(Context context, ArrayList<Item> Itemarraylist) {
        this.context = context;
        this.Itemarraylist = Itemarraylist;
    }

    public void addlistitemadapter(ArrayList<Item> itemplus){
        Itemarraylist.addAll(itemplus);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return Itemarraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return Itemarraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.dong_listview,null);

        TextView txtTenItem = view.findViewById(R.id.txtTenItem);
        TextView txtGiaItem = view.findViewById(R.id.txtGiaItem);
        ImageView imgHinhAnh = view.findViewById(R.id.imgHinhAnh);

        Item item = Itemarraylist.get(i);
        txtTenItem.setText(item.tenitem);

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        txtGiaItem.setText(decimalFormat.format(item.giaitem)+" Đồng");
        imgHinhAnh.setImageResource(item.hinhanhitem);

        return view;
    }
}
