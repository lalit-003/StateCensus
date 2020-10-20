package com.bridgelabz.statecensus.StateCensus;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.exceptions.CsvException;

public class TestingStateAnalyzer {

	public static String StateCensus_FilePath = "D:\\FileIO\\demo\\StateCensus.csv";
	StateAnalyzer stateAnalyzer = new StateAnalyzer();
	Logger logger = Logger.getLogger(StateAnalyzer.class.getName());

	// Test to check number of entries in csv file using iterator
	@Test
	public void checkingNumberOfStates() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(StateCensus_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	// Test to check number of entries in csv file using iterator
	// Sad Test Case
	@Test
	public void checkingNumberOfStatesSadCase() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(StateCensus_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(0, count);
	}

	public static String Wrong_StateCensus_FilePath = "C:\\FileIO\\demo\\StateCensus.csv";
	// test to show that program throws exception when given wrong file path
	@Test
	public void givenWrongFilePathShouldReturnException() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(Wrong_StateCensus_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String Wrong_StateCensus_FileType = "D:\\FileIO\\demo\\StateCensus.txt";
	// test to show that program throws exception when given wrong file type
	@Test
	public void givenWrongFileTypeShouldReturnException() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(Wrong_StateCensus_FileType);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String StateCensus_Delimeter = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusDeli.csv";

	// test to show that program throws exception when given wrong file type
	@Test
	public void givenWrongDelimeterInFile_ReturnCustomException() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(StateCensus_Delimeter);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	public static String StateCensus_Header = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusHeader.csv";
	// test to show that program throws exception when there is incorrect header
	// definition
	@Test
	public void givenWrongHeaderInCSVFile_ReturnCustomException() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCensusData(StateCensus_Header);
		logger.info("Count is : " + count);
		Assert.assertEquals(29, count);
	}

	// TESTS FOR STATE CODE CLASS STARTS HERE

	public static String StateCode_FilePath = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";
	// Test to check number of entries in csv file using iterator
	@Test
	public void checkingNumberOfStatesInStateCode() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCodeData(StateCode_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(37, count);
	}

	public static String Wrong_StateCode_FilePath = "C:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";
	// test to show that program throws exception when given wrong file path
	@Test
	public void givenWrongFilePathShouldReturnExceptionInStateCode() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCodeData(Wrong_StateCode_FilePath);
		logger.info("Count is : " + count);
		Assert.assertEquals(37, count);
	}

	public static String Wrong_StateCode_FileType = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.txt";
	// test to show that program throws exception when given wrong file type
	@Test
	public void givenWrongFileTypeShouldReturnExceptionInStateCode() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCodeData(Wrong_StateCensus_FileType);
		logger.info("Count is : " + count);
		Assert.assertEquals(37, count);
	}

	public static String StateCode_Delimeter = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCodeDeli.csv";
	// test to show that program throws exception when given wrong delimeter input
	@Test
	public void givenWrongDelimeterInFile_ReturnCustomExceptionInStateCode() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCodeData(StateCode_Delimeter);
		logger.info("Count is : " + count);
		Assert.assertEquals(37, count);
	}

	public static String StateCode_Header = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCodeHeader.csv";
	// test to show that program throws exception when given wrong delimeter input
	@Test
	public void givenWrongHeaderInFile_ReturnCustomExceptionInStateCode() throws ExceptionStateCensus, CsvException {
		int count = stateAnalyzer.loadCodeData(StateCode_Header);
		logger.info("Count is : " + count);
		Assert.assertEquals(37, count);
	}

}