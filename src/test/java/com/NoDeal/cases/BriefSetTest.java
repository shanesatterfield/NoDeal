package com.NoDeal.cases;

import static org.junit.Assert.*;

import org.junit.Test;

public class BriefSetTest
{
	public BriefSetTest()
	{
		final int SIZE = 1000;
		testValues = new int[ SIZE ];
		for( int i = 0; i < SIZE; ++i )
			testValues[ i ] = i;
	}

	@Test
	public void testConstruction()
	{
		BriefSet b = new BriefSet( testValues );
		assertEquals( testValues.length, b.left() );
		assertFalse( checkShuffled( testValues, b ) );

		b = new BriefSet( testValues, false );
		assertEquals( testValues.length, b.left() );
		assertFalse( checkShuffled( testValues, b ) );
		
		b = new BriefSet( testValues, true );
		assertEquals( testValues.length, b.left() );
		assertTrue( checkShuffled( testValues, b ) );
	}

	@Test
	public void testIntiailSize()
	{
		//int[] arr = new int[]{ 1, 4, 5, 62, 71, 18 };
		BriefSet b = new BriefSet( testValues );
		assertTrue( testValues.length > 0 );
		assertEquals( b.left(), testValues.length );
	}

	@Test
	public void testGetBriefcase()
	{
		BriefSet b = new BriefSet( testValues );

		assertEquals( testValues.length, b.left() );
		for( int i = 0; i < testValues.length; ++i )
			assertEquals( testValues[i], b.getBriefcase(i).getCashValue() );
	}

	@Test
	public void testOpen()
	{
		BriefSet b = new BriefSet( testValues );

		assertEquals( testValues.length, b.left() );
		for( int i = 0; i < testValues.length; ++i )
		{
			assertFalse( b.isOpen( i ) );
			b.open( i );
			assertTrue( b.isOpen( i ) );
		}
	}

	@Test
	public void testLeftCount()
	{
		BriefSet b = new BriefSet( testValues );

		assertEquals( testValues.length, b.left() );
		for( int i = 0; i < testValues.length; ++i )
		{
			b.open( i );
			assertEquals( testValues.length - i - 1, b.left() );
		}
	}

	@Test
	public void testShuffle()
	{
		BriefSet b = new BriefSet( testValues );
		assertEquals( testValues.length, b.left() );
		b.shuffle();
		assertEquals( testValues.length, b.left() );

		assertTrue( checkShuffled( testValues, b ) );
	}

	@Test
	public void testShuffleInt()
	{
		int[] arr = new int[1000000];
		for( int i = 0; i < arr.length; ++i )
			arr[i] = i;

		BriefSet.shuffle( arr );

		boolean shuffled = false;
		for( int i = 0; i < arr.length; ++i )
		{
			if( i != arr[i] )
			{
				shuffled = true;
				break;
			}
		}

		assertTrue( shuffled );
	}

	private Boolean checkShuffled( int[] arr, BriefSet b )
	{
		Boolean shuffled = false;
		for( int i = 0; i < arr.length; ++i )
		{
			if( arr[ i ] != b.getBriefcase( i ).getCashValue() )
			{
				shuffled = true;
				break;
			}
		}

		return shuffled;
	}

	private int[] testValues;
}