package jm.dodam.aragraphyver20;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bong on 2016-06-14.
 */
public class MyBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RecyclerItem> mElements;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    MyBookHeader header;
    public MyBookAdapter(MyBookHeader header, List<RecyclerItem> elements) {
        this.header = header;
        this.mElements = elements;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headeritem_mybook, parent, false);
            return new ViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_mybook,parent,false);
            return new ViewHolder(view);
        }
    }
    private RecyclerItem getItem(int position){
        return mElements.get(position);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            holder.text.setText(mElements.get(position));
        if (holder instanceof ViewHeader){
            ViewHeader viewHeader = (ViewHeader)holder;
        }
    }

    @Override
    public int getItemCount() {
        return mElements.size()+1;
    }
    public boolean isPositionHeader(int position){
        return position == 0;
    }
    public int getItemViewType(int position){
        if (isPositionHeader(position))return TYPE_HEADER;
        return TYPE_ITEM;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
//                text = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
    public  class ViewHeader extends  RecyclerView.ViewHolder{

        public ViewHeader(View itemView) {
            super(itemView);
        }
    }

}