
package neojdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Query {
    
 
    public static void QueryRe(Connection con, String Or, String Des) throws SQLException{
        
   Statement myStat = null;   
   ResultSet myRs = null;  
   
   String query= " MATCH (f:Flight)-[:ORIGIN]->(a:Airport {abbr: \""+Or+"\"})"
       +" MATCH (f)-[:DESTINATION]->(b:Airport {abbr: \""+Des+"\"}) "
       +" MATCH (f)-[:CARRIER]->(c:Carrier {abbr: 'AA'})"
       +" WHERE f.weekday = 3 "
       +" WITH length(collect(f)) AS allMatch "
       +" MATCH (f:Flight)-[:ORIGIN]->(a:Airport {abbr: \""+Or+"\"}) "
       +" MATCH (f)-[:DESTINATION]->(b:Airport {abbr: \""+Des+"\"}) "
       +" MATCH (f)-[:CARRIER]->(c:Carrier {abbr: 'AA'}) "
       +" WHERE f.weekday =  3 "
       +" MATCH (f)-[:DELAYED_BY|:CANCELLED_BY|:DIVERTED_TO]-() "
       +" WITH allMatch, length(collect(f)) as delayMatch "
       +" With toFloat(delayMatch)/allMatch as A Return A";

    try{ 
        
        myStat = con.createStatement();
        myRs = myStat.executeQuery(query);
        
            while (myRs.next())
           {
               System.out.println("Delay+");
               System.out.println(myRs.getFloat("A")); 
           }
        }
        
         catch(SQLException e)
         {
            {System.out.println("Error" + e);}
  
         }  
        finally // closes the statement at the end
        {
               if(myStat != null || myRs != null) 
               {
                myStat.close(); 
                myRs.close();
               }
        }

    }
}

    

