package additional;

import java.util.Observable;

public class ObservableBoolArray extends Observable {
  private boolean[] value;
 
  public ObservableBoolArray() {}
 
  public ObservableBoolArray(boolean[] startingValue) {
    value = startingValue;
  }
 
  public boolean[] get(){
    return value;
  }
 
  public void set(boolean[] newValue){
      value = newValue;
      notifyChange(); 
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(value);
  }
}