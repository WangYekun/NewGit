package com.hly.dataStructure.linkedList;

import java.util.Arrays;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/3/8
 */
//���Ա�˳��洢
public class SequentialLinearList<E> {

    //���Ա�洢�ռ�
    private Object[] listElem;
    //���Ա���
    private int len;

    //��ʼ�����Ա�Ĵ�С
    public SequentialLinearList(int maxLen) {
        len = 0;
        listElem = new Object[maxLen];
    }

    //�����Ա��ÿ�
    public void clear() {
        len = 0;
    }

    //�ж����Ա��Ƿ�Ϊ��
    public boolean isEmpty() {
        return len == 0;
    }

    //�������Ա���Ԫ�صĸ���
    public int length() {
        return len;
    }

    //�������Ա��е� i ������
    public E get(int i) throws Exception {
        if (i < 0 || i >= len)
            throw new Exception("���ҷ�Χ����ȷ,��" + i + "��Ԫ�ز�����");
        return (E) listElem[i];
    }

    //�ڵ� i ������֮ǰ��������
    public void insert(int i, E e) throws Exception {
        if (i < 0 || i > len)
            throw new Exception("���뷶Χ����ȷ,��" + i + "��Ԫ�ز�����");
        //�����Ա�������������һ��
        if (len == listElem.length)
            listElem = Arrays.copyOf(listElem, 2 * listElem.length);
        //���ݺ���һλ����j=iʱ�����������ݲ���i
        for (int j = len; j > i; j--)
            listElem[j] = listElem[j - 1];
        listElem[i] = e;
        len++;
    }

    //ɾ�����������Ա��е� i ������
    public E remove(int i) throws Exception {
        if (i < 0 || i >= len)
            throw new Exception("ɾ����Χ����ȷ,��" + i + "��Ԫ�ز�����");
        E e = (E) listElem[i];
        //j=len-1 ʱ����ѭ�������һ��Ϊ listElem[len-2] = listElem[len-1]
        for (int j = i; j < len - 1; j++)
            listElem[j] = listElem[j + 1];
        len--;
        return e;
    }

    //�������Ա�������Ԫ�ص�λ��ţ������Ա��в���������-1
    public int indexOf(E e) {
        for (int i = 0; i < len; i++) {
            if (listElem[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //������Ա��е�Ԫ��
    public void display() {
        for (int i = 0; i < len; i++)
            System.out.print(listElem[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        SequentialLinearList<Character> list = new SequentialLinearList<>(3);
        list.insert(0, 'a');
        list.insert(1, 'b');
        list.insert(2, 'c');
        list.remove(2);
        list.display();
        list.get(1);
        System.out.println(list.indexOf('a'));
        list.insert(2,'c');
        list.insert(3,'d');
        System.out.println(list.length());
        System.out.println(list.listElem.length);

    }
}
