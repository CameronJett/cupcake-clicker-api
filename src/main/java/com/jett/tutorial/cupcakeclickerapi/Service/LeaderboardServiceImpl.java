package com.jett.tutorial.cupcakeclickerapi.Service;

import java.util.ArrayList;
import java.util.List;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getLeaderboardList() {
        Iterable<User> source = userRepository.findAll();
        List<User> target = new ArrayList<>();
        source.forEach(target::add);
        
        return target;
    }
    
}