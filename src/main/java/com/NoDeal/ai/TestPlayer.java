package com.NoDeal.ai;

import java.util.*;
import org.apache.commons.lang3.math.NumberUtils;
import com.NoDeal.game.GameState;

public class TestPlayer implements Player
{
	public TestPlayer()
	{
		if( rand == null )
			rand = new Random();
	}

	// Always chooses No Deal.
	public Boolean isDeal( int offer, GameState gs )
	{
		// Finds the largest value that could be won.
		int largest = NumberUtils.max( gs.cashValuesLeft );

		// Calculates the chance of getting the highest value.
		double chance = 1.0 / gs.cashValuesLeft.length;
		return offer > (largest * chance);
	}

	// Just randomly chooses a case.
	public int chooseCase( GameState gs )
	{	
		return gs.casesLeft[ rand.nextInt( gs.casesLeft.length ) ];
	}

	public static Random rand;
}