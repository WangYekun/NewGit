package com.hly.algorithm.introduction.experiment2;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/6
 */
//�����и�(�Ե�����)
public class ExtendedBottomUpCutRod {
    private static class Result {
        private int r[];
        private int s[];
    }

    public static Result extendedBottomUpCutRod(int p[], int n) {

        //0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30
        int s[] = new int[n+1];
        int r[] = new int[n+1];

        r[0]=0;
        //����Ϊj�����Ž�
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            //��i�ε����н�
            for (int i = 1; i <= j; i++) {
                //ȡ��i�����н�����ֵ,p[i]���ηָ�ĳ��ȣ�r[j-i]Ϊ�Ӹ��������Ž�
                if(q<p[i]+r[j-i]){
                    q=p[i]+r[j-i];
                    s[j]=i;//����Ϊj���Ž��е�һ�θ������и��
                }
            }
            //��¼���Ž�
            r[j]=q;
        }
        Result result = new Result();
        result.r =r;
        result.s=s;
        return result;
    }

    public static void main(String[] args) {

        //4:10,7:18,10:30
        int p[] = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int m=10;
        Result result = extendedBottomUpCutRod(p,m);
       for(int i:result.s)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("���Ž⣺"+result.r[m]);
    }
}
