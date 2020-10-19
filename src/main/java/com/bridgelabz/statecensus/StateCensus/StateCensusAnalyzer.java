package com.bridgelabz.statecensus.StateCensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.CensusExceptionType;

public class StateCensusAnalyzer {
	static int count = 0;

	public static <E> int readingStateDataFromCSV(String filePath, E className) throws ExceptionStateCensus {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
			return OpenCSVBuilder.readData(reader, className);
		} 
		catch (NoSuchFileException e) {
			throw new ExceptionStateCensus(CensusExceptionType.WRONG_FILE_NAME,
					"no such file exists at given file location");
		} catch (IOException e) {
			throw new ExceptionStateCensus(CensusExceptionType.OTHER_IO_EXCEPTION,
					"some other file exception other than wrong name");
		}
	}
}

//