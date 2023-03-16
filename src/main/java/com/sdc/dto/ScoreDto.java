package com.sdc.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ScoreDto {
	private Long id;
	private Long gameId;
	@NotBlank(message = "name must not be blank")
	private String name;
	@Min(message = "score should be minimun of 0 | negative score not allowed", value = 0)
	private Integer score;
	private LocalDateTime dateSubmitted;
// constructors, getters, and setters
}