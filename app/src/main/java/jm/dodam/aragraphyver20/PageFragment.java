package jm.dodam.aragraphyver20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    private int likeCnt=0;
    private int followCnt=0;

    public static final String ARG_PAGE = "ARG_PAGE";
    private RecyclerView recyclerView;
    private int pageNum;
    private List<RecyclerItem> items = new ArrayList<>();
    private RecyclerItem item[] = new RecyclerItem[10];

    private ImageButton timeLineLikeBtn;
    private TextView timeLineLikeText;
    private Button timeLineWriteBtn;
    private Button timeLineCommentBtn;
    private TextView timeLineCommentText;
    private ImageButton timeLineFollowBtn;

    private BottomSheetBehavior timeLineBottomSheetBehavior;

    private int timeLineLikeNum = 193;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNum = getArguments().getInt(ARG_PAGE);

        for (int i = 0; i < 10; i++) {
            item[i] = new RecyclerItem(R.drawable.i2);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;

        switch (pageNum) {
            case 1:
                view = inflater.inflate(R.layout.fragment_timeline, container, false);

                timeLineLikeBtn = (ImageButton) view.findViewById(R.id.timeLineLikeBtn);
                timeLineLikeText = (TextView) view.findViewById(R.id.timeLineLikeText);
                timeLineWriteBtn = (Button) view.findViewById(R.id.timeLineWriteBtn);
                timeLineCommentBtn = (Button) view.findViewById(R.id.timeLineCommentBtn);
                timeLineCommentText = (TextView) view.findViewById(R.id.timeLineCommentText);
                timeLineFollowBtn = (ImageButton) view.findViewById(R.id.timeLineFollowBtn);

                timeLineLikeText.setText(Integer.toString(timeLineLikeNum));

                timeLineLikeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(likeCnt ==0) {
                            timeLineLikeBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.select_like_btn));
                            timeLineLikeNum++;
                            likeCnt++;
                            timeLineLikeText.setText(Integer.toString(timeLineLikeNum));
                        } else if(likeCnt ==1) {
                            timeLineLikeBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.like_btn));
                            timeLineLikeNum--;
                            likeCnt =0;
                            timeLineLikeText.setText(Integer.toString(timeLineLikeNum));
                        }
                    }
                });
                timeLineWriteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(),WriteActivity.class);
                        startActivity(intent);
                    }
                });

                timeLineFollowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(followCnt==0) {
//                            timeLineFollowBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.following_btn));
                            timeLineFollowBtn.setImageResource(R.drawable.following_btn);
                            followCnt++;
                        } else if(followCnt==1) {
//                            timeLineFollowBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.follow_btn));
                            timeLineFollowBtn.setImageResource(R.drawable.follow_btn);
                            followCnt=0;
                        }
                    }
                });

                View bottomSheet = view.findViewById(R.id.timeLineBottom_sheet);
                timeLineBottomSheetBehavior=BottomSheetBehavior.from(bottomSheet);
                timeLineCommentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timeLineBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });

                break;
            case 2:
                view = inflater.inflate(R.layout.fragment_mybook, container, false);
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                for (int i = 0; i < 10; i++) {
                    items.add(item[i]);
                }
                recyclerView.setAdapter(new RecyclerAdapter(getHeader(), items));
                break;
            case 3:
                view = inflater.inflate(R.layout.fragment_page, container, false);
                break;
            case 4:
                view = inflater.inflate(R.layout.fragment_page, container, false);
                break;
        }

        return view;
    }

    public MyBookHeader getHeader() {
        MyBookHeader header = new MyBookHeader("I'm header");
        return header;
    }

}
