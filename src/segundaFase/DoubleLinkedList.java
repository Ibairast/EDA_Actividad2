package segundaFase;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    // Atributos
    protected Node<T> first; // apuntador al primero
    protected String descr;  // descripci�n
    protected int count;

    // Constructor
    public DoubleLinkedList() {
        first = null;
        descr = "";
        count = 0;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String nom) {
        descr = nom;
    }

    public T removeFirst() {
        // Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        T dev = first.data;
        Node<T> newPrimero = first.next;
        Node<T> ultimo = first.prev;

        ultimo.next = newPrimero;
        newPrimero.prev = ultimo;
        first = newPrimero;
        count--;
        return dev;
        // O(1)

    }

    public T removeLast() {
        // Elimina el �ltimo elemento de la listac
        // Precondici�n: la lista tiene al menos un elemento
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> ultimo = first.prev;
        T dev = first.prev.data;
        ultimo = ultimo.prev;
        ultimo.next = first;
        first.prev = ultimo;


        count--;
        return dev;
    }//O(1)


    public T remove(T elem) {
        //Elimina un elemento concreto de la lista
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> act = first;
        if (!isEmpty()) {
            if (first != first.next) {
                while (elem != act.data) {
                    act = act.next;//Llegar al elemento
                    if (act == first) {
                        return null;//No esta
                    }
                }
                act.next.prev = act.prev;
                act.prev.next = act.next;
                count--;
                return act.data;
            } else {
                if (first.data == elem) {
                    first = null;
                    count--;
                }

            }
        }
        return null;
    }//O(n)

    public T first() {
        //Da acceso al primer elemento de la lista
        if (isEmpty())
            return null;
        else return first.data;
    }

    public T last() {
        //Da acceso al �ltimo elemento de la lista
        if (isEmpty())
            return null;
        else return first.prev.data;
    }

    public boolean contains(T elem) {
        //Determina si la lista contiene un elemento concreto
        Node<T> act = first;
        if (!isEmpty()) {
            while (elem != act.data) {
                act = act.next;//Llegar al elemento
                if (act == first) {
                    return false;//No esta
                }
            }
        }
        return true;
    }// O(n/2)*P(está) + O(n)*P(!está)

    public T find(T elem) {
        //Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> act = first;
        if (!isEmpty()) {
            while (elem != act.data) {
                act = act.next;//Llegar al elemento
                if (act == first) {
                    return null;//No esta
                }
            }
        }
        return act.data;
    }// O(n/2)*P(está) + O(n)*P(!está)

    public boolean isEmpty()
    //Determina si la lista est� vac�a
    {
        return first == null;
    }


    public int size()
    //Determina el n�mero de elementos de la lista
    {
        return count;
    }


    /**
     * Return an iterator to the stack that iterates through the items .
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public void visualizarNodos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String result = new String();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T elem = it.next();
            result = result + "[" + elem.toString() + "] \n";
        }
        return "SimpleLinkedList " + result + "]";
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node<T> act = first;

        @Override
        public boolean hasNext() {
            return act != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T t = act.data;
                act = act.next;
                return t;
            }
            return null;
        }
        //O(1s)


    }

}
