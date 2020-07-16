package com.DES.converter;

public class _16TransfromTo2 {
	String _16BinaryContent;


	public _16TransfromTo2(String _16content) {
		this._16BinaryContent = _16content;
	}
	
	public String transform(){
		String _2BinaryContent = "";
		for(int i = 0;i < _16BinaryContent.length(); i++){
			char word = _16BinaryContent.charAt(i);
			_2BinaryContent += match16Binarywith2Binary(word);
		}
		return _2BinaryContent;
	}
	
	public String match16Binarywith2Binary(char word){
			String _2binarycontent = "";
		if(word == '0'){
			_2binarycontent = "0000";
		}else if(word == '1'){
			_2binarycontent = "0001";
		}else if(word == '2'){
			_2binarycontent = "0010";
		}else if(word == '3'){
			_2binarycontent = "0011";
		}else if(word == '4'){
			_2binarycontent = "0100";
		}else if(word == '5'){
			_2binarycontent = "0101";
		}else if(word == '6'){
			_2binarycontent = "0110";
		}else if(word == '7'){
			_2binarycontent = "0111";
		}else if(word == '8'){
			_2binarycontent = "1000";
		}else if(word == '9'){
			_2binarycontent = "1001";
		}else if(word == 'a' || word == 'A'){
			_2binarycontent = "1010";
		}else if(word == 'b' || word == 'B'){
			_2binarycontent = "1011";
		}else if(word == 'c' || word == 'C'){
			_2binarycontent = "1100";
		}else if(word == 'd' || word == 'D'){
			_2binarycontent = "1101";
		}else if(word == 'e' || word == 'E'){
			_2binarycontent = "1110";
		}else if(word == 'f' || word == 'F'){
			_2binarycontent = "1111";
		}else{
			_2binarycontent = "+";
		}
		return _2binarycontent;
	}
	
	
	public String get_16content() {
		return _16BinaryContent;
	}

	public void set_16content(String _16content) {
		this._16BinaryContent = _16content;
	}

}
