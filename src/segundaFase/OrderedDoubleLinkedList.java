package segundaFase;


public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {


	public void add(T elem){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> newNode = new Node<>(elem);
		boolean enc = false;
		if (first == null) {
			newNode.prev = newNode;
			newNode.next = newNode;
			first = newNode;
		}else{
			Node<T> act = first;
			int cont = 1;
			while (!enc && cont <= this.count){
				int x = ((Comparable<T>) newNode.data).compareTo(act.data);


				if (x == 1 && cont == this.count){ 
					if(act == first){
						newNode.next = act;
						newNode.prev = act;
						first.prev = newNode;
						first.next = newNode;
						enc = true;
					}else{
						newNode.prev = act;
						newNode.next = act.next;
						act.next.prev = newNode;
						act.next = newNode;
						enc = true;
					}
				}else if(x == -1){
					if (act == first){
						newNode.next = act;
						newNode.prev = act.prev;
						act.prev.next = newNode;
						first = newNode;
						act.prev = newNode;
						enc = true;
					}else{
						newNode.next = act;
						newNode.prev = act.prev;
						act.prev.next = newNode;
						act.prev = newNode;
						enc = true;
					}
				}
				act = act.next;
				cont ++;
			}
		}

		this.count++;
	}


}
