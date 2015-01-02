package com.NoDeal;

import com.NoDeal.game.*;
import com.NoDeal.ai.*;
import java.util.ArrayList;

public class Runner
{
	public static void main( String args[] )
	{
		ArrayList<GameResult> results = new ArrayList<GameResult>();
		ArrayList<Game> games         = new ArrayList<Game>();
		for( int i = 0; i < 1000; ++i )
		{
			Game game = new Game( new TestBanker(), new TestPlayerMean() );
			games.add( game );
			game.start();
		}

		for( Game n: games )
		{
			try {
				n.join();
				results.add( n.getGameResult() );
			} catch( InterruptedException e ) { e.printStackTrace(); }
		}

		printResults( doMetricsAvg(results) );
	}

	public static void printResults( GameResult gr )
	{
		System.out.printf("Player Winnings: %d\nBanker Winnings: %d\n\n", gr.playerWinnings, gr.bankerWinnings);
	}

	public static GameResult doMetricsAvg( ArrayList<GameResult> gr )
	{
		GameResult finalResults = new GameResult();
		for( GameResult iter: gr )
		{
			finalResults.playerWinnings += iter.playerWinnings;
			finalResults.bankerWinnings += iter.bankerWinnings;
		}

		finalResults.playerWinnings /= gr.size();
		finalResults.bankerWinnings /= gr.size();

		return finalResults;
	}
}