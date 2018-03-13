
$(document).ready(function() {
	loadCars();

//讀取車輛資訊
function loadCars() {
var loadCarId;
var tbody =$('#carTable>tbody');  
var doc = $(document.createDocumentFragment());
var url = '/iHitch/editCar/showCar.controller'
  $.getJSON(url,function(cars){
  $.each(cars,function(idx,car){
	var editicon = $("<img alt='edit' src='../website/img/edit.png'>");
	var deleteicon = $("<img alt='delete' src='../website/img/delete.png'>");
	var button1 =$("<button ></button>").append(editicon)
	var button2 =$("<button ></button>").append(deleteicon)
// 	var button3 =$("<button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModal'>Upload</button>")
	var td0 =$("<td style='display:none'></td>").text(car.carId); 
	var tds =$("<td></td>");
	var td1 =$("<td></td>").text(car.carNo);
	var td2 =$("<td></td>").text(car.carBrand);
	var td3 =$("<td></td>").text(car.carType);
	var td4 =$("<td></td>").text(car.color);
	var td5 =$("<td></td>").text(car.pcFriendly);
	var td6 =$("<td></td>").append([button1,button2]);
	var td7 =$("<td></td>");
	var tr1 = $("<tr></tr>").append([td0,tds,td1,td2,td3,td4,td5,td6,td7]);
	doc.append(tr1);
	});  
		tbody.html(doc); 
// 刪除按鈕及動作
$("#carTable>tbody").on('click','tr>td>button:nth-child(2)',function() {
	var carId=$(this).parents("tr").find("td:nth-child(1)").text();
	$.ajax({
	    url: "/iHitch/editCar/deleteCar.controller",
	    data: "carId="+carId,
	    method: 'DELETE',
	    dataType:'json',
	    success: function(){
	    	loadCars();
	    }
	})
	});
$("#carTable>tbody").on("click","tr>td>button:nth-child(3)",function(){
	console.log($(this));
	alert($(this));
	loadCarId = $(this).parents("tr").children("td:nth-child(1)").text();
	console.log(loadCarId);
});

//讀取表單資料
$("#carTable>tbody").on('click','tr>td>button:nth-child(1)',function() {
	var carId=$(this).parents("tr").children("td:nth-child(1)").text();
	var carNo=$(this).parents("tr").children("td:nth-child(3)").text();
	var carBrand=$(this).parents("tr").children("td:nth-child(4)").text();
	var carType=$(this).parents("tr").children("td:nth-child(5)").text();
	var color=$(this).parents("tr").children("td:nth-child(6)").text();
	var pcFriendly = $(this).parents("tr").children("td:nth-child(7)").text();
	$("#carId").val(carId);     
	$("#carNo").val(carNo);
	$("#carBrand").val(carBrand);
	$("#carType").val(carType);
	$("#color").val(color);
	$("#pcFriendly").prop("checked",pcFriendly);
	$("#update").on("click",function () { 
		   
		$.ajax({
		    url: "/iHitch/editCar/updateCar.controller",
		    data: new FormData($("#carform")[0]),
		    method: 'post',
		    processData: false,
		    contentType: false,
		    enctype: 'multipart/form-data',
		    dataType:'json',
		    success: function(data){
		    	loadCars();
		    }
		})
	})
	
	});
//----------------------------------------
})
;}
	
//檢查車輛數
	function checkCarLength() {
		if(carsLength>=3){
			$("#foot").prop("display","none");
		}
	}	
// 上傳檔案選項
    $("#input-b9").fileinput({
        showPreview: true,
        showUpload: false,
        elErrorContainer: '#kartik-file-errors',
        allowedFileExtensions: ["jpg", "png", "gif"],
        maxFileSize:2048,
        maxFileCount:1,
    });
//上傳按鈕及動作
	$("#save").on("click",function(){
		var datas = new FormData($("#docForm")[0]);
		datas.set("carId",$("#carId").val());
		console.log($(this));
		$.ajax({
		    url: "/iHitch/editCar/uploadDocPhoto.controller",
		    data: datas,
		    method: 'post',
		    processData: false,
		    contentType: false,
		    enctype: 'multipart/form-data',
		    dataType:'json',
		    success: function(data){
		    	$("#close").click();
		    	console.log(data);
		    },
		    error:function(data){
		    	console.log();
		    }
		})
	})
});