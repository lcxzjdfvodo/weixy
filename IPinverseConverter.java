package com.DES.converter;

import com.DES.Matrix.Matrix;
import com.DES.converterabstract.Converter;

public class IPinverseConverter extends Converter{

	public IPinverseConverter(String plaintext) {
		super(plaintext);
		// TODO Auto-generated constructor stub
		this.matrixvalue = Matrix.IPInverseMatrix;
	}

}
