package molod.yuliya.project;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Main
 * @author Molod Yuliya
 * @version 1.0
 */
public class Main {

    /** The main function with the execution of class methods
     * @param args string[] args*/
    public static void main(String[] args) {

        int conteiner_size = 0, elements = 0, action, index;
        String InputData = "";
        Scanner text = new Scanner(System.in);
        Container List = new Container();

        conteiner_size = Validation(text, 1,1000000000,"Enter number of elements: ", "Conteiner size cannot be zero or negative!");

        System.out.print("Enter elements: ");
        for (int i = 0; i < conteiner_size; i++) {
            elements = InputData(text, "");
            List.AdditionRight(elements);
        }
        System.out.println(Arrays.toString(List.Element));

        String stopLitera;
        do {
            System.out.print("1 - add left element\n");
            System.out.print("2 - add right element\n");
            System.out.print("3 - add element by index\n");
            System.out.print("4 - exclude element\n");
            System.out.print("5 - delete element\n");
            System.out.print("6 - delete element by index\n");

            action = Validation(text, 1, 6, "Choose action: ", "Enter correct number from 1 to 6!");

            switch (action) {
                case (1) -> {
                    elements = InputData(text, "Add the left element: ");
                    List.AdditionLeft(elements);
                    System.out.print("New list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
                case (2) -> {
                    elements = InputData(text, "Add the element: ");
                    List.AdditionRight(elements);
                    System.out.print("New list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
                case (3) -> {
                    elements = InputData(text, "Add the element: ");
                    index = Validation(text, 1, List.Size(), "On the place number:", "Enter correct number from 1 to " + List.Size());
                    List.AdditionByIndex(elements, index);
                    System.out.print("New list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
                case (4) -> {
                    index = Validation(text, 1, List.Size(),"Exclude the element number: ", "Enter correct number from 1 to " + List.Size());
                    System.out.print("Excluded element: " + List.ExcludeByNumber(index));
                    System.out.print("\nNew list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
                case (5) -> {
                    boolean isElement = false;
                    do {
                        System.out.print("Removing the element: ");
                        elements = text.nextInt();
                        for (int iterator = 0; iterator < List.Size(); iterator++) {
                            if (List.Element[iterator] == elements) isElement = true;
                        }
                        if (!isElement)
                            System.out.print("Enter one of the numbers: " + Arrays.toString(List.Element) + "\n");
                    } while (!isElement);
                    List.DeleteElement(elements);
                    System.out.print("New list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
                case (6) -> {
                    conteiner_size = Validation(text, 1,List.Size(),"Removing the element number: ", "Enter correct number from 1 to " + List.Size());
                    List.DeleteByNumber(conteiner_size);
                    System.out.print("New list: ");
                    System.out.println(Arrays.toString(List.Element));
                }
            }
            System.out.print("Enter 'e' for exit or 'w' for continue\n");
            do {
                stopLitera = text.nextLine();
            } while (stopLitera.equals(""));
        } while (!stopLitera.equals("e"));
        System.out.print("Program finished");
    }
    /**
     * The function
     * @return input data
     * @param text with
     * @param ConsoleMessage like element of conteiner {@link Container#ListSize}
     */
    public static int InputData(Scanner text, String ConsoleMessage) {
        int NumericResult = 1000000000;
        String InputData;
        System.out.print(ConsoleMessage);
        do{
            try {
                InputData = text.nextLine();
                NumericResult = Integer.parseInt(InputData);

            } catch(NumberFormatException e){
                NumericResult = 1000000000;
                System.err.print("Wrong string format! " + ConsoleMessage);
            }
        } while(NumericResult == 1000000000);
        return NumericResult;
    }
    /**
     * The function
     * @param text input data
     * @param ConsoleMessage tell what data need enter
     * @param ErrorMessage tell about errors
     * @param MaximumIntValue max value
     * @param MinimumIntValue min value
     * @return input data like element of conteiner {@link Container#ListSize}
     */
    public static int Validation(Scanner text, int MinimumIntValue, int MaximumIntValue, String ConsoleMessage, String ErrorMessage){
        int TemporaryIntValue = 0;
        do {
            TemporaryIntValue = InputData(text, ConsoleMessage);
            if(TemporaryIntValue < MinimumIntValue || TemporaryIntValue > MaximumIntValue){
                System.out.println(ErrorMessage);
            }
        } while(TemporaryIntValue < MinimumIntValue || TemporaryIntValue > MaximumIntValue);
        return TemporaryIntValue;
    }
}