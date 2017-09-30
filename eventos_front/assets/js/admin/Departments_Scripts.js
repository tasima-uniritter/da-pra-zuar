$(document).ready(function () {

/*
*   Search Departments
*/

$("#name_department").autocomplete({
    minLength: 2,
    source: function (request, response) {
        $.getJSON({
            type: "POST",
            data: {name_department: $("#name_department").val()},
            url: "search",
            beforeSend: function () {
                
            },
            success: function (departments) {
                console.log(departments);
                response($.map(departments, function (department) {
                    return {
                        label: department.name,
                        value: department.name,
                        object: department
                    };
                }));
            },
            error: function () {
                alert('Error');
            }
        });
    },
    select: function (event, ui) {
        department = ui.item;
        $("#id_department").val(department.object.id);
    },
    focus: function (event, ui) {

    }
});

























    var $uploadCrop;
    $uploadCrop = $('#upload-demo').croppie({
        enableExif: true,
        viewport: {
            width: 200,
            height: 200
        },
        boundary: {
            width: 300,
            height: 300
        }
    });
$('#upload').on('change', function () { readFile(this); });

            function readFile(input) {
     			if (input.files && input.files[0]) {
    	            var reader = new FileReader();

    	            reader.onload = function (e) {
    					$('.upload-demo').addClass('ready');
    	            	$uploadCrop.croppie('bind', {
    	            		url: e.target.result
    	            	}).then(function(){
    	            		console.log('jQuery bind complete');
    	            	});

    	            }

    	            reader.readAsDataURL(input.files[0]);
    	        }
    	        else {
    		        swal("Sorry - you're browser doesn't support the FileReader API");
    		    }
    		}

        $('.upload-result').on('click', function (ev) {
                $uploadCrop.croppie('result', {
                        type: 'canvas',
                        size: 'viewport'
                }).then(function (resp) {
                        $('#department_image').val(resp);
                        $('#form').submit();
                });
        });
        
        function popupResult(result) {
		var html;              
                console.log(result.src);
		if (result.html) {
			html = result.html;
		}
		if (result.src) {
			html = '<img src="' + result.src + '" />';
		}
                 $('#myImage').attr('src', html.src);
              //  $(".img_load").append(html);
//		swal({
//			title: '',
//			html: true,
//			text: html,
//			allowOutsideClick: true
//		});
//		setTimeout(function(){
//			$('.sweet-alert').css('margin', function() {
//				var top = -1 * ($(this).height() / 2),
//					left = -1 * ($(this).width() / 2);
//
//				return top + 'px 0 0 ' + left + 'px';
//			});
//		}, 1);
	}


});
