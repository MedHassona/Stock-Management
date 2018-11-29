<%@include file="/WEB-INF/views/includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stock - Nouveau Article</title>

    <!-- Bootstrap Core CSS -->
    <link href="../static/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../static/Bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../static/Bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../static/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
        <nav class="navbar navbar-default navbar-../static-top" role="navigation" style="margin-bottom: 0">
       
			<%@include file="/WEB-INF/views/stock/menu_top/topMenu.jsp" %>
            <%@include file="/WEB-INF/views/stock/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-../static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    	<c:choose>
						    <c:when test="${test=='1'}">
						        <h1 class="page-header">Ajouter un Article</h1>
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <h1 class="page-header">Modifier l'Article ${article.getNomArticle() }</h1>
						        <br />
						    </c:otherwise>
						</c:choose>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Nouveau Article
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                      
                        	  <c:url value="/articles/nouveau" var="enrgistrer" />
                              <f:form modelAttribute="article" action="${enrgistrer }" role="form">
                              	<f:hidden path="idArticle"/>
                              	<div class="form-group">
                                      <label>Code Article</label>
                                      <f:input path="codeArticle" class="form-control" placeholder="code du nouveau article"/>
                                  </div>
                              	 <div class="form-group">
                                      <label>Nom Article</label>
                                      <f:input path="nomArticle" class="form-control" placeholder="nom du nouveau article"/>
                                  </div>
                                  <div class="form-group">
                                      <label>Categorie </label>
                                      <f:select path="categorie.idCategory" items="${cats}" itemLabel="nomCategory" itemValue="idCategory" class="form-control"/>   
                                  </div>
                                  <div class="form-group">
                                      <label>En Stock</label>
                                      <f:input path="qteStock" class="form-control" placeholder="qte stock" value="0"/>
                                  </div>
                                  <div class="form-group">
                                      <label>Description</label>
                                      <f:input path="description" class="form-control" placeholder="Description du nouveau article"/>
                                  </div>
                                  <div class="panel-footer">
                                  	  <button type="submit" class="btn btn-primary"><li class="fa fa-save">&nbsp;Enrgistrer</li></button>
                                  	  <a href="<c:url value="/articles/"/>" class="btn btn-danger"><li class="fa fa-arrow-left">&nbsp;Annuler</li></a>
                                  </div>
                              </f:form> 
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
    <script src="../static/Bootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../static/Bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../static/Bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../static/Bootstrap/dist/js/sb-admin-2.js"></script>

</body>

</html>
