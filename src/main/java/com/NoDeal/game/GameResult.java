package com.NoDeal.game;

public class GameResult
{
	public GameResult(){}
	public GameResult( GameResult gr )
	{
		this.playerWinnings = gr.playerWinnings;
		this.bankerWinnings = gr.bankerWinnings;
		this.finalOffer     = gr.finalOffer;
		this.playerCase     = gr.playerCase;
	}

	public int playerWinnings;
	public int bankerWinnings;
	public int finalOffer;
	public int playerCase;
}