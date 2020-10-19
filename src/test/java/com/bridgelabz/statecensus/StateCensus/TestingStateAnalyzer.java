package com.bridgelabz.statecensus.StateCensus;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;


public class TestingStateAnalyzer {

	  public static String StateCensus_FilePath = "D:\\FileIO\\demo\\StateCensus.csv";

	  StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
	  Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());

	  // Test to check number of entries in csv file using iterator
		@Test
		public void checkingNumberOfStates() throws ExceptionStateCensus
		{
			int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
			logger.info("Count is : "+ count);
			Assert.assertEquals(29, count);
		}
		// Test to check number of entries in csv file using iterator
		  //Sad Test Case
			@Test
			public void checkingNumberOfStatesSadCase() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
				Assert.assertEquals(0,count);
			}

			//

				public static String Wrong_StateCensus_FilePath = "C:\\FileIO\\demo\\StateCensus.csv";
			 // test to show that program throws exception when given wrong file path 
			@Test
			public void givenWrongFilePathShouldReturnException() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FilePath);
				logger.info("Count is : "+ count);
				Assert.assertEquals(29, count);
						}
			
			public static String Wrong_StateCensus_FileType = "D:\\FileIO\\demo\\StateCensus.txt";
			 // test to show that program throws exception when given wrong file type
			@Test
			public void givenWrongFileTypeShouldReturnException() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FileType);
				logger.info("Count is : "+ count);
				Assert.assertEquals(29, count);
						}
			
			public static String StateCensus_Delimeter = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusDeli.csv";

			 // test to show that program throws exception when given wrong file type
				@Test
				public void givenWrongDelimeterInFile_ReturnCustomException() throws ExceptionStateCensus
				{
					int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_Delimeter);
					logger.info("Count is : "+ count);
					Assert.assertEquals(29, count);
							}
			
				public static String StateCensus_Header = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\StateCensusHeader.csv";
				 // test to show that program throws exception when there is incoorect header definition
				@Test
				public void givenWrongHeaderInCSVFile_ReturnCustomException() throws ExceptionStateCensus
				{
					int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_Header);
					logger.info("Count is : "+ count);
					Assert.assertEquals(29, count);
							}

				public static String StateCode_FilePath = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";
				// Test to check number of entries in csv file using iterator
				@Test
				public void checkingNumberOfStatesInStateCode() throws ExceptionStateCensus
				{
					int count =  StateCensusAnalyzer.readingStateCodeFromCSV(StateCode_FilePath);
					logger.info("Count is : "+ count);
					Assert.assertEquals(37, count);
				}
				
				public static String Wrong_StateCode_FilePath = "C:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";

				 // test to show that program throws exception when given wrong file path 
				@Test
				public void givenWrongFilePathShouldReturnExceptionInStateCode() throws ExceptionStateCensus
				{
					int count =  StateCensusAnalyzer.readingStateCodeFromCSV(Wrong_StateCode_FilePath);
					logger.info("Count is : "+ count);
					Assert.assertEquals(28, count);
							}
				
				public static String Wrong_StateCode_FileType = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.txt";
				 // test to show that program throws exception when given wrong file type
				@Test
				public void givenWrongFileTypeShouldReturnExceptionInStateCode() throws ExceptionStateCensus
				{
					int count =  StateCensusAnalyzer.readingStateCodeFromCSV(Wrong_StateCode_FileType);
					logger.info("Count is : "+ count);
					Assert.assertEquals(28, count);
							}
				
				public static String StateCode_Delimeter = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCodeDeli.csv";


				 // test to show that program throws exception when given wrong delimeter input
				
					@Test
					public void givenWrongDelimeterInFile_ReturnCustomExceptionInStateCode() throws ExceptionStateCensus
					{
						int count =  StateCensusAnalyzer.readingStateCodeFromCSV(StateCode_Delimeter);
						logger.info("Count is : "+ count);
						Assert.assertEquals(28, count);
								}
					
					public static String StateCode_Header = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCodeHeader.csv";


					 // test to show that program throws exception when given wrong delimeter input
					
						@Test
						public void givenWrongHeaderInFile_ReturnCustomExceptionInStateCode() throws ExceptionStateCensus
						{
							int count =  StateCensusAnalyzer.readingStateCodeFromCSV(StateCode_Delimeter);
							logger.info("Count is : "+ count);
							Assert.assertEquals(28, count);
									}



				


}