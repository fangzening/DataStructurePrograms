package HW3_zening;

public class IDLListTest {

    public static void main(String[] args) {

        IDLList<Integer> testList = new IDLList();

        // add element 1 at the head
        // result: [1]
        testList.add(1);
        System.out.println("The first element is: " + testList.toString() + "\n");

        // add element 3 at the head
        // result: [3, 1]
        testList.add(0,3);
        System.out.println("After add 5, the list is " + testList.toString() + "\n");

        // add element 5 at index 1
        // result: [3, 5, 1]
        testList.add(1,5);
        System.out.println("After add 8 at index 1, the list is " + testList.toString() + "\n");


        // append element 9 at the end of the list
        // result: [3, 5, 1, 9]
        testList.append(9);
        System.out.println("After append, the list is : " + testList.toString() + "\n");

        // returns the object at position index 1 from the head
        // result: 5
        System.out.println("now the list is: " + testList.toString());
        System.out.println("Get element of position 1 : " + testList.get(1) + "\n");

        // return the object at the head
        // result: 3
        System.out.println("now the list is: " + testList.toString());
        System.out.println("Get head element in list: " + testList.getHead() + "\n");

        // return the object at the tail
        // result: 9
        System.out.println("now the list is: " + testList.toString());
        System.out.println("Get tail element in list: " + testList.getLast() + "\n");

        // return the list size
        System.out.println("The list size is: " + testList.size() + "\n");

        // remove and return element at the head
        System.out.println("Now the list is: " + testList.toString());
        System.out.println("The removed element is: " + testList.remove());
        System.out.println("After remove, list becomes: " + testList.toString() + "\n");

        // remove and return the element at the tail
        System.out.println("Now the list is: " + testList.toString());
        System.out.println("The removed element is: " + testList.removeLast());
        System.out.println("After remove, now list is: " + testList.toString() + "\n");

    }

}