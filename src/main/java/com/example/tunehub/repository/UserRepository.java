package com.example.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entites.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByEmail(String email);

}
