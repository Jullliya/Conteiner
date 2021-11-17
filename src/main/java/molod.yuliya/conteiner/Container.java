package molod.yuliya.project;

/**
 * Class container with properties <b>n</b> and <b>Element</b>.
 * @author Molod Yuliya
 * @version 1.0
 */
public class Container {

    /** Container volume field */
    int ListSize;
    /** Box with container Elements */
    int[] Element;

    /**
     * Constructor - creating a new object
     * @see Container#Container()
     */
    public Container () {
        ListSize = 0;
        Element = new int[ListSize];
    }

    /**
     * Function for addition element
     * @param AddedElement added element
     *                     on the left part of container {@link Container#Element}
     */
    public void AdditionLeft (int AddedElement) {
            ListSize++;
            int[] TemporaryArray = new int[ListSize];
            TemporaryArray[0] = AddedElement;
            for (int iterator = 1; iterator < ListSize; iterator++) {
                TemporaryArray[iterator] = Element[iterator - 1];
            }
            Element = TemporaryArray;
    }

    /**
     * Function for addition element
     * @param AddedElement added element
     *                     on the right part of container {@link Container#Element}
     */
    public void AdditionRight (int AddedElement) {
        ListSize++;
        int[] TemporaryArray = new int[ListSize];
        for (int iterator = 0; iterator < ListSize - 1; iterator++) {
            TemporaryArray[iterator] = Element[iterator];
        }
        TemporaryArray[ListSize - 1] = AddedElement;
        Element = TemporaryArray;
    }

    /**
     * Function for addition element
     * @param AddedElement on the place number
     * @param NumberElement of container {@link Container#Element}
     */
    public void AdditionByIndex (int AddedElement, int NumberElement) {
        ListSize++;
        int[] TemporaryArray = new int[ListSize];
        for (int iterator = 0; iterator < NumberElement - 1; iterator++) {
            TemporaryArray[iterator] = Element[iterator];
        }
        TemporaryArray[NumberElement - 1] = AddedElement;
        for (int iterator = NumberElement; iterator < ListSize; iterator++) {
            TemporaryArray[iterator] = Element[iterator - 1];
        }
        Element = TemporaryArray;
    }

    /**
     * The function of getting the item under the number n {@link Container#ListSize}
     * from container {@link Container#Element}
     * @param NumberElement index of exclude element
     * @return returns the value of an Element
     */
    public int ExcludeByNumber (int NumberElement) {
        int a = 0;
        ListSize--;
        int[] TemporaryArray = new int[ListSize];
        for (int iterator = 0; iterator < NumberElement-1; iterator++) {
            TemporaryArray[iterator] = Element[iterator];
        }
        a = Element[NumberElement-1];
        for (int iterator = NumberElement; iterator <= ListSize; iterator++) {
            TemporaryArray[iterator-1] = Element[iterator];
        }
        Element = TemporaryArray;
        return a;
    }
    /**
     * The function to delete element
     * from container {@link Container#Element}
     * @param RemovedElement removed element
     * @return mistake code
     */
    public int DeleteElement (int RemovedElement) {
        int NumberElement = 0;
        if(ListSize!=0) {
            boolean IsElementFind = false;
            for (int iterator = 0; iterator < ListSize; iterator++) {
                if (Element[iterator] == RemovedElement) {
                    IsElementFind = true;
                    NumberElement = iterator;
                }
            }
            if(IsElementFind) {
                ListSize--;
                int[] copy = new int[ListSize];
                for (int iterator = 0; iterator < NumberElement; iterator++) {
                    copy[iterator] = Element[iterator];
                }
                for (int iterator = NumberElement; iterator < ListSize; iterator++) {
                    copy[iterator] = Element[iterator+1];
                }
                Element = copy;
            } else return -1;
        }
        return 0;
    }
    /**
     * The function of deleting an Element under a number n {@link Container#ListSize}
     * from container {@link Container#Element}
     * @param NumberElement number of deleted element
     */
    public void DeleteByNumber (int NumberElement) {
        if(ListSize!=0) {
            if (NumberElement <= ListSize ) {
                ListSize--;
                int[] TemporaryArray = new int[ListSize];
                for (int iterator = 0; iterator < NumberElement-1; iterator++) {
                    TemporaryArray[iterator] = Element[iterator];
                }
                for (int iterator = NumberElement-1; iterator < ListSize; iterator++) {
                    TemporaryArray[iterator] = Element[iterator+1];
                }
                Element = TemporaryArray;
            }
        }
    }
    /**
     * The function @
     * @return size of conteiner {@link Container#ListSize}
     */
    public int Size(){
        return ListSize;
    }
    /**
     * The function
     * @return element
     * @param NumberElement of conteiner {@link Container#ListSize}
     */
    public int GetElement(int NumberElement) {
        return Element[NumberElement-1];
    }
}