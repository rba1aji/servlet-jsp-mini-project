<%--
  Created by IntelliJ IDEA.
  User: balaji
  Date: 22/12/23
  Time: 2:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String successMessage = (String) request.getAttribute("message"); %>
<script>
    alert("<%=successMessage%>");
    window.history.back();
</script>
