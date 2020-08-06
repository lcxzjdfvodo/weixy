package com.DES.operation;
//整体的DES加密操作过程

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
		String miwen=Transform.convertBinToHex(plaintext);		//获取密文
		String k2=Transform.convertBinToHex(key);				//获取密钥
		String dwkey=Decrypt.a[16-i];		//获取加密过程中生成的密钥，解密的密钥顺序与加密的密钥顺序相反
		

		System.out.println("---------------------Jiemi-------------------");
		
		String resultByIp = new IPconverter(plaintext).convert();//对密文进行IP变换
		String[] resultByDivide = new IpResultDivider(resultByIp).divide();//将IP变换的结果分为两个32位的二进制
		String rightresult = resultByDivide[0];//初始赋值时将左右两边数据要交换，因此初始的右边值是IP变换后左边的值
		String leftresult = resultByDivide[1];//初始赋值时将左右两边数据要交换，因此初始的左边值是IP变换后右边的值
		
		groundresult = "密文为："+miwen+"\n"+"初始密钥为："+k2+"\n";
		groundresult += "密文转换为二进制的结果：\n"+plaintext+"\n"+"密钥转换为二进制的结果为：\n"+key+"\n";
		groundresult += "密文在经过IP变换后的结果：\n"+resultByIp+"\n";
		groundresult += "分为左右两部分为：\n";
		groundresult += "左边值:"+rightresult+"    位数"+rightresult.length()+"\n";
		groundresult += "右边值:"+leftresult+"    位数"+leftresult.length()+"\n";
		groundresult += "\n";
//问题所在，dealwithkey只有1位
		operation(leftresult, rightresult,dwkey);
	}
	
	public void operation(String leftvalue,String rightvalue,String dwkey){
		System.out.println("key=="+dwkey);
		String Eresult = new Econverter(leftvalue).convert();//对拆分后的左边值做E变换
		groundresult += "第"+i+"轮L进行E变换后结果为：\n"+Eresult+"    位数为："+Eresult.length()+"\n";
		groundresult += "第"+i+"轮子密钥为：\n"+dwkey+"" +"    位数为："+dwkey.length()+"\n";
		
		System.out.println("测试");
		System.out.println(dwkey);
		System.out.println(Eresult);
		System.out.println(dwkey.length());
		
		String keyresult = new XORoperation(dwkey,Eresult).generateTheResult();//对E变换后生成的结果和轮密钥进行异或
		groundresult += "第"+i+"轮异或后结果为：\n"+keyresult+"    位数为："+keyresult.length()+"\n";
		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();//将结果分为八部分，每部分6位
		
		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();//获取到s盒中的八个矩阵,它们以二维表的形式存储并放入list中
		
		String _32bitresult = new Match(_8parts,boxList).generate32bitAfterSbox();//通过s盒获取了32位信息
		groundresult += "第"+i+"轮S盒置换后结果为：\n"+_32bitresult+"    位数为："+_32bitresult.length()+"\n";
		
		String resultByPconvert = new Pconverter(_32bitresult).convert();//将32位通过P矩阵转换为新的32位
		groundresult += "第"+i+"轮P置换后结果为：\n"+resultByPconvert+"    位数为："+resultByPconvert.length()+"\n";
		
		String resultByXOR = new XORoperation(rightvalue,resultByPconvert).generateTheResult();//异或后得到右边值
		groundresult += "第"+i+"轮与右边值进行异或结果为：\n"+resultByXOR+"    位数为："+resultByXOR.length()+"\n";
		
		String leftvalueAfterAground = resultByXOR;//第一轮后得到左边值
		String rightvalueAfterAground = leftvalue;
		if(i == 1){
			groundresult += "第"+i+"轮后左边的值为:\n"+leftvalueAfterAground+"    位数"+leftvalueAfterAground.length()+"\n";
			groundresult += "第"+i+"轮后右边的值为:\n"+rightvalueAfterAground+"    位数"+rightvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}else {
			groundresult += "第"+i+"轮后左边的值为:\n"+leftvalueAfterAground+"    位数"+leftvalueAfterAground.length()+"\n";
			groundresult += "第"+i+"轮后右边的值为:\n"+rightvalueAfterAground+"    位数"+rightvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}
		if(i<16){
			i++;
			dwkey=Decrypt.a[16-i];
			operation(leftvalueAfterAground, rightvalueAfterAground, dwkey);
		}else {
			String finalresult = leftvalueAfterAground+rightvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();//进行IP逆变换
			groundresult += "第16轮后最终值为: \n"+finalresult+"\n";
			groundresult+="经过IP逆变换后的结果为：\n";
			groundresult+=result+"\n";
			this.finalresult = result;
		}
	}
}