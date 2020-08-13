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

		DealWithKey dwkey = new DealWithKey(key);// 创建处理密码的对象，在构造函数中已经把64位key处理为58位key，初始密钥

		String resultByIp = new IPconverter(plaintext).convert();// IP变换

		String[] resultByDivide = new IpResultDivider(resultByIp).divide();// 切分ip变换的结果为两个32位的二进制

		String leftresult = resultByDivide[0];// p变换后得到的左边值，初始值
		String rightresult = resultByDivide[1];// p变换后得到的右边值，初始值

		Operate test = new Operate();
		test.operation(leftresult, rightresult, dwkey);

	}

	public void operation(String leftvalue, String rightvalue, DealWithKey dwKey) {
		// System.out.println("第"+i+"次 加密，移位次数为："+dwKey.numOfDisplcae(i));
		groundresult += "第" + i + "次 加密，移位次数为：" + dwKey.numOfDisplcae(i) + "\n";
		dwKey.PC_2Convert(dwKey.numOfDisplcae(i));// 通过移位次数生产这一轮的密钥，参数就是移位次数

		String Eresult = new Econverter(rightvalue).convert();// 对拆分后的右边值做E变换
		String keyresult = dwKey.dispose(Eresult);// 构造函数中应该放入密码，方法参数是匹配密码的值,最终返回密码与明文的与或值。

		String[] _8parts = new SboxConverter(keyresult).divideTo8Parts();// 将结果分为八部分，每部分6位

		Box box = new Box();
		List boxList = box.convertTo2DArraryOfInt();// 获取到s盒中的八个矩阵,它们以二维表的形式存储并放入list中

		String _32bitresult = new Match(_8parts, boxList)
				.generate32bitAfterSbox();// 通过s盒获取了32位信息

		String resultByPconvert = new Pconverter(_32bitresult).convert();// 将32位通过P矩阵转换为新的32位
		String resultByXOR = new XORoperation(leftvalue, resultByPconvert)
				.generateTheResult();// 与或后得到第一轮右边值

		String leftvalueAfterAground = rightvalue;// 第一轮后得到左边值
		String rightvalueAfterAground = resultByXOR;
		if (i == 16) {
			/*
			 * System.out.println("第"+i+"轮后左边的值为:"+resultByXOR+"位数"+resultByXOR.length
			 * ()); System.out.println("第"+i+"轮后右边的值为:"+leftvalueAfterAground);
			 * 
			 * System.out.println();
			 */
			groundresult += "第" + i + "轮后左边的值为:" + resultByXOR + "位数"
					+ resultByXOR.length() + "\n";
			groundresult += "第" + i + "轮后右边的值为:" + leftvalueAfterAground + "\n";
			groundresult += "\n";
		} else {

			/*
			 * System.out.println("第"+i+"轮后左边的值为:"+leftvalueAfterAground+"位数"+leftvalueAfterAground
			 * .length()); System.out.println("第"+i+"轮后右边的值为:"+resultByXOR);
			 * System.out.println();
			 */
			groundresult += "第" + i + "轮后左边的值为:" + leftvalueAfterAground + "位数"
					+ leftvalueAfterAground.length() + "\n";
			groundresult += "第" + i + "轮后右边的值为:" + resultByXOR + "\n";
			groundresult += "\n";
		}
		if (i < 16) {
			i++;
			operation(leftvalueAfterAground, rightvalueAfterAground, dwKey);
		} else {

			String finalresult = rightvalueAfterAground + leftvalueAfterAground;
			String result = new IPinverseConverter(finalresult).convert();// 进行ip逆变换
			// System.out.println("最终结果是"+result+"位数："+result.length());//把结果反过来输出一下即可
			this.finalresult = result;

			// return;
		}

	}

}
