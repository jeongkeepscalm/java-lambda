package lambda.ex1;

import lambda.M2Interface;

public class M2After {
    public static void main(String[] args) {
        M2Interface m2Interface = (a, b) -> System.out.println("무게: " + a + b);
        m2Interface.print(10, "kg");
        m2Interface.print(50, "kg");
        m2Interface.print(200, "g");
        m2Interface.print(40, "g");
    }
}
