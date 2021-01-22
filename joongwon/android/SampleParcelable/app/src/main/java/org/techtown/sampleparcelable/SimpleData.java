package org.techtown.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;


    public SimpleData(int num, String msg) {
        this.number = num;
        this.message = msg;
    }

    public SimpleData(Parcel src) {
        this.number = src.readInt();
        this.message = src.readString();
    }

    // CREATOR 상수 객체 생성
    public static final Creator CREATOR = new Creator() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);  // SimpleData 생성자를 호출해 Parcel 객체에서 읽기
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // Parcel 객체로 쓰기
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
