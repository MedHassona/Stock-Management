<%@include file="/WEB-INF/views/includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stock - Nouveau Bon de Sortie</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../static/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../../static/Bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../static/Bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../static/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-../../static-top" role="navigation" style="margin-bottom: 0">
       
			<%@include file="/WEB-INF/views/stock/menu_top/topMenu.jsp" %>
            <%@include file="/WEB-INF/views/stock/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-../../static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Nouveau Bon de Sortie</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div  id="notFoundBlock" class="alert alert-danger">
                             l'article recherché n'existe pas
                </div>
                <div  id="divisionNotSelectedBlock" class="alert alert-danger">
                             veuillez selectionner une division
                 </div>
                	<div class="row">
		                <div class="col-lg-12">
		                    <div class="panel panel-primary">
		                        <div class="panel-heading">
		                            Nouveau Bon de Sortie
		                        </div>
		                        <!-- /.panel-heading -->
		                        <div class="panel-body">
		                        	  <c:url value="/bonSortie/nouveauS" var="enrgistrer" />
		                              <form action="/" enctype="multipart/form-data" role="form">
				                             <div class="col-md-4 mb-3">
		                                      	 <label>Code du Bon</label>
		                                       	 <input type="text"  class="form-control" id="codeBon" disabled/>   
		                                   	 </div>
				                           	 <div class="col-md-4 mb-3">
				                                  <label>Date</label>
				                                  <input type="text"  class="form-control"  id="dateBon" disabled/>
				                              </div>
			                                <div class="col-md-4 mb-3">
	                                            <label>Division</label>
	                                            <select class="form-control" id="listDivisions">
	                                                <option value="-1">selectionner une division</option>
	                                                <c:forEach items="${divs }" var="division">
		                                   		 		<option value="${division.getNomDivision()}">${division.getNomDivision()}</option>
		                                   		 	</c:forEach>
	                                            </select>
	                                        </div>
		                              </form>
		                        </div>
		                        <div class="panel-footer">
				                      <button type="button" id="saveBon" class="btn btn-primary"><li class="fa fa-save">&nbsp;Enrgistrer</li></button>
				                      <a href="<c:url value="/bonSortie/"/>" class="btn btn-danger"><li class="fa fa-arrow-left">&nbsp;Annuler</li></a>
				                 </div>
		                        <!-- /.panel-body -->
		                    </div>
		                    <!-- /.panel -->
		                </div>
		                <!-- /.col-lg-12 -->
		            </div>
		            
		            
		            <!-- Detailles du bon -->
             <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                    	
                        <div class="panel-heading">
                            Details du Bon de Sortie
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<div class="form-row">
		                        <div class="col-md-4 mb-3">
		                        	<label>code Article</label>
		                        	<input class="form-control" type="text" id="idArticleSearch" placeholder="saisir un code Article"/>
		                        </div>
		                        <div class="col-md-4 mb-3">
	                                    <label>articles</label>
	                                    <select class="form-control" id="listArticles">
                                             <option value="-1">selectionner un article</option>
	                                           <c:forEach items="${arts }" var="article">
		                              		 		<option value="${article.getCodeArticle()}">${article.getCodeArticle()}</option>
		                           		 		</c:forEach>
	                                    </select>
	                              </div>
	                              <div class="col-md-4 mb-3">
		                        	<label>quantité</label>
		                        	<input class="form-control" type="text" id="qte" placeholder="saisir la quatité"/>
		                        </div>
                        	</div><br/><br/><br/><br/>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>code Article</th>
                                        <th>Nom Article</th>
                                        <th>Quantité</th>
                                        <th>Categorie</th>
                                        <th>En Stock</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody id="datailNouvouBonS">
                                	<tr></tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../../static/Bootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../../static/Bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../../static/Bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../../static/Bootstrap/dist/js/sb-admin-2.js"></script>
    
    <!-- Bon Sortie Script -->
    <!-- <script src="../../static/JavaScript/bons.js"></script> -->
    <%-- <script src="<%=request.getContextPath() %>../static/JavaScript/bonSortie.js"></script> --%>
    
   <script src="${pageContext.request.contextPath}/static/JavaScript/bonSortie.js"></script> 
   

</body>

</html>
