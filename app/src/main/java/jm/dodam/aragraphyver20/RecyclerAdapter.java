package jm.dodam.aragraphyver20;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kim on 2016-06-09.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<RecyclerItem> items;
    int item_layout;

    public RecyclerAdapter(Context context, List<RecyclerItem> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        final RecyclerItem item = items.get(position);
//        Drawable drawable = context.getResources().getDrawable(item.getProfile());
//        holder.profile.setBackground(drawable);
        holder.profile.setImageResource(item.getProfile());
        holder.name.setText(item.getName());
        holder.comment.setText(item.getComment());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView name;
        TextView comment;

        public ViewHolder (View itemView) {
            super(itemView);
            profile=(de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.itemRecyclerProfileImage);
            name=(TextView) itemView.findViewById(R.id.itemRecyclerNameText);
            comment=(TextView) itemView.findViewById(R.id.itemRecyclerCommentText);
        }
    }
}
