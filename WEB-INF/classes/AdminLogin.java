import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AdminLogin extends HttpServlet{
  
   public void doPost(HttpServletRequest req,HttpServletResponse res){
  // Connection conn=null;
   System.out.println("dopost method executed....");
   try{
     String uname=req.getParameter("uname");
     String pwd=req.getParameter("pwd");
    
      if(uname.equals("doremon")&&pwd.equals("gadget")){
    RequestDispatcher rd=req.getRequestDispatcher("AdminSection.html");
     rd.forward(req,res);
       }
     else{
      PrintWriter pw=res.getWriter();
      pw.print("<font color='red'>Invalid credentials</font>");
      RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
      rd.include(req,res);
      }
    }
   catch(Exception e){
    e.printStackTrace();
     }
   }
}
     