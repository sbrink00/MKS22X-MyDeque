import java.util.Arrays;
public class Calculator{
  public static void main(String[]args){
    String expression = "10 2.0 +";
    System.out.println(eval(expression));
    System.out.println(eval("1 2 3 4 5 + * - -") );
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
  }

  public static double eval(String s){
    String[] things = s.split(" ");//splits the string into an array of doubles and operations.
    MyDeque<String> help = new MyDeque<String>();//initializes helper MyDeque.
    for (String thing: things){
      if (!operation(thing)) help.addLast(thing);//adds numbers to MyDeque
      //if the string is an operation then it removes the last
      //two numbers and evaluates them based on what operation it is.
      else{
        Double second = Double.parseDouble(help.removeLast());
        Double first = Double.parseDouble(help.removeLast());
        double val = 1.0;
        if (thing.equals("+")) val = first + second;
        else if (thing.equals("-")) val = first - second;
        else if (thing.equals("*")) val = first * second;
        else if (thing.equals("/")) val = first / second;
        else if (thing.equals("%")) val = first % second;
        String valToAdd = val + "";
        help.addLast(valToAdd);//it then adds it back into the array.
      }
    }
    //lastly, it returns the final value.
    return Double.parseDouble(help.removeLast());
  }

  //returns whether or not a given symbol is a valid operation.
  private static boolean operation(String maybeOperation){
    String[] operations = {"+", "-", "*", "/", "%"};
    for (String operation: operations) if (operation.equals(maybeOperation)) return true;
    return false;
  }
}
