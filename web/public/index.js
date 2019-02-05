/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    combo("/DistritoApp/CombosServlet", 1,"cuerpo");
    combo("/DistritoApp/CombosServlet", 2,"comp");
})



function combo(url, opcion,obj) {
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'text',
        data: {opcion: opcion },
        async: false,
        success: function(msg) {
            $("#"+obj).html(msg);
        }
    });
}