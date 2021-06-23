import java.util.*;

//jordan Ashe 06-14-21

public class Exercise_24_05 {
	public static void main(String[] args){
		GenericQueue<String> strings = new GenericQueue<>();
		
		strings.enqueue("apple loops");
		strings.enqueue("BA NA ANA");
		strings.enqueue("Foor Bar");
		
		int max = strings.getSize();
		
		for(int i=0; i<max; i++){
			System.out.println(strings.dequeue());
		}
	}
}


class GenericQueue<E> extends LinkedList<E> {
	private LinkedList<E> list = new LinkedList<>();

	public void enqueue(E e) {
		list.addLast(e);
	}

	public E dequeue() {
		return list.removeFirst();
	}

	public int getSize() {
		return list.size();
	}
}