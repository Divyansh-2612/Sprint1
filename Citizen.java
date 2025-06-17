import java.util.*;
public class Citizen extends Person {
    private String email;
    private String phone;
    private String address;

    public Citizen(int id, String name, String email, String phone,String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address=address;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }

    @Override
    public void displayInfo() {
        System.out.println("Citizen: " + name + ", Email: " + email);
    }
    public void inserRecord(){
        
    }
    public static void ma() throws ClassNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number:\n 1 to insert record \n 2 for deletion \n 3 for updation \n 4 for reading the data ");
        int n=sc.nextInt();
        if(n==1){
        System.out.println("Enter the Citizen id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Citizen name:");
        String name=sc.nextLine();
        System.out.println("Enter the citizen emailId:");
        String email=sc.next();
        System.out.println("Enter the phone number of the Citizen");
        String phone=sc.next();
        sc.nextLine();
        System.out.println("Enter the Citizen Address");
        String address=sc.nextLine();
        Citizen C=new Citizen(id,name,email,phone,address);
        CitizenCrud.insertCitizen(C);
        }
        else if(n==2){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for email \n 3 for ID");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter the Phone number:");
                String phone=sc.next();
                CitizenCrud.deleteCitizenByPhone(phone);
            }
            else if(m==2){
                System.out.println("Enter the email:");
                String email=sc.next();
                CitizenCrud.deleteCitizenByEmail(email);
            }
            else if(m==3){
                System.out.println("Enter the citizen Id:");
                int c=sc.nextInt();
                CitizenCrud.deleteCitizenById(c);
            }
            else{
                System.out.println("You have Entered the Wrong value");
            }
        }
        else if(n==3){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for email \n 3 for ID");
            int m=sc.nextInt();
            sc.nextLine();
            if(m==1){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("Enter address");
                String address=sc.nextLine();
                System.out.println("Phone");
                String phone=sc.next();
                System.out.println("Enter email");
                String email=sc.next();
                CitizenCrud.updateCitizenByPhone(email, name, phone, address);
            }
            else if(m==2){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("Enter address");
                String address=sc.nextLine();
                System.out.println("Phone");
                String phone=sc.next();
                System.out.println("Enter email");
                String email=sc.next();
                CitizenCrud.updateCitizenByEmail(email, name, phone, address);
            }
            else if(m==3){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("Enter address");
                String address=sc.nextLine();
                System.out.println("Phone");
                String phone=sc.next();
                System.out.println("Enter email");
                String email=sc.next();
                System.out.println("Enter Id");
                int id=sc.nextInt();
                CitizenCrud.updateCitizenById(id,email, name, phone, address);
            }
            else{
                System.out.println("You have Entered the Wrong value");
            }
        }
        else if(n==4){
            List<Citizen> l=CitizenCrud.reader();
            for(int i=0;i<l.size();i++){
                System.out.println(l.get(i).name+" "+l.get(i).phone+" "+l.get(i).address);
            }
        }
        else{
            System.out.println("You have Entered the Wrong value");
        }
        sc.close();

    }
}
