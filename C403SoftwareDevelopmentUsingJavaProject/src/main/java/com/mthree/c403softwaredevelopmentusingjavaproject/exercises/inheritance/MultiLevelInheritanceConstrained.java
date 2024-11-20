package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.inheritance;

/**
 * Dated: 04/10/2024
 * Alternative version to MultiLevelInheritance.java, in which I misread the instructions as follows:

CREATE MULTI LEVEL INHERITANCE

MUST HAVE:
CLASS I > 2 VARIABLES OF DIFFERENT DATA TYPE
CLASS II > 2 METHODS OF DIFFERENT NAMES AND REUTURNING SOMETHING
CLASS III > 2 CONSTRUCTORS

NOTE -> INSIDE MAIN METHOD YOU ARE ALLOWED ONLY 1 LINE OF CODE

OUTPUT -> IT SHOULD PRINT TOTAL 18 LINES STARTING FROM GRAND PARENT CLASS TO CHILD CLASS

TRY TO USE ACCESS SPECIFIERS

*/

/*

CREATE MULTI LEVEL INHERITANCE

EACH CLASS MUST HAVE :
I> 2 VARIABLES OF DIFFERENT DATA TYPE
II> 2 METHODS OF DIFFERENT NAMES AND REUTURNING SOMETHING
III> 2 CONSTRUCTORS

NOTE -> INSIDE MAIN METHOD YOU ARE ALLOWED ONLY 1 LINE OF CODE

OUTPUT -> IT SHOULD PRINT TOTAL 18 LINES STARTING FROM GRAND PARENT CLASS TO
          CHILD CLASS


TRY TO USE ACCESS SPECIFIERS

 */


class Iclass {

    int var1 = 18; // print this many times
    String var2 = "";

}

class IIclass extends Iclass {

    String printManyTimes(int num, int times) {

        for (int i = 0; i < times; i++) {
            System.out.println(num);
            super.var2 += num + "\n";
        }
        return super.var2;
    }

    String printManyTimes(String str, int times) {

        for (int i = 0; i < times; i++) {
            System.out.println(str);
            super.var2 += str + "\n";
        }
        return super.var2;
    }
}

class IIIclass extends IIclass {

    IIIclass(int num) {
        String printedNum = super.printManyTimes(num, super.var1);
    }

    IIIclass(String str) {
        String printedStr = super.printManyTimes(str, super.var1);
    }
}

public class MultiLevelInheritanceConstrained {
    
    public static void main(String[] args) {
        IIIclass obj = new IIIclass("hello world");
    }
    
}
