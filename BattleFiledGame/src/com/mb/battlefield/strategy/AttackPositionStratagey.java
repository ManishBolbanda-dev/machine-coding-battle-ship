package com.mb.battlefield.strategy;

import com.mb.battlefield.model.Coordinate;
import com.mb.battlefield.model.Player;

public interface AttackPositionStratagey {
	Coordinate getRandomPositionInField(int xStart, int xEnd,int boardSize, Player playerA);
}
