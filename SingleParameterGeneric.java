class Box<T> {
    private T val;

    public Box(T val) {
        this.val = val;
    }

    public T getValue() {
        return val;
    }

    public void setValue(T val) {
        this.val = val;
    }
}

public class SingleParameterGeneric {
    public static void main(String[] args) {
       
        Box<Integer> integerBox = new Box<>(10); 
        System.out.println("Value in integerBox: " + integerBox.getValue());


        int intValue = integerBox.getValue(); 
        System.out.println("Auto-unboxed value: " + intValue);
    }
}
