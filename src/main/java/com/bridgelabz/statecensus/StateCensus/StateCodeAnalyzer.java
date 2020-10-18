package com.bridgelabz.statecensus.StateCensus;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Logger;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCodeAnalyzer {
	public static int readingStateCensusFromCSV(String filePath)
	{
		Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());
		Reader reader = null;
		try {
              reader = Files.newBufferedReader(Paths.get(filePath));		
		}
		catch(Exception exception)
		{
			logger.warning("Not able to open file at specified path");
			return 0;
		}
       CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader)
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
