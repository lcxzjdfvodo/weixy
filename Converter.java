package com.DES.converterabstract;

import com.DES.Matrix.Matrix;

public class Converter {
	char[] plaintextArrayAfterConvert;
	private String plaintext;
	public String matrixvalue = null;
	
	public Converter(String plaintext){
		this.plaintext = plaintext;
	}
	
	public String convert(){
		String plainTextAfterRegex = generatePlaintextWithoutBlank(plaintext);
		char[] plaintextArray = plainTextAfterRegex.toCharArray();
		Matrix matrix = new Matrix(matrixvalue);
		int[] matrixArrayOfInt = matrix.getMatrixArrayOfInt();
		String resultByConvert = "";
		plaintextArrayAfterConvert = new char[matrixArrayOfInt.length];
		
		


		for(int i=0;i<matrixArrayOfInt.length;i++){//���ݾ������б任
			plaintextArrayAfterConvert[i] = plaintextArray[matrixArrayOfInt[i]-1];
		}
		
		for(int i = 0 ; i < plaintextArrayAfterConvert.length;i++){//����任��Ľ��
			resultByConvert += plaintextArrayAfterConvert[i];
		}

		return resultByConvert;
	}
	
	
	public String generatePlaintextWithoutBlank(String plaintext){//�������еĿո�ȥ��
		String plainTextAfterRegex =  plaintext.trim().replaceAll("\\s+", "");
		return plainTextAfterRegex;
	}
	
	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}
	
}
