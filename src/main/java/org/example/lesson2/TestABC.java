package org.example.lesson2;

public class TestABC {
    public static void main(String[] args) {
        A a  = new A();
        B b = new B();

        a.hello();
        b.hello();

        a.world();
        b.world();

        A bb = new B();
        bb.world();

        b.secure();
    }
}
