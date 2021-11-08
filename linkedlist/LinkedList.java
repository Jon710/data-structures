package linkedlist;

public class LinkedList {
  private ListNode head;

  private static class ListNode {
    private int data; // generic type
    private ListNode next; // pointer to next node

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void printElements() {
    ListNode current = head;

    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }

    System.out.print("Null");
  }

  public int length() {
    if (head == null)
      return 0;

    int count = 0;
    ListNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public void insertFirst(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }

  public void insertLast(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      head = newNode;
      return;
    }

    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }

  public void insertAt(int position, int value) {
    ListNode node = new ListNode(value);

    if (position == 1) {
      node.next = head;
      head = node;
    } else {
      ListNode previous = head;
      int count = 1;

      while (count < position - 1) {
        previous = previous.next;
        count++;
      }

      ListNode current = previous.next;
      previous.next = node;
      node.next = current;
    }
  }

  public ListNode deleteFirst() {
    if (head == null) {
      return null;
    }

    ListNode temp = head;
    head = head.next;
    temp.next = null;
    return temp;
  }

  public ListNode deleteLast() {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode current = head;
    ListNode previous = null;
    while (current.next != null) {
      previous = current;
      current = current.next;
    }

    previous.next = null;
    return current;
  }

  public void deleteAt(int position) {
    if (position == 1) {
      head = head.next;
    } else {
      ListNode previous = head;
      int count = 1;

      while (count < position - 1) {
        previous = previous.next;
        count++;
      }

      ListNode current = previous.next;
      previous.next = current.next;
    }

  }

  public boolean find(ListNode head, int searchKey) {
    if (head == null) {
      return false;
    }

    ListNode current = head;
    while (current != null) {
      if (current.data == searchKey) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  public ListNode reverse(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public ListNode getMiddleNode() {
    if (head == null) {
      return null;
    }

    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    return slowPointer;
  }

  public ListNode getNthNodeFromEnd(int n) {
    if (head == null) {
      return null;
    }

    if (n <= 0) {
      throw new IllegalArgumentException("Invalid value n!");
    }

    ListNode mainPointer = head;
    ListNode referencePointer = head;
    int count = 0;

    while (count < n) {
      if (referencePointer == null) {
        throw new IllegalArgumentException("n is greater than the number of nodes in the list!");
      }

      referencePointer = referencePointer.next;
      count++;
    }

    while (referencePointer != null) {
      referencePointer = referencePointer.next;
      mainPointer = mainPointer.next;
    }

    return mainPointer;
  }

  public void removeDuplicates() {
    if (head == null) {
      return;
    }

    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.data == current.next.data) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
  }

  public ListNode insertInSortedList(int value) {
    ListNode newNode = new ListNode(value);

    if (head == null) {
      return newNode;
    }

    ListNode current = head;
    ListNode temp = null;

    while (current != null && current.data < newNode.data) {
      temp = current;
      current = current.next;
    }

    newNode.next = current;
    temp.next = newNode;
    return head;
  }

  public void removeGivenKey(int key) {
    ListNode current = head;
    ListNode temp = null;

    if (current != null && current.data == key) {
      head = current.next;
      return;
    }

    while (current != null && current.data != key) {
      temp = current;
      current = current.next;
    }

    if (current == null) {
      return;
    }

    temp.next = current.next;
  }

  public boolean containsLoop() {
    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;

      if (slowPointer == fastPointer) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.head = new ListNode(1);
    ListNode second = new ListNode(5);
    ListNode third = new ListNode(8);

    // here we connect the nodes together to create the linked list
    list.head.next = second;
    second.next = third; // 10 -> 1 -> 8 -> null

    // list.insertFirst(11);
    // list.insertLast(11);
    // list.insertAt(1, 3);

    // System.out.println("The length of the list is " + list.length());
    // System.out.println(list.deleteFirst().data);
    // System.out.println(list.deleteLast().data);
    // list.deleteAt(2);

    // list.removeDuplicates();
    // list.insertInSortedList(10);
    // list.removeGivenKey(5);
    list.printElements();

  }
}