package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class IPconverter extends Converter{

	public IPconverter(String plaintext) {
		super(plaintext);
		this.matrixvalue = Matrix.IPmatrix;
		
	}
	
}
