

var person = 
    {
       userimage: image,
       username : username,
       userfname : fName,
       userlname : lName,
       useremail : email,
       usercountry : country,
       usercity : city,
       userphone : phone,
       userpass : pass
    };
function previewFile(){
            var preview = document.querySelector('img'); //selects the query named img
            var file    = document.querySelector('input[type=file]').files[0]; //sames as here
            var reader  = new FileReader();

            reader.onloadend = function () {
                preview.src = reader.result;
            };

            if (file) {
            reader.readAsDataURL(file); //reads the data as a URL
            } else {
            preview.src = "";
            }
        }

        previewFile();  //calls the function named previewFile()