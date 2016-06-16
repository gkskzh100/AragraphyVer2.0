package jm.dodam.aragraphyver20;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class WriteActivity extends Activity {

    private int[] background = {R.drawable.i1, R.drawable.i2, R.drawable.view3, R.drawable.newbackgroud, R.drawable.view4};
    private int temp = 0;

    private ImageButton writeBackBtn;
    private ImageButton writeUploadBtn;
    private EditText writeCalEdit;
    private EditText writeTalkEdit;
    private ImageButton writeBackgroundBtn;
    private EditText writeHashTagEdit;

    private LinearLayout writeCalBackLayout;
    private LinearLayout writeTalkBackLayout;
    private LinearLayout writeBackgroundLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        init();

        writeCalEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력하기 전에
                Typeface type = Typeface.createFromAsset(getAssets(), "fonts/dxSenal.ttf");
                writeCalEdit.setTypeface(type);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력되는 텍스트에 변화가 있을때
                String string = s.toString();

                if (string.length() > 0) {
                    writeCalEdit.setTextSize(30);
                }
                if (string.length() > 12) {
                    writeCalEdit.setTextSize(25);
                }
//                else if (string.length() > 18) {
//                    writeCalEdit.setTextSize(18);
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력이 끝났을때

                String string = s.toString();
                if (string.length() == 0) {
                    int backColor = getResources().getColor(R.color.colorBackground);
                    writeCalBackLayout.setBackgroundColor(backColor);
                    writeCalEdit.setTypeface(Typeface.SANS_SERIF);
                    writeCalEdit.setTextSize(18);
                } else if (string.length() > 0) {
                    writeCalBackLayout.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        writeTalkEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력 전
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력 하는 중
            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력 후
                String string = s.toString();
                if (string.length() == 0) {
                    int backColor = getResources().getColor(R.color.colorBackground);
                    writeTalkBackLayout.setBackgroundColor(backColor);
                } else if (string.length() >0){
                    writeTalkBackLayout.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
        writeHashTagEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력 전
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력 하는 중
            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력 후
            }
        });
    }

    private void init() {
        writeBackBtn = (ImageButton) findViewById(R.id.writeBackBtn);
        writeUploadBtn = (ImageButton) findViewById(R.id.writeUploadBtn);
        writeCalEdit = (EditText) findViewById(R.id.writeCalEdit);
        writeTalkEdit = (EditText) findViewById(R.id.writeTalkEdit);
        writeBackgroundBtn = (ImageButton) findViewById(R.id.writeBackgroundBtn);
        writeHashTagEdit = (EditText) findViewById(R.id.writeHashTagEdit);
        writeCalBackLayout = (LinearLayout) findViewById(R.id.writeCalBackLayout);
        writeBackgroundLayout = (LinearLayout) findViewById(R.id.writeBackgroundLayout);
        writeTalkBackLayout = (LinearLayout) findViewById(R.id.writeTalkBackLayout);
        setHideStatusBar();
        setListener();
    }

    private void setListener() {

        writeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        writeBackgroundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (int) (Math.random() * 5);
                int res = background[index];

                for (int i = 0; i <= 2; i++) {   //랜덤숫자 비중복
                    if (index == temp) {
                        index = (int) (Math.random() * 5);
                        res = background[index];
                        temp = index;
                    } else break;
                }
                writeBackgroundLayout.setBackgroundResource(res);
            }
        });

    }

    private void setHideStatusBar() {
        if (Build.VERSION.SDK_INT >= 19) {      //Kitkat 이상 상태바 투명하게 만들기 //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //TODO : http://stackoverflow.com/questions/19746943/why-cant-we-use-a-translucent-system-bars-with-and-actionbar
    }
}
