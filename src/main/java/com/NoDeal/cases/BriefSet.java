package com.NoDeal.cases;

import java.util.Collections;
import java.util.*;

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

	private Briefcase[] briefcaseSet;
	private int			casesLeft;
}