<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"></c:import>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="nav.jsp"></c:import>
        <article class="content">
            <h1>About The API</h1>
            <h2>Resources</h2>
            <p>ComPosting consists of four resource classes: materials, prices, periods, and services.</p>
            <h3>Materials</h3>
            <p>The materials class contains all the various materials that the services can handle.  Each is identified by a name and comment.</p>
            <h3>Prices</h3>
            <p>The prices class contains the various standard pricing levels associated with material handling.  Each is identified by a dollar amount in USD and the unit by which the price is charged.  Pricing units correspond to the weight, count, or volume of the material being priced.</p>
            <h3>Period</h3>
            <p>The period class contains information used in scheduling periodic/regular billing cycles.  Each is identified by a count and a timing unit, such as day, week, month, etc.</p>
            <h3>Service</h3>
            <p>The service class contains the details of the various services offered.  Each is identified by a name and description of the service.</p>
            <hr>
            <h2>API Structure</h2>
            <p>The ComPosting API is structured around a root resource at the URL <em>/composting</em>.  This is the URL pattern for the <em>ApplicationController</em> class that takes incoming <em>HttpRequest</em> objects and routes them to the appropriate resource.</p>
            <p>Each resource class is represented by three classes: V1, V2, and V3.  V1 consists of all bulk retrieval methods, and requires no additional information be added to the request URI.  V2 consists of those methods that require an ID integer be passed to the resource; the PUT method is also handled here, requiring additional URI parameters be provided in the request.  V3 handles the creation of new resource data, and requires the passing of the relevant field data to the method in the request URI.</p>
            <h2>Resource Endpoints</h2>
            <ul>
                <li>Root: /composting</li>
                <li>Endpoints:
                    <ul>
                        <li>Material resource endpoints
                            <ul>
                                <li>/materialsV1 (GET)</li>
                                <li>/materialsV2/{id} (GET)</li>
                                <li>/materialsV2/alter/{id}/{name}/{comments} (PUT)</li>
                                <li>/materialsV2/drop/{id} (DELETE)</li>
                                <li>/materialsV3/{name}/{comments} (POST)</li>
                            </ul></li>
                        <li>Price resource endpoints
                            <ul>
                                <li>/pricesV1 (GET)</li>
                                <li>/pricesV2/{id} (GET)</li>
                                <li>/pricesV2/alter/{id}/{name}/{comments} (PUT)</li>
                                <li>/pricesV2/drop/{id} (DELETE)</li>
                                <li>/pricesV3/{price}/{unit} (POST)</li>
                            </ul></li>
                        <li>Period resource endpoints
                            <ul>
                                <li>/periodsV1 (GET)</li>
                                <li>/periodsV2/{id} (GET)</li>
                                <li>/periodsV2/alter/{id}/{name}/{comments} (PUT)</li>
                                <li>/periodsV2/drop/{id} (DELETE)</li>
                                <li>/periodsV3/{frequency}/{time_unit} (POST)</li>
                            </ul></li>
                        <li>Service resource endpoints
                            <ul>
                                <li>/servicesV1 (GET)</li>
                                <li>/servicesV2/{id} (GET)</li>
                                <li>/servicesV2/alter/{id}/{name}/{comments} (PUT)</li>
                                <li>/servicesV2/drop/{id} (DELETE)</li>
                                <li>/servicesV3/{name}/{description} (POST)</li>
                            </ul></li>
                    </ul>
                </li>
            </ul>
            <h2>Sample API Calls</h2>
            <ul>Example 1
                <li>{context path}/composting/servicesV1</li>
                <li>Method: GET</li>
                <li>Expected return: List of all service record data</li>
            </ul>
            <ul>Example 2 - Retrieve Material record with ID 1
                <li>{context path}/composting/materialsV2/1</li>
                <li>Method: GET</li>
                <li>Expected return: The material data for the record with ID 1</li>
            </ul>
            <ul>Example 3 - Create a new Price record
                <li>{context path}/composting/pricesV3/1/weekly</li>
                <li>Method: POST</li>
                <li>Expected return: Confirmation message and the data persisted</li>
            </ul>
            <ul>Example 4 - Update Period record with ID 3
                <li>{context path}/composting/periodsV2/alter/3/1/New%20moon</li>
                <li>Method: PUT</li>
                <li>Expected return: Confirmation message and the data persisted</li>
            </ul>
        </article>
    </body>
    <c:import url="footer.jsp"></c:import>
</html>
