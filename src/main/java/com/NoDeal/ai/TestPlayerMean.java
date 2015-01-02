package com.NoDeal.ai;

import java.util.*;
import org.apache.commons.lang3.math.NumberUtils;
import com.NoDeal.game.GameState;

public class TestPlayerMean implements Player
{
	public TestPlayerMean()
	{
		if( rand == null )
			rand = new Random();
	}

	// Always chooses No Deal.
	public Boolean isDeal( int offer, GameState gs )
	{
		int sum = 0;
		for( int i = 0; i < gs.cashValuesLeft.length; ++i )
			sum += gs.cashValuesLeft[i] / (double)(gs.cashValuesLeft.length-1);

		return offer > sum;
	}

	// Just randomly chooses a case.
	public int chooseCase( GameState gs )
	{	
		return gs.casesLeft[ rand.nextInt( gs.casesLeft.length ) ];
	}

	public static Random rand;
}