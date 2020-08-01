package com.DES.converter;

public class SboxConverter {
	String valueByCompareKey;
	String[] resultOf8Parts;
	public SboxConverter(String valueByCompareKey){
		this.valueByCompareKey = valueByCompareKey;
	}
	
	public String[] divideTo8Parts(){//把48位分隔为8分
		int numberOfParts = 8;
		resultOf8Parts = new String[numberOfParts];
//System.out.println(valueByCompareKey.length());
		
		for(int i = 0;i < numberOfParts;i++){
			resultOf8Parts[i] = valueByCompareKey.substring(i*6, (i+1)*6);
		}
		return resultOf8Parts;
	}
	
	
	public String boxConvert(){
		
		return null;
	}
	
}












