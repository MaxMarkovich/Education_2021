package edu2.120220Test;

public class MyClassTest extends Assertions {
    @Test
    public void Test()
    {
        //prep
        //action
        //check
        MyClass myClass =new MyClass();
        int result = myClass.add(10);
        assertEquals(12,result);
    }
}
