package lesson4;

import java.util.*;

public class LinkedList<E> implements Iterable<E> {
    private Node head = null;
    private int size = 0;
    private final List<E> original;

    public LinkedList(List<E> original) {
        this.original = original;
    }

    @Override
    public Iterator<E> iterator() {
        final ListIterator<E> i = original.listIterator(original.size());

        return new Iterator<E>() {
            public boolean hasNext() { return i.hasPrevious(); }
            public E next() { return i.previous(); }
            public void remove() { i.remove(); }
        };
    }

    private class Node {
        private E value;
        private Node next;
        Node(E value) {
            //System.out.println("init");
            this.value = value;
            this.next = null;
        }
        Node(E value, Node next) {
            System.out.println("init");
            this.value = value;
            this.next = next;
        }
    }
    public void add (E e) {
        if (head == null) {
            head = new Node(e);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(e);
        }
        //System.out.println("added: " + e);
        size++;
    }

    public void add (int index, E element) {
        if (index < 0 || index > size) {
            System.out.println("cannot add element #" + index +", size="+this.size);
            return;
        }
        else if (index == size) {
            add(element);
        }
        else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = new Node(element, curr.next);
            size++;
        }
    }

    public void remove (int index) {
        if (index < 0 || index >= size) {
            System.out.println("cannot remove element #" + index +", size="+this.size);
            return;
        }
        else if (index==0) {
            head = head.next;
            size--;
        }
        else {
            Node curr = head;
            Node prev = head;
            for (int i = 0; i < index; i++) {
                //System.out.println("i="+i+", curr:"+curr.value);
                if (i==index-1) {prev = curr;}
                //System.out.println("prev:"+prev.value);
                curr = curr.next;
            }
            if (prev.next.next != null) prev.next = prev.next.next;
            else prev.next = null;
            size--;
        }
    }

    public void show() {
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.value + " ");
            System.out.println("size=" + size);
    }

    public E get(int index)   {
        return this.get(index);
    }

    public void addAll(Collection e) {
        for (Object el : e) {
           this.add((E) el);
        };
    }

    /*public  <E> boolean addAll(LinkedList<? super E> e) {
        this.addAll(e);
        return true;
    }*/
}
