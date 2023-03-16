package com.sdc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdc.dto.GameDto;
import com.sdc.entity.Game;
import com.sdc.repo.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public GameDto createGame(GameDto gameDto) {
		Game gameEntity = new Game();
		BeanUtils.copyProperties(gameDto, gameEntity);
		Game game = gameRepository.save(gameEntity);
		gameDto = new GameDto();
		BeanUtils.copyProperties(game, gameDto);
		return gameDto;
	}
}
