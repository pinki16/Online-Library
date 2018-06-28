import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class RemoveLibrarian extends HttpServlet{
 public void doPost(HttpServletRequest req,HttpServletResponse res){
  Connection con=null;
int no=0;
  System.out.println("dopost1 method executed....");

     String uname=req.getParameter("uname");
 String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
 String sql="delete from libralog where uname=?";
 PreparedStatement pstmt=con.prepareStatement(sql);
 pstmt.setString(1,uname);
 no=pstmt.executeUpdate();

pstmt.close();
}
   
    catch(Exception e){
 e.printStackTrace();
}
finally{
  try{
    con.close();
     }
  catch(Exception e2){
    e2.printStackTrace();
    }
   }
    
     try{
		 if(no>0){
      PrintWriter pw=res.getWriter();
      pw.print("<font color='black'>Librarian Removed Successfully</font>");
      RequestDispatcher rd=req.getRequestDispatcher("RemoveLibrarian.html");
      rd.include(req,res);
      }
    }
	catch(Exception e3)
	{}

}
} 