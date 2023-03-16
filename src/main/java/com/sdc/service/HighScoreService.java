package com.sdc.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdc.dto.ScoreDto;
import com.sdc.entity.Score;
import com.sdc.globalexception.GameIdNotFoundException;
import com.sdc.repo.GameRepository;
import com.sdc.repo.ScoreRepository;

@Service
public class HighScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private GameRepository gameRepository;

	public List<ScoreDto> getHighScores(Long gameId) {
		if (!gameRepository.existsById(gameId)) {
			throw new GameIdNotFoundException(String.format("Then given game id %s not found", gameId));
		}
		List<Score> scores = scoreRepository.findTop10ByGameIdOrderByScoreDesc(gameId);
		return scores.stream().map(x -> {
			ScoreDto scoreDto = new ScoreDto();
			BeanUtils.copyProperties(x, scoreDto);
			return scoreDto;
		}).toList();
	}

	public List<ScoreDto> getHighScoresOfPerson(String userName, Long gameId) {
		if (!gameRepository.existsById(gameId)) {
			throw new GameIdNotFoundException(String.format("Then given game id %s not found", gameId));
		}
		if (!scoreRepository.existsByName(userName)) {
			throw new GameIdNotFoundException(String.format("Then given username %s not found", userName));
		}
		List<Score> scores = scoreRepository.findTop10ByNameAndGameIdOrderByScoreDesc(userName, gameId);
		return scores.stream().map(x -> {
			ScoreDto scoreDto = new ScoreDto();
			BeanUtils.copyProperties(x, scoreDto);
			return scoreDto;
		}).toList();
	}
}
