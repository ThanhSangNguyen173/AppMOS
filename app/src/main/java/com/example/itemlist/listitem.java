package com.example.itemlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listitem extends AppCompatActivity {
    ListView listView;
    Customadapter customadapter;
    ArrayList<Item> arrayList;
    int currentid = 0;
    View footerview;
    Boolean isloading = false;
    mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(listitem.this,teetan.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(listitem.this,teeden.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(listitem.this,hdgrey.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(listitem.this,swpgrey.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(listitem.this,hdtan.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(listitem.this,swptan.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(listitem.this,teenoel.class);
                        startActivity(intent6);
                        break;
                }
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstitem, int visibleitemcount, int totalitemcount) {
                    if(absListView.getLastVisiblePosition()==totalitemcount-1 && isloading==false){
                        isloading = true;
                        Thread thread = new ThreaData();
                        thread.start();
                    }
            }
        });
    }
    private void init(){
        arrayList.add(new Item(++currentid,"Signature Embroidery Tee",330000,R.drawable.aotan));
        arrayList.add(new Item(++currentid,"2way Vintage Tee",265000,R.drawable.aoden));
        arrayList.add(new Item(++currentid,"WNOV21 Q-Zip Hoodie Grey",580000,R.drawable.hdgrey));
        arrayList.add(new Item(++currentid,"WNOV21 Sweatpants Grey",380000,R.drawable.swpgrey));
        arrayList.add(new Item(++currentid,"WNOV21 Q-Zip Hoodie Tan",580000,R.drawable.hdtan));
        arrayList.add(new Item(++currentid,"WNOV21 Sweatpants Tan",380000,R.drawable.swptan));
        arrayList.add(new Item(++currentid,"Papainoel Tee",325000,R.drawable.aonoel));

    }
    private void anhxa() {
        listView = findViewById(R.id.listview);
        arrayList = new ArrayList<Item>();
        mHandler = new mHandler();
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.footerview,null);
        customadapter = new Customadapter(listitem.this,arrayList);
        listView.setAdapter(customadapter);
    }
    public class mHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    listView.addFooterView(footerview);
                    break;
                case 1:
                    listView.removeFooterView(footerview);
                    customadapter.addlistitemadapter((ArrayList<Item>)msg.obj);
                    isloading = false;
                    break;
            }
        }
    }
    public class ThreaData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            ArrayList<Item> mangdata = getMoreData();
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1,mangdata);
            mHandler.sendMessage(message);
        }
    }
    public ArrayList<Item> getMoreData(){
        ArrayList<Item> list = new ArrayList<>();

        return list;
    }
}