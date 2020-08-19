import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hill {
    List a;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String clear = input.nextLine();
        int n = clear.length();

        encry(n,clear);
    }
    public static void encry(int n ,String text) {
        int[] result = new int[n];//密文对应数组
        int[] origin = new int[n];//原密码对应数组
        ArrayList<List> l = new ArrayList();//加密矩阵
        for(int i=0;i<n;i++) {
            l.add(new Hill(n).a);//用对象的属性（数组）作为arraylist的元素
        }
        System.out.println(l);//输出加密数组
        //System.out.println(l.get(1).get(0)); 测试具体值
        for(int t=0;t<n;t++) {
            origin[t]=((int)text.charAt(t)-96);
        }
        for(int j= 0;j<n;j++) {//几个字母几次
            for(int k =0;k<n;k++) {//数组个数
                int sum = 0;
                for(int i = 0;i<l.get(k).size();i++) {//数组里的元素个数
                    sum+=((int)l.get(k).get(i))*origin[i];//矩阵相乘
                }
                result[k]=sum%26;
            }
        }
        for(int q = 0;q<n;q++) {
            System.out.print((char)(result[q]+96));//结果数组
        }
    }
    public Hill(int n) {//数组属性赋随机值
        a = new ArrayList();
        for(int i= 0;i<n;i++) {
            a.add((int)(Math.random()*27));
        }
    }
}