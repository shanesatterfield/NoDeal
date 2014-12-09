package com.NoDeal.ai;

import com.NoDeal.cases.GameState;

public interface Player
{
	Boolean isDeal( int offer, GameState gs );
	int chooseCase( GameState gs );
}