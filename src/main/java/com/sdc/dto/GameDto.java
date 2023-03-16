package com.sdc.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GameDto {
	private Long id;
	@NotBlank(message = "name must not be blank")
	private String name;
	@NotBlank(message = "description must not be blank")
	private String description;
}