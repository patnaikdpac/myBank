package com.myBank.common;

public class InsufficientBalanceException extends Exception
{
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}
