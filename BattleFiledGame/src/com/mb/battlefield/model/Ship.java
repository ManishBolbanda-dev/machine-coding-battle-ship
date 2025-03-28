package com.mb.battlefield.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Ship  {
	
	private final long id; // Auto Incremented
	private final long playerId;
	private final long topLeftCoId; // one-to-one
	private final int size;
	private final String shipLabel;
	public Ship(long playerId, long topLeftCoId, int size, String shipLabel) {
		this.id=0l;
		this.playerId = playerId;
		this.topLeftCoId = topLeftCoId;
		this.size = size;
		this.shipLabel = shipLabel;
	}
	
	
}
