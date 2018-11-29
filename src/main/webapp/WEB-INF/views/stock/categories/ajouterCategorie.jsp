<%@include file="/WEB-INF/views/includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stock - Nouvelle Ctegorie</title>

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
                        <h1 class="page-header">AJouter</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Nouvelle Categorie 
                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	  <c:url value="/categories/nouveau" var="enrgistrer" />
	                              <f:form modelAttribute="categorie"  action="${enrgistrer }" role="form">
	                              	<f:hidden path="idCategory"/>
	                              	 <div class="form-group">
	                                      <label>Nom</label>
	                                      <f:input path="nomCategory" class="form-control" placeholder="nom de la nouvelle categorie"/>
	                                  </div> 
	                                  <div class="form-group">
	                                      <label>Disignation</label>
	                                      <f:input path="designation" class="form-control" placeholder="Disignation de la nouvelle categorie"/>
	                                  </div>
	                                  <div class="panel-footer">
	                                  	  <button type="submit" class="btn btn-primary"><li class="fa fa-save">&nbsp;Enrgistrer</li></button>
	                                  	  <a href="<c:url value="/categories/"/>" class="btn btn-danger"><li class="fa fa-arrow-left">&nbsp;Annuler</li></a>
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
