package com.hly.algorithm.introduction.experiment2;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/7
 * @desc ����������
 */
public class Matrix {

    public static void main(String[] args){
        //int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[] p = {4,3,5,2,3};
        int n = p.length-1 ;
        //��ż������
        int[][] m = new int[n+2][n+2];
        //��ŷָ���k��ֵ
        int[][] s = new int[n+2][n+2];
        //����Ϊ1����С�������Ϊ0����A1,A2,A1 ����Ӧ[0.0],[1,1]��[2,2]��ֵ�Ǳ���Ҳ��0
        for(int i = 1; i <= n; i++){
            m[i][i] = 0;
        }
        //����Ϊ2��n����С�������
        for(int L = 2; L <= n; L++){
            //�����ķ�Χ������С��Χ���ӵ�һ����ʼ��
            for(int i = 1; i <= n - L + 1; i++){//i��Χ����С�� n-1,n-2,n-3
                //ÿ�������1������Ե����ϵĵݹ���ʽ��⡣
                //i �� j �������� L����
                int j = i + L -1;//L �����ĳ��ȣ�Ҳ����������µ���С���ۣ�j�� i ��1
                //��ʼ��m[i,j]��ֵΪ���޴�
                m[i][j] = Integer.MAX_VALUE;
                for(int k=i; k <=j-1; k++){
                    //�ݹ���⹫ʽ��i Ϊ�� i ������p[i-1]Ϊÿһ���ϵ���
                    int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        //�������д��۵Ľ��
                        m[i][j] = q;
                        //����ָ��k��ֵ
                        s[i][j] = k;
                    }
                }
            }
        }



        //���������۵ľ���m�������ս���Ǿ���m[0][m.length-1]
        System.out.println("�þ���������С���������"+m[1][n]);
        for(int i=0; i <m.length; i++){
            for(int j=0; j <m.length; j++){
                System.out.print(m[i][j] +"          ");
            }
            System.out.println();
        }
        //�������Ž�
        Matrix.printOptimalPatterns(s,0,n);
        System.out.println();
        for(int i=0; i <s.length; i++){
            for(int j=0; j <s[i].length; j++){
                System.out.print(s[i][j] +"          ");
            }
            System.out.println();
        }

    }

    static void printOptimalPatterns(int[][]s,int i, int j){
        if(i==j)
            System.out.print("A"+(i+1));//A��1��ʼ�����Լǵü�1
        else{
            System.out.print("(");
            printOptimalPatterns(s,i,s[i][j]);// Ai,k�����Ž� s[i,j]��¼����k��ֵ
            printOptimalPatterns(s,s[i][j]+1,j);//Ak+1,j�����Ž�
            System.out.print(")");
        }
    }


}
//(A1(A2A3))((A4A5)A6)