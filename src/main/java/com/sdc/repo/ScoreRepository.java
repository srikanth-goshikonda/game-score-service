package com.sdc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdc.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

	List<Score> findTop10ByGameIdOrderByScoreDesc(Long gameId);

	List<Score> findTop10ByNameAndGameIdOrderByScoreDesc(String name, Long gameId);

	Boolean existsByName(String name);
}
