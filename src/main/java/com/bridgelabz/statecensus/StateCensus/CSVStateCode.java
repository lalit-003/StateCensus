package com.bridgelabz.statecensus.StateCensus;


	import com.opencsv.bean.CsvBindByName;

	public class CSVStateCode {
		@CsvBindByName(column="SrNO", required = true)
		private static String serialNo;
		@CsvBindByName(column="State Name", required = true)
		private static String stateName;
		@CsvBindByName(column="TIN", required = true)
		private static String tinNumber;
		@CsvBindByName(column="StateCode", required = true)
		private static String stateCode;
		
		public  static String getSerialNO() {
			return serialNo;
		}
		public void setSerialNo(String serialNo) {
			this.serialNo = serialNo;
		}
		public static String getStateName() {
			return stateName;
		}
		public void setStateName(String state) {
			this.stateName = state;
		}
		public static String getTinNumber() {
			return tinNumber;
		}
		public void setTinNumber(String tinNumber) {
			this.tinNumber = tinNumber;
		}
		public static String getStateCode() {
			return stateCode;
		}
		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}
	   
		@Override
	    public String toString() {
	        return  "SerialNumber =" + serialNo +  
	                ", State=" + stateName +
	                ", TIN=" + tinNumber  +
                ", StateCode=" + stateCode ;
	    }


		}


