import java.util.*;
import java.io.*;

public class TopoSort {

    public static void main(final String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(args[0])); //open file
        int count = 0; // create counter variable
        while(input.hasNextLine()) { //create a while loop that will go through and count each line of the file
            input.nextLine();
            count++;
        }
        input.close(); //close the input scanner
        Scanner insert = new Scanner(new File(args[0])); //open file again

        LinkedList[] list = new LinkedList[count]; // created a linkedList same size as lines in file
        int i;
        while(insert.hasNextLine()) {
            String line = insert.nextLine();
            String[] graph = line.split(":"); //go through each line and split lines with :

            int number = Integer.parseInt(graph[0]);
            if(!(count <= 1))
                list[number] = new LinkedList();

                if(graph.length > 1) {
                    String[] graph1 = graph[1].split(","); //split numbers with commas
                    i = 0;
                    while (i < graph1.length) {
                    list[number].add(Integer.parseInt(graph1[i])); //add the numbers into the list

                        i++;
                    }
                }


        }
        LinkedList list1 = DFS(list); //call DFS
        StringBuilder string = new StringBuilder(" " + list1.get(0));

        int j = 1;
        while (j < list1.size()) {
            string.append(", ").append(list1.get(j));
            j++;
        }
        System.out.println(string); //print out the list
        insert.close();
    }
    public static class LinkedList { //create a linkedList class

        private int size;
        private Node head;

        //inner class for ListNode
        private static class Node {
            private final Object data;
            private Node next;

            private Node(Object d) {
                this.data = d;
                this.next = null;
            }
        }


        //inner class for Node
        public int size() {
            return this.size;
        }

        public void add(Integer e) { //add Integer to list
            Node node = new Node(e);
            if (this.size != 0) {
                Node cur = this.head;
                if (cur.next != null) {
                    do {
                        cur = cur.next;
                    } while (cur.next != null);
                }
                cur.next = node;
            } else {
                this.head = node;
            }
            this.size++;
        }

        public void addFirst(Integer e) { //add Integer to the front of the linkedList
            Node node;
            node = new Node(e);
            if (this.size != 0) {
                node.next = this.head;
            }
            this.head = node;
            this.size++;
        }

        public Object get(int index) { //gets index of the current node
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(" Provided index is out of bounds! \n" + index);
            }
            Node cur = this.head;
            for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            return cur.data;

        }
    }




        public static LinkedList DFS(LinkedList[] List) { //create a linkedList DFS method

        boolean[] visit = new boolean[List.length]; //create boolean to check to see if node been visited

            LinkedList lists = new LinkedList();
            int i = 0;
            if (i < List.length) {
                do {
                    if (!visit[i]) {
                        graph_DFS(List, i, visit, lists); //if not visited then call graph_DFS
                    }
                    i++;
                } while (i < List.length);
            }
            return lists;
    }

    public static void graph_DFS(LinkedList[] List, int u, boolean[] visit, LinkedList lists) {
        visit[u] = true; //set boolean to true


        if(List[u] != null) {
            int i;
            i = 0;
            if (i < List[u].size()) { //get the size of linkedList
                do {
                    int v = (int) List[u].get(i); //call the get method
                    if (!visit[i]) {
                        graph_DFS(List, v, visit, lists); //recursive call
                    }
                    i++;
                } while (i < List[u].size()); //get the size of linkedList
            }
        }
        lists.addFirst(u); //call addFirst method 

    }

}
