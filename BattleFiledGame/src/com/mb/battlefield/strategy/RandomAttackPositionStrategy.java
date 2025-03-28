package com.mb.battlefield.strategy;

import java.util.List;
import java.util.Random;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;
import com.mb.battlefield.service.CoordinateService;
import com.mb.battlefield.service.ICoordinateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomAttackPositionStrategy implements AttackPositionStratagey{
	private final Random random ;
	private final ICoordinateService coordinateService;

	@Override
	public Coordinate getRandomPositionInField(int xStart, int xEnd, int boardSize, Player player) {
		// get valid random x and y.
//		check if that posiotn is already attacked?
		List<Coordinate> attackedPositions = coordinateService.getByPlayerId(player.getId());
		Coordinate validateCoId = null;
		while(validateCoId == null) {
			int target_x = random.nextInt(xStart, xEnd+1);
			int target_y = random.nextInt(0, boardSize);
			// select * from CoOrdinate where x=target_x and y = target_y and playerId=plater.getId
			Coordinate attackedCoId = coordinateService.getByXAndYAndPlayerId(target_x, target_y, player.getId());
			if(attackedCoId == null) {
				validateCoId = new Coordinate(target_x, target_y);
				break;
			}
		}
		
		return validateCoId;
	}
	
	

}
