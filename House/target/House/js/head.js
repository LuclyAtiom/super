layui.use('flow', function () {
    var flow = layui.flow;
    var limit = 5;//每页的记录条数
    var total;//总记录数
    var pageTotal;//总分页的页数


    var currPage = 1;//首次加载，当前页是1
    var pageSize = 5;

    flow.load({
        elem: '#demo' //流加载容器
        , scrollElem: '#demo'
        , done: function (page, next) {
            //执行下一页的回调
            var list = [];
            var params = {
                currPage:currPage,
                pageSize:pageSize
            };
            $.ajax('/House/House.do',{
                type: 'POST',
                url: '/House/House.do',
                dataType: 'json',
                data: params,
                async: false,
                success: function (response) {
                    total = response.totalCount;
                    var pageTotal = Math.ceil((total / limit));
                    layui.each(response.data, function (index, item) {

                        // if (item == 0 && page == pageTotal) {
                        //     return;
                        // } else {
                        //     $(".flow-default").append("<li>" + item + "</li>")
                        // }
                        $(".flow-default").append(

                           /* "<li>" +"<a href='https://www.baidu.com/'>" +
                            "  <div style='height: 0px ;float: left ;width: auto'>" + "<img src=\"img/book1.jpg\" width=\"200\" height=\"250、\">"+"</div>" +
                            "  <div style='height: 11% '>" + item.address + "</div>" +
                            "  <div style='height: 11% '>" + item.photo + "</div>" +
                            "  <div style='height: 11% '>" + item.money + "</div>" +
                            " </a>"+
                            "</li>"*/
                            setTimeout(function(){
                                var lis = [];
                                for(var i = 0; i < limit; i++){
                                    lis.push(/*'<div>\n' +
                                        '            <!-- 图片跳转-->\n' +
                                        '            <a href="#">\n' +
                                        '                <div style="float: left;width: 100%;">\n' +
                                        '                    <div style="float: left">\n' +
                                        '\n' +
                                        '                        <img src="img/2.jpg" width="200" height="200">\n' +
                                        '                    </div>\n' +
                                        '                    <div  style="float: left">\n' +
                                        '                        <h3>房子地址1</h3><br>\n' +
                                        '                        <p>房子类型1</p><br>\n' +
                                        '                        <p>车程距离1</p><br>\n' +
                                        '                        <h3><font color="red">房子价格1</font></h3>\n' +
                                        '                    </div>\n' +
                                        '                </div>\n' +
                                        '            </a>\n' +
                                        '        </div>'+'<br>'*/
                                        "<li>" +"<a href='/House/demo.html'>" +
                          "  <div style='height: 0px ;float: left ;width: auto'>" + "<img src=\"img/book1.jpg\" width=\"200\" height=\"250、\">"+"</div>" +
                          "  <div style='height: 11% '>" + item.address + "</div>" +
                          "  <div style='height: 11% '>" + item.photo + "</div>" +
                          "  <div style='height: 11% '>" + item.money + "</div>" +
                          " </a>"+
                          "</li>"
                                    )
                                }

                                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                                next(lis.join(''), page < 10); //假设总页数为 10
                            }, 500)
                        )
                    });
                    currPage++;
                },
                error: function (err) {
                    console.log("err=", err)
                }
            })
        }
    })
});
