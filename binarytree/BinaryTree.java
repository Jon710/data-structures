package binarytree;

import java.util.Stack;

public class BinaryTree {

  private TreeNode root;

  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public void createBinaryTree() {
    TreeNode first = new TreeNode(9);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);

    root = first;
    first.left = second;
    first.right = third;

    second.left = fourth;
  }

  // pre order -> root, left subtree, right subtree
  public void recursivePreOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    recursivePreOrder(root.left);
    recursivePreOrder(root.right);
  }

  // with a stack
  public void iterativePreOrder() {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      System.out.print(temp.data + " ");
      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
  }

  // in order -> left subtree, root, right subtree
  public void recursiveInOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    recursiveInOrder(root.left);
    System.out.print(root.data + " ");
    recursiveInOrder(root.right);
  }

  public void iterativeInOrder(TreeNode root) {
    if (root == null)
      return;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode temp = root;
    while (!stack.isEmpty() || temp != null) {
      if (temp != null) {
        stack.push(temp);
        temp = temp.left;
      } else {
        temp = stack.pop();
        System.out.print(temp.data + " ");
        temp = temp.right;
      }
    }
  }

  // post order -> left subtree, right subtree, visit root node
  public void recursivePostOrder(TreeNode root) {
    if (root == null)
      return;

    recursivePostOrder(root.left);
    recursivePostOrder(root.right);
    System.out.print(root.data + " ");
  }

  public void iterativePostOrder(TreeNode root) {
    TreeNode current = root;
    Stack<TreeNode> stack = new Stack<>();
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        TreeNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.pop();
          System.out.print(temp.data + " ");
          while (!stack.isEmpty() && temp == stack.peek().right) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
          }
        } else {
          current = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.createBinaryTree();

    // tree.recursivePreOrder(tree.root);
    // tree.iterativePreOrder();

    // tree.recursiveInOrder(tree.root);
    // tree.iterativeInOrder(tree.root);

    // tree.recursivePostOrder(tree.root);
    // tree.iterativePostOrder(tree.root);
  }
}