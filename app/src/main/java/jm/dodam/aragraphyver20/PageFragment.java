package jm.dodam.aragraphyver20;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PageFragment extends Fragment {
    private int likeCnt = 0;
    private int followCnt = 0;

    public static final String ARG_PAGE = "ARG_PAGE";
    private RecyclerView recyclerView_mybook, recyclerView_fallow;
    private int pageNum;

    private ImageButton timeLineLikeBtn;
    private TextView timeLineLikeText;
    private Button timeLineWriteBtn;
    private Button timeLineCommentBtn;
    private TextView timeLineCommentText;
    private ImageButton timeLineFollowBtn;
    private RecyclerView timeLineCommentRecyclerView;

    private BottomSheetBehavior timeLineBottomSheetBehavior;

    private int timeLineLikeNum = 193;

    private List<RecyclerItem> bookitems = new ArrayList<>();
    private List<FollowItem> followItems = new ArrayList<>();

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
        View frontView = inflater.inflate(R.layout.activity_main, container, false);
        LinearLayout linearLayout = (LinearLayout) frontView.findViewById(R.id.menuLayout);
        linearLayout.bringToFront();
        switch (pageNum) {

            case 1:
                view = inflater.inflate(R.layout.fragment_timeline, container, false);

                timeLineLikeBtn = (ImageButton) view.findViewById(R.id.timeLineLikeBtn);
                timeLineLikeText = (TextView) view.findViewById(R.id.timeLineLikeText);
                timeLineWriteBtn = (Button) view.findViewById(R.id.timeLineWriteBtn);
                timeLineCommentBtn = (Button) view.findViewById(R.id.timeLineCommentBtn);
                timeLineCommentText = (TextView) view.findViewById(R.id.timeLineCommentText);
                timeLineFollowBtn = (ImageButton) view.findViewById(R.id.timeLineFollowBtn);
                timeLineCommentRecyclerView = (RecyclerView) view.findViewById(R.id.timeLineCommentRecyclerView);

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                timeLineCommentRecyclerView.setHasFixedSize(true);
                timeLineCommentRecyclerView.setLayoutManager(layoutManager);

                List<RecyclerItem> items = new ArrayList<>();
                RecyclerItem[] item = new RecyclerItem[2];
                item[0] = new RecyclerItem(R.drawable.view3, "araGraphy0608", "commentCommentComment");
                item[1] = new RecyclerItem(R.drawable.aragraphy_main2, "araGraphy0609", "comment?");
                for (int i = 0; i < 2; i++) items.add(item[i]);


                timeLineLikeText.setText(Integer.toString(timeLineLikeNum));

                timeLineLikeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (likeCnt == 0) {
                            timeLineLikeBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.select_like_btn));
                            timeLineLikeNum++;
                            likeCnt++;
                            timeLineLikeText.setText(Integer.toString(timeLineLikeNum));
                        } else if (likeCnt == 1) {
                            timeLineLikeBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.like_btn));
                            timeLineLikeNum--;
                            likeCnt = 0;
                            timeLineLikeText.setText(Integer.toString(timeLineLikeNum));
                        }
                    }
                });
                timeLineWriteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), WriteActivity.class);
                        startActivity(intent);
                    }
                });

                timeLineFollowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (followCnt == 0) {
                            timeLineFollowBtn.setImageResource(R.drawable.following_btn);
                            followCnt++;
                        } else if (followCnt == 1) {
                            timeLineFollowBtn.setImageResource(R.drawable.follow_btn);
                            followCnt = 0;
                        }
                    }
                });

                View bottomSheet = view.findViewById(R.id.timeLineBottom_sheet);
                timeLineBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
                timeLineCommentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timeLineBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });

                break;
            case 2:
                view = inflater.inflate(R.layout.fragment_mybook, container, false);
                recyclerView_mybook = (RecyclerView) view.findViewById(R.id.mybookList);
                recyclerView_mybook.setHasFixedSize(true);
                recyclerView_mybook.setLayoutManager(new LinearLayoutManager(getActivity()));
                MyBookAdapter myBookAdapter = new MyBookAdapter(getHeader(), getListItems());
                recyclerView_mybook.setAdapter(myBookAdapter);
                break;
            case 3:
                view = inflater.inflate(R.layout.fragment_fallowing, container, false);
                recyclerView_fallow = (RecyclerView) view.findViewById(R.id.fallowList);
                recyclerView_fallow.setHasFixedSize(true);
                recyclerView_fallow.setLayoutManager(new LinearLayoutManager(getActivity()));
                FollowAdapter followAdapter = new FollowAdapter(getFollowItems());
                recyclerView_fallow.setAdapter(followAdapter);
                break;
            case 4:
                view = inflater.inflate(R.layout.fragment_page, container, false);
                break;
        }

        return view;
    }

    public MyBookHeader getHeader() {
        MyBookHeader header = new MyBookHeader("헤더입니다");
        return header;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public List<RecyclerItem> getListItems() {
        RecyclerItem bookitem[] = new RecyclerItem[10];
        for (int i = 0; i < 10; i++) {
            bookitem[i] = new RecyclerItem(R.drawable.i2);
            bookitems.add(bookitem[i]);
        }

        return bookitems;
    }
    public List<FollowItem> getFollowItems() {
        FollowItem followitem[] = new FollowItem[10];
        for (int i = 0; i < 10; i++) {
            followitem[i] = new FollowItem(R.drawable.i2);
            followItems.add(followitem[i]);
        }

        return followItems;
    }

}
