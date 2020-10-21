package com.bridgelabz.statecensus.StateCensus;

import java.util.List;
import java.io.Reader;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder<E> {

	private CsvToBean<E> getCsvToBean(Reader reader, Class className) throws ExceptionStateCensus {
		try {
			CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
					                .withIgnoreLeadingWhiteSpace(true)
					                 .withType(className)
					                 .build();
			return csvToBean;
		} catch (IllegalStateException e) {
			throw new ExceptionStateCensus(e.getMessage(), ExceptionStateCensus.ExceptionType.INVALID_FILE_PATH);
		}
			}
	
	@Override
	public Iterator<E> getIterator(Reader reader, Class className) throws ExceptionStateCensus {
		return this.getCsvToBean(reader, className).iterator();
	}


	@Override
	public List getList(Reader reader, Class className) throws ExceptionStateCensus {
		return this.getCsvToBean(reader, className).parse();
	}

}
