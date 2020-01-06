package in.blogspot.tecnopandit.tutorialsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String id;
    private String name;
    private String pin;

    // Constructor
    public Student(String id, String name, String pin){
        this.id = id;
        this.name = name;
        this.pin = pin;
    }


    // Parcelling part
    public Student(Parcel in){
        String[] data = new String[3];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.id = data[0];
        this.name = data[1];
        this.pin = data[2];
    }


    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.id,
                this.name,
                this.pin});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
