package jm.dodam.aragraphyver20;

/**
 * Created by kim on 2016-06-09.
 */
public class RecyclerItem {
    int profile;
    int image;
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

    RecyclerItem(int profile, String name, String comment) {
        this.profile=profile;
        this.name=name;
        this.comment=comment;
    }
}
