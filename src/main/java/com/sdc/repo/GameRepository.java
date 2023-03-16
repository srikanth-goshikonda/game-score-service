package com.sdc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdc.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
