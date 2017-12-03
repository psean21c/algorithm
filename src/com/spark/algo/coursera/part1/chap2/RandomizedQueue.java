package com.spark.algo.coursera.part1.chap2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue
    
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }	
    
	/***
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() {
        first = null;
        last  = null;
        n = 0;	}

	/***
	 * is the randomized queue empty?
	 */
	public boolean isEmpty(){
        return first == null;
	}

	/***
	 * return the number of items on the randomized queue
	 */
	public int size(){
		return n;
	}

	/***
     *  add the item
	 */
	public void enqueue(Item item){
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
	}
	   
	/***
	 * remove and return a random item
	 */
	public Item dequeue(){
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");

		Node<Item> prev = first;
		Node<Item> target = first;
		Item item = null;
		
		Random random = new Random();
		int idx = 	random.nextInt(n);
		
		System.out.println("will remove the " + (idx + 1) + "th (out of " + n +") node");
		for(int i =0; i<n; i++){
			item = target.item;
			if(idx ==0){
				first = first.next;
				break;
			}
			
			if(i==idx) {
				if(idx==n-1) prev.next = null;
				else  prev.next = target.next;
				break;
			}
			prev = target;
			target = target.next;
		}

		n--;
		if (isEmpty()) last = null; // to avoid loitering

		return item;
	}
	   
	/***
	 * return a random item (but do not remove it)
	 */
	public Item sample(){
		return null;
	}
	   
	/***
	 * return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);  
	}

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }	

	public static void printIterable(RandomizedQueue<String> deque){
		for(String str: deque) System.out.print(str + " ");
		System.out.println();

	}    
    
	/***
	 * unit testing (optional)
	 */
	public static void main(String[] args) {
		runMain();
//		runLab();
	}
	
	static void runLab(){
		Random random = new Random();
		System.out.println("" + random.nextInt(4));
	}
	
	static void runMain(){
		RandomizedQueue<String> queue = new RandomizedQueue<String>();	
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		printIterable(queue);
		
		queue.dequeue();
		printIterable(queue);
		
		queue.dequeue();
		printIterable(queue);

		queue.dequeue();
		printIterable(queue);

		queue.dequeue();
		printIterable(queue);

		queue.dequeue();
		printIterable(queue);

		queue.enqueue("x");
		queue.enqueue("y");
		printIterable(queue);
		
		queue.dequeue();
		printIterable(queue);
		
	}
}
