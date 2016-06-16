package jm.dodam.aragraphyver20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Bong on 2016-06-14.
 */
public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.ViewHolder> {
    List<FollowItem> listItems;

    public FollowAdapter(List<FollowItem> listItems) {
        this.listItems = listItems;
    }

    @Override
    public FollowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FollowAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    class ViewHolder extends  RecyclerView.ViewHolder{
        public ImageButton followingButton;
        public ViewHolder(final View itemView) {
            super(itemView);
            followingButton = (ImageButton) itemView.findViewById(R.id.followingButton);
            followingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"오류안뜬당 : "+getPosition(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
