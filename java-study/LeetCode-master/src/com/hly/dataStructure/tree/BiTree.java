package com.hly.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/27
 * @QQ :1136513099
 * @desc :
 */
public class BiTree<AnyType> {

    //��̬�ڲ��ڵ���
    public static class TreeNode<AnyType> {

        //�ڵ�����
        public AnyType data;
        //������
        public TreeNode<AnyType> lChild, rChild;

        public TreeNode() {
            this(null);
        }

        public TreeNode(AnyType data) {
            this(data, null, null);
        }

        public TreeNode(AnyType data, TreeNode<AnyType> lChild, TreeNode<AnyType> rChild) {
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }

    //���ڵ�
    TreeNode<AnyType> root = null;

    public BiTree() {
        this.root = null;
    }

    static int $ = 0;

    //����һ����
    // "a","b","d","#","#","#","c","e","#","#","f","#","#"
    public BiTree(AnyType[] preorder) {
        AnyType data = preorder[$++];
        if (data != "#") {
            root = new TreeNode<AnyType>(data);
            root.lChild = new BiTree<AnyType>(preorder).root;
            root.rChild = new BiTree<AnyType>(preorder).root;
        } else {
            root = null;
        }
    }

    //����һ����
    static int count = 0;

    public TreeNode<AnyType> create(AnyType[] h) {
        TreeNode<AnyType> root = null;
        if (count < h.length) {
            AnyType data = h[count++];
            if (!data.equals("#")) {
                root = new TreeNode<AnyType>(data);
                root.lChild = create(h);
                root.rChild = create(h);
            } else {
                root = null;
            }
        }
        return root;
    }


    //ǰ�����
    public void preTraverse(TreeNode<AnyType> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preTraverse(root.lChild);
            preTraverse(root.rChild);
        }
    }

    //�������
    public void infixTraverse(TreeNode<AnyType> root) {
        if (root != null) {
            infixTraverse(root.lChild);
            System.out.print(root.data + " ");
            infixTraverse(root.rChild);
        }
    }

    //��������
    public void postTraverse(TreeNode<AnyType> root) {
        if (root != null) {
            postTraverse(root.lChild);
            postTraverse(root.rChild);
            System.out.print(root.data + " ");
        }
    }

    //��������ת�ݹ�
    public void reverseRecursion(TreeNode<AnyType> root) {
        if (root != null) {
            TreeNode<AnyType> p = root.rChild;
            root.lChild = root.rChild;
            root.rChild = p;
            reverseRecursion(root.lChild);
            reverseRecursion(root.rChild);
        }
    }

    //��������ת����
    public void reverseIteration(TreeNode<AnyType> root) {
        Queue<TreeNode<AnyType>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<AnyType> cur = queue.poll();
            if (cur.lChild != null || cur.rChild != null) {
                TreeNode<AnyType> t = cur.lChild;
                cur.lChild = cur.rChild;
                cur.rChild = t;
                if (cur.lChild != null)
                    queue.offer(cur.lChild);
                if (cur.rChild != null)
                    queue.offer(cur.rChild);
            }
        }
    }

    //ͳ�ƶ������ڵ����
    public int countNode(TreeNode<AnyType> root) {
        int count = 0;
        if (root != null) {
            count++;
            count += countNode(root.lChild);
            count += countNode(root.rChild);
        }
        return count;
    }

    //ͳ�ƶ������ڵ����
    public int countNode2(TreeNode<AnyType> root) {
        if (root == null)
            return 0;
        return countNode2(root.lChild) + countNode2(root.rChild) + 1;
    }

    //�õ��������
    public int getDepth(TreeNode<AnyType> root) {
        if (root != null) {
            int lDepth = getDepth(root.lChild);
            int rDepth = getDepth(root.rChild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }

    //�õ�Ҷ�ӽڵ�ĸ���
    public int leaf(TreeNode<AnyType> root) {
        if (root == null) {
            return 0;
        } else {
            int c =  leaf(root.lChild)+ leaf(root.rChild);
            if (root.lChild == null && root.rChild == null) {
               return c+1;
            }else{
                return c;
            }
        }
    }

    //�õ�Ҷ�ӽڵ�ĸ���
    public int leaf2(TreeNode<AnyType> root) {
        if (root == null)
            return 0;
        else {
            int leftTreeLeaf = leaf2(root.lChild);
            int rightTreeLeaf = leaf2(root.rChild);
            if (root.lChild == null && root.rChild == null)
                return leftTreeLeaf + rightTreeLeaf + 1;
            else
                return leftTreeLeaf + rightTreeLeaf;
        }
    }

    //��α���
    public void printFromTopToBottom(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.data+" ");
            if(cur.lChild!=null){
                queue.offer(cur.lChild);
            }
            if(cur.rChild!=null){
                queue.offer(cur.rChild);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "d", "#", "#", "#", "c", "e", "#", "#", "f", "#", "#"};
        BiTree<String> biTree = new BiTree<String>(a);// ABDEGCFH//DBGEAFHC
        //BiTree<String> biTree = new BiTree<String>();// ABDEGCFH//DBGEAFHC
        System.out.println();
        //// abdcef
        biTree.preTraverse(biTree.root);
        System.out.println();
        // dbaecf
        biTree.infixTraverse(biTree.root);
        System.out.println();
        // dbefca
        biTree.postTraverse(biTree.root);
        System.out.println();
        System.out.println("Ҷ��" + biTree.leaf(biTree.root));
        System.out.println("���" + biTree.getDepth(biTree.root));
        System.out.println("�������Ľڵ���� " + biTree.countNode(biTree.root));
        biTree.printFromTopToBottom(biTree.root);
    }
}
