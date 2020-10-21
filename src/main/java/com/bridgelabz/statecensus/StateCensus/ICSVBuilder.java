package com.bridgelabz.statecensus.StateCensus;

import java.io.Reader;

import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {

	public Iterator<E> getIterator(Reader reader, Class className) throws ExceptionStateCensus;
	public List getList(Reader reader, Class className) throws ExceptionStateCensus;

}
