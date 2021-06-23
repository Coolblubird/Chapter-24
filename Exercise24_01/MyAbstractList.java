import java.util.*;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Adds the elements in otherList to this list.
	* Returns true if this list changed as a result of the call */ 
	public boolean addAll(MyList<E> otherList){
		for (int b=0; b<otherList.size(); b++){
			add(otherList.get(b));
		}
		
		return true;
	}

	/** Removes all the elements in otherList from this list
	* Returns true if this list changed as a result of the call */ 
	public boolean removeAll(MyList<E> otherList){
		boolean returner = false;
		
		for (int b=0; b<otherList.size(); b++){
			for (int i=0; i<this.size(); i++){
				if (otherList.get(b) == this.get(i)){
					this.remove(i);
					returner = true;
				}
			}
		}
		
		return returner;
	}

	/** Retains the elements in this list that are also in otherList 
	* Returns true if this list changed as a result of the call */ 
	public boolean retainAll(MyList<E> otherList){
		boolean returner = false;
		MyList<E> temp = new MyArrayList<E>();
		
		for (int b=0; b<otherList.size(); b++){
			for (int i=0; i<this.size(); i++){
				if (otherList.get(b) == this.get(i)){
					temp.add(this.get(i));
					returner = true;
				}
			}
		}
		
		this.clear();
		this.addAll(temp);
		
		return returner;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
}