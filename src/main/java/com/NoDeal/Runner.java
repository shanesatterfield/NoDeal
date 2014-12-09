package com.NoDeal;

import com.NoDeal.cases.*;

public class Runner
{
	public static void main( String args[] )
	{
		Briefcase brief = new Briefcase( 10 );
		System.out.println( "Briefcase Value: " + brief.getCashValue() );

		BriefSet bs = new BriefSet( new int[]{1,2,3,4} );
		bs.open( 1 );
		System.out.println( "Briefcases Left: " + bs.left() );
	}
}