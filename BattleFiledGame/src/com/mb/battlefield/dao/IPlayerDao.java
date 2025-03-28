package com.mb.battlefield.dao;

import java.util.List;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

public interface IPlayerDao {
	Player add(Player player);
//	boolean update(Player player);
	Player getById(long id);
	List<Ship> getShipsForPlayer(long playerId);
	List<Coordinate> getCordinateForPlayer(long playerId);
	List<Player> getAll();
	
}
