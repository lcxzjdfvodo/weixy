package com.DES.converter;

public class XORoperation {
	String rightvalue;
	String leftvalue;
	public XORoperation(String leftvalue,String rightvalue) {
		// TODO Auto-generated constructor stub
		this.rightvalue = rightvalue;
		this.leftvalue = leftvalue;
	}
	
	
	public String generateTheResult(){//得出异或运算结果
		String result = "";
		for(int i = 0; i< rightvalue.length();i++){
			result += XOR(rightvalue.charAt(i),leftvalue.charAt(i));
		}
		return result;
	}
	
	
	public char XOR(char valuechar, char keychar) {//异或运算
		if (valuechar == keychar) {
			return '0';
		} else {
			return '1';
		}
	}
}
