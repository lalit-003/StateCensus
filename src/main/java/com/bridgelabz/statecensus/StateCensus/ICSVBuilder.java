package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Iterator;

public  interface ICSVBuilder<E> {
	
	public void checkHeaderNClassName(String headerLine,Reader reader, E className) throws ExceptionStateCensus;

	public boolean headerTestResult();
}
