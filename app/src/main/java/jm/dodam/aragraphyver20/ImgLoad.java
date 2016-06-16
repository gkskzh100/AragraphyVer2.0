package jm.dodam.aragraphyver20;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Bong on 2016-06-16.
 */
public class ImgLoad extends AsyncTask< String, String, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        return null;
    }
    /*LinearLayout linearLayout = null;
    List<RecyclerItem> recyclerItems = null;
    int i;
    public ImgLoad(LinearLayout linearLayout, List<RecyclerItem> recyclerItems, int i){
        this.linearLayout = linearLayout;
        this.recyclerItems = recyclerItems;
        this.i = i;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bitmap myImage = getBitmapFromURL(recyclerItems.get(i).profile);
        return false;
    }
    public Bitmap getBitmapFromURL(String imageUrl){

    }비동기 처리 다른거하고여..*/
}