package com.bridgelabz.statecensus.StateCensus;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.exceptions.CsvException;

public  interface ICSVBuilder<E> {
	
		public <E> Iterator<E> getIterator(Reader reader, Class className) throws CsvException;
	}

