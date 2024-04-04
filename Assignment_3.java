 import java.util.Scanner;

 class Assignment_3
 {
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);

        Binary_Tree t1 = new Binary_Tree();

        boolean flag = true;
        while(flag)
        {
            System.out.println("  +---------------------------------------------------------+  ");
            System.out.println("  |  1)  Create A Binary Search Tree.                       |  ");
            System.out.println("  |  2)  Insert A Element Inside A BST.                     |  ");
            System.out.println("  |  3)  Search For An Element Inside A BST.                |  ");
            System.out.println("  |  4)  Display Tree Nodes (Inorder Traversal).            |  ");
            System.out.println("  |  5)  Total Number Of Nodes In Tree.                     |  ");
            System.out.println("  |  6)  Exit.                                              |  ");
            System.out.println("  +---------------------------------------------------------+  ");
            System.out.println("  |  ~ Enter Your Choice :                                  |  ");
            int ch = read.nextInt();
            System.out.println("  +---------------------------------------------------------+  ");
            
            switch(ch)
            {
                case 1 :
                    {
                        t1.create_tree();
                        break;
                    }
                case 2 :
                    {
                        System.out.println("Enter The Element To Insert In A Tree : ");
                        int ele = read.nextInt();
                        t1.insert_node(t1.root,ele);
                        break;
                    }
                case 3 :
                    {
                        t1.cnt = 0;
                        System.out.println("Enter The Element To Search In A Tree : ");
                        int ele = read.nextInt();
                        t1.search(ele);
                        break;
                    }
                case 4 :
                    {
                        t1.array_of_nodes = new int[t1.total_nodes];
                        t1.cnt = 0;
                        t1.inorder(t1.root);

                        for (int i = 0; i < t1.total_nodes; i++)
                        {
                            System.out.println(t1.array_of_nodes[i]);
                        }                        
                        break;
                    }
                case 5 : 
                    {
                        System.out.println("Total Number Of Nodes In a Tree Are : ");
                        System.out.println(t1.total_nodes);
                        break;
                    }
                case 6 : 
                    {
                        System.out.println("Thank you for your time.");
                        flag = false;
                        break;
                    }
            }
            System.out.println("  ***********************************************************  ");
        }

    }
 }

 class Binary_Tree
 {
    public Node root = null;
    public int array_of_nodes[];
    public int total_nodes = 0;
    public int cnt = 0;

    public void create_tree()
    {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter The Total Number of Nodes : ");
        int total = read.nextInt();

        for (int i = 0; i < total; i++)
        {
            if (root == null)
            {
                Node new_node = new Node();
                System.out.println("Enter The Data Of Node " + (i+1) +" : ");
                int data = read.nextInt();
                new_node.data = data;

                root = new_node;
                System.out.println("Node " + data + " Is Initialized As A Root Node !");
                total_nodes++;
            }
            else
            {
                System.out.println("Enter The Data Of Node " + (i+1) +" : ");
                int data = read.nextInt();
                insert_node(root,data);
            }
        }
    }
    public void insert_node(Node parent_node, int value)
    {
        Node temp = parent_node;
        Node new_node = new Node();
        new_node.data = value;

        if (new_node.data <= temp.data)
        {
            if (temp.left == null)
            {   
                temp.left = new_node;
                total_nodes++;
                System.out.println("Node " + new_node.data + " Inserted At Left Of Parent Node");
            }
            else
            {
                insert_node(temp.left,value);
            }
        }
        else
        {
            if (temp.right == null)
            {   
                temp.right = new_node;
                total_nodes++;
                System.out.println("Node " + new_node.data + " Inserted At Right Of Parent Node");

            }
            else
            {
                insert_node(temp.right,value);
            }
        }
    }

    public void inorder(Node temp)
    {
        if (temp != null)
        {
            inorder(temp.left);
            array_of_nodes[cnt] = temp.data;
            cnt+=1;
            inorder(temp.right);
        }
    }
    public void search(int value)
    {
        inorder(root);

        String result = "Node Not Found";
        for (int i = 0; i < cnt; i++)
        {
            if (value == array_of_nodes[i])
            {
                result = "Node Found";
            }
        }
        System.out.println(result);
    }
 }

 class Node
 {
    public int data = 0;
    Node left = null;
    Node right = null;
 }
