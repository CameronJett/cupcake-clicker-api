package com.jett.tutorial.cupcakeclickerapi.Repository;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}