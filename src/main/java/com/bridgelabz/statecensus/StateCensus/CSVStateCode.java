package com.bridgelabz.statecensus.StateCensus;


	import com.opencsv.bean.CsvBindByName;

	public class CSVStateCode {
		@CsvBindByName(column="SrNO",required = true)
		private static String serialNo;
		@CsvBindByName(column="State Name", required = true)
		private static String stateName;
		@CsvBindByName(column="TIN", required = true)
		private static String tinNumber;
		@CsvBindByName(column="StateCode", required = true)
		private static String stateCode;
		
				@Override
	    public String toString() {
	        return  "SerialNumber =" + serialNo +  
	                ", State=" + stateName +
	                ", TIN=" + tinNumber  +
                ", StateCode=" + stateCode ;
	    }


		}


