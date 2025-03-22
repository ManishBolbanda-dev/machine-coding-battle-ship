package com.mb.battlefield.service;

import java.util.ArrayList;

import com.mb.battlefield.model.BattleFiled;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BattleFiledService {
	
	public void addShipForPlayer(BattleFiled filed, Player player, Ship ship) {
		filed.getPlayerToShipMap().computeIfAbsent(player, lst -> new ArrayList<>()).add(ship);
	}
}
