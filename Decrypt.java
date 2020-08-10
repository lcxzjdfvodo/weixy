package com.DES.operation;
//整体的DES加密操作过程

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
		DealWithKey dwkey = new DealWithKey(key);//创建处理密码的对象，在构造函数中已经把64位key处理为58位key，初始密钥
		
		String resultByIp = new IPconverter(plaintext).convert();//IP变换
		String[] resultByDivide = new IpResultDivider(resultByIp).divide();//将IP变换的结果分为两个32位的二进制
		String leftresult = resultByDivide[0];//IP变换后得到的左边值，初始值
		String rightresult = resultByDivide[1];//IP变换后得到的右边值，初始值
		
		groundresult = "初始明文为："+ming1+"\n"+"初始密钥为："+k2+"\n";
		groundresult += "明文转换为二进制的结果：\n"+plaintext+"\n"+"密钥转换为二进制的结果为：\n"+key+"\n";
		groundresult += "明文在经过IP变换后的结果：\n"+resultByIp+"\n";
		groundresult += "分为左右两部分为：\n";
		groundresult += "左边值:"+leftresult+"    位数"+leftresult.length()+"\n";
		groundresult += "右边值:"+rightresult+"    位数"+rightresult.length()+"\n";
		groundresult += "\n";
		operation(leftresult, rightresult,dwkey);
	}
	
	public void operation(String leftvalue,String rightvalue,DealWithKey dwKey){
		String Eresult = new Econverter(rightvalue).convert();//对拆分后的右边值做E变换
		groundresult += "第"+i+"轮R进行E变换后结果为：\n"+Eresult+"    位数为："+Eresult.length()+"\n";
		groundresult += "第"+i+"次 加密，移位次数为："+dwKey.numOfDisplcae(i)+"\n";
		a[i-1]=dwKey.PC_2Convert(dwKey.numOfDisplcae(i));//通过移位次数生产这一轮的密钥，参数就是移位次数
		System.out.println(a[i-1]);
		//a[i-1]=dwKey.PC_2Convert(dwKey.numOfDisplcae(i));
		
		groundresult += "第"+i+"轮子密钥为：\n"+a[i-1]+"" +
				"    位数为："+a[i-1].length()+"\n";
		String keyresult = dwKey.dispose(Eresult);//构造函数中应该放入密码，方法参数是匹配密码的值,最终返回密码与明文的异或值。
		groundresult += "第"+i+"轮异或后结果为：\n"+keyresult+"    位数为："+keyresult.length()+"\n";
		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();//将结果分为八部分，每部分6位
		
		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();//获取到s盒中的八个矩阵,它们以二维表的形式存储并放入list中
		
		String _32bitresult = new Match(_8parts,boxList).generate32bitAfterSbox();//通过s盒获取了32位信息
		groundresult += "第"+i+"轮S盒置换后结果为：\n"+_32bitresult+"    位数为："+_32bitresult.length()+"\n";
		
		String resultByPconvert = new Pconverter(_32bitresult).convert();//将32位通过P矩阵转换为新的32位
		groundresult += "第"+i+"轮P置换后结果为：\n"+resultByPconvert+"    位数为："+resultByPconvert.length()+"\n";
		
		String resultByXOR = new XORoperation(leftvalue,resultByPconvert).generateTheResult();//异或后得到右边值
		groundresult += "第"+i+"轮与左边值进行异或结果为：\n"+resultByXOR+"    位数为："+resultByXOR.length()+"\n";
		
		String leftvalueAfterAground = rightvalue;//第一轮后得到左边值
		String rightvalueAfterAground = resultByXOR;
		if(i == 16){
			groundresult += "第"+i+"轮后左边的值为:\n"+resultByXOR+"    位数"+resultByXOR.length()+"\n";
			groundresult += "第"+i+"轮后右边的值为:\n"+leftvalueAfterAground+"    位数"+leftvalueAfterAground.length()+"\n";
			groundresult += "\n";
		}else {
			groundresult += "第"+i+"轮后左边的值为:\n"+leftvalueAfterAground+"    位数"+leftvalueAfterAground.length()+"\n";
			groundresult += "第"+i+"轮后右边的值为:\n"+resultByXOR+"    位数"+resultByXOR.length()+"\n";
			groundresult += "\n";
		}
		if(i<16){
			i++;
			operation(leftvalueAfterAground, rightvalueAfterAground, dwKey);
		}else {
			String finalresult = rightvalueAfterAground+leftvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();//进行IP逆变换
			groundresult += "第16轮后最终值为: \n"+finalresult+"\n";
			groundresult+="经过IP逆变换后的结果为：\n";
			groundresult+=result+"\n";
			this.finalresult = result;
		}
	}
}
