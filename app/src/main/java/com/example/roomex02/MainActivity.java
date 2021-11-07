package com.example.roomex02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;

    private EditText mEditName, mEditAge, mEditPhoneNumber, sEditDeleteName;
    private Button mBtnAdd, mBtnCheaks, mBtnDelete;
    private TextView mTextResult;


    AlertDialog.Builder dlg;
    View deleteView;
    DialogInterface.OnClickListener _DataDeleteFucEv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditName = (EditText) findViewById(R.id.edit_Name);
        mEditAge = (EditText) findViewById(R.id.edit_age);
        mEditPhoneNumber = (EditText) findViewById(R.id.edit_PhonNumber);

        mBtnAdd = (Button) findViewById(R.id.btn_Add);
        mBtnCheaks = (Button) findViewById(R.id.btn_Check);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);

        mTextResult = (TextView) findViewById(R.id.text_result);


        // 데이터베이스 삽입
        // jiwon_db 는 db의 이름
        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "Jiwon_db")
                .fallbackToDestructiveMigration()       // 스키마(데이터베이스) 버전에 대해 변경가능
                .allowMainThreadQueries()               // Main Thread에서 DB에 Input Output가능함
                .build();

        // UserDao 인터페이스 객체 생성
        mUserDao = database.userDao();

        // 데이터 삽입
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();     // 객체 인스턴스
                user.setName(mEditName.getText().toString());                   // 이름 삽입
                user.setAge(mEditAge.getText().toString());                     // 나이 삽입
                user.setPhoneNumber(mEditPhoneNumber.getText().toString());     // 폰번호 삽입
                mUserDao.setInsertUser(user);       // 데이터 삽입
            }
        });

        // 데이터를 조회
        mBtnCheaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextResult.setText(database.userDao().getUserAll().toString());
                List<User> userList = mUserDao.getUserAll();

                /*
                for (int i = 0; i < userList.size(); i++) {
                    mTextResult.setText(userList.get(i).getId() + "\n"
                            + userList.get(i).getName() + "\n"
                            + userList.get(i).getAge() + "\n"
                            + userList.get(i).getPhoneNumber() + "\n"
                            + "________________________________________");
                }
                */      // 데이터를 조회하는 다른방법


            }
        });


        _DataDeleteFucEv = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sEditDeleteName = (EditText) deleteView.findViewById(R.id.edit_Delete);

                String _DeleteNameFind = sEditDeleteName.getText().toString();
                mUserDao.findByname(_DeleteNameFind);
            }
        };


        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("데이터 삭제");
                deleteView = (View) View.inflate(getApplicationContext(), R.layout.delete_lay, null);
                dlg.setView(deleteView);
                dlg.setPositiveButton("삭제", _DataDeleteFucEv);
                dlg.setNegativeButton("뒤로가기", null);
                dlg.show();

            }
        });



        /*
        // 데이터 삽입
        User user = new User();     //  객체 인스턴스
        user.setName("지원");
        user.setAge("21");
        user.setPhoneNumber("010-1234-5678");
        mUserDao.setInsertUser(user);

        // UserDao에 만든 데이터 조회 쿼리
        // 결과값이 list User에 저장됨
        List<User> userList = mUserDao.getUserAll();
        // 데이터 조회
        for (int i = 0; i < userList.size(); i++) {
            Log.d("Test", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhoneNumber() + "\n");
        }

//         데이터 수정
        User user2 = new User();     //  객체 인스턴스
        user2.setId(1);              // 데이터베이스의 id
        user2.setName("지원_수정");
        user2.setAge("25");
        user2.setPhoneNumber("010-1234-0000");
        mUserDao.setUpdateUser(user2);      // 데이터 수정


        // 데이터 삭제
        User user3 = new User();
        user3.setId(4);
        mUserDao.setDeleteUser(user3);
        */

    }
}