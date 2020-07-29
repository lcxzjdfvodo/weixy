package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class PC_1Converter extends Converter{

	public PC_1Converter(String plaintext) {
		super(plaintext);
		// TODO Auto-generated constructor stub
		this.matrixvalue = Matrix.PC_1matrix;
	}

}
