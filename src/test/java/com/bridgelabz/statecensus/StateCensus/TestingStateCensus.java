package com.bridgelabz.statecensus.StateCensus;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class TestingStateCensus {

	public static String StateCensus_FilePath = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStatesCensus.csv";

	StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
	Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());

	// Test to check number of entries in csv file using iterator
	@Test
	public void checkingNumberOfStates() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	// Test to check number of entries in csv file using iterator
	// Sad Test Case
	@Test
	public void checkingNumberOfStatesSadCase() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
		Assert.assertEquals(10, count);
	}

	//

	public static String Wrong_StateCensus_FilePath = "C:\\FileIO\\demo\\StateCensus.csv";

	// test to show that program throws exception when given wrong file path
	@Test
	public void givenWrongFilePathShouldReturnException() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String Wrong_StateCensus_FileType = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStatesCensus.txt";


	// test to show that program throws exception when given wrong file type
	@Test
	public void givenWrongFileTypeShouldReturnException() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FileType);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String StateCensus_Delimeter = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusDeli.csv";

	// test to show that program throws exception when given wrong file type
	@Test
	public void givenWrongDelimeterInFile_ReturnCustomException() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_Delimeter);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String StateCensus_Header = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusHeader.csv";

	// test to show that program throws exception when there is incoorect header
	// definition
	@Test
	public void givenWrongHeaderInCSVFile_ReturnCustomException() throws ExceptionStateCensus {
		int count = StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_Header);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

}