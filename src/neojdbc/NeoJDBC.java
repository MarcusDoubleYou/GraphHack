package neojdbc;


import java.sql.*;
import java.util.Scanner;

public class NeoJDBC {
    

    public Statement  myStat = null;
    public Connection dbConnection = null;
    
    
    
    public static void main(String[] args) throws SQLException  {
       MyConnection myCon = new MyConnection(); 
       Connection con = myCon.getConnection();
       

       Scanner scan= new Scanner(System.in);
      
            System.out.println("Origin");
       String abbrOr = scan.nextLine();
            System.out.println("Destination");
       String abbrDes = scan.nextLine();
       
     
       Query q = new Query();
       q.QueryRe(con, abbrOr, abbrDes);

        if (con != null)
        {
            con.close();
        }
        
        
}
}
