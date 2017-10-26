package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    public void addToFront(T elem) {
        // a�ade un elemento al comienzo
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> newNode = new Node<>(elem);
        if (first == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
            first = newNode;
        } else {
            Node ultimo = first.prev;
            newNode.prev = ultimo;
            ultimo.next = newNode;
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }

        count++;


    }//COSTE O(1)

    public void addToRear(T elem) {
        // a�ade un elemento al final
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> newNode = new Node<>(elem);
        if (first == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            first = newNode;
        } else {
            Node ultimo = first.prev;
            newNode.prev = ultimo;
            first.prev = newNode;
            ultimo.next = newNode;
            newNode.next = first;
        }
        count++;


    }//COSTE O(1)

    public void addAfter(T elem, T target) {
        // A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
        // �COMPLETAR OPCIONAL!
    	Node<T> newNode = new Node<>(elem);
    	Node<T> act = first;
    	Node<T> tar = new Node<>(target);
    	
    	while(act.data != tar.data){
    		act = act.next;
    	}
    	
    	if(first.prev == target){ //Caso: Target ultimo
    		tar.next = newNode;
    		newNode.next = first.prev;
    		newNode.prev = tar;
    		first.prev = newNode;
    	}else{ //Caso: Target no ultimo
    		newNode.next = act.next;
    		newNode.prev = act;
    		newNode.next.prev = newNode;
    		act.next = newNode;
    	}
    	this.count ++;
    }//COSTE O(1)


}
