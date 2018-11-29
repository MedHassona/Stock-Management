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
			alert("enrgistrer");
			if(data){
				window.location.replace("http://localhost:5050/bonSortie/");
				alert("data");
			}else{
				alert("no data");
				window.location.replace("http://localhost:5050/bonSortie/");
			}
		});
	});
	
	$("#listArticles").on("change", function(){
		var code = $("#listArticles option:selected").val();
		if(code != "-1" && verivierDivision()){
			searchArticle(code);
		}
	});
	
	$("#qte").on("keypress",function(e){
		if(e.keyCode === 13){
			var qte = $("#qte").val();
			var code = $("#listArticles option:selected").val()
			if(qte && verivierDivision() && code != "-1"){
				plusQuqntite(code, qte);				
			}
		}
	});
	
	$("#myImg").hide();
	$("#bonsRow").hide();
	$("#detailRow").hide();
	$("#notFoundBonsBlock").hide();
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

function plusQuqntite(code, qte){
	if(code && qte){
		var detailHtml = "";
		
		$.getJSON("plusQuantite", {
			code: code,
			qte: qte,
			ajax: true
		},function(data){
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
			}
		 }
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

//function chercherDivision(nomD){
//	if(nomD != "-1"){
//		$.getJSON("chercherDivision", {
//			nomD: nomD,
//			ajax: true
//		},
//		function(data){
//			if(data){
//				
//			}
//		});
//	}
//}
//
//function chercherDate(dateD, dateF, nomD){
//	if(date != "" && dateF != ""){
//		return true;
//	}
//	
//}


function updateBon(data){
	if($("#json"+data).text()){
		var json = $.parseJSON($("#json"+data).text());
		var detailHtml = "";
		if(json){
			for(var i = 0; i< json.length; i++){
				detailHtml+=
					"<tr>"+
					"<td>"+json[i].article.codeArticle+"</td>"+
					"<td>"+json[i].article.nomArticle+"</td>"+
					"<td>"+json[i].qte+"</td>"+
					"<td>"+json[i].article.categorie.nomCategory+"</td>"+
					"</tr>";
			}
			$("#updateDetails").html(detailHtml);
			$("#detailRow").show();
			$("#notFoundBonsBlock").hide("slow", function(){$("#notFoundBonsBlock").hide()});
		}
	}else{
		$("#detailRow").hide();
		$("#notFoundBonsBlock").show("slow", function(){$("#notFoundBonsBlock").show()});
	}
}


function myTable(data){
	if(data == "-1"){
		$("#bonsRow").hide();
	}else{
		$("#bonsRow").show();
	}
		
}



