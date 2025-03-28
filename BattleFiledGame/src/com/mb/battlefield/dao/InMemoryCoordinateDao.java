package com.mb.battlefield.dao;

import java.util.List;
import java.util.Map;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InMemoryCoordinateDao implements ICoordinateDao{

	private final Map<Long, Coordinate> coOrdinates; 
	private Long incrementlSequence;
	
	public synchronized long getNextSequence() {
		return incrementlSequence++;
	}
	
	@Override
	public Coordinate add(Coordinate coordinate) {
		Coordinate co = Coordinate.builder()
				.id(getNextSequence())
				.x(coordinate.getX())
				.y(coordinate.getY())
				.playerId(coordinate.getPlayerId())
				.build();
		coOrdinates.put(co.getId(), co);
		return co;
	}

	@Override
	public Coordinate getById(long id) {
		return coOrdinates.get(id);
	}

	@Override
	public List<Coordinate> getByPlayerId(long playerId) {
		return coOrdinates.values().stream().filter(co -> co.getPlayerId() == playerId).toList();
	}

	@Override
	public Coordinate getByShipId(long shipId) {
		return coOrdinates.values().stream()
				.filter(co -> co.getShipId() == shipId)
				.findFirst()
				.orElse(null);

	}

	@Override
	public Coordinate updateShipIdById(long id, long shipId) {
		Coordinate coordinate = coOrdinates.get(id);
		Coordinate co = Coordinate.builder()
				.id(coordinate.getId())
				.x(coordinate.getX())
				.y(coordinate.getY())
				.shipId(shipId)
				.build();
		coOrdinates.put(co.getId(), co);
		return co;
	}

	// select * from CoOrdinate where x=target_x and y = target_y and playerId=plater.getId
	@Override
	public Coordinate getByXAndYAndPlayerId(int x, int y, long playerId) {
		
		return coOrdinates.values()
				.stream()
				.filter(co -> co.getX() == x && co.getY() == y 
				&& co.getPlayerId() == playerId)
				.findAny()
				.orElse(null);
	}

}
