// zening fang
// assignment 3 IDLList
package HW3_zening;
import java.util.*;

public class IDLList<E> {
	private static class Node<E>{ // declare inner class Node<E> 
		private E data;
		private Node<E> next;
		private Node<E> prev;
		// constructor for elem
		private Node(E elem) {
			this.data = elem;
		}
		// create the constructor to hold elem, prev, next
		public Node(E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
    }	
    //the private data fields 
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    private ArrayList<Node<E>> indices;
    
    // create the list constructor
    public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<>();
	}

    // adds elem at position index
    public boolean add(int index, E elem)
	{
		//check the out of bounds exception.
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		//if adding the element at the start, use add(elem)
		else if(index == 0) {
			add(elem);
		}
		
		else if(index == size-1) {
			append(elem);
		}
		else
		{   // create a newElement in the LinkedList
            Node<E> newElement = new Node<>(elem);
			//get the index of the element in arrayList
			Node<E> temp = indices.get(index);
            // insert new element into the double-linked list, which is in front of ith position
            newElement.next = temp;
            newElement.prev = temp.prev;
            temp.prev.next = newElement;
            temp.prev = newElement;
            //change the the arrayList also.
            indices.add(index, newElement);
            size++;
            return true;
		}
    }

    // adds elem at the head 
    public boolean add(E elem) 
    {
        if (head == null) // /if the IDLList is empty, updates head and tail
        {
            head = new Node<>(elem);
            tail = head;
            size++;
            indices.add(0,head); 
            return true;
        } 
        else 
        {
            // otherwise insert firstItem before the head
            Node<E> firstItem = new Node<>(elem);
            firstItem.next = head;
            head.prev = firstItem;
            head = firstItem;
            size++;
            indices.add(0, firstItem);
            return true;
        }
    }

    // adds elem as the new last element of the list
    public boolean append(E elem){
        if (head == null){
            add(elem);
            return true;
        }
        // if head is not null, then create the lastItem and inserte it after the tail
        Node<E> lastItem = new Node<>(elem);
        tail.next = lastItem;
        lastItem.prev = tail;
        tail = lastItem;
        size++;
        indices.add(lastItem);
        return true;
    }

    // returns the object at position index from the head
    public E get(int index)
	{   //check the out of bounds exception.
		if(index<0||index>=size)
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		return indices.get(index).data;
	} 
    
    // returns the object at the head
    public E getHead () 
    {
        return head.data;
    }

    // returns the object at the tail
    public E getLast() 
    {
        return tail.data;
    }

    // returns the list size.
    public int size() 
    {
        return indices.size();
    }

    // removes and returns the element at the head.
    public E remove() 
    {
        if (head == null)
        {
        	return null;
        }
        // store head.data in the temp, and points to the next item
        Node<E> temp = head;
        head = head.next; 
        head.prev = null;
        size--;
        indices.remove(temp);
        return temp.data;
    }

    // removes and returns the element at the tail.
    public E removeLast() 
    {
        if (tail == null)
        {
        	return null;
        }
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        indices.remove(temp);
        return temp.data;
    }
    
    // removes and returns the element at the index
    public E removeAt(int index)
    {

        //check the out of bounds exception.
        if (index < 0 || index >= indices.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0)
        {
        	return remove();
        }
        else if (index == indices.size() - 1) 
        {
        	return removeLast();
        }
        else{
            Node<E> removeItem = indices.get(index);
            removeItem.prev.next = removeItem.next;
            removeItem.next.prev = removeItem.prev;
            size--;
            indices.remove(removeItem);
            return removeItem.data;
        }

    }

    // removes the first occurrence of elem in the list and returns true. Return false if elem was not in the list.
    public boolean remove(E elem) 
    {
        for (int i = 0; i < indices.size(); i++) 
        {
            if (indices.get(i).data == elem)
            {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // presents a string representation of the list
    public String toString() 
    {				
        Node temp = head;
		String str = "";
		while (temp != null) {
			str = str + " " + temp.data.toString();
			temp = temp.next;
		}
		return str;
    }

}