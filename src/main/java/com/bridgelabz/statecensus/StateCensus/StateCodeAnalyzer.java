package com.bridgelabz.statecensus.StateCensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Logger;
import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.CensusExceptionType;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCodeAnalyzer {
	public static int readingStateCensusFromCSV(String filePath) throws ExceptionStateCensus

	{
		Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());
		Reader reader = null;
		try {
              reader = Files.newBufferedReader(Paths.get(filePath));		
		}
		catch(NoSuchFileException e)
		{
			logger.warning("Not able to open file at specified path");
		   throw new ExceptionStateCensus(CensusExceptionType.WRONG_FILE_NAME, "no such file exists at given file location");
		}
		catch(IOException e)
		{
			throw new ExceptionStateCensus(CensusExceptionType.OTHER_IO_EXCEPTION, "some other file exception other than wrong name");
		}       CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader)
                .withType(CSVStateCode.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();	
       Iterator<CSVStateCode> stateIterator = csvToBean.iterator();
       int count =0;
       while(stateIterator.hasNext()) {
    	   count++;
			CSVStateCode state = stateIterator.next();
			logger.info("state  information : "+state.toString());
		}
       return count ;
	}
}
