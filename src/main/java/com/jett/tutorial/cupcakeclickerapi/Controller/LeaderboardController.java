package com.jett.tutorial.cupcakeclickerapi.Controller;

import java.util.List;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Service.LeaderboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LeaderboardController {
    
    @Autowired
	LeaderboardService leaderboardService;

	@GetMapping("/leaderboard")
	public List<User> getLeaderboard() {
		return leaderboardService.getLeaderboardList();
    }
    
}