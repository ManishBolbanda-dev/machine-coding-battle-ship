package com.mb.battlefield.dao;

import java.util.HashMap;
import java.util.List;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Ship;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InMemoryShipDao implements IShipDao {
	
	private final HashMap<Long, Ship> ships;
	private Long incrementlSequence;
	private final ICoordinateDao coordinateDao;
	
	public synchronized long getNextSequence() {
		return incrementlSequence++;
	}

	@Override
	public Ship add(Ship ship) {
		
		Ship shipToBeSaved = Ship.builder()
				.id(getNextSequence())
				.playerId(ship.getPlayerId())
				.size(ship.getSize())
				.topLeftCoId(ship.getTopLeftCoId())
				.shipLabel(ship.getShipLabel())
				.build();
		ships.put(shipToBeSaved.getId(), shipToBeSaved);
		coordinateDao.updateShipIdById(shipToBeSaved.getTopLeftCoId(), shipToBeSaved.getId());
		return shipToBeSaved;
	}

	@Override
	public Ship getById(long id) {
		return ships.get(id); // todo add a builder here
	}

	@Override
	public List<Ship> getShipByPlayerId(long playerId) {
		return ships.values().stream().filter(sh -> sh.getPlayerId() == playerId).toList();
	}

	@Override
	public Coordinate getCoordinateByShipId(long shipId) {
		return coordinateDao.getByShipId(shipId);
	}
	
}
