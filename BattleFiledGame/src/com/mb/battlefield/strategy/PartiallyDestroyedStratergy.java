package com.mb.battlefield.strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mb.battlefield.enums.FireResult;
import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.model.Ship;
import com.mb.battlefield.service.ICoordinateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PartiallyDestroyedStratergy implements ShipDestroyCheckStrategy {

//	if ship is partially dstroyed then consider it as fully non-functional and mark it as destroyed
	
	private final ICoordinateService coordinateService;

	@Override
	public List<Ship> getDestroyedShips(List<Ship> ships, Player player) {
		List<Coordinate> lst = coordinateService.getByPlayerId(player.getId());
		Set<String> destoyedSet = prepareSet(lst);
		List<Ship> destroyedShips = new ArrayList();
		
		// check if any of the ship area is Destroed. if any one is Destroyed then the whole ship is destroyed.
		ships.forEach(sh -> {
			Coordinate shCo = coordinateService.getByShipId(sh.getId());
			for(int x=shCo.getX(); x<shCo.getX()+sh.getSize(); x++) {
				for(int y = shCo.getY(); y< shCo.getY()+sh.getSize(); y++) {
					if(destoyedSet.contains(x+"-"+y)) {
						destroyedShips.add(sh);
						break;
					}
				}
			}
		});
		return destroyedShips;
	}

	private Set<String> prepareSet(List<Coordinate> allDestroyedCo) {
		Set<String> coSet = new HashSet();
		allDestroyedCo.forEach(co -> coSet.add(co.getX()+"-"+ co.getY()));
		return coSet;
	}
	
	

}
