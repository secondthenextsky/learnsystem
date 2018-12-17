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
function logout() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/manager/logout",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/login_manager.html";
        },
        error: function () {
            window.location.href = "/html/login_manager.html";
        }
    });
}
function addTeacher() {
    var teacher = {};
    teacher.username = $("#teacher_username").val();
    teacher.password = $("#teacher_password").val();
    teacher.phonenumber = $("#teacher_phonenumber").val();
    teacher.gender = $("#teacher_gender").val();
    teacher.number = $("#teacher_number").val();
    teacher.birthday = $("#teacher_birthday").val();
    teacher.nation = $("#teacher_nation").val();
    teacher.remarks = $("#teacher_remarks").val();
    teacher.idcardnumber = $("#teacher_idcardnumber").val();
    teacher.address = $("#teacher_address").val();
    teacher.email = $("#teacher_email").val();
    if (!teacher.username || !teacher.password || !teacher.phonenumber || !teacher.gender || !teacher.number || !teacher.birthday || !teacher.nation || !teacher.remarks || !teacher.idcardnumber || !teacher.address || !teacher.email) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/teacher/addTeacher",
        data: JSON.stringify(teacher),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert("添加成功");
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/index_manager.html";
        },
        error: function () {
            window.location.href = "/html/index_manager.html";
        }
    });
}
//修改教师信息
function updateTeacher() {
    var teacher = {};
    teacher.id = $("#update_teacher_id").val();
    teacher.username = $("#update_teacher_username").val();
    teacher.password = $("#update_teacher_password").val();
    teacher.phonenumber = $("#update_teacher_phonenumber").val();
    teacher.gender = $("#update_teacher_gender").val();
    teacher.number = $("#update_teacher_number").val();
    teacher.birthday = $("#update_teacher_birthday").val();
    teacher.nation = $("#update_teacher_nation").val();
    teacher.remarks = $("#update_teacher_remarks").val();
    teacher.idcardnumber = $("#update_teacher_idcardnumber").val();
    teacher.address = $("#update_teacher_address").val();
    teacher.email = $("#update_teacher_email").val();
    if (!teacher.username || !teacher.password || !teacher.phonenumber || !teacher.gender || !teacher.number || !teacher.birthday || !teacher.nation || !teacher.remarks || !teacher.idcardnumber || !teacher.address || !teacher.email) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/teacher/updateTeacher",
        data: JSON.stringify(teacher),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert("添加成功");
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/index_manager.html";
        },
        error: function () {
            window.location.href = "/html/index_manager.html";
        }
    });
}
//获取教师列表
function getTeacherList() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/teacher/getAll",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                var teacher_list = $("#teacher_list");
                teacher_list.empty();
                $.each(data.data, function (i, item) {
                    var t = createTeacherLi(item);
                    teacher_list.append(t);
                });
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
        },
        error: function () {
        }
    });
}

function createTeacherLi(item) {
    var li = $('<div class="media text-muted pt-3"></div>');
    var div = $('<img src="../img/3.png" alt="" class="mr-2 rounded">' +
        '<div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">' +
        '<div class="d-flex justify-content-between align-items-center w-100">' +
            '<strong class="text-gray-dark">id：' + item.id + '</strong>' +
            '<a class="btn btn-outline-success my-2 my-sm-0"  onclick="deleteTeacher(\'' + item.id + '\')">删除</a>' +
        '</div> ' +
        '<div class="d-flex justify-content-between align-items-center w-100">' +
            '<span class="d-block">姓　　名：' + item.username + '</span>' +
            '<a class="btn btn-outline-success my-2 my-sm-0"  onclick="prepareUpdateTeacher(\'' + item.id + '\')">修改</a>' +
        '</div> ' +
        '<span class="d-block">联系方式：' + item.phonenumber + '</span>' +
        '<span class="d-block">性　　别：' + item.gender + '</span>' +
        '<span class="d-block">工　　号：' + item.number + '</span>' +
        '<span class="d-block">生　　日：' + item.birthday + '</span>' +
        '<span class="d-block">民　　族：' + item.nation + '</span>' +
        '<span class="d-block">地　　址：' + item.address + '</span>' +
        '<span class="d-block">电子邮箱：' + item.email + '</span>' +
        '<span class="d-block">备　　注：' + item.remarks + '</span>' +
        '</div>');
    li.append(div);
    return li;
}
function deleteTeacher(teacherId) {
    var ok = confirm("确定删除吗？");
    if (!ok) {
        return;
    }
    var url = "/teacher/deleteTeacher?teacherId=" + teacherId;
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: url,
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {

        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/index_manager.html";
        },
        error: function () {
            window.location.href = "/html/index_manager.html";
        }
    });
}
//获取该教师信息显示
function prepareUpdateTeacher(teacherId) {
    var url = "/teacher/get?id=" + teacherId;
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: url,
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if(data.code==200){
                $("#update_teacher_id").val(data.data.id);
                $("#update_teacher_username").val(data.data.username);
                $("#update_teacher_password").val("");
                $("#update_teacher_phonenumber").val(data.data.phonenumber);
                $("#update_teacher_gender").val(data.data.gender);
                $("#update_teacher_number").val(data.data.number);
                $("#update_teacher_birthday").val(data.data.birthday);
                $("#update_teacher_nation").val(data.data.nation);
                $("#update_teacher_remarks").val(data.data.remarks);
                $("#update_teacher_idcardnumber").val(data.data.idcardnumber);
                $("#update_teacher_address").val(data.data.address);
                $("#update_teacher_email").val(data.data.email);
                $("#openModal_updateteacher").click();
            }else{
                alert(data.data);
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
        },
        error: function () {
        }
    });
}