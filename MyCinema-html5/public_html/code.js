/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var code = {
    init: function () {
        $.get("http://localhost:9090/MyCinema-server/webresources/films")
                .done(code.onGetSuccesYeah)
                .fail(code.onErrorBoooh);
    },
    onGetSuccesYeah: function (data) {
        console.log(data);
        code.writeFilmList(data.films);
    },
    onErrorBoooh: function () {
        console.log(":....(");
    }
    ,
    writeFilmList: function (filmList) {
        for (var f of filmList) {
            var htmlStr = `<div class="cinema-panel-item">
                <img class="film-template" src="images/MissionImpossible.jpg" alt="film template">
                <div class="film-description">
                    <p><strong>` + f.title + `</strong></p>
                    <p>
                        <span><strong>Genere:</strong>` + f.genere + `</span><br>
                        <span><strong>Cast:</strong>` + f.cast + `</span><br>
                        <span><strong>Durata:</strong>` + f.durata + `</span><br>
                        <span><strong>Data Uscita:</strong>` + f.dataUscita + `</span><br></p>
                    <p><span>Data: 04-09-2018</span><br>
                        <span>Sala: 5      Posti: 190</span><br>
                        <span>19:00    21:00   23:00</span>
                    </p>
                </div>
            </div>`;
            $("#films-list").append(htmlStr);
        }

    }

};
$(document).ready(code.init);