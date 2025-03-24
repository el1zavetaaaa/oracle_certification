package sandbox;

public class A {

    public A() {
        print();
    }

    void print() {
        System.out.println("A");
    }

    int calculate(int i, int a){
        return i+a;
    }
    double calculate(byte i, byte a){
        return i;
    }
}
