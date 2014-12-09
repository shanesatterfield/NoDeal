package com.NoDeal.cases;

public class Briefcase
{
	public Briefcase()
	{
		this( 0 );
	}

	public Briefcase( int cashValue )
	{
		setCashValue( cashValue );
		this.opened = false;
	}

	public void setCashValue( int cashValue )
	{
		if( cashValue >= 0 )
			this.cashValue = cashValue;
	}

	public int getCashValue()
	{
		return this.cashValue;
	}

	public void open()
	{
		this.opened = true;
	}

	public Boolean isOpen()
	{
		return this.opened;
	}

	private int cashValue;
	private Boolean opened;
}