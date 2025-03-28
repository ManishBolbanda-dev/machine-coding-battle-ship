package com.mb.battlefield.service;

import java.util.List;

import com.mb.battlefield.model.Coordinate;

public interface ICoordinateService {
	
	Coordinate add(int x, int y);
	Coordinate getByShipId(long shipId);
	List<Coordinate> getByPlayerId(long playerId);
	Coordinate getByXAndYAndPlayerId(int x, int y, long playerId);
	Coordinate addDestroyedCo(int x, int y, long playerId);

}
