<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Mag
  Date: 03.07.2019
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Users list</title>
</head>
<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>Hello! Im list.jps page.</h1>
    </div>

    <!-- JAVA code -->
    <ul class="w3-ul">
    <%
        List<User> list = (List<User>) request.getAttribute("userNames");
        if (list != null && !list.isEmpty()) {
            for (User s : list) {
                out.write("<li class=\"w3-hover-sand\">" + s.getName() + " (" + s.getType() + ") " +
                        "<a href=\"/edit?action=update&userID=" + s.getId() + "\"/>update</a>" +
                        " | " +
                        "<a href=\"/list?action=delete&userID=" + s.getId() + "\" />delete</a></li>");
//                out.write("<li class=\"w3-hover-sand\">" + s.getName() + " (" + s.getType() + ") <a href=\"/save?action=update&userID=1\"/>update</a></li>");
            }
        }
        else
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>There are no users yet!</h5>\n" +
                    "</div>");
    %>
    </ul>
    <%
        if (request.getAttribute("userName") != null)
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>User '" + request.getAttribute("userName") + "' deleted!</h5>\n" +
                    "</div>");
    %>

    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
