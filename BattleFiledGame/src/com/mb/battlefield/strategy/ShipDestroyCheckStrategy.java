package com.mb.battlefield.strategy;

import java.util.List;

import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

public interface ShipDestroyCheckStrategy {
	
	List<Ship> getDestroyedShips(List<Ship> ships, Player player);

}
