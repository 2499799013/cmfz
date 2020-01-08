<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#userList").jqGrid({
            url: "${pageContext.request.contextPath}/user/findByPage",
            editurl: "${pageContext.request.contextPath}/user/edit",
            datatype: "json",
            colNames: ["编号", "名字", "性别", "省份", "创建时间","图片","账号","密码"],
            colModel: [
                {name: "id"},
                {name: "name", editable: true},
                {
                    name: "sex", editable: true, edittype: 'select',
                    editoptions: {value: '1:1 ; 0:0'}
                },
                {name: "province", editable: true},


                {name: "create_Date", formatter: "date"},
                {
                    name: "img", editable: true, edittype: "file",
                    formatter: function (a, b, c) {
                        return "<img style='width: 100px;height:50px' src='${pageContext.request.contextPath}/img/" + a + "'/>"
                    }
                },
                {name: "username", editable: true},
                {name: "password", editable: true}



            ],
            styleUI: "Bootstrap",
            autowidth: true,
            height: "60%",
            pager: "#userPager",
            page: 1,
            rowNum: 3,
            rowList: [3, 6, 9],
            viewrecords: true,
            multiselect: true,
        }).jqGrid("navGrid", "#userPager",
            {
               /* //处理页面几个按钮的样式
                search: false*/
            },
            {//在编辑之前或者之后进行额外的操作
                closeAfterAdd: true,
                afterSubmit: function (response) {
                    var userId = response.responseText;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/user/upload",
                        fileElementId: "img",
                        data: {userId: userId},
                        success: function (data) {
                            $("#userList").trigger("reloadGrid");
                        }
                    });
                    return response
                }
            },
            {//在添加数据 之前或者之后进行额外的操作
                closeAfterEdit: true,
                afterSubmit: function (response) {
                    var userId = response.responseText;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/user/upload",
                        fileElementId: "img",
                        data: {userId: userId},
                        success: function (data) {
                            $("#userList").trigger("reloadGrid");
                        }
                    });
                    return response
                }
            },

            {//在删除数据之前或者之后进行额外的操作
                /*beforeShowForm:function () {
                    alert("3")
                }*/
            }
        )
    })
</script>
<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">用户列表</a></li>
    </ul>

</div>
<table id="userList"></table>
<div id="userPager"></div>
