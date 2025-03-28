package com.mb.battlefield.service;

import java.util.List;

import com.mb.battlefield.enums.FireResult;
import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

public interface IPlayerService {
	Player add(String name);
	Player getPlayerById(long id);
	List<Ship> getPlayerShips(long playerId);
	List<Coordinate> getAttackedPositions(long playerId);
	List<Player> getAll();
	FireResult attackOnOpponentPosition(Coordinate randomPosToAttack, Player opponenetPlayer); 
}
