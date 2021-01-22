package com.example.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class simpleData implements Parcelable {

    int number;
    String message;

    public simpleData(int num, String msg) {
        number = num;
        message = msg;
    }
    //parcel 객체에서 읽기
    public simpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    public static final Creator CREATOR = new Creator() { //creator 상수 정의

        public simpleData createFromParcel(Parcel in) {
            return new simpleData(in);//심플 데이터 객체를 호출해 parcel 객체에서 읽기
        }

        public simpleData[] newArray(int size) {

            return new simpleData[size];
        }

    };

    public int describeContents() {

        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {//parcel 객체로 쓰기
        dest.writeInt(number);
        dest.writeString(message);
    }

}
