package com.mylinkedlist;

public class MyLinkedList {
	public static class Node {
		int value;
		Node next;
		
		Node(int value) {
			this(value, null);
		}
		
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public void insertAtFront(int value) {
		if (isEmpty()) {
			head = new Node(value);
		} else {
			Node newHead = new Node(value, head);
			head = newHead;
		}
	}
	
	public void insertAtLast(int value) {
		if (isEmpty()) {
			insertAtFront(value);
			return;
		}

		Node curr = head;
		while(curr.next != null) curr = curr.next;
		curr.next = new Node(value);
	}
	
	public void insertAtIndex(int index, int value) {
		if (index < 0) return;
	
		int maxAvailableIndex = Math.max(0, size()-1);
		if (maxAvailableIndex <= index) {
			insertAtLast(value);
			return;
		}

		Node curr = head;
		int currIndex = 0;

		while(currIndex != index-1) {
			currIndex++;
			curr = curr.next;
		}
		
		curr.next = new Node(value);
	}
	
	public Node removeAtFront() {
		if (isEmpty()) return null;
		
		Node front = head;
		head = head.next;
		return front;
	}
	
	public Node removeAtLast() {
		if (isEmpty()) return null;
		
		if (head.next == null) {
			return removeAtFront();
		}
		
		Node curr = head;
		while(curr.next.next != null) {
			curr = curr.next;
		}
		
		Node last = curr.next;
		curr.next = null;
		
		return last;
	}
	
	public Node removeAtIndex(int index) {
		if (isEmpty()) return null;
		
		int maxAvailableIndex = Math.max(0, size()-1);
		if (maxAvailableIndex < index) return null;
		
		int currIndex = 0;
		Node curr = head;
		
		while(currIndex != index-1) {
			currIndex++;
			curr = curr.next;
		}
		
		Node node = curr.next;
		curr.next = node.next;
		return node;
	}
	
	public Node removeByValue(int value) {
		if (isEmpty()) return null;
		
		Node curr = head;
		Node prev = null;
		Node node = null;

		while(curr != null) {
			if (curr.value == value) {
				if (curr == head) {
					node = removeAtFront();
				} else {
					node = curr;
					prev.next = node.next;
				}
				
				break;
			}

			prev = curr;
			curr = curr.next;
		}
		
		return node;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.value + " --> ");
			curr = curr.next;
		}
		
		System.out.println("null");
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		int count = 0;
		if (isEmpty()) return 0;
		
		Node curr = head;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		
		return count;
	}

	private Node head = null;
}
