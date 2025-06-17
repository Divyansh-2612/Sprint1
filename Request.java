import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Request {
    private int requestId;
    private int citizenId;
    private int technicianId;
    private int serviceId;
    private Status status;
    private Priority priority;
    private LocalDate submissionDate;

public Request(int requestId, int citizenId,int technicianId, int serviceId,
               Status status, Priority priority, LocalDate submissionDate) {
    this.requestId = requestId;
    this.citizenId = citizenId;
    this.technicianId=technicianId;
    this.serviceId = serviceId;
    this.status = status;
    this.priority = priority;
    this.submissionDate = submissionDate;}

    // Getters
    public int getRequestId() {
        return requestId;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
    return priority;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    // Optional: toString() for printing
    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", citizenId=" + citizenId +
                ", technicianId"+ technicianId +
                ", serviceId=" + serviceId +
                ", status='" + status + '\'' +
                ", priority=" + priority.name() +
                ", submissionDate=" + submissionDate +
                '}';
    }
    public static void requestRaised(int ids) throws SQLException{
        Scanner sc=new Scanner(System.in);
        LocalDate d=LocalDate.now();
        String[] arr={" Sanitation & Waste Management","Electricity & Lighting","Roads & Transport","Parks & Environment","Property & Building","Water Supply","Public Safety","Administrative Requests"};
        System.out.println("Enter the Request that you want to raise among: \n 1  Sanitation & Waste Management\n  2 Electricity & Lighting \n 3 Roads & Transport \n 4 Parks & Environment \n 5 Property & Building\n 6 Water Supply\n 7 Public Safety\n 8 Administrative Requests");
        int n=sc.nextInt();
        String serviceraised=arr[n-1].toLowerCase();
        System.out.println(serviceraised);
        int id=0;
        String Query="Select service_id from servicetype where typename= ?";
        try(Connection con=DBConnection.getConnection()){
            PreparedStatement pst=con.prepareStatement(Query);
            pst.setString(1, serviceraised);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                id=rs.getInt("service_id");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String Q="Select technician_id from technician where skillset = ? and status= ?";
        int tid=0;
        try(Connection con=DBConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement(Q);
            ps.setString(1, serviceraised);
            ps.setString(2, "free");
            ResultSet rd=ps.executeQuery();
            if(rd.next()){
               tid=rd.getInt("technician_id");
            }
            else{
                System.out.println("No Technician is free");
            }
        }
        Status status=Status.PENDING;
        System.out.println("Enter the priority as per rewuired among: \n High \n Medium \n Low");
        String prior=sc.next().toUpperCase();
        Priority P=Priority.valueOf(prior);
        System.out.println("Enter the request id");
        Request r=new Request(sc.nextInt(), ids,tid, id, status, P, d);
        RequestCrud.addRequest(r);
    }}