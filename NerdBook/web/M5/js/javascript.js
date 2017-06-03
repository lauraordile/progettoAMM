/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(user){//restituiamo un div di tipo user con immagine, un h2 ecc...
    var img=$("<img>")
            .attr("alt","FotoProfilo")
            .attr("src",user.urlFotoProfilo);
    var nome=$("<h2>").html(user.nome);
    
    var profilePic=$("<div>")
            .attr("class","profilePic")
            .append(img);
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(UserData);
}
function stateSucces(data){
     var userListPage=$("#userList");
     
     $(userListPage).empty();
     for(var instance in data){
         $(userListPage).append(createElement(data[instance]));
     }
}
function stateFailure(date,state){
    console.log(state);
}
$(document).ready(function(){
    $("serchYourUtente").click(function()){//serchyourUtente è il pulsante nell'html
        var wantedUtente =$("searchField")[0].value;
        
        $.ajax({
            url:"BachecaAjax",
            data:{
                cmd:"search",
                nomeUtenteCercato:wantedUtente
            },
            dataType:"json",
            success: function(data, state){
                console.log(data);
            },
            error:function(data,state){
                //stateFailuture(data,state)
            }
        });
    });
});



function createElement(gtt){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",gtt.urlFotoProfilo);
    var name = $("<h2>").html(gtt.nome);
    var link = $("<a>")
            .attr("href", "index.html?user="+gtt.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    var profilePic = $("<div>")
            .attr("class","profilePic")
            .append(img);
    
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(userData);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchYourGato").click(function(){
        
        var wantedCat = $("#searchField")[0].value;
        
        $.ajax({
            url: "CercaAmiciAjax",
            data:{
                cmd:"search",
                nomeGattoCercato: wantedCat
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
