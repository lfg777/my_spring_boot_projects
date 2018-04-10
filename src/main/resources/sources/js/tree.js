var width = 700,
    height = 500;

//定义数据转换函数
var tree = d3.layout.tree()
    .size([500,height-200]);
//定义对角线生成器diagonal
var diagonal = d3.svg.diagonal()
    .projection(function(d) { return [d.y, d.x]; });

//定义svg
var svg = d3.select("body").append("svg")
    .attr("width",width)
    .attr("height",height)
    .append("g")
    .attr("transform","translate(100,0)");

//读取json文件，进行绘图
d3.json("/getData",function(erro,root){
    var nodes = tree.nodes(root);
    var links = tree.links(nodes);

    //画点
    var node = svg.selectAll(".node")
        .data(nodes)
        .enter()
        .append("g")
        .attr("class","node")
        .attr("transform",function(d){return "translate("+ d.y+","+ d.x+")"});
    //加圈圈
    node.append("circle")
        .attr("r",11)
        .style("fill",function(d) { return d.children ? "lightsteelblue" : "#fff"; });
    //加文字
    node.append("text")
        .attr("dx",function(d){return d.children?-11:11;})
        .attr("dy",3)
        .style("text-anchor", function (d) {return d.children?"end":"start"})
        .attr("class","showName")
        .attr("depth",function (d) {
            return d.depth
        })
        .text(function (d) {return d.name});

    //画线
    var line = svg.selectAll("link")
        .data(links)
        .enter()
        .append("path")
        .attr("class","link")
        .attr("d",diagonal);
    svg.selectAll(".node").on("click",function () {
        var text = $(this).find("text")[0];
        console.log(text.innerHTML);
        showModal(text.innerHTML);
    });


});



