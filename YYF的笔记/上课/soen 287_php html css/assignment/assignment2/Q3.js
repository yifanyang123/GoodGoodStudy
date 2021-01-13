function test(){
    var a = document.getElementById("inString").value.split("");
    var b = document.getElementById("inWord").value.split("");
    var x =new Array(0);
    for(var i = 0; i < a.length; i++){
        for(var j = 0; j < b.length; j++){
            if(b[j] == a[i])
                x.push(a[i]);
        }
    }
    var histElements = {
        x: x,
        type: 'histogram',
        marker: {color: '#FFC300',},
    };
    var layout = {
        bargap: 0.05,
        bargroupgap: 0.5,
        barmode: "overlay",
        title: "Histogram",
        xaxis: {title: "Values",},
        yaxis: {title: "Count"},
    };
    var data = [histElements];
//Using ID for div to plot the graph
    Plotly.newPlot('graph', data, layout);
    return false;
}