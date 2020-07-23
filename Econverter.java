package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class Econverter extends Converter{

	public Econverter(String plaintext) {
		super(plaintext);
		this.matrixvalue = Matrix.Ematrix;
	}
	
	
}
