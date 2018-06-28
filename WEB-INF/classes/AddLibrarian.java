import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class AddLibrarian extends HttpServlet{
 public void doPost(HttpServletRequest req,HttpServletResponse res){
  Connection con=null;
int no=0;
  System.out.println("dopost1 method executed....");

     String uname=req.getParameter("uname");
     String pwd=req.getParameter("pwd");
     String email=req.getParameter("email");
     String address=req.getParameter("address");
     int testify=1;
   
String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
String sql="insert into libralog values(?,?,?,?,?)";
 PreparedStatement pstmt=con.prepareStatement(sql);

pstmt.setString(1,uname);
pstmt.setString(2,pwd);
pstmt.setInt(3,testify);
pstmt.setString(4,email);
pstmt.setString(5,address);
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
      pw.print("<font color='black'>Librarian Added Successfully</font>");
      RequestDispatcher rd=req.getRequestDispatcher("AddLibrarian.html");
      rd.include(req,res);
      }
    }
	catch(Exception e3)
	{}
}
}