package com.mb.battlefield.util;

import java.util.HashMap;
import java.util.Random;

import com.mb.battlefield.dao.ICoordinateDao;
import com.mb.battlefield.dao.IPlayerDao;
import com.mb.battlefield.dao.IShipDao;
import com.mb.battlefield.dao.InMemoPlayerDao;
import com.mb.battlefield.dao.InMemoryCoordinateDao;
import com.mb.battlefield.dao.InMemoryShipDao;
import com.mb.battlefield.service.CoordinateService;
import com.mb.battlefield.service.ICoordinateService;
import com.mb.battlefield.service.IPlayerService;
import com.mb.battlefield.service.IShipService;
import com.mb.battlefield.service.PlayerService;
import com.mb.battlefield.service.ShipService;
import com.mb.battlefield.strategy.AttackPositionStratagey;
import com.mb.battlefield.strategy.PartiallyDestroyedStratergy;
import com.mb.battlefield.strategy.RandomAttackPositionStrategy;
import com.mb.battlefield.strategy.ShipDestroyCheckStrategy;
import com.mb.battlefield.validators.ShipPositionValidatorImpl;
import com.mb.battlefield.validators.ShipPostionValidators;

import lombok.Getter;


public class BeanFactory {
	
	//services
		private  IPlayerService playerService;
		private  IShipService shipService;
		private  ICoordinateService coordinateService;
		private  AttackPositionStratagey attackPositionStratagey;
		private  ShipDestroyCheckStrategy shipDestroyCheckStrategy;
		
//		private  BattleFiledService battleFiledService;
		
		// dao
		private  ICoordinateDao coordinateDao;
		private  IShipDao shipDao ;
		private  IPlayerDao playerDao ;
		
		private  ConsolePrinter consolePrinter;
		private  ShipPostionValidators shipPostionValidators;
		private int boardSize;
	
	public BeanFactory(int n) {
		this.boardSize = n;
//		coordinateDao = new InMemoryCoordinateDao(new HashMap<>(), 1l);
//		shipDao = new InMemoryShipDao(new HashMap<>(), 1l, coordinateDao);
//		
//		
//		playerService = new PlayerService(new ShipPositionValidatorImpl(n), null, playerDao)
	}

	public IPlayerService getPlayerService() {
		if(playerService == null) {
			playerService = new PlayerService( getConsolePrinter(), getPlayerDao(), getCoordinateService(),
					getShipService());
		}
		return playerService;
	}

	public IShipService getShipService() {
		if(shipService == null) {
			shipService = new ShipService(getShipDao(), getShipDestroyCheckStrategy());
		}
		return shipService;
	}

	public ICoordinateDao getCoordinateDao() {
		if(coordinateDao == null) {
			coordinateDao = new InMemoryCoordinateDao(new HashMap<>(), 1l);
		}
		return coordinateDao;
	}

	public IShipDao getShipDao() {
		if(this.shipDao == null) {
			this.shipDao =  new InMemoryShipDao(new HashMap<>(), 1l, getCoordinateDao());
		}
		return shipDao;
	}

	public IPlayerDao getPlayerDao() {
		if(playerDao == null) {
			playerDao = new InMemoPlayerDao(new HashMap<>(), 1l, getShipDao(), getCoordinateDao());
		}
		return playerDao;
	}

	public ConsolePrinter getConsolePrinter() {
		if(consolePrinter == null) {
			consolePrinter = ConsolePrinter.getPrinter();
		}
		return consolePrinter;
	}

	public ShipPostionValidators getShipPostionValidators() {
		if(shipPostionValidators == null) {
			shipPostionValidators = new ShipPositionValidatorImpl(boardSize, getCoordinateService());
		}
		return shipPostionValidators;
	}
	
	public ICoordinateService getCoordinateService() {
		if(coordinateService == null) {
			coordinateService = new CoordinateService(getCoordinateDao());
		}
		return coordinateService;
	}

	public AttackPositionStratagey getAttackPositionStratagey() {
		if(attackPositionStratagey == null) {
			attackPositionStratagey = new RandomAttackPositionStrategy(new Random(), getCoordinateService());
		}
		return attackPositionStratagey;
	}

	public ShipDestroyCheckStrategy getShipDestroyCheckStrategy() {
		if(shipDestroyCheckStrategy == null) {
			shipDestroyCheckStrategy = new PartiallyDestroyedStratergy(getCoordinateService());
		}
		return shipDestroyCheckStrategy;
	}

	
	
	
}
