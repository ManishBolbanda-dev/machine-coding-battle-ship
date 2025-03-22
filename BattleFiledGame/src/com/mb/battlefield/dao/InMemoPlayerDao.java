package com.mb.battlefield.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InMemoPlayerDao implements IPlayerDao{
	// use ShipDao
	
	private final Map<Long, Player> players ; 
	private Long incrementlSequence;
	
	private final IShipDao shipDao;
	private final ICoordinateDao coordinateDao;
	
//	public InMemoPlayerDao() {
//		players = new HashMap<>();
//		incrementlSequence = 1l;
//	}
	public synchronized long getNextSequence() {
		return incrementlSequence++;
	}
	
	@Override
	public Player add(Player player) {
		Player plyerToBeSaved = Player.builder()
				.id(getNextSequence())
				.name(player.getName())
				.build();
		players.put(plyerToBeSaved.getId(), plyerToBeSaved);
		return plyerToBeSaved;
	}

	@Override
	public Player getById(long id) {
		return players.get(id);
	}
	@Override
	public List<Ship> getShipsForPlayer(long playerId) {
		return shipDao.getShipByPlayerId(playerId);
	}
	@Override
	public List<Coordinate> getCordinateForPlayer(long playerId) {
		return coordinateDao.getByPlayerId(playerId);
	}

	@Override
	public List<Player> getAll() {
		return players.values().stream().toList();
	}
	
	
	//get ships
	
	//ge player
	
//	

}
