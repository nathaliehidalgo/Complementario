package com.example.complementario2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable, Parcelable {
    @SerializedName("name")

    public String name;
    @SerializedName("description")

    public String description;
    @SerializedName("Rating")

    public String rating;
    @SerializedName("episode")

    public int episode;
    @SerializedName("categorie")

    public String categorie;
    @SerializedName("studio")

    public String studio;
    @SerializedName("img")

    public String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.rating);
        dest.writeInt(this.episode);
        dest.writeString(this.categorie);
        dest.writeString(this.studio);
        dest.writeString(this.img);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.description = source.readString();
        this.rating = source.readString();
        this.episode = source.readInt();
        this.categorie = source.readString();
        this.studio = source.readString();
        this.img = source.readString();
    }

    public Anime() {
    }

    protected Anime(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.rating = in.readString();
        this.episode = in.readInt();
        this.categorie = in.readString();
        this.studio = in.readString();
        this.img = in.readString();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel source) {
            return new Anime(source);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };
}
