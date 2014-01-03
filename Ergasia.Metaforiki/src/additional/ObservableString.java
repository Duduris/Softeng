package additional;

import java.util.Observable;

public class ObservableString extends Observable {
  private String value = "";
 
  public ObservableString() {}
 
  public ObservableString(String startingValue) {
    value = startingValue;
  }
 
  public String get(){
    return value;
  }
 
  public void set(String newValue){
    if(!newValue.equals(value)){
      value = newValue;
      notifyChange();
    }
  }
 
  // Notify the observers calling the update method.
  private void notifyChange(){
    setChanged();
    notifyObservers(new String(value));
  }
}