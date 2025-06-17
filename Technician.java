import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class Technician extends Person {
    private String phone;
    private String skillset;

    public Technician(int id, String name,String phone, String skillset) {
        this.id = id;
        this.name = name;
        this.phone=phone;
        this.skillset = skillset;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSkillset(){
        return skillset;
    }
    public String getPhone(){
        return phone;
    }


    @Override
    public void displayInfo() {
        System.out.println("Technician: " + name + ", Expertised Skill: " + skillset);
    }
    public static void ma() {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Enter the Move that you want to take (only integer value) \n 1 for Insert Record \n 2 for Deletion of Record: \n 3 for Updation of record : \n 4 for Feteching out Records");
        int n=sc.nextInt();
        if(n==1){
        System.out.println("Enter the Technician Id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Technician name:");
        String name=sc.nextLine();
        System.out.println("Enter the Phone number:");
        String phone=sc.next();
        sc.nextLine();
        System.out.println("Enter the Skillset");
        String skillset=sc.nextLine();
        Technician T=new Technician(id, name, phone, skillset);
        TechnicianCrud.insertTechnician(T);
        }
        else if(n==2){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for ID");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter the Phone number:");
                String phone=sc.next();
                TechnicianCrud.deleteTechnicianByPhone(phone);
            }
            else if(m==2){
                System.out.println("Enter the Technician Id:");
                int c=sc.nextInt();
                TechnicianCrud.deleteTechnicianById(c);
            }
            else{
                System.out.println("You have Entered the Wrong value");
            }
        }
        else if(n==3){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for ID");
            int m=sc.nextInt();
            sc.nextLine();
            if(m==1){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("Phone");
                String phone=sc.next();
                System.out.println("Enter Skillset");
                String skillset=sc.next();
                TechnicianCrud.updateTechnicianByPhone(name, phone, skillset);
            }
            else if(m==2){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("Phone");
                String phone=sc.next();
                System.out.println("Enter skillset");
                String skillset=sc.next();
                System.out.println("Enter Id");
                int id=sc.nextInt();
                TechnicianCrud.updateTechnicianById(id, name, phone, skillset);
            }
        }
        else if(n==4){
            System.out.println("Here are the records:");
             List<Technician> l=TechnicianCrud.reader();
            for(int i=0;i<l.size();i++){
                System.out.println(l.get(i).name+" "+l.get(i).phone+" "+l.get(i).skillset);
            }
        }
        else{
            System.out.println("You want to exit");
            break;
        }
        
    }
}

}
