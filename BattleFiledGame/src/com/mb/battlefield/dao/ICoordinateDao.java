package com.mb.battlefield.dao;

import java.util.List;

import com.mb.battlefield.model.Coordinate;

public interface ICoordinateDao {
	Coordinate add(Coordinate coordinate);
	Coordinate updateShipIdById(long id, long shipId);
	Coordinate getById(long id);
	List<Coordinate> getByPlayerId(long playerId);
	Coordinate getByShipId(long shipId);
	Coordinate getByXAndYAndPlayerId(int x, int y, long playerId);
	
}
