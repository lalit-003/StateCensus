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

public class StateCensusAnalyzer {

	public static int readingStateCensusFromCSV(String filePath) throws ExceptionStateCensus
	{
		Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());
		Reader reader = null;
		try {
              reader = Files.newBufferedReader(Paths.get(filePath));		
		}
		
		catch(NoSuchFileException e)
		{
			logger.warning("You have provided wrong file path or Incorrect file type ");
		   throw new ExceptionStateCensus(CensusExceptionType.WRONG_FILE_NAME, "no such file exists at given file location or incorrect file type ");
		}
		catch(IOException e)
		{
			throw new ExceptionStateCensus(CensusExceptionType.OTHER_IO_EXCEPTION, "some other file exception other than wrong name");
		}
       CsvToBean<Object> csvToBean = new CsvToBeanBuilder<Object>(reader)
                .withType(StateCensusAnalyzer.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();	
       Iterator<Object> stateIterator = csvToBean.iterator();
       int count =0;
       while(stateIterator.hasNext()) {
    	   count++;
			Object state = stateIterator.next();
			//logger.info("state  information : "+state.toString());
		}
       return count-1 ;
	}
		}
