package jm.dodam.aragraphyver20;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        startActivity(new Intent(this, SplashActivity.class));

        ViewPager viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.mainTabBar);
        tabStrip.setViewPager(viewPager);


    }

    private void init() {
//        setListener();
        setHideStatusBar();
    }

    private void setHideStatusBar() {
        if (Build.VERSION.SDK_INT >= 19) {      //Kitkat 이상 상태바 투명하게 만들기 //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //TODO : http://stackoverflow.com/questions/19746943/why-cant-we-use-a-translucent-system-bars-with-and-actionbar
    }


//    private void setListener() {
//
//    }


}
