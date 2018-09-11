public class LinkedStack<Item> {
    //initialze list with first node
    private Node first = null;

    //node class contains info of the node
    private class Node {
        Item item;
        Node next;
    } 

    //check if list is empty
    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first; 
        first = new Node(); 
        first.item = item;
        first.next = oldfirst;

    }

    public Item pop(){
        //puts first item inside variable item
        Item item = first.item;

        //goes to next node, which erases first item
        first = first.next;

        return item;
    }
}