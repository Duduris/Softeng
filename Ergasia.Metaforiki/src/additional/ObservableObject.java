package additional;

import java.util.Observable;

public class ObservableObject<T> extends Observable {
  private T value;
 
  public ObservableObject() {}
 
  public ObservableObject(T startingValue) {
    value = startingValue;
  }
 
  public T get(){
    return value;
  }
 
  public void set(T newValue){
      value = newValue;
      notifyChange(); 
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(value);
  }
}