package segundaFase;

import java.util.Iterator;


public class PruebaDoubleLinkedList {

    private static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
        Iterator<Integer> it = l.iterator();
        System.out.println();
        while (it.hasNext()) {
            Integer num = it.next();
            System.out.println(num);
        }
    }


    public static void main(String[] args) {

        UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<>();
        l.addToRear(1);
        l.addToRear(3);
        l.addToRear(6);
        l.addToRear(7);
        l.addToRear(9);
        l.addToRear(0);
        l.addToRear(20);
        l.addToFront(8);
        l.addAfter(10, 6);
        l.addAfter(80, 666);
        l.remove(new Integer(7));


        System.out.print(" Lista ...............");
        visualizarNodos(l);
        System.out.println(" Num elementos: " + l.size());


        System.out.println("Prueba Find ...............");
        System.out.println("9? " + l.find(9));
        System.out.println("0? " + l.find(0));
        System.out.println("7? " + l.find(7));
        System.out.println("10? " + l.find(10));
        System.out.println("80? " + l.find(80));


        System.out.println("Prueba Contains ...............");
        System.out.println("8? " + l.contains(8));
        System.out.println("0? " + l.contains(0));
        System.out.println("20? " + l.contains(20));
        System.out.println("7? " + l.contains(7));
        System.out.println("10? " + l.contains(10));
        System.out.println("80? " + l.contains(80));
    }
}
