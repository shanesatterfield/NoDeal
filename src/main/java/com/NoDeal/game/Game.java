package com.NoDeal.game;

import com.NoDeal.cases.*;
import com.NoDeal.ai.*;
import java.util.*;

public class Game
{
	public Game()
	{
		if( offers == null )
			offers = new ArrayList<Integer>();
	}

	public GameState getGameState()
	{
		//GameState gs = bs.getGameState();
		//gs.offers = offers.toArray( new int[ offers.size() ] );
		return new GameState();
	}

	private ArrayList<Integer> offers;
	private BriefSet bs;
}