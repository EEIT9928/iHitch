$(document).ready(function() {
	loadPhoto();
	loadProf();
	setBirthYear();
	
// 	設定出生年屬性
	function setBirthYear(){
		var date = new Date();
		var year = date.getFullYear();
		$("#birthYear").prop('max',year).prop('min',(year-100)).val(year);
	}
// 	讀取照片
	function loadPhoto() {
		$.ajax({
		    url: "/iHitch/edit/showPhoto.controller",
		    method: 'GET',
		    success: function(data){
		    $("#MemberPhoto").attr('src', "data:image/png;base64,"+data);
		    }
		});
	};
// 	讀取個人資料
	function loadProf() {
		$.getJSON("/iHitch/edit/showProfile.controller",function(member){
			$("#firstName").val(member.firstName);
			$("#lastName").val(member.lastName);
			$("#birthYear").val(member.birthYear);
			$("#country").val(member.country);
			$("#phone").val(member.phone);
			$("#bio").val(member.bio);
		});
	}
// 	修改資料
	$("#submit").on("click",function(){
		var datas = JSON.stringify($("#profForm").serializeObject());   
		console.log(datas);
		$.ajax({
			 	url: "/iHitch/edit/editProfile.controller",
			    method: 'put',
			    data:datas,
			    datatype: "json",
			    contentType:'application/json',
			    success: function(data)
			    {	loadProf();
			    	console.log(data);
			    },
			 	error:function(){
			 		alert("Edit fail");
			 	}
			  });
	});
	
// 	=================轉換=================
	$.fn.serializeObject = function()
	{
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
	
})