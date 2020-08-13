package com.DES.operation;

import java.util.List;


import com.DES.Matrix.Matrix;
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

public class Operate {

	public static String key;
	public static String plaintext;
	public static String groundresult = "";

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Operate.key = key;
	}

	public static String getPlaintext() {
		return plaintext;
	}

	public static void setPlaintext(String plaintext) {
		Operate.plaintext = plaintext;
	}

	int i = 1;
	public static String finalresult;

	public static void main(String[] args) {
		new Operate().luanch();

	}

	public void luanch() {

		DealWithKey dwkey = new DealWithKey(key);// ������������Ķ����ڹ��캯�����Ѿ���64λkey����Ϊ58λkey����ʼ��Կ

		String resultByIp = new IPconverter(plaintext).convert();// IP�任

		String[] resultByDivide = new IpResultDivider(resultByIp).divide();// �з�ip�任�Ľ��Ϊ����32λ�Ķ�����

		String leftresult = resultByDivide[0];// p�任��õ������ֵ����ʼֵ
		String rightresult = resultByDivide[1];// p�任��õ����ұ�ֵ����ʼֵ

		Operate test = new Operate();
		test.operation(leftresult, rightresult, dwkey);

	}

	public void operation(String leftvalue, String rightvalue, DealWithKey dwKey) {
		// System.out.println("��"+i+"�� ���ܣ���λ����Ϊ��"+dwKey.numOfDisplcae(i));
		groundresult += "��" + i + "�� ���ܣ���λ����Ϊ��" + dwKey.numOfDisplcae(i) + "\n";
		dwKey.PC_2Convert(dwKey.numOfDisplcae(i));// ͨ����λ����������һ�ֵ���Կ������������λ����

		String Eresult = new Econverter(rightvalue).convert();// �Բ�ֺ���ұ�ֵ��E�任
		String keyresult = dwKey.dispose(Eresult);// ���캯����Ӧ�÷������룬����������ƥ�������ֵ,���շ������������ĵ����ֵ��

		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();// �������Ϊ�˲��֣�ÿ����6λ

		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();// ��ȡ��s���еİ˸�����,�����Զ�ά�����ʽ�洢������list��

		String _32bitresult = new Match(_8parts, boxList)
				.generate32bitAfterSbox();// ͨ��s�л�ȡ��32λ��Ϣ

		String resultByPconvert = new Pconverter(_32bitresult).convert();// ��32λͨ��P����ת��Ϊ�µ�32λ
		String resultByXOR = new XORoperation(leftvalue, resultByPconvert)
				.generateTheResult();// ����õ���һ���ұ�ֵ

		String leftvalueAfterAground = rightvalue;// ��һ�ֺ�õ����ֵ
		String rightvalueAfterAground = resultByXOR;
		if (i == 16) {
			/*
			 * System.out.println("��"+i+"�ֺ���ߵ�ֵΪ:"+resultByXOR+"λ��"+resultByXOR.length
			 * ()); System.out.println("��"+i+"�ֺ��ұߵ�ֵΪ:"+leftvalueAfterAground);
			 * 
			 * System.out.println();
			 */
			groundresult += "��" + i + "�ֺ���ߵ�ֵΪ:" + resultByXOR + "λ��"
					+ resultByXOR.length() + "\n";
			groundresult += "��" + i + "�ֺ��ұߵ�ֵΪ:" + leftvalueAfterAground + "\n";
			groundresult += "\n";
		} else {

			/*
			 * System.out.println("��"+i+"�ֺ���ߵ�ֵΪ:"+leftvalueAfterAground+"λ��"+leftvalueAfterAground
			 * .length()); System.out.println("��"+i+"�ֺ��ұߵ�ֵΪ:"+resultByXOR);
			 * System.out.println();
			 */
			groundresult += "��" + i + "�ֺ���ߵ�ֵΪ:" + leftvalueAfterAground + "λ��"
					+ leftvalueAfterAground.length() + "\n";
			groundresult += "��" + i + "�ֺ��ұߵ�ֵΪ:" + resultByXOR + "\n";
			groundresult += "\n";
		}
		if (i < 16) {
			i++;
			operation(leftvalueAfterAground, rightvalueAfterAground, dwKey);
		} else {

			String finalresult = rightvalueAfterAground + leftvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();// ����ip��任
			// System.out.println("���ս����"+result+"λ����"+result.length());//�ѽ�����������һ�¼���
			this.finalresult = result;

			// return;
		}

	}

}
