package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.bridgelabz.statecensus.StateJAR.BuilderFactoryCSV;
import com.bridgelabz.statecensus.StateJAR.ExceptionStateCensus;
import com.bridgelabz.statecensus.StateJAR.ICSVBuilder;
import com.opencsv.exceptions.CsvException;


public class StateAnalyzer {
	static int count = 0;

	public int loadCensusData(String filePath) throws ExceptionStateCensus, CsvException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder csvBuilder = BuilderFactoryCSV.generateBuilder();
			Iterator<CSVStateCensus> iterator = csvBuilder.getIterator(reader, CSVStateCensus.class);
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
			String line = "";
			int count = 0;
			while ((line = bufferReader.readLine()) != null) {
				String[] headers = line.split(",");
				if (count != 0 && (headers[0].equals("") || headers[1].equals("") || headers[2].equals(""))
						&& !headers[3].equals("'"))				
				{
					throw new ExceptionStateCensus("Invalid delimiter  in StateCensus file", ExceptionStateCensus.ExceptionType.INVALID_DELIMITER);
				}
				if (count == 0 && ((!headers[0].equals("State") || !headers[1].equals("Population")
						|| !headers[2].equals("AreaInSqKm") || !headers[3].equals("DensityPerSqKm"))))
				{
						throw new ExceptionStateCensus("Invalid header is there in StateCensus CSV file", ExceptionStateCensus.ExceptionType.INVALID_HEADER);
				}
					count++;
				}
				bufferReader.close();
				return this.getCount(iterator);
		} catch (IOException e) {
			throw new ExceptionStateCensus("Invalid file path or file type for StateCensus CSV file ",
					ExceptionStateCensus.ExceptionType.INVALID_FILE_PATH);
		} catch (IllegalStateException a) {
			throw new ExceptionStateCensus("Incorrect class type for StateCensus ",
					ExceptionStateCensus.ExceptionType.INVALID_CLASS_TYPE);
		}
	}


	public int loadCodeData(String filePath) throws ExceptionStateCensus, CsvException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder csvBuilder = BuilderFactoryCSV.generateBuilder();
			Iterator<CSVStateCode> iterator = csvBuilder.getIterator(reader, CSVStateCode.class);
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
			String line = "";
			int count = 0;
			while ((line = bufferReader.readLine()) != null) {
					String[] headers = line.split(",");
					System.out.println(line);
										
					if (count != 0 && (headers[0].equals("") || headers[1].equals("") || headers[2].equals(""))
							&& !headers[3].equals("'"))				
					{
						throw new ExceptionStateCensus("Invalid delimiter  in StateCode file", ExceptionStateCensus.ExceptionType.INVALID_DELIMITER);
					}
					if (count ==0
							&& (!headers[0].equals("SrNo") || !headers[1].equals("State Name")
									|| !headers[2].equals("TIN") || !headers[3].equals("StateCode")))
						{
						throw new ExceptionStateCensus("Invalid header In State Code CSV File",
								ExceptionStateCensus.ExceptionType.INVALID_HEADER);
						}
					count++;
				}
			bufferReader.close();
			return this.getCount(iterator);
		} catch (IOException e) {
			throw new ExceptionStateCensus("Invalid File Path  or file type  For StatecodeCSV file",
					ExceptionStateCensus.ExceptionType.INVALID_FILE_PATH);
		} catch (IllegalStateException e) {
			throw new ExceptionStateCensus("Invalid Class Type for Statecode",
					ExceptionStateCensus.ExceptionType.INVALID_CLASS_TYPE);
		}
		
	}

	private <E> int getCount(Iterator<E> iterator) {
		int entries = 0;
		while (iterator.hasNext()) {
			entries++;
			E censusData = iterator.next();
		}
		return entries;
	}
	}

