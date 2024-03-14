package lesson4;

import lesson4.gb_collections.GbList;
import lesson4.gb_collections.lists.GbArrayList;
import lesson4.gb_collections.lists.GbLinkedList;

public class Main {
    public static void main(String[] args) {
        // GbList<Integer> list = new GbArrayList<>();
        // list.add(5);
        // list.add(9);
        // list.add(66);
        // list.add(8);
        // list.add(5);
        // list.add(9);
        // list.add(66);
        // list.add(8);
        // list.add(5);
        // list.add(9);
        // list.add(66);
        // list.add(8);
        // System.out.println(list.size());
        // System.out.println(list);
        // list.removeByIndex(1);
        // list.remove(66);
        // System.out.println(list);
        // GbList<String> s = new GbArrayList<>();
        // s.add("asdf");
        // s.add("xcdf");
        // s.add("hjdf");
        // s.add("lkjf");
        GbList<Integer> list = new GbLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeByIndex(1);
        list.remove(4);
        System.out.println(list);
    }
}
