package com.manav.ncu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manav.ncu.models.User;

@Repository
public interface Dao extends CrudRepository<User, Integer> {
List<User> findByUsername(String username);

}
