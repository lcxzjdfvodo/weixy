package com.DES.operation;
//�����DES���ܲ�������

import java.util.List;

import javax.swing.JTextField;

import com.DES.converter.Box;
import com.DES.converter.Econverter;
import com.DES.converter.IPconverter;
import com.DES.converter.IPinverseConverter;
import com.DES.converter.IpResultDivider;
import com.DES.converter.Match;
import com.DES.converter.Pconverter;
import com.DES.converter.SboxConverter;
import com.DES.converter.XORoperation;
import com.DES.converter._2TransfromTo16;

public class Encrypt{
	
	public static void main(String[] args) {
		Encrypt jimi = new Encrypt();
		String miwen = "1111010000000011011110011010101110011110000011101100010100110011";
		String miyao = "0001000100010001000100010001000100010001000100010001000100010001";
		System.out.println(miyao.length());
		jimi.setPlaintext(miwen);
		jimi.setKey(miyao);
		System.out.println(jimi.getKey());
		System.out.println(jimi.getPlaintext().length());
		jimi.luanch();
	}
	public  static String key ;
	public static String plaintext ;
	public static String groundresult;

	int i=1;
	public static String finalresult;
	
	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Encrypt.key = key;
	}

	public static String getPlaintext() {
		return plaintext;
	}

	public static void setPlaintext(String plaintext) {
		Encrypt.plaintext = plaintext;
	}

	public void luanch(){
		String miwen=Transform.convertBinToHex(plaintext);		//��ȡ����
		String k2=Transform.convertBinToHex(key);				//��ȡ��Կ
		String dwkey=Decrypt.a[16-i];		//��ȡ���ܹ��������ɵ���Կ�����ܵ���Կ˳������ܵ���Կ˳���෴
		

		System.out.println("---------------------Jiemi-------------------");
		
		String resultByIp = new IPconverter(plaintext).convert();//�����Ľ���IP�任
		String[] resultByDivide = new IpResultDivider(resultByIp).divide();//��IP�任�Ľ����Ϊ����32λ�Ķ�����
		String rightresult = resultByDivide[0];//��ʼ��ֵʱ��������������Ҫ��������˳�ʼ���ұ�ֵ��IP�任����ߵ�ֵ
		String leftresult = resultByDivide[1];//��ʼ��ֵʱ��������������Ҫ��������˳�ʼ�����ֵ��IP�任���ұߵ�ֵ
		
		groundresult = "����Ϊ��"+miwen+"\n"+"��ʼ��ԿΪ��"+k2+"\n";
		groundresult += "����ת��Ϊ�����ƵĽ����\n"+plaintext+"\n"+"��Կת��Ϊ�����ƵĽ��Ϊ��\n"+key+"\n";
		groundresult += "�����ھ���IP�任��Ľ����\n"+resultByIp+"\n";
		groundresult += "��Ϊ����������Ϊ��\n";
		groundresult += "���ֵ:"+rightresult+"    λ��"+rightresult.length()+"\n";
		groundresult += "�ұ�ֵ:"+leftresult+"    λ��"+leftresult.length()+"\n";
		groundresult += "\n";
//�������ڣ�dealwithkeyֻ��1λ
		operation(leftresult, rightresult,dwkey);
	}
	
	public void operation(String leftvalue,String rightvalue,String dwkey){
		System.out.println("key=="+dwkey);
		String Eresult = new Econverter(leftvalue).convert();//�Բ�ֺ�����ֵ��E�任
		groundresult += "��"+i+"��L����E�任����Ϊ��\n"+Eresult+"    λ��Ϊ��"+Eresult.length()+"\n";
		groundresult += "��"+i+"������ԿΪ��\n"+dwkey+"" +"    λ��Ϊ��"+dwkey.length()+"\n";
		
		System.out.println("����");
		System.out.println(dwkey);
		System.out.println(Eresult);
		System.out.println(dwkey.length());
		
		String keyresult = new XORoperation(dwkey,Eresult).generateTheResult();//��E�任�����ɵĽ��������Կ�������
		groundresult += "��"+i+"��������Ϊ��\n"+keyresult+"    λ��Ϊ��"+keyresult.length()+"\n";
		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();//�������Ϊ�˲��֣�ÿ����6λ
		
		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();//��ȡ��s���еİ˸�����,�����Զ�ά�����ʽ�洢������list��
		
		String _32bitresult = new Match(_8parts,boxList).generate32bitAfterSbox();//ͨ��s�л�ȡ��32λ��Ϣ
		groundresult += "��"+i+"��S���û�����Ϊ��\n"+_32bitresult+"    λ��Ϊ��"+_32bitresult.length()+"\n";
		
		String resultByPconvert = new Pconverter(_32bitresult).convert();//��32λͨ��P����ת��Ϊ�µ�32λ
		groundresult += "��"+i+"��P�û�����Ϊ��\n"+resultByPconvert+"    λ��Ϊ��"+resultByPconvert.length()+"\n";
		
		String resultByXOR = new XORoperation(rightvalue,resultByPconvert).generateTheResult();//����õ��ұ�ֵ
		groundresult += "��"+i+"�����ұ�ֵ���������Ϊ��\n"+resultByXOR+"    λ��Ϊ��"+resultByXOR.length()+"\n";
		
		String leftvalueAfterAground = resultByXOR;//��һ�ֺ�õ����ֵ
		String rightvalueAfterAground = leftvalue;
		if(i == 1){
			groundresult += "��"+i+"�ֺ���ߵ�ֵΪ:\n"+leftvalueAfterAground+"    λ��"+leftvalueAfterAground.length()+"\n";
			groundresult += "��"+i+"�ֺ��ұߵ�ֵΪ:\n"+rightvalueAfterAground+"    λ��"+rightvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}else {
			groundresult += "��"+i+"�ֺ���ߵ�ֵΪ:\n"+leftvalueAfterAground+"    λ��"+leftvalueAfterAground.length()+"\n";
			groundresult += "��"+i+"�ֺ��ұߵ�ֵΪ:\n"+rightvalueAfterAground+"    λ��"+rightvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}
		if(i<16){
			i++;
			dwkey=Decrypt.a[16-i];
			operation(leftvalueAfterAground, rightvalueAfterAground, dwkey);
		}else {
			String finalresult = leftvalueAfterAground+rightvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();//����IP��任
			groundresult += "��16�ֺ�����ֵΪ: \n"+finalresult+"\n";
			groundresult+="����IP��任��Ľ��Ϊ��\n";
			groundresult+=result+"\n";
			this.finalresult = result;
		}
	}
}