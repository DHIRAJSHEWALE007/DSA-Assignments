import java.util.Scanner;
class Assignment_1
{
    //Linear Probing

    public static void add_using_linear_probing(int hash_table[] , int data , int total_clients)
    {
        int address = data % total_clients ;

        while (hash_table[address] != data)
        {
            if (hash_table[address] == -1)
            {
                hash_table[address]=data;
            }

            else 
            {
                if (address == 9)
                {
                    address = 0;
                }
                else
                {
                    address++;
                }
            }
        }
        System.out.println("The Number "+ data + " is placed on Position " + address);
    }

    public static void add_using_quadratic_probing(int hash_table[] , int data , int total_clients)
    {


        
    }


    public static void main(String args[])
    {
        System.out.println("Enter The Number of Clients : ");
        Scanner read = new Scanner(System.in);
        int total_clients = read.nextInt();

        // creating hash table
        int hash_table[] = new int[total_clients];

        // initializing values of hash table to -1
        for (int i=0 ; i<total_clients ; i++)
        {
            hash_table[i]=-1;
        }



        while (true) 
        { 
            
            System.out.println("1) Add the Telephone Number using Linear Probing.");
            System.out.println("2) Add the Telephone Number using Quadratic Probing.");
            System.out.println("3) Print The Hash Table.");
            System.out.println("Select your Choice : ");

            int ch = read.nextInt();
            switch(ch)
            {
                case(1):
                {
                    System.out.println("Enter the Telephone Number : ");
                    int data = read.nextInt();
                    add_using_linear_probing(hash_table, data, total_clients);
                    break;
                }

                case(2):
                {
                    System.out.println("Working on it.");
                    break;
                }

                case(3):
                {
                    for (int i=0 ; i<total_clients ; i++)
                    {
                        System.out.println(hash_table[i]);
                    }
                    break;
                }
            }

        }
    }
    
}