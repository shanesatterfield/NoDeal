package com.NoDeal.cases;

import static org.junit.Assert.*;

import org.junit.Test;

public class BriefcaseTest
{
	@Test
	public void testCalculate()
	{
		assertEquals( 4 * 5, 20 );
	}

	@Test
	public void testBriefcaseInitializeUnopened()
	{
		Briefcase brief1 = new Briefcase( 10 );
		Briefcase brief2 = new Briefcase();

		assertEquals( brief1.isOpen(), false );
		assertEquals( brief2.isOpen(), false );
	}

	@Test
	public void testBriefCaseOpens()
	{
		Briefcase brief = new Briefcase();
		assertEquals( brief.isOpen(), false );

		brief.open();
		assertEquals( brief.isOpen(), true );
	}

	@Test
	public void testSetValue()
	{
		int[] failingInserts = { -1, -9001 };
		int[] passingInserts = { 0, 1, 100, 12345 };

		Briefcase brief;
		for( int i: failingInserts )
		{
			brief = new Briefcase( i );
			assertEquals( brief.getCashValue(), 0 );

			brief.setCashValue( i );
			assertEquals( brief.getCashValue(), 0 );

			for( int j: passingInserts )
			{
				brief.setCashValue( j );
				assertEquals( brief.getCashValue(), j );
			}
		}

		for( int i: passingInserts )
		{
			brief = new Briefcase( i );
			assertEquals( brief.getCashValue(), i );

			brief.setCashValue( i );
			assertEquals( brief.getCashValue(), i );
		}
	}
}