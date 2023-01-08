<%@page import="Models.TypeService"%>
<%@page import="DAO.ServiceCRUD"%>
<%
    
ServiceCRUD sc = new ServiceCRUD();
 TypeService ts = sc.getServiceById(Integer.parseInt(request.getParameter("id_serv")));


%>

<%=ts.getDescription()%> <%=ts.getNomServ()%>

<form method="post" action="/WebApplication1/ServiceEditServlet">
    <input type="hidden" name="id" value="<%=ts.getId()%>">
              <div class="form-group">
                <label for="exampleInputEmail1">Nom du service</label>
                <input type="text" class="form-control" id="exampleInputEmail1" value="<%=ts.getNomServ()%>"  name="nom" placeholder="Enter email">
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">description</label>
                <input type="text" class="form-control" id="exampleInputPassword1" value="<%=ts.getDescription()%>" name="desc" placeholder="Password">
              </div>
              <div class="form-group">
                <label for="exampleInputFile">File input</label>
                <input type="file" id="exampleInputFile" name="image">
              </div>
          
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
