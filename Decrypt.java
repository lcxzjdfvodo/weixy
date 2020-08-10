package com.DES.operation;
//�����DES���ܲ�������

import java.util.List;

import javax.swing.JTextField;

import com.DES.converter.Box;
import com.DES.converter.DealWithKey;
import com.DES.converter.Econverter;
import com.DES.converter.IPconverter;
import com.DES.converter.IPinverseConverter;
import com.DES.converter.IpResultDivider;
import com.DES.converter.Match;
import com.DES.converter.Pconverter;
import com.DES.converter.SboxConverter;
import com.DES.converter.XORoperation;

public class Decrypt{
	public  static String key ;
	public static String plaintext ;
	public static String groundresult;
    
	public static String[] a=new String[]{"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
	
	int i=1;
	public static String finalresult;
	
	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Decrypt.key = key;
	}

	public static String getPlaintext() {
		return plaintext;
	}

	public static void setPlaintext(String plaintext) {
		Decrypt.plaintext = plaintext;
	}

	public void luanch(){
		String ming1=Transform.convertBinToHex(plaintext);
		String k2=Transform.convertBinToHex(key);
		DealWithKey dwkey = new DealWithKey(key);//������������Ķ����ڹ��캯�����Ѿ���64λkey����Ϊ58λkey����ʼ��Կ
		
		String resultByIp = new IPconverter(plaintext).convert();//IP�任
		String[] resultByDivide = new IpResultDivider(resultByIp).divide();//��IP�任�Ľ����Ϊ����32λ�Ķ�����
		String leftresult = resultByDivide[0];//IP�任��õ������ֵ����ʼֵ
		String rightresult = resultByDivide[1];//IP�任��õ����ұ�ֵ����ʼֵ
		
		groundresult = "��ʼ����Ϊ��"+ming1+"\n"+"��ʼ��ԿΪ��"+k2+"\n";
		groundresult += "����ת��Ϊ�����ƵĽ����\n"+plaintext+"\n"+"��Կת��Ϊ�����ƵĽ��Ϊ��\n"+key+"\n";
		groundresult += "�����ھ���IP�任��Ľ����\n"+resultByIp+"\n";
		groundresult += "��Ϊ����������Ϊ��\n";
		groundresult += "���ֵ:"+leftresult+"    λ��"+leftresult.length()+"\n";
		groundresult += "�ұ�ֵ:"+rightresult+"    λ��"+rightresult.length()+"\n";
		groundresult += "\n";
		operation(leftresult, rightresult,dwkey);
	}
	
	public void operation(String leftvalue,String rightvalue,DealWithKey dwKey){
		String Eresult = new Econverter(rightvalue).convert();//�Բ�ֺ���ұ�ֵ��E�任
		groundresult += "��"+i+"��R����E�任����Ϊ��\n"+Eresult+"    λ��Ϊ��"+Eresult.length()+"\n";
		groundresult += "��"+i+"�� ���ܣ���λ����Ϊ��"+dwKey.numOfDisplcae(i)+"\n";
		a[i-1]=dwKey.PC_2Convert(dwKey.numOfDisplcae(i));//ͨ����λ����������һ�ֵ���Կ������������λ����
		System.out.println(a[i-1]);
		//a[i-1]=dwKey.PC_2Convert(dwKey.numOfDisplcae(i));
		
		groundresult += "��"+i+"������ԿΪ��\n"+a[i-1]+"" +
				"    λ��Ϊ��"+a[i-1].length()+"\n";
		String keyresult = dwKey.dispose(Eresult);//���캯����Ӧ�÷������룬����������ƥ�������ֵ,���շ������������ĵ����ֵ��
		groundresult += "��"+i+"��������Ϊ��\n"+keyresult+"    λ��Ϊ��"+keyresult.length()+"\n";
		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();//�������Ϊ�˲��֣�ÿ����6λ
		
		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();//��ȡ��s���еİ˸�����,�����Զ�ά�����ʽ�洢������list��
		
		String _32bitresult = new Match(_8parts,boxList).generate32bitAfterSbox();//ͨ��s�л�ȡ��32λ��Ϣ
		groundresult += "��"+i+"��S���û�����Ϊ��\n"+_32bitresult+"    λ��Ϊ��"+_32bitresult.length()+"\n";
		
		String resultByPconvert = new Pconverter(_32bitresult).convert();//��32λͨ��P����ת��Ϊ�µ�32λ
		groundresult += "��"+i+"��P�û�����Ϊ��\n"+resultByPconvert+"    λ��Ϊ��"+resultByPconvert.length()+"\n";
		
		String resultByXOR = new XORoperation(leftvalue,resultByPconvert).generateTheResult();//����õ��ұ�ֵ
		groundresult += "��"+i+"�������ֵ���������Ϊ��\n"+resultByXOR+"    λ��Ϊ��"+resultByXOR.length()+"\n";
		
		String leftvalueAfterAground = rightvalue;//��һ�ֺ�õ����ֵ
		String rightvalueAfterAground = resultByXOR;
		if(i == 16){
			groundresult += "��"+i+"�ֺ���ߵ�ֵΪ:\n"+resultByXOR+"    λ��"+resultByXOR.length()+"\n";
			groundresult += "��"+i+"�ֺ��ұߵ�ֵΪ:\n"+leftvalueAfterAground+"    λ��"+leftvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}else {
			groundresult += "��"+i+"�ֺ���ߵ�ֵΪ:\n"+leftvalueAfterAground+"    λ��"+leftvalueAfterAground.length()+"\n";
			groundresult += "��"+i+"�ֺ��ұߵ�ֵΪ:\n"+resultByXOR+"    λ��"+resultByXOR.length()+"\n";
			groundresult += "\n";
		}
		if(i<16){
			i++;
			operation(leftvalueAfterAground, rightvalueAfterAground, dwKey);
		}else {
			String finalresult = rightvalueAfterAground+leftvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();//����IP��任
			groundresult += "��16�ֺ�����ֵΪ: \n"+finalresult+"\n";
			groundresult+="����IP��任��Ľ��Ϊ��\n";
			groundresult+=result+"\n";
			this.finalresult = result;
		}
	}
}
