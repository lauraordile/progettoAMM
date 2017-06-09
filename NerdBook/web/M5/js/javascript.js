/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(user){
    var img = $("<img>")
            .attr("title","profilo"+user.id)
            .attr("alt","foto profilo "+user.id)
            .attr("src",user.urlProfilo);
    var name = $("<h2>").html(user.nome);
    var link = $("<a>")
            .attr("href", "index.html?user="+user.id)
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
    
    var label = $("<label>")
                .html("Persone");
    
    $(userListPage).append(label);
    
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#search").click(function(){
        
        var wantedUser = $("#search")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                filtro: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});