import java.util.Scanner;
class Assignment_1
{

    // Linear Probing

    public static void add_using_linear_probing(int hash_table[] , int data , int total_clients)
    {
        int address = data % total_clients ;

        while (true)
        {
            if (hash_table[address] == -1)
            {
                hash_table[address]=data;
                System.out.println("==========" + "The Number "+ data + " is placed on Position " + address + "==========");
                break;
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
        
    }


    // Quadratic Probing

    public static void add_using_quadratic_probing(int hash_table[] , int data , int total_clients)
    {
        int i = 0;

        while (true)
        {
            int temp_data = data + (i*i);
            int address = temp_data % total_clients;

            if (hash_table[address] == -1)
            {
                hash_table[address]=data;
                System.out.println("==========" +"The Number "+ data + " is placed on Position " + address + "==========");
                break;
            }

            else 
                i++;

        }
        
    }

    // Main Function

    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);


        // creating hash table

        System.out.println(" +----------------------------------------------------------+ ");
        System.out.println("Enter The Number of Clients : ");
        int total_clients = read.nextInt();
        System.out.println(" +----------------------------------------------------------+ ");
        int hash_table[] = new int[total_clients];

        // initializing values of hash table to -1

        for (int i=0 ; i<total_clients ; i++)
        {
            hash_table[i]=-1;
        }

        // Creating Menu
        
        boolean flag = true;

        while (flag) 
        {
            System.out.println(" +----------------------------------------------------------+ ");
            System.out.println(" |  1) Add the Telephone Number using Linear Probing.       | ");
            System.out.println(" |  2) Add the Telephone Number using Quadratic Probing.    | ");
            System.out.println(" |  3) Show Hash Table.                                     | ");
            System.out.println(" |  4) Exit                                                 | ");
            System.out.println(" |                                                          | ");
            System.out.println(" |  Select your Choice :                                    | ");
            System.out.println(" +----------------------------------------------------------+ ");

            int ch = read.nextInt();
            System.out.println(" +----------------------------------------------------------+ ");
            switch(ch)
            {
                case(1):
                {
                    System.out.println("Enter the Telephone Number (Note :- Don't Enter The Number Greater than 9 digits) : ");
                    int data = read.nextInt();
                    System.out.println(" +----------------------------------------------------------+ ");
                    add_using_linear_probing(hash_table, data, total_clients);
                    break;
                }

                case(2):
                {
                    System.out.println("Enter the Telephone Number (Note :- Don't Enter The Number Greater than 9 digits) : ");
                    int data = read.nextInt();
                    System.out.println(" +----------------------------------------------------------+ ");
                    add_using_quadratic_probing(hash_table, data, total_clients);
                    break;
                }

                case(3):
                {
                    System.out.println(" +----------------------------------------------------------+ ");
                    for (int i=0 ; i<total_clients ; i++)
                    { 
                        System.out.println(hash_table[i]);  
                    }
                    System.out.println(" +----------------------------------------------------------+ ");
                    break;
                }

                case(4):
                {
                    flag = false;
                    System.out.println("Thank You For Your Service.");
                    break;
                }
            }

        }
    }
    
}
