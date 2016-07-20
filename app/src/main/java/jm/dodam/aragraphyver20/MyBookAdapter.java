package jm.dodam.aragraphyver20;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Bong on 2016-06-14.
 */
public class MyBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RecyclerItem> mElements;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    MyBookHeader header;
    Context context;
    Uri uri = Uri.parse("android.resource://jm.dodam.aragraphyver20/drawable/i1");


    public MyBookAdapter(MyBookHeader header, List<RecyclerItem> elements, Context context) {
        this.header = header;
        this.mElements = elements;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headeritem_mybook, parent, false);
            return new ViewHeader(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_mybook, parent, false);
            return new ViewHolder(view);
        }
    }

    private RecyclerItem getItem(int position) {
        return mElements.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final RecyclerItem item = mElements.get(position);

        if (holder instanceof ViewHeader){
            ViewHeader viewHeader = (ViewHeader)holder;
        }else if (holder instanceof ViewHolder){
            ViewHolder viewHolder =(ViewHolder)holder;
            Glide.with(context)
                    .load(item.getProfile())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.mainImage);

        }
//        requestManager.load(item.getProfile()).into(viewHolder.profile);

    }

    @Override
    public int getItemCount() {
        return mElements.size();
    }

    public boolean isPositionHeader(int position) {
        return position == 0;
    }

    public int getItemViewType(int position) {
        if (isPositionHeader(position)) return TYPE_HEADER;
        return TYPE_ITEM;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView mainImage;

        public ViewHolder(View itemView) {
            super(itemView);

            mainImage = (ImageView) itemView.findViewById(R.id.bookImage);

        }
    }

    public class ViewHeader extends RecyclerView.ViewHolder {

        public ViewHeader(View itemView) {
            super(itemView);
        }
    }

}