package com.bridgelabz.statecensus.StateCensus;

import java.io.Reader;
import java.util.Iterator;

import com.bridgelabz.statecensus.StateJAR.ICSVBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class OpenCSVBuilder<E> implements ICSVBuilder<E>  {
	
		@Override
		public Iterator<E> getIterator(Reader reader, Class className) throws CsvException  {
			try {
				CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
				csvToBeanBuilder.withType(className);
				csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
				CsvToBean<E> csvToBean = csvToBeanBuilder.build();
				return csvToBean.iterator();
			} catch (IllegalStateException e) {
				throw new  CsvException();
			}
		}
}


