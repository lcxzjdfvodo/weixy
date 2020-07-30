package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class PC_2Converter extends Converter{

	public PC_2Converter(String plaintext) {
		super(plaintext);
		// TODO Auto-generated constructor stub
		this.matrixvalue = Matrix.PC_2matrix;
//System.out.println("ÖÃ»»¹¹Ôìº¯Êý");
	}

}
