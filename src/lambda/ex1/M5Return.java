package lambda.ex1;

import lambda.MyFunction;

public class M5Return {

    public static MyFunction getOperation(String operation) {
        switch (operation) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a, b) -> 0;
        }
    }

    public static void main(String[] args) {
        int add = getOperation("add").apply(1,2);
        int sub = getOperation("sub").apply(1,2);
        int other = getOperation("xxx").apply(1,2);
        System.out.println(add);
        System.out.println(sub);
        System.out.println(other);
    }

}
