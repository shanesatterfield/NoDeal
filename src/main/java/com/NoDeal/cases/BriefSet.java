package com.NoDeal.cases;

import java.util.Collections;
import java.util.*;

import com.NoDeal.game.GameState;

public class BriefSet
{
	public BriefSet( int[] cashValues )
	{
		this( cashValues, false );
	}
	
	public BriefSet( int[] cashValues, Boolean doShuffle )
	{
		briefcaseSet = new Briefcase[ cashValues.length ];
		for( int i = 0; i < cashValues.length; ++i )
				briefcaseSet[i] = new Briefcase( cashValues[i] );

		casesLeft = cashValues.length;

		if( doShuffle )
			this.shuffle();
	}

	public Briefcase getBriefcase( int index )
	{
		return briefcaseSet[ index ];
	}

	public void open( int index )
	{
		briefcaseSet[ index ].open();
		casesLeft -= 1;
	}

	public Boolean isOpen( int index )
	{
		return briefcaseSet[ index].isOpen();
	}

	public int left()
	{
		return casesLeft;
	}

	public void shuffle()
	{
		List< Briefcase > castedList = Arrays.asList( this.briefcaseSet );
		Collections.shuffle( castedList );
		this.briefcaseSet = castedList.toArray( this.briefcaseSet );
	}
	/*
	public GameState getGameState()
	{
		ArrayList<Integer> opened         = new ArrayList<Integer>();
		ArrayList<Integer> casesLeft      = new ArrayList<Integer>();
		ArrayList<Integer> cashValuesLeft = new ArrayList<Integer>();
		ArrayList<Integer> cashValuesList = new ArrayList<Integer>();

		for( int i = 0; i < briefcaseSet.length; ++i )
		{
			if( briefcaseSet[i].isOpened() )
				opened.add( i );
			else
			{
				cashValuesLeft.add( briefcaseSet[i].getCashValue() );
				casesLeft.add( i );
			}

			cashValuesList.add( briefcaseSet[i].getCashValue() );
		}

		Collections.sort( cashValuesLeft );
		Collections.sort( cashValuesList );

		
		GameState gs      = new GameState();
		gs.opened         = 		opened.toArray( new int[ 		 opened.size() ] );
		gs.casesLeft      = 	 casesLeft.toArray( new int[ 	  casesLeft.size() ] );
		gs.cashValuesLeft = cashValuesLeft.toArray( new int[ cashValuesLeft.size() ] );
		gs.cashValuesList = cashValuesList.toArray( new int[ cashValuesList.size() ] );

		return gs;
	}
	*/
	private Briefcase[] briefcaseSet;
	private int			casesLeft;
}