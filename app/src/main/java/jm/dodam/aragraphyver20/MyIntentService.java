package jm.dodam.aragraphyver20;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Bong on 2016-06-03.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(10000);
            Intent broadcastIntent = new Intent();
            broadcastIntent.putExtra("message","Hello");
            broadcastIntent.setAction("MY_ACTION");
            getBaseContext().sendBroadcast(broadcastIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
