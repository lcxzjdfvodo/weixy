package com.DES.converter;

import com.DES.operation.Operate;

public class DealWithKey {
	private String key;
	
	private String _56bitKey;
	private String resultByPC_2;
	
	public DealWithKey(String key) {
		this.key = key;
		_56bitKey = new PC_1Converter(key).convert();//�û�һ����64λ��Ϊ56λ
	}
	
	
	
	
	
	public String get_56bitKey(){//PC1�û��õ�56λ���
		return _56bitKey;
	}
	
	
	public String[] divideTo2Parts(){
		String[] twoPartsOfKey = new String[2];
		String resultByPC_1 = get_56bitKey();
		twoPartsOfKey[0] = resultByPC_1.substring(0, resultByPC_1.length()/2);
		twoPartsOfKey[1] = resultByPC_1.substring(resultByPC_1.length()/2, resultByPC_1.length());
		
		return twoPartsOfKey;
		
	}
	
	
	public String PC_2Convert(int displace){//ͨ���û�ѡ��ת��Ϊ48λ��Կ
//System.out.println("ÿһ�����û�");		
		String[] resultByDisplace = resultByDisplace(displace);
		String resultbydisplace = resultByDisplace[0]+resultByDisplace[1];
		String resultByPC_2 = new PC_2Converter(resultbydisplace).convert();//ͨ���û�2ת��Ϊһ��48λ����Կ
		this.resultByPC_2 = resultByPC_2;
//System.out.println("ÿһ��48λ��Կ:"+resultByPC_2+"λ��:"+resultByPC_2.length());
			Operate.groundresult += "ÿһ��48λ��Կ:"+resultByPC_2+"λ��:"+resultByPC_2.length()+"\n";
		return resultByPC_2;
		
	}

	
	public String[] resultByDisplace(int displacenum){//�ڶ�����������λ�ĸ���
		String[] twoPartsOfKey = divideTo2Parts();
		String left28bitkey = twoPartsOfKey[0];
		String right28bitkey = twoPartsOfKey[1];
		
		String left_tail = "";
		String right_tail = "";
		
		for(int i=0;i<displacenum;i++ ){
			left_tail += left28bitkey.charAt(i);
			right_tail += right28bitkey.charAt(i);
		}
		
		left28bitkey = left28bitkey.substring(displacenum, left28bitkey.length())+ left_tail;
		right28bitkey = right28bitkey.substring(displacenum, right28bitkey.length())+right_tail;
		String[] resultByDisplace = new String[2];
		resultByDisplace[0] = left28bitkey;
		resultByDisplace[1] = right28bitkey;
		_56bitKey = left28bitkey+right28bitkey;
//System.out.println("��ǰ��56λ��Կ�ǣ�"+_56bitKey);	
		
		
		return resultByDisplace;
	}
	
	
	public String dispose(String value) {//�õ����������48λ���
		String result = "";
		if (value.length() != resultByPC_2.length()) {
			System.out.println("���볤�Ȳ�ƥ��");

		} else {
			for (int i = 0; i < value.length(); i++) {
				result += XOR(value.charAt(i), resultByPC_2.charAt(i));
			}

		}
		
		return result;
	}

	public char XOR(char valuechar, char keychar) {//�������
		if (valuechar == keychar) {
			return '0';
		} else {
			return '1';
		}
	}
	
	
	public int numOfDisplcae(int i){
		int num = 0;
		if(i == 1){
			num = 1;
		}else if(i == 2){
			num = 1;
		}else if(i == 3){
			num = 2;
		}else if(i == 4){
			num = 2;
		}else if(i == 5){
			num = 2;
		}else if(i == 6){
			num = 2;
		}else if(i == 7){
			num = 2;
		}else if(i == 8){
			num = 2;
		}else if(i == 9){
			num = 1;
		}else if(i == 10){
			num = 2;
		}else if(i == 11){
			num = 2;
		}else if(i == 12){
			num = 2;
		}else if(i == 13){
			num = 2;
		}else if(i == 14){
			num = 2;
		}else if(i == 15){
			num = 2;
		}else if(i == 16){
			num = 1;
		}
		
		return num;
	}
	
	
	
}
