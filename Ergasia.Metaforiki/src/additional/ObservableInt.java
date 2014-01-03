package additional;

import java.util.Observable;

public class ObservableInt extends Observable {
  private int value = 0;
 
  public ObservableInt() {}
 
  public ObservableInt(int startingValue) {
    value = startingValue;
  }
 
  public int get(){
    return value;
  }
 
  public void set(int newValue){
    if(newValue != value){
      value = newValue;
      notifyChange();
    }
  }
 
  public void increment(){
    value++;
    notifyChange();
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(new Integer(value));
  }
}