package com.mylinkedlist;

public class StackUsingLL {
	public static void main(String[] args) {
		list = new MyLinkedList();
		
		for(int i=1; i<=10; i++)
			list.insertAtLast(i*10);
		
		printList();
		
		MyLinkedList.Node pop = list.removeAtLast();
		System.out.println("Pop: " + pop.value);
		printList();
		
		int toRemoveValue = 40;
		System.out.println("Remove by value = " + toRemoveValue);
		list.removeByValue(toRemoveValue);
		printList();

		int toRemoveIndex = 5;
		System.out.println("Remove at index = " + toRemoveIndex);
		list.removeAtIndex(toRemoveIndex);
		printList();
	}
	
	private static void printList() {
		System.out.println("List: ");
		list.print();
		System.out.println("");
	}
	
	private static MyLinkedList list;
}
