import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class AddBook extends HttpServlet{
 public void doPost(HttpServletRequest req,HttpServletResponse res){
  Connection con=null;
int no=0;
  System.out.println("dopost addbook method executed....");

     String book_no=req.getParameter("book_no");
     String nob=req.getParameter("nob");
     String eob=req.getParameter("eob");
     String sob=req.getParameter("sob");
          String pob=req.getParameter("pob");
   
   
String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
String sql="insert into booklog values(?,?,?,?,?)";
 PreparedStatement pstmt=con.prepareStatement(sql);

pstmt.setString(1,book_no);
pstmt.setString(2,nob);
pstmt.setString(3,eob);
pstmt.setString(4,sob);
pstmt.setString(5,pob);
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
      pw.print("<font color='black'>Book Added Successfully</font>");
      RequestDispatcher rd=req.getRequestDispatcher("AddBook.html");
      rd.include(req,res);
      }
    }
	catch(Exception e3)
	{}
}
}