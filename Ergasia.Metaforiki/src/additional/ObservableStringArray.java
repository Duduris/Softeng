package additional;

import java.util.Observable;

public class ObservableStringArray extends Observable {
  private String[] value;
 
  public ObservableStringArray() {}
 
  public ObservableStringArray(String[] startingValue) {
    value = startingValue;
  }
 
  public String[] get(){
    return value;
  }
 
  public void set(String[] newValue){
      value = newValue;
      notifyChange(); 
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(value);
  }
}