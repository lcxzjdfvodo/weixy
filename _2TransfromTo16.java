package com.DES.converter;

public class _2TransfromTo16 {
	String _2BinaryContent;


	public _2TransfromTo16(String _2content) {
		this._2BinaryContent = _2content;
	}
	
	public String transform(){
		String _16BinaryContent = "";
		for(int i = 0;i < (_2BinaryContent.length()/4); i++){
			String each_16Binary = _2BinaryContent.substring(i*4, (i+1)*4);
//System.out.println(each_16Binary);
			_16BinaryContent += match2Binarywith16Binary(each_16Binary);
			
		}
		return _16BinaryContent;
	}
	
	public char match2Binarywith16Binary(String _4words){
			char word = 0;
			if(_4words.equals("0000")){
				word = '0';
			}else if(_4words.equals("0001")){
				word = '1';
			}else if(_4words.equals("0010")){
				word = '2';
			}else if(_4words.equals("0011")){
				word = '3';
			}else if(_4words.equals("0100")){
				word = '4';
			}else if(_4words.equals("0101")){
				word = '5';
			}else if(_4words.equals("0110")){
				word = '6';
			}else if(_4words.equals("0111")){
				word = '7';
			}else if(_4words.equals("1000")){
				word = '8';
			}else if(_4words.equals("1001")){
				word = '9';
			}else if(_4words.equals("1010")){
				word = 'A';
			}else if(_4words.equals("1011")){
				word = 'B';
			}else if(_4words.equals("1100")){
				word = 'C';
			}else if(_4words.equals("1101")){
				word = 'D';
			}else if(_4words.equals("1110")){
				word = 'E';
			}else if(_4words.equals("1111")){
				word = 'F';
			}
			return word;
	}
	
	
	public String get_16content() {
		return _2BinaryContent;
	}

	public void set_16content(String _16content) {
		this._2BinaryContent = _16content;
	}

}
