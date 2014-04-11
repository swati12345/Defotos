$('document').ready(function() 
{
	$('#valid').blur(function() 
	{
		var name = $('#valid').val();
		$.ajax(
		{
			url : 'email',
			type : 'POST',
			dataType :'text',
			data : {data : name},
			success : function(response) 
			{ 
				
				$('.emailvalid').html(response);
				/*alert("success :"+response);*/
			},
			error : function(response) 
			{  
				alert("error......"+response);
			}
		});
	});
});