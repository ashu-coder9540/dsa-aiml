import java.util.*;

public class PrintLinkedList {
    public static void main(String[] args) {
        // create linkedList
        LinkedList<Integer> ll = new LinkedList<>();

        // print Linked List
        ll.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(ll);

        // Add element first and last
        ll.addFirst(8);
        ll.addLast(9);

        System.out.println(ll);
        // Remove elements from linked list
        ll.remove(2);
        System.out.println(ll);

        // Traverse linkedlist using loop
        for(var e: ll){
            System.out.print(e + " ");
        }

        System.out.println();

        // Find size of linked list 
        System.out.println(ll.size());

        // search element in linked list
        System.out.println(ll.contains(3));

        // reverse a linkedlist
            LinkedList<Integer> reversedLL = new LinkedList<>();
            for(int i = ll.size() - 1; i >= 0; i--){
                reversedLL.add(ll.get(i));
            }
            System.out.println(reversedLL);

        // find the middle element of linked list
        int middleIndex = ll.size() / 2;
        System.out.println("Middle element: " + ll.get(middleIndex));

        // Remove duplicate elment in linkd list
            LinkedList<Integer> uniqueLL = new LinkedList<>();
            for(Integer e: ll){
                if(!uniqueLL.contains(e)){
                    uniqueLL.add(e);
                }
            }
            System.out.println(uniqueLL);

        // Merge two linked list
            LinkedList<Integer> ll2 = new LinkedList<>();
            ll2.addAll(Arrays.asList(6, 7, 8, 9, 10));
            LinkedList<Integer> mergedLL = new LinkedList<>();
            mergedLL.addAll(ll);
            mergedLL.addAll(ll2);
            System.out.println(mergedLL);
    }
}
