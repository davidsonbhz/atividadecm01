package cm.ufop.br.atividade01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by George on 03/04/2017.
 */

public class Student implements Parcelable {

    public static final int HAPPY = 0;
    public static final int SAD = 1;

    public int id;
    public String name, phone;
    public String course;
    public int period;
    public double coefficient;

    public Student(int id, String name, String course, int period, double coefficient, String phone) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.period = period;
        this.coefficient = coefficient;
        this.phone = phone;
    }

    public int getImage() {
        if(coefficient >= 7) {
            return R.drawable.happy;
        } else {
            return R.drawable.sad;
        }
    }



    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in.readInt(), in.readString(), in.readString(), in.readInt(), in.readDouble(), in.readString());
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(course);
        dest.writeInt(period);
        dest.writeDouble(coefficient);
        dest.writeString(phone);
    }

}
