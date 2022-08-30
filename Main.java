import java.util.*;
class Employee
{
    int Id;
    int password;
    Employee(int Id,int password)
    {
        this.Id=Id;
        this.password=password;
    }
    public int getId()
    {
        return Id;
    }
    public int getpassowrd()
    {
        return password;
    }
}
class Account 
{
    int AccNo;
    int Balance;
    long Contact;
    String Name;
    String Address;
    Account()
    {}
    public void input(int AccNo,int Balance,long Contact,String Name,String Address)
    {
        this.AccNo=AccNo;
        this.Balance=Balance;
        this.Contact=Contact;
        this.Name=Name;
        this.Address=Address;
    }
    public int getAccNo()
    {
        return AccNo;
    }
    public int getBalance()
    {
        return Balance;
    }
    public long getContact()
    {
        return Contact;
    }
    public String getName()
    {
        return Name;
    }
    public String getAddress()
    {
        return Address;
    }
    public void display()
    {
        System.out.println("-------------------------------ACCOUNT INFO----------------------------");
        System.out.println("Account No: "+AccNo);
        System.out.println("Name: "+Name);
        System.out.println("Contact Number: "+Contact);
        System.out.println("Address: "+Address);
        System.out.println("Balance: "+Balance);
        System.out.println("------------------------------------------------------------------------");
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public void setBalance(int Balance)
    {
        this.Balance=Balance;
    }
    public void setContact(long Contact)
    {
        this.Contact=Contact;
    }
    public void setAddress(String Address)
    {
        this.Address=Address;
    }
}
public class Main
{
    public static void main(String args[])
    {
        int a=0,b=0,c=0;
        Account acc[]=new Account[1000];
        for (int i=0;i<1000;i++)
        {
            acc[i]=new Account();
        }
        int x=0;
        String e,f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Employees you want to register: ");
        a=sc.nextInt();
        Employee emp[]=new Employee[a];
        for (int i=0;i<emp.length;i++)
        {
            System.out.println("Enter the Log In ID: ");
            b=sc.nextInt();
            System.out.println("Enter the password");
            c=sc.nextInt();
            emp[i]=new Employee(b,c);
        }
        while  (true)
        {
            int ch;
            System.out.println("1-Login Page\n2-Exit");
            System.out.println("Enter your chocie: ");
            ch=sc.nextInt();
            if (ch==1)
            {
                System.out.println("Enter your Log In ID: ");
                a=sc.nextInt();
                for (int i=0;i<emp.length;i++)
                {
                    if (emp[i].getId()==a)
                    {
                        b=i;
                        break;
                    }
                }
                System.out.println("Enter your password: ");
                c=sc.nextInt();
                if (c==emp[b].getpassowrd())
                {
                    while(true)
                    {
                        System.out.println("------------------------------------WELCOME-----------------------------------");
                        System.out.println("1-Create an Account\n2-Withdraw Cash\n3-Deposit Cash\n4-Update Information\n5-Search Account\n6-Exit");
                        int amt,ans;
                        long temp;
                        System.out.println("Enter your choice: ");
                        ch=sc.nextInt();
                        if(ch==1)
                        {
                            System.out.println("Enter the name of the customer: ");
                            e=sc.next();
                            sc.nextLine();
                            System.out.println("Enter the account number for the customer: ");
                            a=sc.nextInt();
                            System.out.println("Enter the contact number of the customer: ");
                            temp=sc.nextLong();
                            System.out.println("Enter the Balance to be deposited: ");
                            b=sc.nextInt();
                            System.out.println("Enter the residential address of the Customer: ");
                            f=sc.next();
                            sc.nextLine();
                            acc[x].input(a,b,temp,e,f);
                            x++;
                            System.out.println("Account created successfully!");
                            acc[x-1].display();
                            int op=acc[0].getAccNo();
                            System.out.println(op);
                        }
                        else if (ch==2)
                        {
                            if(x==0)
                            {
                                System.out.println("No accounts are created!\nCreate an account to use this feature.");
                            }
                            else 
                            {
                                boolean value=false;
                                System.out.println("Enter the account number: ");
                                a=sc.nextInt();
                                for (int i=0;i<x;i++)
                                {
                                    System.out.println(acc[i].getAccNo());
                                    if (acc[i].getAccNo()==a)
                                    {
                                        b=i;
                                        value=true;
                                        break;
                                    }
                                }
                                if (value==true)
                                {
                                    System.out.println("Enter the amount to be withdrawn: ");
                                    amt=sc.nextInt();
                                    if(acc[b].getBalance()-amt>=0)
                                    {
                                        ans=acc[b].getBalance()-amt;
                                        acc[b].setBalance(ans);
                                        System.out.println("Amount withdrawn successfully!");
                                    }
                                    else 
                                    {
                                        System.out.println("Insufficient Balance!");
                                    }
                                }
                                else 
                                {
                                    System.out.println("Account not found!");
                                }
                            }
                        }
                        else if(ch==3)
                        {
                            if (x==0)
                            {
                                System.out.println("No accounts create!\nCreate an account to use this feature.");
                            }
                            else 
                            {
                                boolean value=false;
                                System.out.println("Enter the account number: ");
                                a=sc.nextInt();
                                for (int i=0;i<x;i++)
                                {
                                    if (acc[i].getAccNo()==a)
                                    {
                                        b=i;
                                        value=true;
                                        break;
                                    }
                                }
                                if (value==true)
                                {
                                    System.out.println("Enter the amount you want to deposit: ");
                                    amt=sc.nextInt();
                                    ans=acc[b].getBalance()+amt;
                                    acc[b].setBalance(ans);
                                    System.out.println("Account deposited successfully!");
                                }
                                else 
                                {
                                    System.out.println("Account not found!");
                                }
                            }
                        }
                        else if (ch==4)
                        {
                            System.out.println("Enter the option you want to update:\n1-Contact Number\n2-Customer name\n3-Residential Address");
                            System.out.println("Enter your choice: ");
                            ch=sc.nextInt();
                            switch(ch)
                            {
                                case 1:
                                        if (x==0)
                                        {
                                            System.out.println("No accounts created!\nCreate an account to use this feature.");
                                        }
                                        else 
                                        {
                                            boolean value=false;
                                            System.out.println("Enter the account number: ");
                                            a=sc.nextInt();
                                            for (int i=0;i<x;i++)
                                            {
                                                if (acc[i].getAccNo()==a)
                                                {
                                                    b=i;
                                                    value=true;
                                                    break;
                                                }
                                            }
                                            if (value==true)
                                            {
                                                System.out.println("Enter the new contact number: ");
                                                temp=sc.nextLong();
                                                acc[b].setContact(temp);
                                                System.out.println("Information updated successfully!");
                                            }
                                            else
                                            {
                                                System.out.println("Account not found!");
                                            }
                                        }
                                break;
                                case 2:
                                        if (x==0)
                                        {
                                            System.out.println("No accounts created!\nCreate an account to use this feature.");
                                        }
                                        else 
                                        {
                                            System.out.println("Enter your account number: ");
                                            a=sc.nextInt();
                                            boolean value=false;
                                            for (int i=0;i<x;i++)
                                            {
                                                if (acc[i].getAccNo()==a)
                                                {
                                                    b=i;
                                                    value=true;
                                                    break;
                                                }
                                            }
                                            if (value==true)
                                            {
                                                System.out.println("Enter the new name: ");
                                                e=sc.next();
                                                sc.nextLine();
                                                acc[b].setName(e);
                                                System.out.println("Information updated successfully!");
                                            }
                                            else 
                                            {
                                                System.out.println("Account not found!");
                                            }
                                        }
                                break;
                                case 3:
                                        if(x==0)
                                        {
                                            System.out.println("No accounts created!\nCreate an account to use this feature.");
                                        }
                                        else
                                        {
                                            System.out.println("Enter the account number: ");
                                            a=sc.nextInt();
                                            boolean value=false;
                                            for (int i=0;i<x;i++)
                                            {
                                                if (acc[i].getAccNo()==a)
                                                {
                                                    value=true;
                                                    b=i;
                                                    break;
                                                }
                                            }
                                            if (value==true)
                                            {
                                                System.out.println("Enter the new residential address: ");
                                                f=sc.next();
                                                acc[b].setAddress(f);
                                                System.out.println("Information updated successfully!");
                                            }
                                            else 
                                            {
                                                System.out.println("Account not found!");
                                            }
                                        }
                                break;
                                default:
                                        System.out.println("Invalid input!");
                            }
                        }
                        else if(ch==5)
                        {
                            System.out.println("Enter the account number: ");
                            a=sc.nextInt();
                            boolean value=false;
                            for (int i=0;i<x;i++)
                            {
                                if (acc[i].getAccNo()==a)
                                {
                                    value=true;
                                    b=i;
                                    break;
                                }
                            }
                            if (value==true)
                            {
                                System.out.println("Account found!");
                                acc[b].display();
                            }
                            else 
                            {
                                System.out.println("Account not found!");
                            }
                        }
                        else if(ch==6)
                        {
                            break;
                        }
                        else 
                        {
                            System.out.println("Invalid input!");
                        }  
                        }
                    }
                    else 
                    {
                        System.out.println("Invalid login Credentials!");
                    }
            }
            else if (ch==2)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid input!");
            }
        }
    }
}