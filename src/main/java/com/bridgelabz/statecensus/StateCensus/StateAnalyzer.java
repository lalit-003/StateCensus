package com.bridgelabz.statecensus.StateCensus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.bridgelabz.statecensus.StateCensus.ExceptionStateCensus.ExceptionType;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvException;

public class StateAnalyzer {

	ICSVBuilder csvBuilder = BuilderFactoryCSV.generateBuilder();
	List<CSVStateCensus> listCensus = null;
	List<CSVStateCode> listStateCode = null; 
	
	public int loadCensusData(String filePath) throws ExceptionStateCensus {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			 listCensus = csvBuilder.getList(reader, CSVStateCensus.class);
			int listSize = listCensus.size();
			checkHeaderException(filePath, CSVStateCensus.class);
			return listSize;
		} catch (IOException e) {
			throw new ExceptionStateCensus("Invalid file path or file type for StateCensus CSV file ",
					ExceptionType.INVALID_FILE_PATH);
		} catch (IllegalStateException a) {
			throw new ExceptionStateCensus("Incorrect class type for StateCensus ", ExceptionType.INVALID_CLASS_TYPE);
		}
		catch(RuntimeException a)
		{
			throw new ExceptionStateCensus("Invalid delimiter  in StateCensus file",
					ExceptionType.INVALID_DELIMITER);
		}
	}

	public int loadCodeData(String filePath) throws ExceptionStateCensus {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			 listStateCode = csvBuilder.getList(reader, CSVStateCode.class);
			int listSize = listStateCode.size();
			this.checkHeaderException(filePath, CSVStateCode.class);
			return listSize;
		} catch (IOException e) {
			throw new ExceptionStateCensus("Invalid File Path  or file type  For StatecodeCSV file",
					ExceptionType.INVALID_FILE_PATH);
		} catch (IllegalStateException e) {
			throw new ExceptionStateCensus("Invalid Class Type for Statecode", ExceptionType.INVALID_CLASS_TYPE);
		}

	}
	
	public void checkHeaderException(String filePath,Class className) throws ExceptionStateCensus
	{
		try
		{
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
		String line = "";
		int count = 0;
		while ((line = bufferReader.readLine()) != null) {
			String[] headers = line.split(",");
			if (count != 0 && (headers[0].equals("") || headers[1].equals("") || headers[2].equals("") || headers[3].equals("")))
						{
				throw new ExceptionStateCensus("Invalid delimiter  in StateCensus file",
						ExceptionType.INVALID_DELIMITER);
			}
			if (count == 0 && ((className.equals(CSVStateCensus.class ) &&  ((!headers[0].equals("State") || !headers[1].equals("Population")
					|| !headers[2].equals("AreaInSqKm") || !headers[3].equals("DensityPerSqKm")))) || 
					(className.equals(CSVStateCode.class) &&  (!headers[0].equals("SrNo") || !headers[1].equals("State Name")
							|| !headers[2].equals("TIN") || !headers[3].equals("StateCode"))))) {
				throw new ExceptionStateCensus("Invalid header is there in StateCensus CSV file",
						ExceptionType.INVALID_HEADER);
			}
			count++;
		}
		bufferReader.close();
		}
		catch (IOException e)
		{
			System.out.println("IO Exception with message :"+e.getMessage());
		}
			}


	private <E> int getCount(Iterator<E> iterator) {
		int entries = 0;
		while (iterator.hasNext()) {
			entries++;
			E entry = iterator.next();
		}
		return entries;
	}

	public String getStateWiseSortedCensusData(String filePath) throws ExceptionStateCensus {
		// TODO Auto-generated method stub
		if(listCensus==null || listCensus.size()==0)
		{
			throw new ExceptionStateCensus("Empty state census list", ExceptionType.NO_CENSUS_DATA);
		}
			Comparator<CSVStateCensus> csvStateCensusComparator = Comparator.comparing(census ->census.getStateName());
			this.sortStateCensus(csvStateCensusComparator);
			String sortedStateCensusJson = new Gson().toJson(listCensus);
			return sortedStateCensusJson;
	}

	private void sortStateCensus( Comparator<CSVStateCensus> csvStateCensusComparator) {
		// TODO Auto-generated method stub
		for (int i=0;i<listCensus.size()-1;i++)
		{
			for(int j=0;j<listCensus.size()-i-1;j++)
			{
				CSVStateCensus census1 = listCensus.get(j);
				CSVStateCensus census2 = listCensus.get(j+1);
				if(csvStateCensusComparator.compare(census1,census2)>0)
				{
					listCensus.set(j, census2);
					listCensus.set(j+1, census1);
				}

			}
		}
	}

	public String getStateCodeWiseSortedCodeData(String stateCode_FilePath) throws ExceptionStateCensus {
		if(listStateCode==null || listStateCode.size()==0)
		{
			throw new ExceptionStateCensus("Empty state census list", ExceptionType.NO_CENSUS_DATA);
		}
			Comparator<CSVStateCode> csvStateCodeComparator = Comparator.comparing(code ->code.getStateCode());
			this.sortStateCode(csvStateCodeComparator);
			String sortedStateCodeJson = new Gson().toJson(listStateCode);
			return sortedStateCodeJson;
	}

	private void sortStateCode(Comparator<CSVStateCode> csvStateCodeComparator) {
		// TODO Auto-generated method stub
		for (int i=0;i<listStateCode.size()-1;i++)
		{
			for(int j=0;j<listStateCode.size()-i-1;j++)
			{
				CSVStateCode code1 = listStateCode.get(j);
				CSVStateCode code2 = listStateCode.get(j+1);
				if(csvStateCodeComparator.compare(code1,code2)>0)
				{
					listStateCode.set(j, code2);
					listStateCode.set(j+1, code1);
				}

			}
		}
			}
}
