
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ViewLibrarian extends HttpServlet{
//private static final long serialVersionUID = 1L;
 public void doPost(HttpServletRequest req,HttpServletResponse res){
System.out.println("we are in viewlibrarian do post");
  Connection con=null;
String url="jdbc:oracle:thin:@localhost:1521/XE";
String dbuname="SYSTEM";
String dbpwd="pinki";
res.setContentType("text/html");

try{

  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection(url,dbuname,dbpwd);
  PrintWriter pw=res.getWriter();
   
String sql="select * from libralog";
 PreparedStatement pstmt=con.prepareStatement(sql);
 ResultSet rs=pstmt.executeQuery();

 pw.println("<table border='2'>"); 
pw.println("<b><tr>");
   pw.println("<th>v_uname</th><th>v_pwd</th><th>v_testify</th><th>v_email</th><th>v_address</th>");
pw.println("</tr></br>");

while(rs.next())
{
//String uname=rs.getString(1);
//String pwd=rs.getString(2);
//int testify=rs.getInt(3);
//String email=rs.getString(4);
//String address=rs.getString(5);

pw.println("<tr>");
pw.println("<td>"+rs.getString(1)+"</td>");
pw.println("<td>"+rs.getString(2)+"</td>");
pw.println("<td>"+rs.getString(3)+"</td>");
pw.println("<td>"+rs.getString(4)+"</td>");
pw.println("<td>"+rs.getString(5)+"</td>");
pw.println("</tr>");


}
pw.print("</table>");
rs.close();
pstmt.close();
}
 catch(Exception e){
 e.printStackTrace();
 //pw.println("sorry some problem occured");
  }

   finally{
      try
         {
      if(con!=null)
        {
            con.close();
           }
      }catch(Exception e){
    }
 }
}}