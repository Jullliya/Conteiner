package molod.yuliya.project.test;
import molod.yuliya.project.Container;

import org.junit.Test;

import static org.junit.Assert.*;


public class Container_test {

      private Container test = new Container();

      @Test
      public void AdditionLeftTest()   {
          assertEquals(0, test.Size());
          test.AdditionRight(11);
          test.AdditionRight(12);
          test.AdditionRight(13);
          test.AdditionLeft(10);
          assertEquals(4, test.Size());
          assertEquals(10,test.ExcludeByNumber(1));
      }

    @Test
    public void AdditionRightTest()   {
        assertEquals(0, test.Size());
        test.AdditionLeft(13);
        test.AdditionLeft(12);
        test.AdditionLeft(11);
        test.AdditionRight(10);
        assertEquals(4, test.Size());
        assertEquals(10,test.ExcludeByNumber(test.Size()));
    }

    @Test
    public void AdditionByIndexTest()   {
        assertEquals(0, test.Size());
        test.AdditionRight(11);
        test.AdditionRight(12);
        test.AdditionRight(13);
        test.AdditionByIndex(10, 2);
        assertEquals(4, test.Size());
        assertEquals(10,test.ExcludeByNumber(2));
    }


    @Test
    public void ExcludeByNumber()   {
        assertEquals(0, test.Size());
        test.AdditionRight(11);
        test.AdditionRight(12);
        test.AdditionRight(13);
        assertTrue(test.ExcludeByNumber(2) == 12);
        assertEquals(2, test.Size());
        assertEquals(11,test.GetElement(1));
        assertEquals(13,test.GetElement(2));
    }

    @Test
    public void DeleteElementTest()   {
        assertEquals(0, test.Size());
        test.AdditionRight(11);
        test.AdditionRight(12);
        test.AdditionRight(13);
        test.AdditionRight(14);
        test.DeleteElement(13);
        assertEquals(3, test.Size());
        assertEquals(12,test.GetElement(2));
        assertEquals(14,test.GetElement(3));
    }

    @Test
    public void DeleteByNumberTest()   {
        assertEquals(0, test.Size());
        test.AdditionRight(11);
        test.AdditionRight(12);
        test.AdditionRight(13);
        test.AdditionRight(14);
        test.DeleteByNumber(2);
        assertEquals(3, test.Size());
        assertEquals(13,test.GetElement(2));
        assertEquals(14,test.GetElement(3));
    }
}