package jm.dodam.aragraphyver20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Bong on 2016-06-07.
 */
public class PinnerHeaderAdapter extends SectionedBaseAdapter {
    @Override
    public Object getItem(int section, int position) {
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        return 0;
    }

    @Override
    public int getSectionCount() {
        return 1;
    }

    @Override
    public int getCountForSection(int section) {
        return 5;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflater.inflate(R.layout.headeritem_mybook, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        ((TextView)layout.findViewById(R.id.headerText)).setText("Section");
        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflater.inflate(R.layout.headeritem_mybook, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        ((TextView)layout.findViewById(R.id.headerText)).setText("Header for section");
        return layout;
    }
}
