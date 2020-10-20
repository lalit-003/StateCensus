package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.beanutils.ConversionException;

import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.CensusExceptionType;
import com.opencsv.CSVWriter;
import com.opencsv.ICSVParser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class OpenCSVBuilder<E> implements ICSVBuilder<E>  {
	
	boolean headerTest = true;

		@Override
	public void checkHeaderNClassName(String line,Reader reader, E className) throws ExceptionStateCensus {
		// TODO Auto-generated method stub
		        		
        		//checking for header
        		try {
            		      System.out.println(line);
						System.out.println("state info is :" + line);
						String[] headers = line.split(",");
							if (className.equals(CSVStateCensus.class)
									&& (!headers[0].equals("State") || !headers[1].equals("Population")
											|| !headers[2].equals("AreaInSqKm") || !headers[3].equals("DensityPerSqKm"))) {
								headerTest = false;
								throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
										"Header issue in csv file");
							}
							if (className.equals(CSVStateCode.class)
									&& (!headers[0].equals("SrNo") || !headers[1].equals("State Name") || !headers[2].equals("TIN")
											|| !headers[3].equals("StateCode"))) {
								throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
										"Header issue in csv file");
							}
						
				} catch (ExceptionStateCensus e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
					}

		@Override
		public boolean headerTestResult() {
			// TODO Auto-generated method stub
			return headerTest;
		}
}
