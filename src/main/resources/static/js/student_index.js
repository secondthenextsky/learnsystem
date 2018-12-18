$(function () {
    $("#_easyui_tree_2").attr("onClick", "showAttendanceTab()");
    $("#_easyui_tree_3").attr("onClick", "showCourseTab()");
    $("#_easyui_tree_4").attr("onClick", "showHomeworkTab()");
    $("#_easyui_tree_5").attr("onClick", "showInteractionTab()");
    $("#_easyui_tree_6").attr("onClick", "showStudentTab()");


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
//显示学生个人信息板块
function showStudentTab() {
    var t = $('#mytabs');
    var tabs = t.tabs('tabs');
    t.tabs('select', "student");
    getStudentMessage();
}

//退出登录
function logout() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/student/logout",
        data: {},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend: function () {
        },
        success: function (data) {
        },
        complete: function (XMLHttpRequest, textStatus) {
            window.location.href = "/html/login_student.html";
        },
        error: function () {
            window.location.href = "/html/login_student.html";
        }
    });
}
///////////////////////////////////////////////////////////////////////////////////////学生

//获取学生个人信息
function getStudentMessage() {
    var url = "/student/getLoginStudent";
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
                var d = new Date(data.data.birthday);
                $("#update_student_birthday").val(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
                $("#update_student_nation").val(data.data.nation);
                $("#update_student_remarks").val(data.data.remarks);
                $("#update_student_idcardnumber").val(data.data.idcardnumber);
                $("#update_student_address").val(data.data.address);
                $("#update_student_email").val(data.data.email);
                $("#update_student_college").val(data.data.college);
                $("#update_student_major").val(data.data.major);
                var d2 = new Date(data.data.intendtime);
                $("#update_student_intendtime").val(d2.getFullYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate());
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
//修改学生个人信息
function updatestudent() {
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
    if (!student.username || !student.password || !student.phonenumber || !student.gender || !student.number || !student.birthday || !student.nation || !student.remarks || !student.idcardnumber || !student.address || !student.email ||!student.college||!student.major||!student.intendtime) {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/student/updateLoginStudent",
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
            window.location.href = "/html/index_student.html";
        },
        error: function () {
            window.location.href = "/html/index_student.html";
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
        url: "/article/getAll",
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
                        "<td><a href=\"article.html?id="+item.id+"\" target=\"_blank\">查看</a></td></tr>");
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
/////////////////////////////////////////////////////////////////////////////////////////作业
//获取所有作业列表
function getHomeworkList() {
    $.ajax({
        type: "POST",
        async: true,
        contentType: "application/json",
        url: "/homework/getAll",
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
                        "<td>"+item.status+"</td>"+
                        "<td><a href=\"submithomework.html?id="+item.id+"\" target=\"_blank\">查看</a></td></tr>");
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