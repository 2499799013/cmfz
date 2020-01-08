<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#bannerList").jqGrid({
            url: "${pageContext.request.contextPath}/banner/findAllByPage",
            editurl: "${pageContext.request.contextPath}/banner/edit",
            datatype: "json",
            colNames: ["编号", "标题", "状态", "描述", "创建时间", "图片"],
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {
                    name: "status", editable: true, edittype: 'select',
                    editoptions: {value: '展示:展 示;冻结:冻结'}
                },
                {name: "esc", editable: true},

               {name: "create_date", formatter: "date"},

                {
                    name: "img_path", editable: true, edittype: "file",
                    formatter: function (a, b, c) {
                        return "<img style='width: 100px;height:50px' src='${pageContext.request.contextPath}/img/" + a + "'/>"
                    }
                }
            ],
            styleUI: "Bootstrap",
            autowidth: true,
            height: "60%",
            pager: "#bannerPager",
            page: 1,
            rowNum: 3,
            rowList: [3, 6, 9],
            viewrecords: true,
            multiselect: true,
        }).jqGrid("navGrid", "#bannerPager",
            {
                //处理页面几个按钮的样式
                search: false
            },
            {//在编辑之前或者之后进行额外的操作
                /*beforeShowForm:function () {
                    alert("1")
                }*/
                closeAfterEdit: true,
                afterSubmit: function (response) {
                    var bannerId = response.responseText;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/banner/upload",
                        fileElementId: "img_path",
                        data: {bannerId: bannerId},
                        success: function (data) {
                            $("#bannerList").trigger("reloadGrid");

                        }
                    });
                    return response
                }
            },
            {//在添加数据 之前或者之后进行额外的操作
                /* beforeShowForm:function () {
                     alert("2")
                 }*/
                closeAfterAdd: true,
                afterSubmit: function (response) {
                    var bannerId = response.responseText;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/banner/upload",
                        fileElementId: "img_path",
                        data: {bannerId: bannerId},
                        success: function (data) {
                            $("#bannerList").trigger("reloadGrid");
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

    function queryAll() {
        location.href = "${pageContext.request.contextPath}/banner/queryAll"
    }
</script>
<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">轮播图列表</a></li>

        <li role="presentation"><a href="#profile" onclick="queryAll()" aria-controls="profile" role="tab"
                                    data-toggle="tab">展示图片</a></li>
       <%-- <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">导入图片</a></li>--%>

    </ul>

</div>
<table id="bannerList"></table>
<div id="bannerPager"></div>
