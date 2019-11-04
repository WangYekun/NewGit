package com.hly.dataStructure.linkedList;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/3/9
 */
//����ͷ���ĵ�����
public class LinkedListWithoutHead<AnyType extends Comparable<? super AnyType>> {

    //����ڵ�
    private static class Node<AnyType> {

        private Node<AnyType> next;
        private AnyType data;

        public Node() {
            this(null, null);
        }

        public Node(AnyType data) {
            this.data = data;
        }

        public Node(Node<AnyType> head, AnyType data) {
            this.next = head;
            this.data = data;
        }
    }

    private Node<AnyType> head;//ͷָ��
    private int size;

    public LinkedListWithoutHead(Node<AnyType> head, int size) {
        this.head = head;
        this.size = size;
    }

    public LinkedListWithoutHead() {
        this(null, 0);
    }

    //���ص�����Ĵ�С
    public int size() {
        return size;
    }

    //���ص�����ĳ���
    public int length() {
        int j = 0;
        Node<AnyType> p = head;
        if (head == null)//ͷָ��Ϊ�գ��򳤶�Ϊ 0
            return 0;
        while (p != null) {
            p = p.next;
            j++;
        }
        return j;
    }

    //���ص������λ��
    public int indexOf(AnyType x) {
        int j = 0;
        Node<AnyType> p = head;
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            j++;
        }
        if (p != null)
            return j;
        return -1;
    }

    //���ص� i ���ڵ�
    public AnyType get(int i) throws Exception {
        Node<AnyType> p = head;
        int j = 0;
        while (j < i && p != null) {
            p = p.next;
            j++;
        }
        if (j > i || p == null)
            throw new Exception("����λ�ò��Ϸ�");
        return p.data;
    }

    //����ڵ�
    public void add(int i, AnyType x) throws Exception {
        Node<AnyType> p = head;
        int j = 0;
        while (j < i - 1 && p != null) {
            p = p.next;
            j++;
        }
        if (j > i && p == null)
            throw new Exception("����λ�ò��Ϸ�!");
        Node<AnyType> s = new Node<>(x);
        //�����λ��Ϊ��ͷʱ
        if (i == 0) {
            s.next = head;
            head = s;
            size++;
        } else {
            s.next = p.next;
            p.next = s;
            size++;
        }
    }

    //ɾ�������ؽڵ�
    public AnyType remove(int i) throws Exception {
        Node<AnyType> p = head;
        int j = 0;
        while (j < i - 1 && p != null) {
            p = p.next;
            j++;
        }
        if (j > i || p == null)
            throw new Exception("ɾ��λ�ò��Ϸ�");
        Node<AnyType> node;
        //���ɾ�������׽ڵ�
        if (i == 0) {
            node = head;
            head = head.next;
        } else {
            node = p.next;
            p.next = p.next.next;
            size--;
        }
        p.next = p.next.next;
        size--;
        return node.data;
    }

    //������нڵ�
    public void display() {
        Node<AnyType> p = head;//��ͷָ��ָ��ĵ�һ���ڵ㿪ʼ
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //������͵�����
    public Node<AnyType> reverse() {
        Node<AnyType> p = head;
        head = null;
        while (p != null) {
            Node<AnyType> q = p.next;
            p.next = head;
            head = p;
            p = q;
        }///
        return head;
    }

    public static void main(String[] args) throws Exception {

        LinkedListWithoutHead<Integer> list = new LinkedListWithoutHead<>();
        //�������
        for (int i = 0; i < 3; i++)
            list.add(list.length(), i);
        list.display();

        //������ĳ���
        System.out.println("������ĳ��ȣ�" + list.length());
        //����ֵΪ x �Ľڵ�
        System.out.println("����ֵΪ x �Ľڵ㣺"+list.indexOf(2));
        //�͵�����
        list.reverse();
        list.display();
        //ɾ��Ԫ��
        System.out.println("ɾ����i��Ԫ�أ�" + list.remove(0));
        list.display();
    }
}
