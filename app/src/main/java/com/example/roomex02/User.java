package com.example.roomex02;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// 테이블

// 언어테이션이라는 속성
@Entity // Room에서 지원하는 데이터 모델로써 사용
public class User {
    // autoGenerate가 자동으로 아이디를 생성해줌
    // 1씩 카운트 되면서 올라감
    @PrimaryKey(autoGenerate = true)
    private int id = 0;     // 하나의 사용자에 대한 고유 ID값

    private String name;        // 사용자의 이름
    private String age;         // 사용자의 나이
    private String phoneNumber; // 사용자의 번호

    // getter & setter 가져오거나 세팅을 하기 위한 준비단계

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(" Id :").append(id);
        sb.append(" Name : ").append(name);
        sb.append(" Phone : ").append(phoneNumber);
        sb.append("\n-----------------------------------------------\n");
        return sb.toString();
    }
}
