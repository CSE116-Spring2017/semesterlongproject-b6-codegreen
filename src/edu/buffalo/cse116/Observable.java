package observer_pattern;

public interface Observable {
	
	public void notifyObservers();
	public void addObserver(Observer o);

}
