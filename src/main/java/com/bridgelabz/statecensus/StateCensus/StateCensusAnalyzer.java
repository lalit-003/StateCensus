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
	static int count =0 ;

	public static int readingStateCensusFromCSV(String filePath) throws ExceptionStateCensus
	{
		Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());
		Reader reader = null;
		try {
              reader = Files.newBufferedReader(Paths.get(filePath));		
		}
		catch(NoSuchFileException e)
		{
			logger.warning("Wrong file type or Incorrect path specified");
			throw new ExceptionStateCensus(CensusExceptionType.WRONG_FILE_NAME, "no such file exists at given file location");
		}
		catch(IOException e)
		{
			throw new ExceptionStateCensus(CensusExceptionType.OTHER_IO_EXCEPTION, "some other file exception other than wrong name");
		}
       		       CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withType(CSVStateCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();	
     
       Iterator<CSVStateCensus> stateIterator = csvToBean.iterator();
         count =0;
       while(stateIterator.hasNext()) {
						CSVStateCensus state = stateIterator.next();
						count++;
						if (CSVStateCensus.getStateName() == null || CSVStateCensus.getPopulation() == null || CSVStateCensus.getDensityPerSqKm() == null
					|| CSVStateCensus.getAreaInSqKm() ==  null)
			{
				throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER, "Incorrect data or header issue in csv file");
			}
						
				logger.info("state  information : "+state.toString());
				 						}

		       return count ;
	}
	
	public static int readingStateCodeFromCSV(String filePath) throws ExceptionStateCensus

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
       count =0;
       while(stateIterator.hasNext()) {
    	   count++;
			CSVStateCode state = stateIterator.next();
			logger.info("state  information : "+state.toString());
			if (CSVStateCode.getSerialNO() == null || CSVStateCode.getStateCode() == null || CSVStateCode.getTinNumber() == null||CSVStateCode.getStateName()==null)
			{
				throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER, "Incorrect data or dellimeter issue in csv file");
			}
		}
       return count ;
	}
	       
}
//