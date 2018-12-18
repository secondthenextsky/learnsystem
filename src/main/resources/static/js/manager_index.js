$(function () {
    $("#_easyui_tree_2").attr("onClick", "showTeacherTab()");
    $("#_easyui_tree_3").attr("onClick", "showStudentTab()");
    $("#_easyui_tree_4").attr("onClick", "showManagerTab()");
    $("#_easyui_tree_5").attr("onClick", "showRoleTab()");

    getTeacherList();
    getStudentList();
    getManagerMessage();
})
//显示教师板块
function showTeacherTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "teacher");
    getTeacherList();
}
//显示学生板块
function showStudentTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "student");
    getStudentList();
}
//显示管理员板块
function showManagerTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "manager");
    getManagerMessage();
}
//显示角色板块
function showRoleTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "role");
}
//退出登录
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
/////////////////////////////////////////////////////////////////////////////////////////////////教师
//新增教师
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
            }else{
                alert(data.data);
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
                alert("修改成功");
            }else{
                alert(data.data);
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
//创建教师列表的每一项
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
//删除教师
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
                var d = new Date(data.data.birthday);
                $("#update_teacher_birthday").val(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
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
///////////////////////////////////////////////////////////////////////////////////////学生
//获取学生列表
function getStudentList() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/student/getAll",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                var student_list = $("#student_list");
                student_list.empty();
                $.each(data.data, function (i, item) {
                    var t = createStudentLi(item);
                    student_list.append(t);
                });
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
//创建学生列表的每一项
function createStudentLi(item) {
    var li = $('<div class="media text-muted pt-3"></div>');
    var div = $('<img src="../img/3.png" alt="" class="mr-2 rounded">' +
        '<div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">' +
        '<div class="d-flex justify-content-between align-items-center w-100">' +
        '<strong class="text-gray-dark">id：' + item.id + '</strong>' +
        '<a class="btn btn-outline-success my-2 my-sm-0"  onclick="deleteStudent(\'' + item.id + '\')">删除</a>' +
        '</div> ' +
        '<div class="d-flex justify-content-between align-items-center w-100">' +
        '<span class="d-block">姓　　名：' + item.username + '</span>' +
        '<a class="btn btn-outline-success my-2 my-sm-0"  onclick="prepareUpdateStudent(\'' + item.id + '\')">修改</a>' +
        '</div> ' +
        '<span class="d-block">联系方式：' + item.phonenumber + '</span>' +
        '<span class="d-block">性　　别：' + item.gender + '</span>' +
        '<span class="d-block">工　　号：' + item.number + '</span>' +
        '<span class="d-block">生　　日：' + item.birthday + '</span>' +
        '<span class="d-block">民　　族：' + item.nation + '</span>' +
        '<span class="d-block">地　　址：' + item.address + '</span>' +
        '<span class="d-block">电子邮箱：' + item.email + '</span>' +

        '<span class="d-block">学　　院：' + item.college + '</span>' +
        '<span class="d-block">专　　业：' + item.major + '</span>' +
        '<span class="d-block">入学时间：' + item.intendtime + '</span>' +

        '<span class="d-block">备　　注：' + item.remarks + '</span>' +
        '</div>');
    li.append(div);
    return li;
}

//新增学生
function addStudent() {
    var student = {};
    student.username = $("#student_username").val();
    student.password = $("#student_password").val();
    student.phonenumber = $("#student_phonenumber").val();
    student.gender = $("#student_gender").val();
    student.number = $("#student_number").val();
    student.birthday = $("#student_birthday").val();
    student.nation = $("#student_nation").val();
    student.remarks = $("#student_remarks").val();
    student.idcardnumber = $("#student_idcardnumber").val();
    student.address = $("#student_address").val();
    student.email = $("#student_email").val();

    student.college = $("#student_college").val();
    student.major = $("#student_major").val();
    student.intendtime = $("#student_intendtime").val();

    if (!student.username || !student.password || !student.phonenumber || !student.gender || !student.number ||
        !student.birthday || !student.nation || !student.remarks || !student.idcardnumber || !student.address || !student.email||
        !student.college || !student.major || !student.intendtime
    ) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/student/addStudent",
        data: JSON.stringify(student),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert("添加成功");
            }else{
                alert(data.data);
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
//修改学生信息
function updateStudent() {
    var student = {};
    student.id = $("#update_student_id").val();
    student.username = $("#update_student_username").val();
    student.password = $("#update_student_password").val();
    student.phonenumber = $("#update_student_phonenumber").val();
    student.gender = $("#update_student_gender").val();
    student.number = $("#update_student_number").val();
    student.birthday = $("#update_student_birthday").val();
    student.nation = $("#update_student_nation").val();
    student.remarks = $("#update_student_remarks").val();
    student.idcardnumber = $("#update_student_idcardnumber").val();
    student.address = $("#update_student_address").val();
    student.email = $("#update_student_email").val();

    student.college = $("#update_student_college").val();
    student.major = $("#update_student_major").val();
    student.intendtime = $("#update_student_intendtime").val();

    if (!student.username || !student.password || !student.phonenumber || !student.gender || !student.number ||
        !student.birthday || !student.nation || !student.remarks || !student.idcardnumber || !student.address || !student.email||
        !student.college || !student.major || !student.intendtime) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/student/updateStudent",
        data: JSON.stringify(student),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert("修改成功");
            }else{
                alert(data.data);
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
//删除学生
function deleteStudent(studentId) {
    var ok = confirm("确定删除吗？");
    if (!ok) {
        return;
    }
    var url = "/student/deleteStudent?studentId=" + studentId;
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
//获取该学生信息显示
function prepareUpdateStudent(studentId) {
    var url = "/student/get?id=" + studentId;
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
                $("#update_student_id").val(data.data.id);
                $("#update_student_username").val(data.data.username);
                $("#update_student_password").val("");
                $("#update_student_phonenumber").val(data.data.phonenumber);
                $("#update_student_gender").val(data.data.gender);
                $("#update_student_number").val(data.data.number);
                var d =  new Date(data.data.birthday);
                $("#update_student_birthday").val(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
                $("#update_student_nation").val(data.data.nation);
                $("#update_student_remarks").val(data.data.remarks);
                $("#update_student_idcardnumber").val(data.data.idcardnumber);
                $("#update_student_address").val(data.data.address);
                $("#update_student_email").val(data.data.email);

                $("#update_student_college").val(data.data.college);
                $("#update_student_major").val(data.data.major);
                var d2 =  new Date(data.data.intendtime);
                $("#update_student_intendtime").val(d2.getFullYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate());
                $("#openModal_updatestudent").click();
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
///////////////////////////////////////////////////////////////////////////////////////////////////////管理员
//获取管理员个人信息
function getManagerMessage() {
    var url = "/manager/getLoginManager";
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
                $("#update_manager_id").val(data.data.id);
                $("#update_manager_username").val(data.data.username);
                $("#update_manager_password").val("");
                $("#update_manager_phonenumber").val(data.data.phonenumber);
                $("#update_manager_gender").val(data.data.gender);
                $("#update_manager_number").val(data.data.number);
                var d = new Date(data.data.birthday);
                $("#update_manager_birthday").val(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
                $("#update_manager_nation").val(data.data.nation);
                $("#update_manager_remarks").val(data.data.remarks);
                $("#update_manager_idcardnumber").val(data.data.idcardnumber);
                $("#update_manager_address").val(data.data.address);
                $("#update_manager_email").val(data.data.email);
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
//修改管理员个人信息
function updatemanager() {
    var manager = {};
    manager.id = $("#update_manager_id").val();
    manager.username = $("#update_manager_username").val();
    manager.password = $("#update_manager_password").val();
    manager.phonenumber = $("#update_manager_phonenumber").val();
    manager.gender = $("#update_manager_gender").val();
    manager.number = $("#update_manager_number").val();
    manager.birthday = $("#update_manager_birthday").val();
    manager.nation = $("#update_manager_nation").val();
    manager.remarks = $("#update_manager_remarks").val();
    manager.idcardnumber = $("#update_manager_idcardnumber").val();
    manager.address = $("#update_manager_address").val();
    manager.email = $("#update_manager_email").val();
    if (!manager.username || !manager.password || !manager.phonenumber || !manager.gender || !manager.number || !manager.birthday || !manager.nation || !manager.remarks || !manager.idcardnumber || !manager.address || !manager.email) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/manager/updateLoginManager",
        data: JSON.stringify(manager),
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert("修改成功");
            }else{
                alert(data.data);
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