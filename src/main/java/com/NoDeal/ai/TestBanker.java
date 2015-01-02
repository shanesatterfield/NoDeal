package com.NoDeal.ai;

import com.NoDeal.game.GameState;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.Collections;

public class TestBanker implements Banker
{
	// Always returns the same offer.
	public int makeOffer( GameState gs )
	{

		/*
		int sum = 0;
		for( int i: gs.cashValuesLeft )
			sum += i;
		return sum / gs.cashValuesLeft.length;
		*/
		//int median = StatUtils.percentile( gs.cashValuesLeft, 50 );
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for( int i: gs.cashValuesLeft )
			stats.addValue( i );

		return (int)( stats.getPercentile(50) * 1.25 );
	}
}