package com.mb.battlefield.service;

import java.util.List;

import com.mb.battlefield.enums.FireResult;
import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

public interface IShipService {
	
	Ship addShip(int size, long playerId, long coId, String shipLabel);
	Ship getById(long id);
	Ship doesShipExistAtAttackPosition(Coordinate randomPosToAttack, long playerId);
	List<Ship> getAllDestroyedShips(List<Ship> ships, Player player);
	List<Ship> getPlayerShips(long id);


}
