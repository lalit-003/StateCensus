package com.bridgelabz.statecensus.StateCensus;


	import com.opencsv.bean.CsvBindByName;

	public class CSVStateCode {
		@CsvBindByName(column="SrNO", required = true)
		private String serialNo;
		@CsvBindByName(column="State Name", required = true)
		private String stateName;
		@CsvBindByName(column="TIN", required = true)
		private String tinNumber;
		@CsvBindByName(column="StateCode", required = true)
		private String stateCode;
		
		public String getSerialNO() {
			return serialNo;
		}
		public void setSerialNo(String serialNo) {
			this.serialNo = serialNo;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String state) {
			this.stateName = state;
		}
		public String getTinNumber() {
			return tinNumber;
		}
		public void setTinNumber(String tinNumber) {
			this.tinNumber = tinNumber;
		}
		public String getStateCode() {
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


