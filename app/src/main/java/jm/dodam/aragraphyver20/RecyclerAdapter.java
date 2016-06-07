package jm.dodam.aragraphyver20;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Bong on 2016-05-31.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    MyBookHeader myBookHeader;
    List<RecyclerItem> items;

    public RecyclerAdapter(MyBookHeader myBookHeader, List<RecyclerItem> items) {
        this.myBookHeader = myBookHeader;
        this.items = items;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.headeritem_mybook, parent, false);
            return new ViewHeader(v);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_mybook, parent, false);
            return new ViewHolder(v);
        }
        throw new RuntimeException("thare is no type matches the type "+viewType+" + make sure your using types correctly");
    }
    public RecyclerItem getItem(int position){
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHeader){
            ViewHeader viewHeader = (ViewHeader)holder;
            viewHeader.headerText.setText(myBookHeader.getHeader());
        }else if(holder instanceof ViewHolder){

            RecyclerItem currentItem = getItem(position-1);
            ViewHolder viewHolder = (ViewHolder)holder;
            viewHolder.image.setBackgroundResource(currentItem.getImage());
        }


    }

    @Override
    public int getItemCount() {
        return this.items.size()+1;
    }
    public int getItemViewType(int position){
        if (isPositionHeader(position))return TYPE_HEADER;
        return TYPE_ITEM;
    }
    private boolean isPositionHeader(int position){
        return position == 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.bookImage);
        }
    }
    public class ViewHeader extends RecyclerView.ViewHolder{
        TextView headerText;
        public ViewHeader(View itemView) {
            super(itemView);
            headerText = (TextView)itemView.findViewById(R.id.headerText);
        }
    }
}
