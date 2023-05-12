package com.example.vizsgaremek;


import android.os.Parcel;
import android.os.Parcelable;

public class Gyakorlat implements Parcelable {
    private int gyakorlatId;
    private String name;
    private String media;
    private String description;

    public int getGyakorlatId() {
        return gyakorlatId;
    }

    public String getName() {
        return name;
    }

    public String getMedia() {
        return media;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeInt(gyakorlatId);
        dest.writeString(name);
        dest.writeString(media);
        dest.writeString(description);
    }

    public Gyakorlat(Parcel in) {
        gyakorlatId = in.readInt();
        name = in.readString();
        media = in.readString();
        description = in.readString();
    }

    public static final Parcelable.Creator<Gyakorlat> CREATOR = new Parcelable.Creator<Gyakorlat>() {
        public Gyakorlat createFromParcel(Parcel in) {
            return new Gyakorlat(in);
        }

        public Gyakorlat[] newArray(int size) {
            return new Gyakorlat[size];
        }
    };
}
