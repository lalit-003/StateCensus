package com.bridgelabz.statecensus.StateCensus;

public class ExceptionStateCensus  extends Exception{

	public enum ExceptionType{
		INVALID_FILE_PATH,INVALID_CLASS_TYPE, INVALID_DELIMITER,INVALID_HEADER
	}
	public ExceptionType type;

	 public ExceptionStateCensus(String message,ExceptionType type) {
		super();
		System.out.println(message);
		this.type = type;
	}
}
