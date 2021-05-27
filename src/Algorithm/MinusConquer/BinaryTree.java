package Algorithm.MinusConquer;

public class BinaryTree {
    public int data;
    public BinaryTree leftChild;
    public BinaryTree rightChild;

    public BinaryTree(int data) {
        this.data = data;
    }

    public String Find(int target) {
        if (data == target) {
            return this.toString();
        } else if (data >= target) {
            if (this.leftChild != null) {
                return this.leftChild.Find(target);
            } else {
                return "-1";
            }
        } else {
            if (this.rightChild != null) {
                return this.rightChild.Find(target);
            } else {
                return "-1";
            }
        }
    }

    public static BinaryTree InsertTree(BinaryTree tree, int data) {
        if (tree == null) {
            tree = new BinaryTree(data);
            return tree;// 这里一定要结束
        }

        if (tree.data >= data) {
            tree.leftChild = InsertTree(tree.leftChild, data);
        } else {
            tree.rightChild = InsertTree(tree.rightChild, data);
        }

        return tree;
    }

    public static BinaryTree Array2Tree(int[] arr) {
        BinaryTree root = null;

        for (int i = 0; i < arr.length; i++) {
            root = InsertTree(root, arr[i]);
        }

        return root;
    }
}

class Bootstrap {
    public static void main(String[] args) {
        int[] arr = { 63, 55, 90, 42, 58, 70, 10, 45, 67, 83 };
        BinaryTree tree = BinaryTree.Array2Tree(arr);
        System.out.println(tree.Find(67));
    }

    public static void test(BinaryTree tree) {
        tree = new BinaryTree(5);
    }
}