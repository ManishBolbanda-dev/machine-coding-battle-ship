package com.mb.battlefield;

import com.mb.battlefield.service.GameService;

public class BattleFieldGameExecutor {
	public static void main(String[] args) {
		System.out.println("hello, battle field");
		GameService gameService = new GameService(6);
		gameService.addPlayers("John", "Ruven");
		gameService.addShips(1, 2, 1, 1, 4, 3);
		gameService.startGame();
		
		gameService.viewBattleField();
	}
}
