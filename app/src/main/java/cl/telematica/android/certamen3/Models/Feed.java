package cl.telematica.android.certamen3.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by franciscocabezas on 11/18/16.
 */

public class Feed implements Parcelable {

    private String ID;
    private String title;
    private String link;
    private String author;
    private String publishedDate;
    private String content;
    private String image;
    private boolean isFavorite;

    public Feed() {

    }

    protected Feed(Parcel in) {
        ID = in.readString();
        title = in.readString();
        link = in.readString();
        author = in.readString();
        publishedDate = in.readString();
        content = in.readString();
        image = in.readString();
        isFavorite = in.readInt() == 1;
    }

    public static final Creator<Feed> CREATOR = new Creator<Feed>() {
        @Override
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        @Override
        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };

    public String getID(){ return ID; }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ID);
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeString(author);
        parcel.writeString(publishedDate);
        parcel.writeString(content);
        parcel.writeString(image);
        parcel.writeInt(isFavorite ? 1 : 0);
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String Insertar(){
        return "INSERT INTO " + FeedContract.FeedEntry.TABLE_NAME +" ("
                + FeedContract.FeedEntry.ID +", "
                + FeedContract.FeedEntry.Title +", "
                + FeedContract.FeedEntry.Link +", "
                + FeedContract.FeedEntry.Author +", "
                + FeedContract.FeedEntry.PublishedDate +", "
                + FeedContract.FeedEntry.Content +", "
                + FeedContract.FeedEntry.Image +") VALUES('"+ID+"', ' "+title+"', ' "
                +link+"', ' "+author+"', ' "+publishedDate+"', ' "+content+"', ' "+image+"');";

    }
    public String Delete(){
        return "DELETE FROM "+ FeedContract.FeedEntry.TABLE_NAME+ " WHERE "
                + FeedContract.FeedEntry.ID+"='"+ID+"';";

    }
}
