package com.mb.battlefield.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Coordinate {
	private final long id;
	private final int x;
	private final int y;
	private final long playerId;
	private final long shipId;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		id=0;
		playerId=0;
		shipId=0;
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
