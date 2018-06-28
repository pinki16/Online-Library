import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class LibrarianLogin extends HttpServlet{
int it1;

   public void doPost(HttpServletRequest req,HttpServletResponse res){
  // Connection conn=null;
  System.out.println("dopost method executed....");
  // try{
     String uname=req.getParameter("uname");
     String pwd=req.getParameter("pwd");
    
      
	/*  if(uname.equals("happy")&&pwd.equals("plue")){
    RequestDispatcher rd=req.getRequestDispatcher("LibrarianSection.html");
     rd.forward(req,res);
       }
     else{
      PrintWriter pw=res.getWriter();
      pw.print("<font color='red'>Invalid credentials</font>");
      RequestDispatcher rd=req.getRequestDispatcher("Librarian.html");
      rd.include(req,res);
      }
    }
   }catch(Exception e){
    e.printStackTrace();
     }
	*/ 
   
Connection con=null;
String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
CallableStatement cstmt=con.prepareCall("{call liblog(?,?)}");
//String username=sc.next();
//String password=sc.next();
cstmt.setString(1,uname);
cstmt.setString(2,pwd);

//cstmt.registerOutParameter(3,Types.INTEGER);
cstmt.execute();
//int it2=cstmt.getInt(3);
//System.out.println(it2+"hello");
//PreparedStatement pstmt=con.prepareStatement("update libralog set testify=0 ");
// it=cstmt.getInt(3);
//pstmt.execute();

cstmt.close();
String sql="select testify from libralog";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
int it2=-3;
while(rs.next()){
it2=rs.getInt("testify");
}
stmt.close();
it1=it2;
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
		 if(it1==1){
			     RequestDispatcher rd=req.getRequestDispatcher("LibrarianSection.html");
     rd.forward(req,res);
       }
     else{
      PrintWriter pw=res.getWriter();
      pw.print("<font color='red'>Invalid credentials</font>");
      RequestDispatcher rd=req.getRequestDispatcher("Librarian.html");
      rd.include(req,res);
      }
    }
	catch(Exception e3)
	{}
	 
 
 
 }



}
     