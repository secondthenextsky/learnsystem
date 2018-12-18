$(function () {
    $("#_easyui_tree_2").attr("onClick", "showAttendanceTab()");
    $("#_easyui_tree_3").attr("onClick", "showCourseTab()");
    $("#_easyui_tree_4").attr("onClick", "showHomeworkTab()");
    $("#_easyui_tree_5").attr("onClick", "showInteractionTab()");
    $("#_easyui_tree_6").attr("onClick", "showTeacherTab()");


})
//显示考勤板块
function showAttendanceTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "attendance");
}
//显示课程板块
function showCourseTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "course");
    getArticleList();
}
//显示作业板块
function showHomeworkTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "homework");
    getHomeworkList();
}
//显示互动板块
function showInteractionTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "interaction");
}
//显示教师个人信息板块
function showTeacherTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "teacher");
    getTeacherMessage();
}

//退出登录
function logout() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/teacher/logout",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/login_teacher.html";
        },
        error: function () {
            window.location.href = "/html/login_teacher.html";
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

//获取教师个人信息
function getTeacherMessage() {
    var url = "/teacher/getLoginTeacher";
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
//修改教师个人信息
function updateteacher() {
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
        url: "/teacher/updateLoginTeacher",
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
            window.location.href = "/html/index_teacher.html";
        },
        error: function () {
            window.location.href = "/html/index_teacher.html";
        }
    });
}
/////////////////////////////////////////////////////////////////////////////////////////////////////课程章节
//获取当前登录教师的所有章节列表
function getArticleList() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/article/getAllByLoginTeacher",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                var tbody = $("#articleListTBODY");
                tbody.empty();

                $.each(data.data, function (i, item) {
                    var tr = $("<tr><td>"+item.id+"</td>" +
                        "<td>"+item.sort+"</td>"+
                        "<td>"+item.title+"</td>"+
                        "<td>"+item.textContent+"</td>"+
                        "<td>"+item.teacherName+"</td>"+
                        "<td>"+new Date(item.createTime).toLocaleString()+"</td>"+
                        "<td><a href=\"article.html?id="+item.id+"\" target=\"_blank\">查看</a>" +
                        "|<a href=\"updateArticle.html?id="+item.id+"\" target=\"_blank\">修改</a>" +
                        "|<a href='javascript:void(0)' onclick='deletearticle(\""+item.id+"\")'>删除</a></td></tr>");
                    tbody.append(tr);
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
//删除章节
function deletearticle(articleId) {
    var ok = confirm("确定删除吗？");
    if(!ok){
        return;
    }
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/article/delete?articleId="+articleId,
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert(data.data);
                getArticleList();
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

/////////////////////////////////////////////////////////////////////////////////////////作业
//获取当前登录教师的所有作业列表
function getHomeworkList() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/homework/getAllByLoginTeacher",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                var tbody = $("#homeworkListTBODY");
                tbody.empty();

                $.each(data.data, function (i, item) {
                    var tr = $("<tr><td>"+item.id+"</td>" +
                        "<td>"+item.sort+"</td>"+
                        "<td>"+item.content+"</td>"+
                        "<td>"+item.teacherName+"</td>"+
                        "<td>"+new Date(item.beginTime).toLocaleString()+"</td>"+
                        "<td>"+new Date(item.endTime).toLocaleString()+"</td>"+
                        "<td>" +
                        "<a href=\"homework.html?id="+item.id+"\" target=\"_blank\">查看</a>" +
                        "|<a href=\"updateHomework.html?id="+item.id+"\" target=\"_blank\">修改</a>" +
                        "|<a href='javascript:void(0)' onclick='deletehomework(\""+item.id+"\")'>删除</a>" +
                        "</td></tr>");
                    tbody.append(tr);
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

//删除作业
function deletehomework(homeworkId) {
    var ok = confirm("确定删除吗？");
    if(!ok){
        return;
    }
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/homework/delete?homeworkId="+homeworkId,
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
            if (data.code == 200) {
                alert(data.data);
                getHomeworkList();
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
