package com.codecool.springbootdemo.repository;


import com.codecool.springbootdemo.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{

    List<Guest> findByNameStartingWith(String a);

}
