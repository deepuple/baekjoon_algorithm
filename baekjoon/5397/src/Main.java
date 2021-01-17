import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0 ; i<cases ; ++i) {
			char[] cmd = sc.nextLine().toCharArray();
			/*
			char[] prt = new char[1000001];
			int length = run_cmd(cmd, prt);
			for(int j = 0 ; j<length ; ++j) {
				System.out.print(prt[j]);
			}
			System.out.println();
			*/
			run_cmd(cmd);
		}
		
		sc.close();
	}
	
	static void run_cmd(char[] cmd) {
		int cursor = 0;
		int end = 0;
		MyLinkedList mq = new MyLinkedList();
		for(int i = 0 ; i<cmd.length ; ++i) {
			if(cmd[i]=='<') {
				mq.left();	
			}else if(cmd[i]=='>') {
				mq.right();
			}else if(cmd[i]=='-') {
				mq.delete();
			}else {
				mq.insert(cmd[i]);
			}
		}
		mq.print();
	}
	
	static class MyLinkedList{
		Node head, tail = null;
		Node cursor = null;
		int size = 0;
		
		class Node{
			char data;
			Node next;
			Node prev;
			
			public Node(char in) {
				this.data = in;
				this.next = null;
				this.prev = null;
			}
		}
		
		public MyLinkedList() {
			this.head = new Node('h');
			size++;
		}
		
		public int insert(char in) {
			Node tmp = new Node(in);
			
			if(size == 1) {
				cursor = tmp;
				head.next = cursor;
				cursor.prev = head;
			}else {
				if(cursor.next==null) {//tail
					cursor.next = tmp;
					tmp.prev = cursor;
					cursor = tmp;
				}else {
					Node tmp2 = cursor.next;
					cursor.next = tmp;
					tmp.prev = cursor;
					tmp.next = tmp2;
					tmp2.prev = tmp;
					cursor = tmp;
				}
			}
			size++;
			return size;
		}
		
		public int delete() {	
			if(size == 1 || cursor==head) {
				return size;
			}else {
				if(cursor.next==null) {//tail
					cursor = cursor.prev;
					cursor.next = null;
				}else {
					
					cursor.prev.next = cursor.next;
					cursor.next.prev = cursor.prev;
					cursor = cursor.prev;
				}
			}
			size--;
			
			return size;
		}
		
		public void left() {
			if(cursor==null)
				return;
			if(cursor.prev != null)
				cursor = cursor.prev;	
		}
		public void right() {
			if(cursor==null)
				return;
			if(cursor.next != null)
				cursor = cursor.next;
		}
		public void print() {
			Node tmp = head.next;
			while(tmp!=null) {
				System.out.print(tmp.data);
				tmp = tmp.next;
			}
			System.out.println();
		}
	}
}
