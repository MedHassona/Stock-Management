<%@include file="/WEB-INF/views/includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stock - Bons de Sortie</title>

    <!-- Bootstrap Core CSS -->
    <link href="../static/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../static/Bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../static/Bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../static/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"><!-- DataTables CSS -->
    <link href="../static/Bootstrap/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../static/Bootstrap/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
       
			<%@include file="/WEB-INF/views/stock/menu_top/topMenu.jsp" %>
            <%@include file="/WEB-INF/views/stock/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Bons Sortie</h1>
                    </div>
                 
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  <li><a href="<c:url value="/bonSortie/nouveauS" />" ><i class="fa fa-plus">&nbsp;ajouter</i></a></li>
						  <li><a href="#"><i class="fa fa-download">&nbsp;exporter</i></a></li>
						  <li><a href="#"><i class="fa fa-upload">&nbsp;importer</i></a></li>
						</ol>					
					</div>                
                </div>
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Liste des Bons de Sortie
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Code Bone</th>
                                        <th>Date</th> 
                                        <th>Division</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${bons }" var="bon">
                                		<tr class="gradeA odd" role="row">
	                                        <td ><c:out value="${bon.getCode() }"/></td>
	                                     	<td><c:out value="${bon.getDate() }"/></td> 
	                                        <td><c:out value="${bon.getDivision().getNomDivision() }"/></td>
	                                        <td class="center">
	                                        	<textarea id="json${bon.getIdBon() }" style="display:none;">${bon.getLignesJason()}</textarea>
	                                       		<a href="javascript:void(0);" onclick="updateBon(${bon.getIdBon() });"><i class="fa fa-th-list"></i></a>
	                                       		&nbsp;|&nbsp;
                                        		<c:url value="/bonSortie/modifierS" var="modifier" />
                                        		<a href="${modifier }?id=${bon.getIdBon() }"  ><i class="fa fa-edit"></i></a>
                                        		&nbsp;|&nbsp;
						                            <!-- Button trigger modal -->
						                            <a href="javascript:void(0);" data-toggle="modal" data-target="#modalBon${bon.getIdBon() }"><i class="fa fa-trash-o" ></i></a>
						                            <!-- Modal -->
						                            <div class="modal fade" id="modalBon${bon.getIdBon() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
						                                <div class="modal-dialog">
						                                    <div class="modal-content">
						                                        <div class="modal-header">
						                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						                                            <h4 class="modal-title" id="myModalLabel">Confirmer la supprission</h4>
						                                        </div>
						                                        <div class="modal-body">
						                                            Voulez-vous supprimer cet Element ?
						                                        </div>
						                                        <div class="modal-footer">
						                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Annuler</button>
						                                            <c:url value="/bonSortie/supprimer" var="supprimer"/>
						                                            <a href="${supprimer }?id=${bon.getIdBon() }" type="button" class="btn btn-danger"><i class="fa fa-trash-o" ></i>&nbsp;Confirmer</a>
						                                        </div>
						                                    </div>
						                                    <!-- /.modal-content -->
						                                </div>
						                                <!-- /.modal-dialog -->
						                            </div>
						                            <!-- /.modal -->
                                        	</td>
	                                    </tr>
                                	</c:forEach>
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
            <div  id="notFoundBonsBlock" class="alert alert-danger">
                         Le Bon chisit ne contient pas des Articles ! 
             </div>
            
            <!-- Detailles du bon -->
             <div id="detailRow" class="row">
                <div   class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Details du Bon de Sortie
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>code Article</th>
                                        <th>Nom Article</th>
                                        <th>Quantité</th>
                                        <th>Categorie</th>
                                    </tr>
                                </thead>
                                <tbody id="updateDetails">
                                	 
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
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
    
    <!-- Bons javascript file  -->
    <script src="../static/JavaScript/bonSortie.js"></script>
    
    <!-- DataTables JavaScript -->
    <script src="../static/Bootstrap/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../static/Bootstrap/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../static/Bootstrap/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../static/Bootstrap/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
