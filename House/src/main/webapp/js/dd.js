layui.use('flow', function(){
    var flow = layui.flow;

    flow.load({
        elem: '#demo' //流加载容器
        ,scrollElem: '#demo' //滚动条所在元素，一般不用填，此处只是演示需要。
        ,done: function(page, next){ //执行下一页的回调

            //模拟数据插入
            setTimeout(function(){
                var lis = [];
                for(var i = 0; i < 8; i++){
                    lis.push('<div>\n' +
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
                        '        </div>'+'<br>')
                }

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < 10); //假设总页数为 10
            }, 500);
        }
    });
});