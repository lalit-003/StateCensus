package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.CensusExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder {

	public static <E> int readData(Reader reader, E className) throws ExceptionStateCensus {
		try
		{
		CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
				                               .withType(CSVStateCensus.class)
				                               .withIgnoreLeadingWhiteSpace(true)
				                               .build();

		BufferedReader bufferReader = new BufferedReader(reader);
		String line = "";
		int count = 0;
		while ((line = bufferReader.readLine()) != null) {
			System.out.println("state info is :" + line);
			String[] headers = line.split(",");

			if (count != 0 && (headers[0].equals("") || headers[1].equals("") || headers[2].equals(""))
					&& !headers[3].equals("'")) {
				throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
						" dellimeter issue in csv file");
			}
			if (count == 0) {
				if (className.equals(CSVStateCensus.class)
						&& (!headers[0].equals("State") || !headers[1].equals("Population")
								|| !headers[2].equals("AreaInSqKm") || !headers[3].equals("DensityPerSqKm"))) {
					throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
							"Header issue in csv file");
				}
				if (className.equals(CSVStateCode.class)
						&& (!headers[0].equals("SrNo") || !headers[1].equals("State Name") || !headers[2].equals("TIN")
								|| !headers[3].equals("StateCode"))) {
					throw new ExceptionStateCensus(CensusExceptionType.INCORRECT_DATA_IN_FILE_OR_INCORRECT_HEADER,
							"Header issue in csv file");
				}
			}
			count++;
		}
		bufferReader.close();
		// count is decreased because it also includes header count
		return count - 1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
