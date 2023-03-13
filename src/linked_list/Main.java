package linked_list;

import static linked_list.LinkedList.contains;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();


        list1.add(5);
        list1.add(10);
        list1.add(15);
        list1.add(155);
        list1.add(25);

        list1.showList();
        list1.addFirst(35);

/*
        try {
            list1.remove(155);
        }catch (MyException m){
            System.out.println(m.getMessage());
        }*/


        list1.showList();

        //System.out.println(list1.size());


        list1.add1(2,4);
        list1.showList();
        //list1.clear();
        //list1.showList();

        System.out.println(contains(list1, 5));

        System.out.println(list1.getFirst());
        System.out.println(list1.getLast());
        list1.toArray();
        list1.toArray1();
        list1.set(3,25);
        list1.showList();


    }
}
