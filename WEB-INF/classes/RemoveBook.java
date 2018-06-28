import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class RemoveBook extends HttpServlet{
int no;
 public void doPost(HttpServletRequest req,HttpServletResponse res){
  Connection con=null;
  System.out.println("dopost Removebook method executed....");

     String book_no=req.getParameter("book_no");
 String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
 String sql="delete from booklog where book_no=?";
 PreparedStatement pstmt=con.prepareStatement(sql);
 pstmt.setString(1,book_no);
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
	if(no>0)
             {
      PrintWriter pw=res.getWriter();
      pw.print("<font color='red'>Book Removed Successfully</font>");
      RequestDispatcher rd=req.getRequestDispatcher("RemoveBook.html");
      rd.include(req,res);
      }
    }
	catch(Exception e3)
	{}

}
} 