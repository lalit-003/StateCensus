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
		int count =0;
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

       while(stateIterator.hasNext()) {
    	   count++;
						CSVStateCensus state = stateIterator.next();
						if (CSVStateCensus.getStateName() == null || Integer.parseInt(CSVStateCensus.getPopulation()) == 0 || Integer.parseInt(CSVStateCensus.getDensityPerSqKm()) == 0
					|| Integer.parseInt(CSVStateCensus.getAreaInSqKm()) == 0)
			{
				throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE, "Incorrect data or dellimeter issue in csv file");

			}
				logger.info("state  information : "+state.toString());
						}

		       return count-1 ;
	}
	       
}
