package com.spark.algo.coursera.part1.chap2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first; // beginning of deque
	private Node<Item> last; // end of deque
	private int n; // number of elements on deque

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
		private Node<Item> prev;
	}

	/***
	 * construct an empty deque
	 */
	public Deque() {
		first = null;
		last = null;
		n = 0;
	}

	/***
	 * is the deque empty?
	 */
	public boolean isEmpty() {
		return (first == null || last == null) ;
	}

	/***
	 * return the number of items on the deque
	 */
	public int size() {
		return n;
	}

	/***
	 * add the item to the front 
	 */
	public void addFirst(Item item) {
		Node<Item> oldfirst = first;
		
		first = new Node<Item>();
		first.item = item;
		first.next = null;
		first.prev = null;

		if (isEmpty()) {
			last = first;
		} else {
			first.next = oldfirst;
			oldfirst.prev = first;
		}
		n++;
	}

    
    
	/***
	 * add the item to the end
	 */
	public void addLast(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		last.prev = null;

		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
			last.prev = oldlast;
		}
		n++;
	}

	/***
	 * remove and return the item from the front
	 */
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("Deque underflow");
		Item item = first.item;
		first = first.next;
		
		n--;
		
		// to avoid loitering
		if (isEmpty()) last = null;
		else first.prev = null;
		
		return item;
	}

	/***
	 * remove and return the item from the end
	 */
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("Deque underflow");
		Item item = last.item;
		last = last.prev;
		n--;
		
		// to avoid loitering
		if (isEmpty()) first = null;
		else last.next = null;

		return item;
	}

	/***
	 * return an iterator over items in order from front to end
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
    
    
	public static void printIterable(Deque<String> deque){
		for(String str: deque) System.out.print(str + " ");
		System.out.println();

	}    
	/***
	 * unit testing (optional)
	 */
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		deque.addFirst("a"); // a
		printIterable(deque);
		
		deque.addFirst("b"); // b-a
		printIterable(deque);
		
		deque.addFirst("c"); // c-b-a
		printIterable(deque);

		deque.addLast("d");  // c-b-a-d 
		printIterable(deque);
		
		deque.removeFirst(); // b-a-d
		printIterable(deque);
		
		deque.removeLast(); // b-a
		printIterable(deque);
		
		deque.removeFirst(); // a
		printIterable(deque);
		
		deque.removeFirst(); // 
		printIterable(deque);
		
		deque.addFirst("a"); // a
		printIterable(deque);
		
		deque.addFirst("b"); // b-a
		printIterable(deque);
		
		deque.removeLast(); // b
		printIterable(deque);
		
		deque.removeLast(); // 
		printIterable(deque);
		
		deque.removeLast(); //
		printIterable(deque);
	}
	

}