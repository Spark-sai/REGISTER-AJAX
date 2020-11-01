# REGISTER-AJAX



function validate_uomModel() {
                var val = $("#UomModel").val();
                var exp = /^[A-Z\-\s]{4,8}$/;
                if(val=='') {
                    $("#uomModelError").show();
                    $("#uomModelError").html("Model <b>can not be empty</b>");
                    $("#uomModelError").css("color","red");
                    uomModelError = false;
                } else if(!exp.test(val)) {
                    $("#uomModelError").show();
                    $("#uomModelError").html("Model <b>is not vaild</b>");
                    $("#uomModelError").css("color","red");
                    uomModelError = false;
                } else {
                	//ajax call start
                	$.ajax({
                		url : 'validate',
                		data: {'model':val},
                		success:function(resTxt) {
                			if(resTxt=='') { //no error
                				$("#uomModelError").hide();
                				uomModelError = true;
                			} else{ 
                				$("#uomModelError").show();
                                $("#uomModelError").html(resTxt);
                                $("#uomModelError").css("color","red");
                                uomModelError = false;
                			}
                		}
                	});
                	//ajax call end
                    
                }
                return uomModelError;
            }
