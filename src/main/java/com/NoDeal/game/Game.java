package com.NoDeal.game;

import com.NoDeal.cases.*;
import com.NoDeal.ai.*;
import java.util.ArrayList;

public class Game extends Thread
{
	public Game( Banker bai, Player pai )
	{
		setBanker( bai );
		setPlayer( pai );

		offers = new ArrayList<Integer>();
		gr = new GameResult();
	}

	public void run()
	{
		if( banker == null || player == null )
			return;

		bs = new BriefSet( new int[]{0,1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000} );
		int playerCaseNumber = player.chooseCase( getGameState() );
		playerCase = bs.getBriefcase( playerCaseNumber );
		bs.setPlayerCase( playerCaseNumber );

		boolean quit = false;
		while( quit == false )
		{
			// TODO: Change the amount of picks before an offer.
			// Player picks a case to open.
			int chosen = player.chooseCase( getGameState() );
			bs.open( chosen );

			// Banker makes an offer.
			offers.add( banker.makeOffer( getGameState() ) );

			// Player decides whether or not to go with the deal.
			if( player.isDeal( offers.get( offers.size() - 1 ), getGameState() ) )
			{
				gr.playerWinnings = offers.get( offers.size() - 1 );
				gr.bankerWinnings = playerCase.getCashValue() - gr.playerWinnings;
				quit = true;
			}
			else if( bs.left() == 1 )
			{
				gr.playerWinnings = playerCase.getCashValue();
				quit = true;
			}

		}

		gr.finalOffer = offers.get( offers.size() - 1 );
		gr.playerCase = playerCase.getCashValue();

	}

	public void setBanker( Banker ai )
	{
		banker = ai;
	}

	public void setPlayer( Player ai )
	{
		player = ai;
	}

	public GameState getGameState()
	{
		GameState gs = new GameState();
		gs.casesLeft 	= bs.getCasesLeft();
		gs.cashValuesLeft = bs.getCashValuesLeft();
		gs.cashValuesList = bs.getCashValues();

		// TODO: Make this safe.
		gs.offers = new ArrayList<Integer>( this.offers );
		return gs;
	}

	public GameResult getGameResult()
	{
		return new GameResult( gr );
	}

	private Banker 		banker;
	private Player 		player;
	private Briefcase 	playerCase;
	private BriefSet 	bs;
	private ArrayList<Integer> offers;
	private GameResult  gr;
}