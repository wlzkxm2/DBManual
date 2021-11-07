package com.example.roomex02;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// 데이터를 엑세스 할수 있는 개체
@Dao
public interface UserDao {

    @Insert     // 데이터 삽입
    void setInsertUser(User user);

    @Update     // 데이터 수정
    void setUpdateUser(User user);

    @Delete     // 데이터 삭제
    void setDeleteUser(User user);

    // 조회쿼리
    // User Table의 정보를 받아오기
    @Query("SELECT * FROM User")      // 쿼리는 데이터베이스에 요청하는 명령문
    List<User> getUserAll();        // getUserAll이라는 이름으로 받아옴

    @Query("SELECT * FROM User WHERE id =:id")
    User findById(int id);

//    @Query("DELETE FROM User WHERE Name")
//    User findByname(String Name);
    @Query("DELETE FROM User WHERE name = :Name")
    void findByname(String Name);
}
