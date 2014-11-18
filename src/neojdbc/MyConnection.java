package neojdbc;

import java.sql.*;

public class MyConnection {
    
public Connection  myConn = null;
    
    public Connection getConnection()  {
      
        try{ 
            // Make sure Neo4j Driver is registered
        Class.forName("org.neo4j.jdbc.Driver");

        // 1.  Connect
         myConn = DriverManager.getConnection("jdbc:neo4j://localhost:7474/");
            
        }
        // error handeling
         catch(ClassNotFoundException | SQLException e){
            System.out.println("Error" + e);
        }
           if(myConn != null){
               System.out.println("Connceted");
           }else{
                       System.out.println("No Connection");
                       }
            return myConn;
       }
    }
   
