$(document).ready(function() {


	$('#example').DataTable( {
		"ajax": {
			"url":"AdminFetchMatchsController",
			"type":"post"
		}
	});

	/*
	//To fetch the table data
		$.ajax({
			type:"post",
			cache:false,					
			url : "AdminFetchMatchsController",
			success : function(responseText) {						
				var jsonData=jQuery.parseJSON(responseText);
				//alert(jsonData[0].message);

				//alert(Object.keys(jsonData).length);
				var row="";
				for(var i=0;i<Object.keys(jsonData).length;i++){
					alert(jsonData[i].message);
					//console.log(jsonData[i].message);
					row+="<tr>"+
					"<td>"+jsonData[i].message+"</td>"+
					"<td>Position</td>"+
					"<td>Office</td>"+
					"<td>Age</td>"+
					"<td>Start date</td>"+
					"<td>Salary</td>"+
					"</tr>";
				}
				document.getElementById('example').innerHTML+="<tbody>" +"<tr>" +
				"<td>Gavin Joyce</td>" +
				"<td>Developer</td>" +
				"<td>Edinburgh</td>" +
				"<td>42</td>" +
				"<td>2010/12/22</td>" +
				"<td>$92,575</td>" +
				"</tr></tbody>";
			},
			error: function(responseText){
				alert(responseText);
			}				
		});
		return false;
		*/
	
});