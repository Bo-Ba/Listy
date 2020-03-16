package lists;

import java.util.ListIterator;

public class Tester {

	public static void main(String[] args){
		ExtendedOneWayLinkedListWithHead<Integer> t = new ExtendedOneWayLinkedListWithHead<Integer>();
		t.add(4);
		t.add(5);
		t.add(56765);
		System.out.println("Index 5: " + t.indexOf(5));
		System.out.println(t.isEmpty());
		t.add(2, 24);
		System.out.println("Get index 2: " + t.get(1));
		t.contains(24);
		t.set(2, 21);
		t.remove(3);
		System.out.println("Size: " + t.size());
		
		
		
		
		
		
		for(int i: t)
			{
				System.out.println(i);
			}
		

	}

}
