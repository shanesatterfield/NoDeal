package com.NoDeal.cases;

import java.util.Collections;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.MathArrays;

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
		playerCase = -1;

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
		return briefcaseSet[ index ].isOpen();
	}

	public int left()
	{
		return casesLeft;
	}

	public int getTotalCases()
	{
		return briefcaseSet.length;
	}

	public void setPlayerCase( int index )
	{
		if( index > 0 && index < briefcaseSet.length )
			playerCase = index;
	}

	public int[] getCasesLeft()
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for( int i = 0; i < getTotalCases(); ++i )
			if( isOpen( i ) == false && i != playerCase )
				arr.add( i );

		int[] whatsLeft = ArrayUtils.toPrimitive( arr.toArray( new Integer[0] ) );
		this.shuffle( whatsLeft );

		return whatsLeft;
	}

	public int[] getCashValuesLeft()
	{
		int[] whatsLeft = new int[ left() ];

		int iter = 0;
		for( int i = 0; i < getTotalCases(); ++i )
			if( isOpen( i ) == false )
				whatsLeft[ iter++ ] = getBriefcase( i ).getCashValue();

		this.shuffle( whatsLeft );
		return whatsLeft;
	}

	public int[] getCashValues()
	{
		int[] whatsLeft = new int[ getTotalCases() ];

		for( int i = 0; i < getTotalCases(); ++i )
			whatsLeft[ i ] = getBriefcase( i ).getCashValue();


		this.shuffle( whatsLeft );
		return whatsLeft;
	}

	public void shuffle()
	{
		List< Briefcase > castedList = Arrays.asList( this.briefcaseSet );
		Collections.shuffle( castedList );
		this.briefcaseSet = castedList.toArray( this.briefcaseSet );
		/*
		this.<Briefcase>shuffle( this.briefcaseSet );
		*/
	}

	// Uses Apache Commons ArrayUtils to manage with int primitive.
	public static void shuffle( int[] arr )
	{
		/*
		List< Integer > castedList = Arrays.asList( ArrayUtils.toObject(arr) );
		Collections.shuffle( castedList );
		arr = ArrayUtils.toPrimitive( castedList.toArray( new Integer[0] ) );
		*/
		MathArrays.shuffle( arr );
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
	private int 		playerCase;
}