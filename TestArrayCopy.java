package com.arrays;
/*测试数组的拷贝*/

public class TestArrayCopy {
    public static void main(String[] args) {
        //testBasicCopy2();
        String[] str={"雷霆","快船","火箭","骑士","湖人"};

        //removeElment(str,5);

        str=extendRange(str);
    }

        public static void testBasicCopy(){
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 0, s2, 5, 4);

        for (int i = 0; i < s2.length; i++) {
            System.out.println(i+"--"+s2[i]);
        }
    }
        //测试从数组中删除某个元素（本质上还是数组的拷贝）
        public static void testBasicCopy2(){
            String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
            //String s2=new String[5]

            System.arraycopy(s1, 3, s1, 2, s1.length - 3);

            s1[s1.length - 1] = null;
            for (int i = 0; i < s1.length; i++) {
                System.out.println(i + "--" + s1[i]);
            }
        }

        //删除数组中指定索引位置的元素，并将原数组返回
    public static String[] removeElment(String[] s,int index){
        System.arraycopy(s,index,s,index-1,s.length-index);
        s[s.length-1]=null;
        for(int i=0;i<s.length;i++) {
            System.out.println(i + "--" + s[i]);
        }
        return s;
        }

        //数组的扩容（先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中）
         public static String[] extendRange(String[] s1){
        String[] s2=new String[s1.length+10];

        System.arraycopy(s1,0,s2,0,s1.length);
        for(String temp:s2){
            System.out.println(temp);
        }
        return s2;
         }

    }


