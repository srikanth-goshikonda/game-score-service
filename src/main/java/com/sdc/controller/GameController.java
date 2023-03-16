package com.sdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdc.dto.GameDto;
import com.sdc.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping
	public ResponseEntity<GameDto> createGame(@RequestBody @Valid GameDto gameDto) {
		GameDto createdGame = gameService.createGame(gameDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
	}
}
