package com.sdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdc.dto.ScoreDto;
import com.sdc.service.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@PostMapping
	public ResponseEntity<String> submitScore(@RequestBody @Valid ScoreDto scoreDto) {

		boolean success = scoreService.submitScore(scoreDto);
		if (success) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Score submitted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Score submission failed");
		}
	}
}
