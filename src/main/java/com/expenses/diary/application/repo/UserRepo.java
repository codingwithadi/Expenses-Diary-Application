package com.expenses.diary.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.diary.application.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
