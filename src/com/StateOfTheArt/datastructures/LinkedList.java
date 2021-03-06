package com.StateOfTheArt.datastructures;

public class LinkedList {

    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    private Node head;

    public void append(int data){
        if (head ==null){
            head = new Node(data);
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data){
        if(head == null) return;
        if(head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (data == current.next.data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
