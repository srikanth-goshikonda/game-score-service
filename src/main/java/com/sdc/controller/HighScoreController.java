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
@RequestMapping("/highscores")
public class HighScoreController {

	@Autowired
	private HighScoreService highScoreService;

	@GetMapping(params = "gameId")
	public ResponseEntity<List<ScoreDto>> getHighScores(@RequestParam Long gameId) {
		return ResponseEntity.ok(highScoreService.getHighScores(gameId));
	}
}
