package com.sdc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdc.dto.ScoreDto;
import com.sdc.service.HighScoreService;

@RestController
@RequestMapping("/personalhighscores")
public class PersonalHighScoreController {
	@Autowired
	private HighScoreService scoreService;

	@GetMapping(params = { "gameId", "userName" })
	public ResponseEntity<List<ScoreDto>> getPersonalHighScores(@RequestParam Long gameId,
			@RequestParam String userName) {
		return ResponseEntity.ok(scoreService.getHighScoresOfPerson(userName, gameId));
	}

}
