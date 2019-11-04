package com.hly.algorithm.bloom;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int addedElements;
    private int hashFunctionNumber;

    /**
     * c ������Ԥ���忪�ٵĿռ�
     * n �ù�������������¼
     * k �ж��ٸ�hash����
     * ����һ��BloomFilter��������������Ϊc * k
     */
    public BloomFilter(int c, int n, int k) {
        this.hashFunctionNumber = k;
        this.bitSetSize = (int) Math.ceil(c * k);
        this.addedElements = n;
        this.bitSet = new BitSet(this.bitSetSize);
    }

    /**
     * ͨ���ļ���ʼ��������.
     * @param file
     */
    public void init(String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
//            int i = 0;
            while (line != null && line.length() > 0) {
                this.put(line);
                line = reader.readLine();
//                i++;
//                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String str) {
        int[] positions = createHashes(str.getBytes(), hashFunctionNumber);
        for (int i = 0; i < positions.length; i++) {
            int position = Math.abs(positions[i] % bitSetSize);
            bitSet.set(position, true);
        }
    }

    public boolean contains(String str) {
        byte[] bytes = str.getBytes();
        int[] positions = createHashes(bytes, hashFunctionNumber);
        for (int i : positions) {
            int position = Math.abs(i % bitSetSize);
            if (!bitSet.get(position)) {
                return false;
            }
        }
        return true;
    }


    /**
     * �õ���ǰ�������Ĵ�����.
     * @return
     */
    public double getFalsePositiveProbability() {
        // (1 - e^(-k * n / m)) ^ k
        return Math.pow((1 - Math.exp(-hashFunctionNumber * (double) addedElements / bitSetSize)),
                hashFunctionNumber);
    }
    /**
     * ���ַ������ֽڱ�ʾ���ж��ϣ����.
     * @param bytes ����ӽ����������ַ����ֽڱ�ʾ.
     * @param hashNumber Ҫ�����Ĺ�ϣ����.
     * @return ������ϣ�Ľ������.
     */
    public static int[] createHashes(byte[] bytes, int hashNumber) {
        int[] result = new int[hashNumber];
        int k = 0;
        while (k < hashNumber) {
            result[k] = HashFunctions.hash(bytes, k);
            k++;
        }
        return result;
    }
}
