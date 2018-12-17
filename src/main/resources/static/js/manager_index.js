$(function () {
    $("#_easyui_tree_2").attr("onClick", "showTeacherTab()");
    $("#_easyui_tree_3").attr("onClick", "showStudentTab()");
    $("#_easyui_tree_4").attr("onClick", "showManagerTab()");
    getTeacherList();
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
function logout(){
    $.ajax({
        type:"POST",
        async:true,
        contentType:"application/json",
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
function addTeacher() {
    var teacher = {};
    teacher.username = $("#teacher_username").val();
    teacher.password = $("#teacher_password").val();
    teacher.phonenumber = $("#teacher_phonenumber").val();
    $.ajax({
        type:"POST",
        async:true,
        contentType:"application/json",
        url:"/teacher/addTeacher",
        data:JSON.stringify(teacher),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend:function(){
        },
        success:function(data){
            if(data.code==200){
                alert("添加成功");
            }
        },
        complete: function(XMLHttpRequest, textStatus){
            window.location.href="/html/index_manager.html";
        },
        error: function(){
            window.location.href="/html/index_manager.html";
        }
    });
}
//获取教师列表
function getTeacherList() {
    $.ajax({
        type:"POST",
        async:true,
        contentType:"application/json",
        url:"/teacher/getAll",
        data:{},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend:function(){
        },
        success:function(data){
            if(data.code==200){
                var teacher_list = $("#teacher_list");
                teacher_list.empty();
                $.each(data.data, function(i, item) {
                    var t = createTeacherLi(item);
                    teacher_list.append(t);
                });
            }
        },
        complete: function(XMLHttpRequest, textStatus){
        },
        error: function(){
        }
    });
}
function createTeacherLi(item) {
    var li = $('<div class="media text-muted pt-3"></div>');
    var div = $('<img src="../img/3.png" alt="" class="mr-2 rounded"><div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray"><div class="d-flex justify-content-between align-items-center w-100"><strong class="text-gray-dark">id：'+item.id+'</strong></div> <span class="d-block">姓名：'+item.username+'</span><span class="d-block">联系方式：'+item.phonenumber+'</span></div>');
    li.append(div);
    return li;
}