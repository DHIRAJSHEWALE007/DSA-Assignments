import java.util.Scanner;
class Assignment_2
{
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        
        Set s1 = new Set();
        Set s2 = new Set();

        boolean flag = true;
        while(flag)
        {
            System.out.println("  +---------------------------------------------------------+  ");
            System.out.println("  |  1)  Add Element to Set 1.                              |  ");
            System.out.println("  |  2)  Add Element to Set 2.                              |  ");
            System.out.println("  |  3)  Remove Element from Set 1.                         |  ");
            System.out.println("  |  4)  Remove Element from Set 2.                         |  ");
            System.out.println("  |  5)  display Elements of Set 1.                         |  ");
            System.out.println("  |  6)  display Elements of Set 2.                         |  ");
            System.out.println("  |  7)  Total number of Elements in Set 1.                 |  ");
            System.out.println("  |  8)  Total number of Elements in Set 2.                 |  ");
            System.out.println("  |  9)  Check, is element present or not in Set 1 ?        |  ");
            System.out.println("  | 10)  Check, is element present or not in Set 2 ?        |  ");
            System.out.println("  | 11)  Intersection of Sets.                              |  ");
            System.out.println("  | 12)  Union of Sets.                                     |  ");
            System.out.println("  | 13)  Difference of Sets.                                |  ");
            System.out.println("  | 14)  Exit.                                              |  ");
            System.out.println("  +---------------------------------------------------------+  ");
            System.out.println("  |  ~ Enter Your Choice :                                  |  ");
            int ch = read.nextInt();
            System.out.println("  +---------------------------------------------------------+  ");

            switch(ch)
            {
                case 1 :
                    {
                        System.out.println("Enter the element for adding to a set 1 :");
                        int ele = read.nextInt();
                        s1.add_element(ele);
                        break;
                    }
                case 2 :
                    {
                        System.out.println("Enter the element for adding to a set 2 :");
                        int ele = read.nextInt();
                        s2.add_element(ele);
                        break;
                    }
                case 3 :
                    {
                        System.out.println("Enter the element for removing from a set 1 :");
                        int ele = read.nextInt();
                        s1.remove_element(ele);
                        break;
                    }
                case 4 :
                    {
                        System.out.println("Enter the element for removing from a set 2 :");
                        int ele = read.nextInt();
                        s2.remove_element(ele);
                        break;
                    }
                case 5 : 
                    {
                        System.out.println("Elements of set 1 : ");
                        s1.display();
                        break;
                    }
                case 6 : 
                    {
                        System.out.println("Elements of set 2 : ");
                        s2.display();
                        break;
                    }
                case 7 : 
                    {
                        s1.total_values();
                        break;
                    }
                case 8 : 
                    {
                        s2.total_values();
                        break;
                    }
                case 9 : 
                    {
                        System.out.println("Enter the Element to check : ");
                        int z = read.nextInt();
                        boolean y = s1.ispresent(z);
                        System.out.println(y);
                        break;
                    }
                case 10 : 
                    {
                        System.out.println("Enter the Element to check : ");
                        int z = read.nextInt();
                        boolean y = s2.ispresent(z);
                        System.out.println(y);
                        break;
                    }
                case 11 : 
                    {
                        s1.intersection(s2);
                        break;
                    }
                case 12 : 
                    {
                        s1.union(s2);
                        break;
                    }
                case 13 : 
                    {
                        s1.difference(s2);
                        break;
                    }
                case 14 : 
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

// Set As ADT

class Set
{
    int size;
    int[] set;
    int indx;

    public Set()
    {
        size = 10;
        indx = 0;
        set = new int[size];

        for(int i=0;i<size;i++)
        {
            set[i]=0;
        }
    }
    
    // Element is present or not

    public boolean ispresent(int ele)
    {
        for (int i=0;i < size;i++)
        {
            if (set[i] == ele)
            {
                return true;
            }
        }
        return false;
    }

    // Add new element to the set
    public void add_element(int ele)
    {
        if (!ispresent(ele))
        {
            if ((indx < size) && (set[indx]==0))
            {
                set[indx] = ele;
                System.out.println("New Element Added Succesfully.");
                indx++;
                if (indx == size)
                {
                    indx=0;
                }
            }
            else
                System.out.println("Set Is Full ! Can't Add New Elements.");
        }
    }

    // Remove Element from the set

    public int remove_element(int ele)
    {
        for (int i=0;i < size;i++)
        {
            if (set[i] == ele)
            {
                set[i] = 0;
                System.out.println("The Element Is Removed Succesfully.");
                return set[i];
            }
        }
        System.out.println("Element Not Found In Set.");
        return 0;
    }

    // Return Size of an set 

    public void total_values()
    {
        int count = 0;
        for (int i=0;i < size;i++)
        {
            if (set[i] != 0)
            {
                count++;
            }
        }
        System.out.println("Total number of elements are : " + count);
    }

    // Return Intersection of sets

    public void intersection(Set s)
    {
        Set temp = new Set();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if (set[i]==s.set[j])
                {
                    temp.add_element(set[i]);
                }
            }
        }
        System.out.println("Intersection  of both sets is : ");
        temp.display();
    }

    // Return Union of sets

    public void union(Set s)
    {
        Set temp = new Set();
        for(int i=0;i<size;i++)
        {
            temp.add_element(set[i]);
        }
        for(int i=0;i<size;i++)
        {
            temp.add_element(s.set[i]);
        }

        System.out.println("Union  of both sets is : ");
        temp.display();
    }

    // Return Difference of sets

    public void difference(Set s)
    {
        Set temp = new Set();
        for(int k=0;k<size;k++)
        {
            temp.set[k]=set[k];
        }

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if (temp.set[i]==s.set[j])
                {
                    temp.remove_element(temp.set[i]);
                }
            }
        }
        System.out.println("Difference of both sets is : ");
        temp.display();
    }

    // Display the set
    
    public void display()
    {
        System.out.println("  +--------------+  ");
        for(int i=0;i<size;i++)
        {   if(set[i]!=0)
                System.out.println("  |     "+ set[i] +"      |  ");
        }
        System.out.println("  +--------------+  ");
    }
}
