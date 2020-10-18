package com.bridgelabz.statecensus.StateCensus;


public class ExceptionStateCensus extends Exception {

	enum CensusExceptionType
	{
		WRONG_FILE_NAME,INCORRECT_FILE_TYPE,INCORRECT_DATA_IN_FILE,OTHER_IO_EXCEPTION
	}
	CensusExceptionType type;
	String message;

	public ExceptionStateCensus(CensusExceptionType type,String message)
	{
				super(message);
				System.out.println(message);
				this.type = type;
	}
}