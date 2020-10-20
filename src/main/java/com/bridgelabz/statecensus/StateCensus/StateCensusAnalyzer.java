package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.CensusExceptionType;

public class StateCensusAnalyzer {
	static int count = 0;

	public static <E> int readingStateDataFromCSV(String filePath, E className) throws ExceptionStateCensus {
		Reader reader = null;
		try {
			
			int entries = 0;
			String line = "";
			reader = Files.newBufferedReader(Paths.get(filePath));
			BufferedReader bufferReader = new BufferedReader(reader);
			 String headerLine = bufferReader.readLine();
			ICSVBuilder icsvBuilder = BuilderFactoryCSV.generateBuilder();
			 icsvBuilder.checkHeaderNClassName(headerLine,reader, className);
			 boolean flag = icsvBuilder.headerTestResult();
			 if(flag == true)
			 {
			while((line = bufferReader.readLine()) != null)
			{
				entries++;
				System.out.println("state info is :" + line);
				String[] headers = line.split(",");
				if (headers.length !=4  || ((headers[0].equals("") || headers[1].equals("") || headers[2].equals(""))
						&& !headers[3].equals("'"))) {
					throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
							" dellimeter issue in csv file");
				}
			}
			 }
			return entries;
		} catch (NoSuchFileException e) {
			throw new ExceptionStateCensus(CensusExceptionType.WRONG_FILE_NAME,
					"no such file exists at given file location");
		} catch (IOException e) {
			throw new ExceptionStateCensus(CensusExceptionType.OTHER_IO_EXCEPTION,
					"some other file exception other than wrong name");
		}
	}
}

