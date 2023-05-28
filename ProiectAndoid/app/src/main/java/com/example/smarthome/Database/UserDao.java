package com.example.smarthome.Database;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);
    @Query("SELECT * FROM users WHERE userId = (:userId) AND password = (:password)")
    UserEntity login (String userId, String password);

    @Query("SELECT * FROM users WHERE userId = :userId")
    UserEntity getUserById(String userId);



}
