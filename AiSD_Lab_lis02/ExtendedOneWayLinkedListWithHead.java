package lists;

import java.nio.channels.IllegalSelectorException;
import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class ExtendedOneWayLinkedListWithHead <T> extends AbstractList<T> implements Iterable<T> {
	
	 private OneWayLinkedListWithHead<T> innerList = new OneWayLinkedListWithHead<>();
	 

	public boolean isEmpty() {
		return innerList.isEmpty();
	}
	
	public void clear() {
		innerList.clear();
	}
	
	@Override
	public boolean add (T e) {
		return innerList.add(e);
	}
	
	@Override
	public void add(int index, T data) {
		innerList.add(index, data);
	}
	
	@Override
	public T get(int index) {
		return innerList.get(index);
	}
	
	@Override
	public int indexOf(Object data) {
		return	innerList.indexOf(data);
	}
	
	@Override
	public boolean contains(Object data) {
		return innerList.contains(data);
	}
	
	@Override
	public T set (int index, T data) {
		return innerList.set(index, data);
	}
	
	@Override
	public T remove (int index) {
		return innerList.remove(index);
	}
	
	@Override
	public boolean remove (Object value) {
		return innerList.remove(value);
	}

	@Override
	public int size() {
		return innerList.size();
	}
	
	@Override
	public ListIterator<T> listIterator() {
		return new ListIterator<T>() {
			int cursor = -1, listSize = innerList.size(); 
			T lastReturned;
			boolean wasPrevious;
			
			@Override
			public boolean hasNext() {
				return cursor < listSize -1;
			}
			
			@Override
			public T next() {
				
				try {
				cursor++;
				lastReturned = innerList.get(cursor);
				return lastReturned;
				} catch (IndexOutOfBoundsException e)
				
				{
					throw new NoSuchElementException();
				}
			}
			
			@Override
			public boolean hasPrevious() {	
				return cursor > -1;
			}
			
			@Override
			public T previous() {
				try {
					wasPrevious = true;
					int temp = cursor;
					cursor--;
					lastReturned = innerList.get(temp);
					return lastReturned;
				} catch (IndexOutOfBoundsException e)
				{
					throw new NoSuchElementException();
				}
				
			}
			
			@Override
			public int nextIndex() {
				int temp = cursor +1;
				return temp;
			}
			
			@Override
			public int previousIndex() {
				int temp = cursor - 1;
				return temp;
			}
			
			@Override
			public void remove() {		
				
				if (lastReturned != null) 
				{
				int index = innerList.indexOf(lastReturned);
				innerList.remove(index);
				lastReturned = null;
				if(!wasPrevious) cursor --;
				listSize--;
				}
					else {
						throw new IllegalStateException();
					}
				
				
			}
			
			@Override
			public void set(T e) {
				
				if (lastReturned != null)
				{
					innerList.set(cursor, e);
				}
				else throw new IllegalStateException();
				lastReturned = null;
				
			}
			
			@Override
			public void add(T e) {
				cursor++;
				innerList.add(cursor, e);
				listSize++;
				lastReturned = null;
			}
			
			@Override public void forEachRemaining(Consumer<? super T> action){ throw new UnsupportedOperationException(); }
		};
	}
	
	
	
}
