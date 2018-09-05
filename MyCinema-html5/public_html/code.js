/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var code = {
    init: function() {
    $.get("http://localhost:9090/MyCinema-server/films")
        .done(code.onGetSuccesYeah)
        .fail(code.onErrorBoooh);
},
onGetSuccesYeah : function(data) {
    console.log(data);
},
onErrorBoooh: function() {
    console.log(":....(");
}
};

$(document).ready(code.init);