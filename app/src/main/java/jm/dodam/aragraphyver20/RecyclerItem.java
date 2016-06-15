package jm.dodam.aragraphyver20;

/**
 * Created by kim on 2016-06-09.
 */
public class RecyclerItem {
    int profile;
    String name,comment;

    int getProfile() {
        return this.profile;
    }

    String getName() {
        return this.name;
    }

    String getComment() {
        return this.comment;
    }



    public RecyclerItem(int profile) {
        this.profile = profile;
    }

    RecyclerItem(int profile, String name, String comment) {
        this.profile=profile;
        this.name=name;
        this.comment=comment;
    }
}
