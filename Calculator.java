import java.util.Arrays;
public class Calculator{
  public static void main(String[]args){
    String expression = "10 2.0 +";
    System.out.println(eval(expression));
    System.out.println(eval("1 2 3 4 5 + * - -") );
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
  }

  @SuppressWarnings("unchecked")
  public static double eval(String s){
    String[] things = s.split(" ");
    //System.out.println(Arrays.toString(things));
    MyDeque<String> help = new MyDeque<String>();
    for (String thing: things){
      if (!operation(thing)) help.addLast(thing);
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
        help.addLast(valToAdd);
      }
    }
    return Double.parseDouble(help.removeLast());
  }

  private static boolean operation(String maybeOperation){
    String[] operations = {"+", "-", "*", "/", "%"};
    for (String operation: operations) if (operation.equals(maybeOperation)) return true;
    return false;
  }
}
