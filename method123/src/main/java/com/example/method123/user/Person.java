package com.example.method123.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by fountian on 2016/12/31.
 *  1.public class Person implements Serializable 整个类都序列化，效率较低
 *  2.public class Person implements Parcelable  可以自行选择需要写入的数据，效率高
 */
public class Person implements Parcelable{
    private String name;
    private String password;
//无参的构造方法
    public Person(){
        super();
    }

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    Parcelable的代码
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
    }

    public static final Parcelable.Creator<Person> CREATOR=new Creator<Person>(){

        @Override
        public Person createFromParcel(Parcel source) {
            Person person=new Person();
            person.name=source.readString();
            person.password=source.readString();
            return person;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
