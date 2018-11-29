$(document).ready(function(){
	
	$("#idArticleSearch").on("keypress",function(e){
		if(e.keyCode === 13){
			var codeArticle = $("#idArticleSearch").val();
			if(codeArticle && verivierDivision()){
				searchArticle(codeArticle);				
			}
		}
	});
	
	
	$("#listDivisions").on("change", function(e){
		if(verivierDivision()){
			$("#divisionNotSelectedBlock").hide("slow", function(){$("#divisionNotSelectedBlock").hide()});
			creerBonS($("#listDivisions option:selected").val());
		}
	});
	
	$("#saveBon").on("click", function(){
		$.getJSON("enrgistrerBonS", function(data){
			if(data){
				window.location.href='data';
			}
		});
	});
	
	$("#notFoundBlock").hide();
	$("#divisionNotSelectedBlock").hide();
	
});


function verivierDivision(){
	var nomD = $("#listDivisions option:selected").val();
	if(nomD){
		if(nomD == "-1"){
			$("#divisionNotSelectedBlock").show("slow", function(){$("#divisionNotSelectedBlock").show()});
			return false;
		}
		return true;
	}
}

function creerBonS(nomD){
	if(nomD){
		$.getJSON("creerBonS",{
			nomD: nomD,
			ajax: true
		},
		function(data){
			if(data){
				$("#codeBon").val(data.code);
				$("#dateBon").val(data.date);
			}
		}
		);
	}
}


function searchArticle(codeArticle)  {
	if(codeArticle){
	var detailHtml = "";
	
	$.getJSON("ajouterLigneS", {
		codeArticle: codeArticle,
		ajax: true
	}, 
	function(data){
		if(data){
				if($("#qte" + data.article.idArticle).length > 0){
					$("#qte" + data.article.idArticle).text(data.qte);
					$("#notFoundBlock").hide("slow", function(){$("#notFoundBlock").hide()});
				}else{
					detailHtml+=
						"<tr id='ligne"+data.article.idArticle+"'>"+
						"<td>" + data.article.codeArticle + "</td>"+
						"<td>" + data.article.nomArticle + "</td>"+
						"<td id='qte"+data.article.idArticle+"'>" + data.qte+ "</td>"+
						"<td>" + data.article.categorie.nomCategory + "</td>"+
						"<td>" + data.article.qteStock + "</td>"+
						"<td> <button class='btn btn-link' onclick='supprimerLigneS("+data.article.idArticle+")'><li class='fa fa-trash'/></button></td>"+
						"</tr>";
					$("#datailNouvouBonS").append(detailHtml);
					$("#notFoundBlock").hide("slow", function(){$("#notFoundBlock").hide()});
			  }
		 }
	}).fail(function(){
		$("#notFoundBlock").show("slow", function(){$("#notFoundBlock").show()});
	});
	}
	
}

function supprimerLigneS(idArticle){
	if($("#ligne" + idArticle).length > 0){
		
		$.getJSON("supprimerLigneS", {
			idArticle: idArticle,
			ajax: true
		}, 
		function(data){
			if(data){
				$("#ligne" + idArticle).hide("slow", function(){$("#ligne" + idArticle).remove()});
				}
			});
	}
}












