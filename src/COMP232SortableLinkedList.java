/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	public void insertionSortList() {
		for(int i = 1; i < size; i++) {
			for(int j = i-1; j >= 0; j --) {
				if(get(j).compareTo(get(j + 1)) == 1) {
					E curr = get(j);
					set(j, get(j + 1));
					set(j + 1, curr);
				}
				else {
					break;
				}
			}
		}
	}
}
