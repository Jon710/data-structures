package queue;

import java.util.NoSuchElementException;

public class Queue {

  private ListNode front;
  private ListNode back;
  private int length;

  public Queue() {
    this.front = null;
    this.back = null;
    this.length = 0;
  }

  private class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void enqueue(int data) {
    // back
    ListNode temp = new ListNode(data);
    if (isEmpty()) {
      front = temp;
    } else {
      back.next = temp;
    }

    back = temp;
    length++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty!");
    }

    int result = front.data;
    front = front.next;
    if (front == null) {
      back = null;
    }
    length--;
    return result;
  }

  public void print() {
    if (isEmpty()) {
      return;
    }

    ListNode current = front;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }

    System.out.println("null");
  }

  public int first() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty!");
    }

    return front.data;
  }

  public int last() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty!");
    }

    return back.data;
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.print();

    // System.out.println(queue.last());
  }
}
