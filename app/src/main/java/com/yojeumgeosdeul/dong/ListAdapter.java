package com.yojeumgeosdeul.dong;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ConcurrentModificationException;
import java.util.List;

public class ListAdapter extends ArrayAdapter<ChatData> {
    
    public Context context;
    public ListView listView;
    public List list;

    
    class ViewHolder{
        public TextView text1;
    }
    
    
    public ListAdapter(Context context,List<ChatData>list,ListView listView){
        super(context,0,list);
        
        this.context=context;
        this.list = list;
        this.listView =listView;
    
    }
}
