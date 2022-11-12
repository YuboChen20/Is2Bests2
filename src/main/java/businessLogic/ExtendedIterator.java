package businessLogic;

import java.util.Iterator;

public interface ExtendedIterator<Event> extends Iterator<Event> {
	
	//return	the	actual	element	and	go	to	the next
	public Event next();
	
	//true	if ther	is	a	next	element
	public boolean hasNext();
	
	//return	the	actual	element	and	go	to	the	previous
	public Event	previous();
	
	//true	if ther	is	a	previous	element
	public boolean hasPrevious();
	
	//It	is	placed	in	the	first	element
	public void goFirst();
	
	// It	is	placed	in	the	last	element
	public void goLast();
}
