public class Level1 {
    // 1. Generic clas Box that can hold any type of value
    static class Box<T>{
        T value;

        void set(T value){
            this.value = value;
        }
        T get(){
            return value;
        }
    }
   // 2. Create a method to print any type.
    public static <T> void printValue(T value) {
        System.out.print(value + " ");
        System.out.println();
    }

    // 3. Generic Method with Array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
    // 1. Create a Box class that can hold any type of value and demonstrate its usage.
        Box<Integer> box1 = new Box<>();
        box1.set(123);
        System.out.println(box1.get());

        Box<String> box2 = new Box<>();
        box2.set("Hello");
        System.out.println(box2.get());

    // 2. Use the printValue method to print different types of values.
        printValue(123); // prints an integer
        printValue("Hello"); // prints a string
        printValue(3.14); // prints a double

    // 3. Use the printArray method to print an array of different types.
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D", "E"};
        System.out.println("Integer Array:");
        printArray(intArray);
        System.out.println("String Array:");
        printArray(strArray);

    }
}
