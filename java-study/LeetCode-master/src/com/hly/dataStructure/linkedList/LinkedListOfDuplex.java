package com.hly.dataStructure.linkedList;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/3/11
 */

//��ͷ����˫��ѭ������
public class LinkedListOfDuplex<AnyType extends Comparable<? super AnyType>> {

    private static class Node<AnyType> {
        AnyType data;
        private Node<AnyType> prior;
        private Node<AnyType> next;

        public Node() {
            this(null);
        }

        public Node(AnyType data) {
            this(data, null, null);
        }

        public Node(AnyType data, Node<AnyType> prior, Node<AnyType> next) {
            this.data = data;
            this.prior = prior;
            this.next = next;
        }
    }

    private Node<AnyType> head;//��ʼ��ͷ���
    int size;

    public LinkedListOfDuplex() {
        head = new Node<>();//��ʼ��ͷ���
        head.prior = head;
        head.next = head;
        size = 0;

    }

    //��ȡ����
    public int length() {
        Node<AnyType> p = head.next;
        int j = 0;
        while (p != head) {
            p = p.next;
            j++;
        }
        return j;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void clear() {
        head.next = null;
    }

    //��ȡ��i���ڵ������
    public AnyType get(int i) {
        Node<AnyType> p;
        int j;
        if (i < size / 2) {
            p = head.next;
            j = 0;
            while (j < i) {
                p = p.next;
                j++;
            }
        } else {
            p = head;
            j = size;
            while (j > i) {
                p = p.prior;
                j--;
            }
        }
        return p.data;
    }

    //�͵�����
    public void reverse() {
        Node<AnyType> p, q, k;
        p = head.next;
        q = p.next;
        while (p != head) {
            k = q.next;
            q.next = p;
            p.prior = q;
            p = q;
            q = k;
        }
        q.next = p;
        p.prior = q;
    }

    //�������
    public void add(int i, AnyType x) throws Exception {
        Node<AnyType> p = head.next;//ָ���׽ڵ�
        int j = 0;
        while (p != head && j < i) {
            p = p.next;
            j++;
        }
        if (j != i )
            throw new Exception("����λ�ò��Ϸ�");
        Node<AnyType> s = new Node<>(x);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;
        size++;
    }


    //ɾ������
    public AnyType remove(int i) throws Exception {
        Node<AnyType> p = head.next;
        int j = 0;
        while (p != head && j < i) {
            p = p.next;
            j++;
        }
        if (j != i)
            throw new Exception("ɾ��λ�ò��Ϸ�");
        Node<AnyType> node = p;
        p.prior.next = p.next;
        p.next.prior = p.prior;
        size--;
        return node.data;
    }

    public void display() {
        Node<AnyType> p = head.next;
        while (p != head) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //Test
    public static void main(String[] args) throws Exception {
        LinkedListOfDuplex<Integer> list = new LinkedListOfDuplex<>();
        //�������
        for (int i = 0; i < 6; i++)
            list.add(list.length(), i);
        list.display();
        //������ĳ���
        System.out.println("������ĳ��ȣ�" + list.length());
        //����� i ��Ԫ�أ��� 0 ����ʼ
        System.out.println("����� i ��Ԫ�أ�" + list.get(2));
        list.reverse();
        list.add(6,9);
        list.display();
        //ɾ��Ԫ��
        System.out.println("ɾ��Ԫ�أ�" + list.remove(2));
        list.display();

    }
}
