package com.hly.dataStructure.linkedList;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/3/8
 */

//��ͷ���ĵ�����
public class LinkedList<AnyType extends Comparable<? super AnyType>> {

    //���徲̬�ڲ���ڵ�
    private static class Node<AnyType>{

        public AnyType data;
        public Node<AnyType> next;

        public Node() {
            this(null,null);
        }

        public Node(AnyType data) {
            this.data = data;
        }

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    //ͷָ��
    private Node<AnyType> head; //ͷָ��
    private int size;

    public LinkedList() {
        size = 0;
        head = new Node<>();//��ʼ��ͷ���
    }

    public LinkedList(Node<AnyType> head, int size) {
        this.head = head;
        this.size = size;
    }

    public int size(){
        return size;
    }

    //���������óɿձ�
    public void clear(){
        head.data = null;
        head.next = null;
    }

    //�жϵ������Ƿ�Ϊ��
    public boolean isEmpty(){
        return head.next == null;
    }

    //������ĳ���
    public int length(){
        int length = 0;
        Node<AnyType> p = head.next;//���׽ڵ㿪ʼ����
        while(p!=null){
            p = p.next;
            length ++ ;
        }
        return length;
    }

    //��ȡ�� i ���ڵ�
    public AnyType get(int i) throws Exception {
        Node<AnyType> p = head.next;
        int j = 0;
        while (j<i&&p!=null){
            p = p.next;
            j++;
        }
        //����Ϊ�յ����
        //1.j>i,i<0ʱ���Ϸ�
        //p==null,˵�����Ѿ��˳���whileѭ����i�����˱�-1
        if(p==null||j>i)
            throw new Exception("��"+i+"���ڵ㲻���ڣ�");
        return p.data;
    }

    //�ڵ������е�i���ڵ�ǰ����һ���µ�ֵ
    public void add(int i,AnyType data) throws Exception {
        int j = -1;
        Node<AnyType> p = head;//pΪͷ���
        //�ҵ� i ��ǰ���ڵ� p
        while(j<i-1&&p!=null){
            p = p.next;
            j++;
        }
        if(j>i-1||p ==null)
            throw new Exception("����λ�ò��Ϸ�");
        Node<AnyType> s = new Node<>(data);
        s.next = p.next;
        p.next = s;
    }

    //ɾ���������е� i ���ڵ�,���ظýڵ�
    public AnyType remove(int i) throws Exception {
        Node<AnyType> p = head;
        int j = -1;
        while(j<i-1&&p.next!=null){
            p = p.next;
            j++;
        }
        if(j>i-1||p.next==null)
            throw new  Exception("ɾ��λ�ò��Ϸ�");
        Node<AnyType> node = p.next;
        p.next = p.next.next;
        return node.data;
    }


    //���ҵ�ֵΪx�Ľڵ�
    public int indexOf(AnyType x){
        Node<AnyType> p = head.next;
        int i = 0;
        while (p!=null&&!p.data.equals(x)){
                p = p.next;
                i++;
        }
        if(p!=null)//������������� p Ϊ null ��˵��û���ҵ�
            return i;
        return -1;
    }

    //������еĽڵ�
    public void display(){
        Node<AnyType> p = head.next;//ȡ����ͷ�����׽ڵ�
        while(p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    //Test
    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list  = new LinkedList<>();
        //�������
        for(int i=0;i<3;i++)
            list.add(list.length(),i);
        list.display();
        //������ĳ���
        System.out.println("������ĳ��ȣ�"+list.length());
        //����ֵΪ x �Ľڵ�
        System.out.println("����ֵΪ x �Ľڵ㣺"+list.indexOf(2));
        //ɾ��Ԫ��
        System.out.println("ɾ��Ԫ�أ�"+list.remove(2));
        list.display();
    }
}


