package com.NoDeal.ai;

import com.NoDeal.game.GameState;

public interface Player
{
	Boolean isDeal( int offer, GameState gs );
	int chooseCase( GameState gs );
}