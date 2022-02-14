var default_content="";

$(document).ready(function(){

	checkURL();
	populateCurrency()
	$('ul li a').click(function (e){
			checkURL(this.hash);
	});

	//filling in the default content
	default_content = $('#pageContent').html();


	setInterval("checkURL()",250);

});

var lasturl="";

function checkURL(hash)
{
	if(!hash) hash=window.location.hash;

	if(hash != lasturl)
	{
		lasturl=hash;
		// FIX - if we've used the history buttons to return to the homepage,
		// fill the pageContent with the default_content
		if(hash=="")
		$('#pageContent').html(default_content);

		else{
		 if(hash=="#products")
		 	loadProducts();
		 else
		   loadPage(hash);
		}
	}
}


function loadPage(url)
{
	//url=url.replace('#page','');
	url=url.replace('#','');  // Change 1
	$('#loading').css('visibility','visible');

	$.ajax({
		type: "POST",
		async: false,
		url: "load_page.jsp",  //Change 2
		data: 'page='+url,
		dataType: "html",
		success: function(msg){

			if(parseInt(msg)!=0)
			{
				$('#pageContent').html(msg);
				$('#loading').css('visibility','hidden');
			}
		}

	});

}

function loadProducts() {
  $('#loading').css('visibility','visible');
  var jsonURL = "products.json";
  $.getJSON(jsonURL, function (json)
  {
    var imgList= "<ul class=\"products\">";
    $.each(json.products, function () {


	  imgList += '<li>' +
	  					'<a href="#' + this.detailsPage +'"  \
						        onclick="sessionStorage.setItem(\'basePrice\',  \'' + this.price + '\' )">'  +
							  	'<img src= "' + this.imgPath + '">' +
								'<h3>' + this.name + '</h3>'+
						'</a>' +
						'<p id="' + this.id + '"><b> SGD: ' + this.price + '</b></p>' +
					'</li>';
    });
    imgList+='</ul>'
   $('#pageContent').html(imgList);
   $('#loading').css('visibility','hidden');
  });

}
function populateCurrency(){
	var currencySelector = document.getElementById("currency_selector");
	var opt; 
	
	var jsonURL = "currency.json";
  	$.getJSON(jsonURL, function (json)  { 
	    $.each(json.currencies, function () {
			opt = document.createElement('option');
			opt.value = this.code;
			opt.text = this.name;
			currencySelector.appendChild(opt);
			sessionStorage.setItem(this.code, this.conversion);
		});
	  });

	  currencySelector.onchange=function() {
        currencyCode = currencySelector.options[currencySelector.selectedIndex].value; 
        refreshPrice(currencyCode);
    }

}

function refreshPrice (currencyCode){
		hash = window.location.hash;
		var basePrice;
		var newPrice;
		var exchangeRate ; 
		
		if (hash == "#products") {
			var jsonURL = "products.json";
			$.getJSON(jsonURL, function(json) {
				$.each(json.products, function() {
					 basePrice = this.price;
					 exchangeRate = sessionStorage.getItem(currencyCode);
					 newPrice = basePrice * exchangeRate;  
					 $('#'+this.id).html(currencyCode +': '+newPrice);
				})
			})
		} else{
			// basePrice ?
			// from json
			// for which product?
			// using hash - detail page name 
			// this.detailsPage = hash excluding '#'
			// this is tedious way when we have more products 
			// How do we optimize 
			// When we click the product, store the product price in the session 
			// Get the price as basePrice from the session while refreshing 

			basePrice = sessionStorage.getItem("basePrice")
			exchangeRate = sessionStorage.getItem(currencyCode);
			newPrice = basePrice * exchangeRate;  
			$('#price').html(currencyCode +': '+newPrice);
		}
}
