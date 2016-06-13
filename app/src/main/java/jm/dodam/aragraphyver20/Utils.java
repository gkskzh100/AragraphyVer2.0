package jm.dodam.aragraphyver20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jm.dodam.aragraphyver20.core.StikkyHeaderBuilder;

/**
 * Created by Bong on 2016-06-07.
 */
public class Utils {
    private static final int COUNT_ITEMS = 100;


    public  static void populateRecyclerView(RecyclerView recyclerview){
        List<String> elements = new ArrayList<>(COUNT_ITEMS);
        for (int i = 0;i<COUNT_ITEMS;i++){
            elements.add("row "+i);

        }
        SimpleRecyclerAdapter recyclerAdapter = new SimpleRecyclerAdapter(recyclerview.getContext(),elements);
        recyclerview.setAdapter(recyclerAdapter);
    }
    private static class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>{
        private final Context mContext;
        protected  final  List<String> mElements;
        public SimpleRecyclerAdapter(Context context, List<String> elements) {
            mContext = context;
            mElements = elements;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(mElements.get(position));
        }
        @Override
        public int getItemCount() {
            return mElements.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView text;
            public ViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
