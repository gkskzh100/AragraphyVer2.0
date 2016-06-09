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

/**
 * Created by Bong on 2016-05-31.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    MyBookHeader myBookHeader;
    List<RecyclerItem> items;

    public RecyclerAdapter(MyBookHeader myBookHeader, List<RecyclerItem> items) {
        this.myBookHeader = myBookHeader;
        this.items = items;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_mybook, parent, false);
        return new ViewHolder(v);
    }
    public RecyclerItem getItem(int position){
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            RecyclerItem currentItem = getItem(position);
            ViewHolder viewHolder = (ViewHolder)holder;
            viewHolder.image.setBackgroundResource(currentItem.getImage());

    }

    @Override
    public int getItemCount() {

        return this.items.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.bookImage);
        }
    }
}
