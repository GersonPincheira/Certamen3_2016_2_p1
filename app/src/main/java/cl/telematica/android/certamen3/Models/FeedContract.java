package cl.telematica.android.certamen3.Models;

import android.provider.BaseColumns;

/**
 * Created by gerson on 18-11-16.
 */

public class FeedContract {

    public static abstract class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME ="Feeds";

            public static final String Title= "title";
            public static final String Link = "link";
            public static final String Author = "author";
            public static final String PublishedDate = "publishedDate";
            public static final String Content = "content";
            public static final String Image = "image";
        }


}
