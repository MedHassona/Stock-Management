<%@include file="/WEB-INF/views/includes/includes.jsp" %>
<div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <c:url value="/reporting" var="home"/>
                        <li>
                            <a href="${home}"><i class="fa fa-dashboard fa-fw"></i>Table de bord</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-th fa-fw"></i>Gestion d'Articles<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:url value="/articles/" var="articles"/>
		                        <li>
		                            <a href="${articles}"><i class="fa fa-th-large fa-fw"></i>Articles</a>
		                        </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i>Gestion de Stock<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            <!--------------------------------------------- Entrées --------------------------------------->
                                <li>
	                            	<a href="#"><i class="fa fa-arrow-right fa-fw"></i>Entrées<span class="fa arrow"></span></a>
		                            <ul class="nav nav-second-level">
		                            	<c:url value="/bonsEntree/entres" var="urlEntree"/>
		                                <li>
		                                    <a href="${urlEntree}"><i class="fa fa-file-text-o fa-fw"></i>Bons d'entrée</a>
		                                </li>
		                                <c:url value="/bonSortie/sorties" var="urlSorties"/>
		                                <li>
		                                    <a href="${urlSorties }"><i class="fa fa-plus-circle fa-fw"></i>Créer Bon</a>
		                                </li>
		                                <c:url value="/bonSortie/sorties" var="urlSorties"/>
		                                <li>
		                                    <a href="${urlSorties }"><i class="fa  fa-search fa-fw"></i>Rechercher</a>
		                                </li>
		                            </ul>
		                            <!-- /.nav-third-level -->
	                        	</li>
                                <!--------------------------------------------- Sorties --------------------------------------->
                                <li>
	                            	<a href="#"><i class="fa fa-arrow-left fa-fw"></i>Sorties<span class="fa arrow"></span></a>
		                            <ul class="nav nav-second-level">
		                            	<c:url value="/bonSortie/" var="urlSorties"/>
		                                <li>
		                                    <a href="${urlSorties }"><i class="fa fa-file-text-o fa-fw"></i>Bons de Sortie</a>
		                                </li>
		                                <c:url value="/bonSortie/nouveauS" var="urlCreerS"/>
		                                <li>
		                                    <a href="${urlCreerS }"><i class="fa fa-plus-circle fa-fw"></i>Créer Bon</a>
		                                </li>
		                                <c:url value="/bonSortie/chercher" var="urlChercherS"/>
		                                <li>
		                                    <a href="${urlChercherS }"><i class="fa  fa-search fa-fw"></i>Rechercher</a>
		                                </li>
		                            </ul>
		                            <!-- /.nav-third-level -->
	                        	</li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>parametrage<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:url value="/users/" var="users"/>
                                <li>
                                    <a href="${users}"><i class="fa fa-users fa-fw"></i>Utilisateurs</a>
                                </li>
                                <c:url value="/fournisseurs/" var="fournisseurs"/>
                                <li>
                                    <a href="${fournisseurs}"><i class="fa fa-male fa-fw"></i>Fournisseurs</a>
                                </li>
		                        <c:url value="/divisions/" var="divisions"/>
		                        <li>
		                            <a href="${divisions }"><i class="fa fa-cubes fa-fw"></i>Divisions</a>
		                        </li>
                                <c:url value="/categories/" var="categories"/>
		                        <li>
		                            <a href="${categories }"><i class="fa fa-th-large fa-fw"></i>Categories</a>
		                        </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>