<%@page import="Models.TypeService"%>
<%@page import="DAO.ServiceCRUD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Option"%>
<%@page import="java.util.List"%>
<%@page import="DAO.OptionCRUD"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
     <% 
        ServiceCRUD sc = new ServiceCRUD();
        TypeService ts = sc.getServiceById(Integer.parseInt(request.getParameter("id_serv")));
        OptionCRUD oc = new OptionCRUD();
        List<Option> liste = new ArrayList<Option>();
        liste = oc.getOptionsByService(Integer.parseInt(request.getParameter("id_serv")));
              
      %>
<style>
.navbar-icon-top .navbar-nav .nav-link > .fa {
  position: relative;
  width: 36px;
  font-size: 24px;
}

.navbar-icon-top .navbar-nav .nav-link > .fa > .badge {
  font-size: 0.75rem;
  position: absolute;
  right: 0;
  font-family: sans-serif;
}

.navbar-icon-top .navbar-nav .nav-link > .fa {
  top: 3px;
  line-height: 12px;
}

.navbar-icon-top .navbar-nav .nav-link > .fa > .badge {
  top: -10px;
}

@media (min-width: 576px) {
  .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link {
    text-align: center;
    display: table-cell;
    height: 70px;
    vertical-align: middle;
    padding-top: 0;
    padding-bottom: 0;
  }

  .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link > .fa {
    display: block;
    width: 48px;
    margin: 2px auto 4px auto;
    top: 0;
    line-height: 24px;
  }

  .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link > .fa > .badge {
    top: -7px;
  }
}

@media (min-width: 768px) {
  .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link {
    text-align: center;
    display: table-cell;
    height: 70px;
    vertical-align: middle;
    padding-top: 0;
    padding-bottom: 0;
  }

  .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link > .fa {
    display: block;
    width: 48px;
    margin: 2px auto 4px auto;
    top: 0;
    line-height: 24px;
  }

  .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link > .fa > .badge {
    top: -7px;
  }
}

@media (min-width: 992px) {
  .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link {
    text-align: center;
    display: table-cell;
    height: 70px;
    vertical-align: middle;
    padding-top: 0;
    padding-bottom: 0;
  }

  .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link > .fa {
    display: block;
    width: 48px;
    margin: 2px auto 4px auto;
    top: 0;
    line-height: 24px;
  }

  .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link > .fa > .badge {
    top: -7px;
  }
}

@media (min-width: 1200px) {
  .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link {
    text-align: center;
    display: table-cell;
    height: 70px;
    vertical-align: middle;
    padding-top: 0;
    padding-bottom: 0;
  }

  .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link > .fa {
    display: block;
    width: 48px;
    margin: 2px auto 4px auto;
    top: 0;
    line-height: 24px;
  }

  .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link > .fa > .badge {
    top: -7px;
  }
}


.jumbotron {
background: #358CCE;
color: #FFF;
border-radius: 0px;
}
.jumbotron-sm { padding-top: 24px;
padding-bottom: 24px; }
.jumbotron small {
color: #FFF;
}
.h1 small {
font-size: 24px;
}

</style>
<nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">
          Accueil
          </a>
      </li>
      <%
            List<TypeService> liste_ts = new ArrayList<TypeService>();
              liste_ts = sc.getAllServices();
              
for(TypeService l : liste_ts){
      %>
      <li class="nav-item active">
        <a class="nav-link" href="solution.jsp?id_serv=<%=l.getId()%>">
        
            <%=l.getNomServ()%>
         
          </a>
      </li>
      <% } %>
      <li class="nav-item active">
        <a class="nav-link" href="apropos.jsp">
          a propos
          </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="contact.jsp">
          Contact
          </a>
      </li>
      
      <li class="nav-item active">
        <a class="nav-link" href="login.jsp">
          Login
          </a>
      </li>
      
       
      <li class="nav-item active">
        <a class="nav-link" href="registre.jsp">
          Registre
          </a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<style>
    ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}
li.active{border-bottom:3px solid silver;}

.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:30px;margin-bottom:0;color:black}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}
</style>

<div class="alert alert-success">${msg}</div>
    <div class="container">
        <div class="row">
            <form role="form" class="row" action="CommandeServlet" method="post">
                <div class="col-md-3 item-photo">
                    <img style="max-width:100%;" src="<%=ts.getImage()%>" />
                </div>
                    <input type="hidden" name="service_id" value="<%=ts.getId()%>">
                <div class="col-md-5" style="border:0px solid gray">
                    <!-- Datos del vendedor y titulo del producto -->
               
                    <h3>Service <%=ts.getNomServ()%></h3>    
                  
        
                    <ul>
                         <%
                              double prix_totale = 0;
                      for(Option l : liste){
                            if (l.getObligation()==1) {
                                prix_totale += l.getPrix();
                            }
                            %>
                            <li> <table class="table"><tr><th><input id="op_<%=l.getId_op()%>" type="checkbox" <% if (l.getObligation()==1) { %> disabled checked <% } %>  onChange="changeoption(<%=l.getId_op()%> , <%=l.getPrix()%>)" name="op_<%=l.getId_op()%>"> <%=l.getNom()%> </th> <th style="text-align: right;"> <%=l.getPrix() %> </th> </tr></table></li>
                        
                        <% } %>
                        <script>
                            sprix = <%=prix_totale%>;
                            function changeoption(id , prix){
                                if(document.getElementById("op_"+id).checked == true){
                                    sprix += prix;
                                }else{
                                    sprix -= prix;
                                }
                                console.log(sprix);
                                document.getElementById("prix_tt").innerHTML= sprix+0.0 +" DT";
                                document.getElementById("inputprix").value = sprix;
                            }
                        </script>
                    </ul>  
                    <hr>
                    <br>
                    <input type="hidden" id="inputprix" name="prix" value="<%=prix_totale%>">
                    <table class="table"> <tr> <th> <h4>Prix totale</h4> </th> <th><h4 style="color : green ; text-align: right ; margin-right: 30px" id="prix_tt"><%=prix_totale%> DT </h4></th></tr></table>
 
                </div> 
                <div class="col-md-4">
                    <div class="row">
                           
		
			
			<div class="form-group row">
			<input id="name" name="name" type="text" class="form-control" required>
			<label for="name">Nom de l'application</label>
                        </div>
                        <br>
                            <div class="form-group row">
                                    <textarea id="message" name="details" class="form-control" required></textarea>
                                    <label for="message">Details</label>
                            </div>
                        <br>
                        <div class="form-group row">
                            <input id="phone" name="cdc" type="file" class="form-control" required>
                            <label for="phone">Cahier de charge</label>
                        </div>
		
                    </div>
                </div>
                    <div class="row"> <button type="submit" value="Commander" class=""btn btn-success>Commander</button>
                    </div> </form>
                <div class="row">
                    <div class="col-md-12">
                        <br>
                        <%=ts.getDescription()%>
                    </div>
                </div>
            </div>
        </div>        
