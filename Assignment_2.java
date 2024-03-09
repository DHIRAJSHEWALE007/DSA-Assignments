class Assignment_2
{
    public static void main(String args[])
    {
        Set s1 = new Set();
        Set s2 = new Set();

        s1.add_element(100);
        s1.add_element(200);
        s1.add_element(300);
        s1.add_element(400);

        s2.add_element(500);
        s2.add_element(400);
        s2.add_element(300);
        s2.add_element(600);
        s2.add_element(700);

        Set s3 = s1.intersection(s2);
        Set s4 = s1.union(s2);
        Set s5 = s1.difference(s2);
        s1.display();
        s2.display();
        s3.display();
        s4.display();
        s5.display();
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

    public int total_values()
    {
        int count = 0;
        for (int i=0;i < size;i++)
        {
            if (set[i] != 0)
            {
                count++;
            }
        }
        return count;
    }

    // Return Intersection of sets

    public Set intersection(Set s)
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
        return temp;
    }

    // Return Union of sets

    public Set union(Set s)
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

        return temp;
    }

    // Return Difference of sets

    public Set difference(Set s)
    {
        Set temp = new Set();
        temp.set = set;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if (set[i]==s.set[j])
                {
                    temp.remove_element(set[i]);
                }
            }
        }
        return temp;
    }

    // Display the set
    
    public void display()
    {
        for(int i=0;i<size;i++)
        {   if(set[i]!=0)
                System.out.println(set[i]);
        }
    }
}