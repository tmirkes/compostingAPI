<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"></c:import>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="nav.jsp"></c:import>
        <article class="content">
            <h1>About Team ComPosting</h1>
            <h2>Members</h2>
            <p>Team ComPosting consists of Nate Peck, Abigail Genz, and Tim Mirkes.</p>
            <h2>The Problem</h2>
            <p>Nate's independent project is building a service around coordinating the pickup, delivery, and management of materials used for home composting.  A critical part of that service is being able to access a consistent, readily available resource that allows one to develop servlets for the scheduling and tracking of user accounts and services rendered.</p>
            <p>This is where the ComPosting API comes in.  As a web service that provides access to the current body of services, materials, and pricing handled by Nate's project, ComPosting allows for the local client to access the API for the purposes of scheduling tasks and generating invoices and reports, ensuring that all such local clients are always using the most up-to-date information to place orders and schedule tasks.</p>
        </article>
    </body>
    <c:import url="footer.jsp"></c:import>
</html>

