jQuery(function(){
	$("body").on("click","a.ajax-link",function(evt){
		evt.preventDefault();
		$("#right").load($(this).attr("href"));
	});
	$("body").on('submit','form.ajax-form',function(evt){
		evt.preventDefault();
		var form = $(this);
		$.post(form.attr("action"),form.serialize(),function(rs){
			alert(rs);
			$("#right").load("dog/list.do");
		});
	});
	$("body").on('submit','form.form-update',function(evt){
		evt.preventDefault();
		var form = $(this);
		$.post(form.attr("action"),form.serialize(),function(rs){
			alert(rs);
			$("#right").load("dog/list.do");
		});
	});
	
	$(".menu li").on('click',function(){
		$(".menu li i").css("color","black");
		$(this).find("i").css("color","blue");
	})
});



/*JavaScript*/
/*(function(){
	var right = document.getElementById("right");
	var aLink = document.getElementsByTagName("a");
	for(var i=0;i<aLink.length;i++){
		if(aLink[i].className == "ajax-link"){
			aLink[i].onclick = function(){
				var xhr = new XMLHttpRequest();
				xhr.open("get", this.href, true);
				xhr.send(null);
				xhr.onload = function(){
					right.innerHTML = xhr.responseText;
				}
				return false;
			}
		}
	}

})();*/