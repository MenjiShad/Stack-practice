import java.util.Scanner;
import java.util.ArrayList;

public class notebookStack
{
  // instance variables
  protected ArrayList<Integer> aList = new ArrayList<Integer>();
  protected Scanner input = new Scanner(System.in);
  protected int top = -1;

  public boolean isEmpty()
  {
    return top == -1;
  }
  
  public int peek()
  {
    if (isEmpty())
    {
      System.out.println("Your stack is empty."); 
    }
    return aList.get(top);
  }
  
  public int getSize()
  {
    return aList.size();
  }
  public void push(int i)
  {
   aList.add(i);
   top++;
  }
  
  public int pop()
  {
    if (isEmpty())
    {
      System.out.println("Stack is empty");
    }
    return aList.remove(top--);
  }
  
  public void retrieve(int search, notebookStack subStack)
  {
    if (isEmpty())
    {
      System.out.println("Stack is empty. Could not retrieve element");
      while (!subStack.isEmpty())
      {
        push(subStack.pop());
      }
      return;
    }
    if (!isEmpty())
    {
      if (search == peek())
      {
        System.out.println("Element retrieved " + pop());
        while (!subStack.isEmpty())
        {
          push(subStack.pop());
        }
      } else
      {
        subStack.push(pop());
        retrieve(search, subStack);
      }
    }
  }
  
  public void display()
  {
   System.out.print("\nStack = ");
   if (aList.size() == 0)
   {
     System.out.println("Empty\n");
   } else
   {
     System.out.print(" (Bottom) ");
   }
    for (int count = 0; count <= top; count++)
    {
      System.out.print(aList.get(count) + " ");
    }
    if (!isEmpty())
    {   
      System.out.println(" (Top)");
    }
  }
}
