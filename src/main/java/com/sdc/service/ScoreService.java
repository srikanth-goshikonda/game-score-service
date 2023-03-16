package com.sdc.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdc.dto.ScoreDto;
import com.sdc.entity.Game;
import com.sdc.entity.Score;
import com.sdc.repo.GameRepository;
import com.sdc.repo.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired
	private GameRepository gameRepository;

	public boolean submitScore(ScoreDto scoreDto) {
		scoreDto.setDateSubmitted(LocalDateTime.now());
		Score scoreEntity = new Score();
		Optional<Game> findById = gameRepository.findById(scoreDto.getGameId());
		BeanUtils.copyProperties(scoreDto, scoreEntity);
		scoreEntity.setGame(findById.get());
		scoreRepository.save(scoreEntity);
		return true;
	}

}
