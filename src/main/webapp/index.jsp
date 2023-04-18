<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<!-- HTML form feeding the URL creation on submit courtesy of https://stackoverflow.com/questions/11811782/form-value-creates-a-url -->
    <c:import url="head.jsp"></c:import>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="nav.jsp"></c:import>
        <div class="content">
            <fieldset>
                <legend>Sample API Calls</legend>
                <p><em>Materials</em></p>
                <table>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve all Materials in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="MA" method="get">
                                <button type="submit">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMA" value="/composting/materialsV1">
                            <label>Format:</label>
                            <label for="plainMA">Text</label>
                            <input type="radio" name="field1MA" id="plainMA" value="plain_text" required>
                            <label for="htmlMA">HTML</label>
                            <input type="radio" name="field1MA" id="htmlMA" value="html">
                            <label for="jsonMA">JSON</label>
                            <input type="radio" name="field1MA" id="jsonMA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Material by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="MB" method="get">
                                <button type="submit">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMB" value="/composting/materialsV2">
                            <label for="field1MB">ID:</label>
                            <input class="box" type="text" name="field1MB" id="field1MB" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainMB">Text</label>
                            <input type="radio" name="field2MB" id="plainMB" value="plain_text" required>
                            <label for="htmlMB">HTML</label>
                            <input type="radio" name="field2MB" id="htmlMB" value="html">
                            <label for="jsonMB">JSON</label>
                            <input type="radio" name="field2MB" id="jsonMB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Material with user-provided Name and Comments</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="MC" method="post">
                                <button type="submit">POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMC" value="/composting/materialsV3">
                            <label for="field1MC">Name:</label>
                            <input class="box" type="text" name="field1MC" id="field1MC" required placeholder="Material name">
                        </td>
                        <td>
                            <label for="field2MC">Comments:</label>
                            <input class="box" type="text" name="field2MC" id="field2MC" required placeholder="Additional details">
                            </form>
                        </td>
                    </tr>
                </table>
                <p><em>Periods</em></p>
                <table>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve all Periods in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="DA" method="get">
                                <button type="submit" onclick="redirectA('DA')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/periodsV1">
                            <label>Format:</label>
                            <label for="plainDA">Text</label>
                            <input type="radio" name="field1" id="plainDA" value="plain_text" required>
                            <label for="htmlDA">HTML</label>
                            <input type="radio" name="field1" id="htmlDA" value="html">
                            <label for="jsonDA">JSON</label>
                            <input type="radio" name="field1" id="jsonDA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Period by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="DB" method="get">
                                <button type="submit" onclick="redirectB('DB')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/periodsV2">
                            <label for="field1">ID:</label>
                            <input class="box" type="text" name="field1" id="field1" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainDB">Text</label>
                            <input type="radio" name="field2" id="plainDB" value="plain_text" required>
                            <label for="htmlDB">HTML</label>
                            <input type="radio" name="field2" id="htmlDB" value="html">
                            <label for="jsonDB">JSON</label>
                            <input type="radio" name="field2" id="jsonDB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Period with user-provided Frequency and Time Unit</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="DC" method="post">
                                <button type="submit" onclick="redirectB('DC')">POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/periodsV3">
                            <label for="field1">Frequency:</label>
                            <input class="box" type="text" name="field1" id="field1" required placeholder="1">
                        </td>
                        <td>
                            <label for="field2">Time Unit:</label>
                            <input class="box" type="text" name="field2" id="field2" required placeholder="Measure of time">
                            </form>
                        </td>
                    </tr>
                </table>
                <p><em>Prices</em></p>
                <table>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve all Prices in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="PA" method="get">
                                <button type="submit" onclick="redirectA('PA')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/pricesV1">
                            <label>Format:</label>
                            <label for="plainPA">Text</label>
                            <input type="radio" name="field1" id="plainPA" value="plain_text" required>
                            <label for="htmlPA">HTML</label>
                            <input type="radio" name="field1" id="htmlPA" value="html">
                            <label for="jsonPA">JSON</label>
                            <input type="radio" name="field1" id="jsonPA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Price by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="PB" method="get">
                                <button type="submit" onclick="redirectB('PB')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/pricesV2">
                            <label for="field1">ID:</label>
                            <input class="box" type="text" name="field1" id="field1" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainPB">Text</label>
                            <input type="radio" name="field2" id="plainPB" value="plain_text" required>
                            <label for="htmlPB">HTML</label>
                            <input type="radio" name="field2" id="htmlPB" value="html">
                            <label for="jsonPB">JSON</label>
                            <input type="radio" name="field2" id="jsonPB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Price with user-provided Per Unit Cost and Unit Type</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="PC" method="post">
                                <button type="submit" onclick="redirectB('PC')">POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/pricesV3">
                            <label for="field1">Per Unit:</label>
                            <input class="box" type="text" name="field1" id="field1" required placeholder="0.00">
                        </td>
                        <td>
                            <label for="field2">Unit Type:</label>
                            <input class="box" type="text" name="field2" id="field2" required placeholder="Unit of measure">
                            </form>
                        </td>
                    </tr>
                </table>
                <p><em>Services</em></p>
                <table>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve all Services in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="SA" method="get">
                                <button type="submit" onclick="redirectA('SA')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/servicesV1">
                            <label>Format:</label>
                            <label for="plainA">Text</label>
                            <input type="radio" name="field1" id="plainA" value="plain_text" required>
                            <label for="htmlA">HTML</label>
                            <input type="radio" name="field1" id="htmlA" value="html">
                            <label for="jsonA">JSON</label>
                            <input type="radio" name="field1" id="jsonA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Service by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="SB" method="get">
                                <button type="submit" onclick="redirectB('SB')">GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="address" value="/composting/servicesV2">
                            <label for="field1">ID:</label>
                            <input class="box" type="text" name="field1" id="field1" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainB">Text</label>
                            <input type="radio" name="field2" id="plainB" value="plain_text" required>
                            <label for="htmlB">HTML</label>
                            <input type="radio" name="field2" id="htmlB" value="html">
                            <label for="jsonB">JSON</label>
                            <input type="radio" name="field2" id="jsonB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Service with user-provided Name and Description</td>
                    </tr>
                    <tr>
                        <td>
                            <form id="SC" method="post">
                                <button type="submit" onclick="redirectB('SC')">POST</button>
                        </td>
                        <td>
                                <input hidden type="text" id="address" value="/composting/servicesV3">
                                <label for="field1">Name:</label>
                                <input class="box" type="text" name="field1" id="field1" required placeholder="Service name">
                        </td>
                        <td>
                                <label for="field2">Description:</label>
                                <input class="box" type="text" name="field2" id="field2" required placeholder="Summary of Service work">
                            </form>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    <script type="text/javascript">
        init();
    </script>
    </body>
    <c:import url="footer.jsp"></c:import>
</html>
