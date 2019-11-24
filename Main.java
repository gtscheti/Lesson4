package lesson4;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList <? super Number> mylist = new LinkedList<>(null);
        LinkedList <Integer> intList = new LinkedList<Integer>(null);
        mylist.add(1);
        mylist.add(2);
        mylist.add(4);
        mylist.add(2,3);
        mylist.show();
        mylist.remove(0);
        mylist.remove(1);
        mylist.show();
        intList.add(1);
        intList.show();
        //System.out.println(mylist);
        mylist.addAll((Collection) intList);
    }
}
