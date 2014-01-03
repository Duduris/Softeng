package additional;

import java.util.Observable;

public class ObservableBool extends Observable {
  private boolean value;
 
  public ObservableBool() {}
 
  public ObservableBool(boolean startingValue) {
    value = startingValue;
  }
 
  public boolean get(){
    return value;
  }
 
  public void set(boolean newValue){
      value = newValue;
      notifyChange(); 
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(new Boolean(value));
  }
}