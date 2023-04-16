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
                            <form onsubmit="this.action='/'+this.addressMA.value+'/'+this.fieldMA.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMA" value="ComPostingv3_war/composting/materialsV1">
                            <label>Format:</label>
                            <label for="plainMA">Text</label>
                            <input type="radio" name="fieldMA" id="plainMA" value="plain_text" required>
                            <label for="htmlMA">HTML</label>
                            <input type="radio" name="fieldMA" id="htmlMA" value="html">
                            <label for="jsonMA">JSON</label>
                            <input type="radio" name="fieldMA" id="jsonMA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Material by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressMB.value+'/'+this.fieldMB.value+'/'+this.fieldMC.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMB" value="ComPostingv3_war/composting/materialsV2">
                            <label for="fieldMB">ID:</label>
                            <input class="box" type="text" name="fieldMB" id="fieldMB" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainMB">Text</label>
                            <input type="radio" name="fieldMC" id="plainMB" value="plain_text" required>
                            <label for="htmlMB">HTML</label>
                            <input type="radio" name="fieldMC" id="htmlMB" value="html">
                            <label for="jsonMB">JSON</label>
                            <input type="radio" name="fieldMC" id="jsonMB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Material with user-provided Name and Comments</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressMC.value+'/'+this.fieldMD.value+'/'+this.fieldME.value;" method="post">
                                <button>POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressMC" value="ComPostingv3_war/composting/materialsV3">
                            <label for="fieldMD">Name:</label>
                            <input class="box" type="text" name="fieldMD" id="fieldMD" required placeholder="Material name">
                        </td>
                        <td>
                            <label for="fieldME">Comments:</label>
                            <input class="box" type="text" name="fieldME" id="fieldME" required placeholder="Additional details">
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
                            <form onsubmit="this.action='/'+this.addressDA.value+'/'+this.fieldDA.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressDA" value="ComPostingv3_war/composting/periodsV1">
                            <label>Format:</label>
                            <label for="plainDA">Text</label>
                            <input type="radio" name="fieldDA" id="plainDA" value="plain_text" required>
                            <label for="htmlDA">HTML</label>
                            <input type="radio" name="fieldDA" id="htmlDA" value="html">
                            <label for="jsonDA">JSON</label>
                            <input type="radio" name="fieldDA" id="jsonDA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Period by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressDB.value+'/'+this.fieldDB.value+'/'+this.fieldDC.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressDB" value="ComPostingv3_war/composting/periodsV2">
                            <label for="fieldDB">ID:</label>
                            <input class="box" type="text" name="fieldDB" id="fieldDB" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainDB">Text</label>
                            <input type="radio" name="fieldDC" id="plainDB" value="plain_text" required>
                            <label for="htmlDB">HTML</label>
                            <input type="radio" name="fieldDC" id="htmlDB" value="html">
                            <label for="jsonDB">JSON</label>
                            <input type="radio" name="fieldDC" id="jsonDB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Period with user-provided Frequency and Time Unit</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressDC.value+'/'+this.fieldDD.value+'/'+this.fieldDE.value;" method="post">
                                <button>POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressDC" value="ComPostingv3_war/composting/periodsV3">
                            <label for="fieldDD">Frequency:</label>
                            <input class="box" type="text" name="fieldSD" id="fieldDD" required placeholder="1">
                        </td>
                        <td>
                            <label for="fieldDE">Time Unit:</label>
                            <input class="box" type="text" name="fieldDE" id="fieldDE" required placeholder="Measure of time">
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
                            <form onsubmit="this.action='/'+this.addressPA.value+'/'+this.fieldPA.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressPA" value="ComPostingv3_war/composting/pricesV1">
                            <label>Format:</label>
                            <label for="plainPA">Text</label>
                            <input type="radio" name="fieldPA" id="plainPA" value="plain_text" required>
                            <label for="htmlPA">HTML</label>
                            <input type="radio" name="fieldPA" id="htmlPA" value="html">
                            <label for="jsonPA">JSON</label>
                            <input type="radio" name="fieldPA" id="jsonPA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Price by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressPB.value+'/'+this.fieldPB.value+'/'+this.fieldPC.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressPB" value="ComPostingv3_war/composting/pricesV2">
                            <label for="fieldPB">ID:</label>
                            <input class="box" type="text" name="fieldPB" id="fieldPB" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainPB">Text</label>
                            <input type="radio" name="fieldPC" id="plainPB" value="plain_text" required>
                            <label for="htmlPB">HTML</label>
                            <input type="radio" name="fieldPC" id="htmlPB" value="html">
                            <label for="jsonPB">JSON</label>
                            <input type="radio" name="fieldPC" id="jsonPB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Price with user-provided Per Unit Cost and Unit Type</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressPC.value+'/'+this.fieldPD.value+'/'+this.fieldPE.value;" method="post">
                                <button>POST</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressPC" value="ComPostingv3_war/composting/pricesV3">
                            <label for="fieldPD">Per Unit:</label>
                            <input class="box" type="text" name="fieldPD" id="fieldPD" required placeholder="0.00">
                        </td>
                        <td>
                            <label for="fieldPE">Unit Type:</label>
                            <input class="box" type="text" name="fieldPE" id="fieldPE" required placeholder="Unit of measure">
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
                            <form onsubmit="this.action='/'+this.addressSA.value+'/'+this.fieldSA.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressSA" value="ComPostingv3_war/composting/servicesV1">
                            <label>Format:</label>
                            <label for="plainA">Text</label>
                            <input type="radio" name="fieldSA" id="plainA" value="plain_text" required>
                            <label for="htmlA">HTML</label>
                            <input type="radio" name="fieldSA" id="htmlA" value="html">
                            <label for="jsonA">JSON</label>
                            <input type="radio" name="fieldSA" id="jsonA" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Retrieve a single Service by ID in a chosen format</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressSB.value+'/'+this.fieldSB.value+'/'+this.fieldSC.value;" method="get">
                                <button>GET</button>
                        </td>
                        <td>
                            <input hidden type="text" id="addressSB" value="ComPostingv3_war/composting/servicesV2">
                            <label for="fieldSB">ID:</label>
                            <input class="box" type="text" name="fieldSB" id="fieldSB" required placeholder="1">
                        </td>
                        <td>
                            <label>Format:</label>
                            <label for="plainB">Text</label>
                            <input type="radio" name="fieldSC" id="plainB" value="plain_text" required>
                            <label for="htmlB">HTML</label>
                            <input type="radio" name="fieldSC" id="htmlB" value="html">
                            <label for="jsonB">JSON</label>
                            <input type="radio" name="fieldSC" id="jsonB" value="json">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="heading">-- Create a new Service with user-provided Name and Description</td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="this.action='/'+this.addressSC.value+'/'+this.fieldSD.value+'/'+this.fieldSE.value;" method="post">
                                <button onclick="intercept()">POST</button>
                        </td>
                        <td>
                                <input hidden type="text" id="addressSC" value="ComPostingv3_war/composting/servicesV3">
                                <label for="fieldSD">Name:</label>
                                <input class="box" type="text" name="fieldSD" id="fieldSD" required placeholder="Service name">
                        </td>
                        <td>
                                <label for="fieldSE">Description:</label>
                                <input class="box" type="text" name="fieldSE" id="fieldSE" required placeholder="Summary of Service work">
                            </form>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </body>
</html>
