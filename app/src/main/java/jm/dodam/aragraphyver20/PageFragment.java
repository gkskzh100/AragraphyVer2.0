package jm.dodam.aragraphyver20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jm.dodam.aragraphyver20.core.StikkyHeaderBuilder;

public class PageFragment extends Fragment {
    private int likeCnt=0;
    private int followCnt=0;

    public static final String ARG_PAGE = "ARG_PAGE";
    private ListView mListView;
    private int pageNum;

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
                            timeLineFollowBtn.setImageResource(R.drawable.following_btn);
                            followCnt++;
                        } else if(followCnt==1) {
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
                view = inflater.inflate(R.layout.fragment_parallax, container, false);
                mListView = (ListView) view.findViewById(R.id.listview);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (pageNum == 2) {
            StikkyHeaderBuilder.stickTo(mListView)
                    .setHeader(R.id.header, (ViewGroup) getView())
                    .minHeightHeader(850)//헤더길이설정
                    .build();
            Utils.populateListView(mListView);
        }
    }
}
