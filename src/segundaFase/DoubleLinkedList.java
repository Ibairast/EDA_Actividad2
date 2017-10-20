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
        Node<T> primero = first;
        Node<T> ultimo = first.prev;
        if (first.next == null) {
            first = null;
            dev = first.data;
        } else {
            primero = primero.next;
            primero.prev = ultimo;
            ultimo.next = primero;
        }
        count--;
        return dev;
        // O(1)

    }

    public T removeLast() {
        // Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        T dev = first.prev.data;
        Node<T> ultimo = first.prev;
        if (first.next == null){
            dev = first.data;
            first = null;
        }
        else {
            ultimo = ultimo.prev;
            ultimo.next = first;
            first.next = ultimo;

        }
        count--;
        return dev;
    }//O(1)


    public T remove(T elem) {
        //Elimina un elemento concreto de la lista
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE

        return null;
    }

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
        if (isEmpty())
            return false;
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        return false;
    }

    public T find(T elem) {
        //Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        return null;
    }

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
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE


    } // private class

}
