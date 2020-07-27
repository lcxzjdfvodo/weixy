package com.DES.converter;

import java.util.List;

public class Match {
	String[] _8parts;
	List boxList;
	
	public Match(String[] _8parts,List boxList){
		this._8parts = _8parts;
		this.boxList = boxList;
	}
	
	public String generate32bitAfterSbox(){
		String resultAfterSbox = "";
		if(_8parts.length != boxList.size()){
			System.out.println("S盒数与结果个数不匹配，");
		}else{
			for(int i = 0;i < _8parts.length;i++){
				resultAfterSbox += generateEachBoxMessage(_8parts[i], (int[][])boxList.get(i));
			}
		}
		return resultAfterSbox;
	}
	
	
	public String generateEachBoxMessage(String messageOf6bit,int [][] boxMatrix){
		int linenum = matchline(messageOf6bit);
		int indexOfline = matchIndexOfOneLine(messageOf6bit);
		int result = boxMatrix[linenum][indexOfline];
		
		return matchBoxValueTo4bit(result);
	}
	
	
	public String matchBoxValueTo4bit(int boxValue){
		String result = null;
		if(boxValue == 0){
			result = "0000";
		} else if(boxValue == 1){
			result = "0001";
		}else if(boxValue == 2){
			result = "0010";
		}else if(boxValue == 3){
			result = "0011";
		}else if(boxValue == 4){
			result = "0100";
		}else if(boxValue == 5){
			result = "0101";
		}else if(boxValue == 6){
			result = "0110";
		}else if(boxValue == 7){
			result = "0111";
		}else if(boxValue == 8){
			result = "1000";
		}else if(boxValue == 9){
			result = "1001";
		}else if(boxValue == 10){
			result = "1010";
		}else if(boxValue == 11){
			result = "1011";
		}else if(boxValue == 12){
			result = "1100";
		}else if(boxValue == 13){
			result = "1101";
		}else if(boxValue == 14){
			result = "1110";
		}else if(boxValue == 15){
			result = "1111";
		}
		
		return result;
	}
	

	public int matchline(String messageOf6bit){//把二进制进行转换，得到盒匹配所需定位的行
		String lineMessage = messageOf6bit.substring(0, 1)+messageOf6bit.substring(messageOf6bit.length()-1, messageOf6bit.length());
		int line = 0;
		if(lineMessage.equals("00")){
			line = 0;
		}else if(lineMessage.equals("01")){
			line = 1;
		}else if(lineMessage.equals("10")){
			line = 2;
		}else if(lineMessage.equals("11")){
			line = 3;
		}
		return line;
	}
	
	
	public int matchIndexOfOneLine(String messageOf6bit){//把二进制转换，得到盒匹配所需定位的行的个数
		String indexOfline = messageOf6bit.substring(1, messageOf6bit.length()-1);
		int index = 0;
		if(indexOfline.equals("0000")){
			index = 0;
		}else if(indexOfline.equals("0001")){
			index = 1;
		}else if(indexOfline.equals("0010")){
			index = 2;
		}else if(indexOfline.equals("0011")){
			index = 3;
		}else if(indexOfline.equals("0100")){
			index = 4;
		}else if(indexOfline.equals("0101")){
			index = 5;
		}else if(indexOfline.equals("0110")){
			index = 6;
		}else if(indexOfline.equals("0111")){
			index = 7;
		}else if(indexOfline.equals("1000")){
			index = 8;
		}else if(indexOfline.equals("1001")){
			index = 9;
		}else if(indexOfline.equals("1010")){
			index = 10;
		}else if(indexOfline.equals("1011")){
			index = 11;
		}else if(indexOfline.equals("1100")){
			index = 12;
		}else if(indexOfline.equals("1101")){
			index = 13;
		}else if(indexOfline.equals("1110")){
			index = 14;
		}else if(indexOfline.equals("1111")){
			index = 15;
		}
		
		return index;
	}
	
	
	
}
