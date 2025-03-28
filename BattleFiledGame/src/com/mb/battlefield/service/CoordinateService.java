package com.mb.battlefield.service;

import java.util.List;

import com.mb.battlefield.dao.ICoordinateDao;
import com.mb.battlefield.model.Coordinate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoordinateService implements ICoordinateService {

	private final ICoordinateDao coordinateDao;
	
	@Override
	public Coordinate add(int x, int y) {
		return coordinateDao.add(new Coordinate(x, y));
	}

	@Override
	public Coordinate getByShipId(long shipId) {
		
		return coordinateDao.getByShipId(shipId);
	}

	@Override
	public List<Coordinate> getByPlayerId(long playerId) {
		return coordinateDao.getByPlayerId(playerId);
	}

	@Override
	public Coordinate getByXAndYAndPlayerId(int x, int y, long playerId) {
		
		return coordinateDao.getByXAndYAndPlayerId(x, y, playerId);
	}

	@Override
	public Coordinate addDestroyedCo(int x, int y, long playerId) {
		return coordinateDao.add(Coordinate.builder()
				.x(x)
				.y(y)
				.playerId(playerId)
				.build());
		
	}
	

}
