<%@ page language="java" %>
    <html>

    <head>
        <title>Subtract number program in JSP </title>
    </head>

    <body>
        <form method=“post” action=“MultNumbers.jsp”>
            Enter Number 1 <input type=”text” name=“No1”>
            Enter Number 2 <input type=”text” name=“No2”>
            <input type="submit" value="RESULT" />
            <% 
            try{
            int p=Integer.parseInt(request.getParameter(“No1”));
            int q=Integer.parseInt(request.getParameter(“No2”));
            int result=p - q;
             out.print("Substraction of p and q :"+result); 
            }catch(Exception e)
            {
                out.println(e);
            }
             %>
        </form>
    </body>

    </html>