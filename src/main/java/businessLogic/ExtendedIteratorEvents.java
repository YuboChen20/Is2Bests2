package businessLogic;

import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	private Vector<Event> eventL;
	private int posAct = -1;
	private int lon;
	public ExtendedIteratorEvents(Vector<Event> eventL) {
		
		this.eventL = eventL;
		this.lon=eventL.size();
	}

	@Override
	public Event next() {
		posAct++;
		return  eventL.elementAt(posAct);
	}

	@Override
	public boolean hasNext() {
		 if (posAct == lon -1) return false;
		 if ((this.eventL.isEmpty()) || (this.eventL.elementAt(posAct+1)==null)) return false;
		 else return true;
	}

	@Override
	public Event previous() {
		posAct--;
		return this.eventL.elementAt(posAct);
	}

	@Override
	public boolean hasPrevious() {
		 if(posAct==0) return false;
		 if ((this.eventL.isEmpty()) ||(this.eventL.elementAt(posAct-1)==null) ) return false;
		 else return true;
	}

	@Override
	public void goFirst() {
		posAct=-1;
		
	}

	@Override
	public void goLast() {
		posAct=lon;
		
	}

}
