package com.example.roomex02;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// 데이터베이스
// 데이터가 추가되면 버전을 바꿔주면서 관리
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    // UserDao선언
    public abstract UserDao userDao();


}
