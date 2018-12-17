$(function () {
    $("#_easyui_tree_2").attr("onClick", "showTeacherTab()");
    $("#_easyui_tree_3").attr("onClick", "showStudentTab()");
    $("#_easyui_tree_4").attr("onClick", "showManagerTab()");

})
function showTeacherTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "teacher");
}
function showStudentTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "student");
}
function showManagerTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "manager");
}
function getDataFromService() {
    var year = 2018;
    $.ajax({
        type: "POST",
        data: {
            method: "getData",
            year: year
        },
        url: "/manager/getAll",
        dataType: "json",
        success: function (res) {
        }
    });
}
function logout(){
    $.ajax({
        type:"POST",
        async:true,
        contentType:"application/x-www-form-urlencoded",
        url:"/manager/logout",
        data:{
        },
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend:function(){
        },
        success:function(data){
        },
        complete: function(XMLHttpRequest, textStatus){
            window.location.href="/html/login_manager.html";
        },
        error: function(){
            window.location.href="/html/login_manager.html";
        }
    });
}