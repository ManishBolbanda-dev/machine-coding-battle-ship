package com.mb.battlefield.model;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Player {
	private final long id; // auto incremented
	private final String name;
	public Player(String name) {
		this.id=0;
		this.name = name;
	}
	
}
