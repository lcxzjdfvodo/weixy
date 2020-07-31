package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class Pconverter extends Converter{

	String messageForPconvert;
	
	public Pconverter(String plaintext) {
		// TODO Auto-generated constructor stub
		super(plaintext);
		this.matrixvalue = Matrix.Pmatrix;
	}
	
	
	
}
