package com.DES.converter;

public class IpResultDivider {
	private String resultByIpConvert;
	
	public IpResultDivider(String resultByIpConvert){
		this.resultByIpConvert = resultByIpConvert;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String result = new IPconverter().
		
	}
	
	public String[] divide(){
		String[] resultByDivide = new String[2];
		int middleIndex = (resultByIpConvert.length())/2;
		int lastIndex = resultByIpConvert.length();
		String leftValue = resultByIpConvert.substring(0, middleIndex);
		String rightValue = resultByIpConvert.substring(middleIndex, lastIndex);
		resultByDivide[0] = leftValue;
		resultByDivide[1] = rightValue;
		return resultByDivide;
	}
	

}
