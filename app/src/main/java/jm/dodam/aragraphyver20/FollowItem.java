package jm.dodam.aragraphyver20;

/**
 * Created by Bong on 2016-06-14.
 */
public class FollowItem {
    int profile;
    String name;
    boolean follow;

    public FollowItem(int profile){
        this.profile = profile;
    }
    public FollowItem(int profile, String name){
        this.profile = profile;
        this.name = name;
    }
    public FollowItem(int profile, String name, boolean follow){
        this.profile = profile;
        this.name = name;
        this.follow = follow;

    }
}
