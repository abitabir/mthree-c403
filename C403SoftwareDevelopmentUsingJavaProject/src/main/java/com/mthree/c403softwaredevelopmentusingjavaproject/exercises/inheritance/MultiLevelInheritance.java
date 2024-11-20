/*
 * Dated: 07/10/2024

CREATE MULTI LEVEL INHERITANCE

EACH CLASS MUST HAVE:
I> 2 VARIABLES OF DIFFERENT DATA TYPE
II> 2 METHODS OF DIFFERENT NAMES AND RETURNING SOMETHING
III> 2 CONSTRUCTORS

NOTE -> INSIDE MAIN METHOD YOU ARE ALLOWED ONLY 1 LINE OF CODE

OUTPUT -> IT SHOULD PRINT TOTAL 18 LINES STARTING FROM GRAND PARENT CLASS TO CHILD CLASS


TRY TO USE ACCESS SPECIFIERS

 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.inheritance;

/**
 * @author khali
 */
class GrandParent {

    int gpVar1 = 1;
    String gpVar2 = "Bye for now from the Grandparent class";

    int gpMethod1() {

        System.out.println(this.gpVar2 + "'s method returning an int value...");
        return this.gpVar1;

    }

    String gpMethod2() {

        System.out.println(this.gpVar2 + "'s method returning a String value...");
        return this.gpVar2;
    }

    public GrandParent() {

        this(1);
        int gpMethodReturned1 = gpMethod1();
        String gpMethodReturned2 = gpMethod2();
        System.out.println("The Grandparent class's methods returned the int '" + gpMethodReturned1 + "' and the String: '" + gpMethodReturned2 + "'");
        System.out.println(this.gpVar2 + "'s default constructor");

    }

    public GrandParent(int gpInt) {

        System.out.println(this.gpVar2 + "'s parameterised constructor");
        if (gpInt == this.gpVar1) {
            System.out.println("where the input parameter was equal to the int value stored in the Grandparent class");
        } else {
            System.out.println("where the input parameter was not equal to the int value stored in the Grandparent class");
        }
    }
}

class Parent extends GrandParent {

    int pVar1 = 2;
    String pVar2 = "Bye for now from Parent class";

    int pMethod1() {

        System.out.println(this.pVar2 + "'s method returning an int value...");
        return this.pVar1;

    }

    String pMethod2() {

        System.out.println(this.pVar2 + "'s method returning a String value...");
        return this.pVar2;
    }

    public Parent() {

        this(1);
        int pMethodReturned1 = pMethod1();
        String pMethodReturned2 = pMethod2();
        System.out.println("The Parent class's methods returned the int '" + pMethodReturned1 + "' and the String: '" + pMethodReturned2 + "'");
        System.out.println(this.pVar2 + "'s default constructor");

    }

    public Parent(int pInt) {

        super();
        System.out.println(this.pVar2 + "'s parameterised constructor");
        if (pInt == this.pVar1) {
            System.out.println("where the input parameter was equal to the int value stored in the Parent class");
        } else {
            System.out.println("where the input parameter was not equal to the int value stored in the Parent class");
        }
    }
}

class Child extends Parent {

    int cVar1 = 1;
    String cVar2 = "Bye for now from Child class";

    int cMethod1() {

        System.out.println(this.cVar2 + "'s method returning an int value...");
        return this.cVar1;

    }

    String cMethod2() {

        System.out.println(this.cVar2 + "'s method returning a String value...");
        return this.cVar2;
    }

    public Child() {
        this(1);
        int cMethodReturned1 = cMethod1();
        String cMethodReturned2 = cMethod2();
        System.out.println("The Child class's methods returned the int '" + cMethodReturned1 + "' and the String: '" + cMethodReturned2 + "'");
        System.out.println(this.cVar2 + "'s default constructor");

    }

    public Child(int cInt) {

        super();
        System.out.println(this.cVar2 + "'s parameterised constructor");
        if (cInt == this.cVar1) {
            System.out.println("where the input parameter was equal to the int value stored in the Child class");
        } else {
            System.out.println("where the input parameter was not equal to the int value stored in the Child class");
        }
    }
}

public class MultiLevelInheritance {

    public static void main(String args[]) {

        Child c = new Child();

    }
}
