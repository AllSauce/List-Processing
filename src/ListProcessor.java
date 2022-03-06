import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * A collection of methods
 * for arrays and Lists.
 * Listing up an array or List.
 * Shuffling an array or List through iteration.
 * Shuffling an array or List through recursion.
 *
 * @author Krenar Manxhuka
 * @version 2020-11-13
 */

public class ListProcessor{

    public ListProcessor(){

    }

    /**
     * This method takes two int parameters 'from' and 'to'
     * It then creates an array with the integers between
     * from and to, also including from.
     *
     * @param from - First value of the array
     * @param to - Last value of the array
     *
     */
    public int[] arraySequence(int from, int to){
      if(to < from){
        throw new IllegalArgumentException("First value must be smaller than second value.");
      }
      int[] theArray = new int[(to - from)];
      if(from < to){
        int element = from;
        while(element < to){
          for(int i = 0; i < theArray.length; i++){
            theArray[i] = element;
            element++;
            }
          }
        }
        else if(from == to){
          theArray = new int[0];
        }
        return theArray;
    }

    /**
     *
     * Takes in two int parameters 'from' and 'two'.
     * It then creates an arrayList with all the integers
     * from 'from' to 'to' also including 'from'.
     *
     * @param from - First value of arrayList
     * @param to - Last value of arrayList
     */
    public List<Integer> listSequence(int from, int to){
      if(to < from){
        throw new IllegalArgumentException("First value must be smaller than second value.");
      }
      else if(from == to){
        List<Integer> list = new ArrayList<Integer>();
      }
      List<Integer> list = new ArrayList<Integer>();
      int element = from;
      while(element < to){
        list.add(element);
        element++;
      }
      return list;
    }

    /**
     * This method shuffles an array of integers through iteration.
     *
     * @param numbers
     */
    public int[] shuffled(int[] numbers){
      int[] getShuffled = new int[numbers.length];
      System.arraycopy(numbers, 0, getShuffled, 0, numbers.length);

      Random rand = new Random();

      for(int i = 0; i < getShuffled.length; i++){
        int swap = rand.nextInt(getShuffled.length);
        int temp = getShuffled[swap];
        getShuffled[swap] = getShuffled[i];
        getShuffled[i] = temp;
      }
      return getShuffled;
    }

    /**
     *  This method shuffles a list of integers through iteration.
     *
     * @param numbers - Name of List
     */
    public List<Integer> shuffled(List<Integer> numbers) {
      List<Integer> copy = new ArrayList<Integer>(numbers);
      List<Integer> newList = new ArrayList<Integer>();
      Random random = new Random();
      while(copy.size() > 0) {
        int randomIndex = random.nextInt(copy.size());
        newList.add(copy.get(randomIndex));
        copy.remove(randomIndex);
      }
      return newList;
    }

    /**
     * Returns the sum of an array on integers.
     *
     * @param numbers - Name of array
     */
    public int sumIterative(int[] numbers){
      int sum = 0;
      for(int i = 0; i < numbers.length; i++){
       sum = sum + numbers[i];
      }
      return sum;
    }

    /**
     * Returns the sum of a list of integers.
     *
     * @param numbers - Name of List
     */
    public int sumIterative(List<Integer> numbers){
      int sum = 0;
      for(int i = 0; i < numbers.size(); i++){
        sum += numbers.get(i);
      }
      return sum;
    }

    /**
     * Returns the sum of an array, through recursion.
     * It repeatedly removes one from the array length
     * so that the basecase will eventually be met.
     *
     * @param numbers - array that you want the sum of.
     */
    public int sumRecursive(int[] numbers){
      if(numbers.length == 0){
        return 0;
      }
      else if(numbers.length == 1){
        return numbers[0];
      }
      else {
        return numbers[0] + sumRecursive(Arrays.copyOfRange(numbers, 1, numbers.length));
      }
    }

    /**
     * Returns the sum a List, through recursion.
     * It repeatedly removes one from the List size so that
     * it eventually reaches the basecase.
     *
     * @param numbers - List that you want the sum of.
     */
    public int sumRecursive(List<Integer> numbers){
      if(numbers.isEmpty() == true){
        return 0;
      }
      else {
        return numbers.get(0) + sumRecursive(numbers.subList(1, numbers.size()));
      }
    }

    //Main method
    public static void main(String[] args){
      ListProcessor a = new ListProcessor();
      int[] array = {1, 2, 3, 4, 5};
      List<Integer> list = new ArrayList<Integer>();
      list.add(2);
      list.add(3);
      list.add(5);
      list.add(3);

      System.out.println(Arrays.toString(a.arraySequence(5, 10)));
      System.out.println(a.listSequence(5, 10));
      System.out.println(Arrays.toString(a.shuffled(array)));
      System.out.println(a.shuffled(list));
      System.out.println(a.sumIterative(array));
      System.out.println(a.sumIterative(list));
      System.out.println(a.sumRecursive(array));
      System.out.println(a.sumRecursive(list));
    }
}
