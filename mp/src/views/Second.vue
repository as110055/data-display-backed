<template>
    <div id="main" style="width: 500px; height:400px"></div>
</template>

<script>

export default {
    name: "Second",
    data() {
        return {
            tableData: [],

        }
    },
    methods: {
        load() {
            this.request.get("http://localhost:8081/user", {
            }).then(res => {
                this.tableData = res.data

            })
        }
    },
    // created() {
    //     this.load()
    // },
    mounted() {
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;

        option = {
            xAxis: {
                type: 'category',
                data: ['20s', '30s', '40s', '50s', '60s']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: [1, 2, 3, 4, 5],
                    type: 'line'
                },
                {
                    data: [],
                    type: 'bar'
                }
            ]
        };
        // console.log(option.series[0].data);
        this.request.get("http://localhost:8081/user", {
        }).then(res => {
            var a = 0;
            var b = 0;
            var c = 0;
            var d = 0;
            var e = 0;
            for (var i = 0; i < res.length; i++) {
                let temp = res[i].age;
                switch (true) {
                    case temp >= 18 && temp <= 29:
                        a++;
                        break;
                    case temp >= 30 && temp <= 39:

                        b++;
                        break;
                    case temp >= 40 && temp <= 49:

                        c++;
                        break;
                    case temp >= 50 && temp <= 59:

                        d++;
                        break;
                    case temp >= 60 && temp <= 69:

                        e++;
                        break;
                }

            };
            var array = [a, b, c, d, e]
            option.series[0].data = array;
            option.series[1].data = array;
            myChart.setOption(option)
        })
        // option && myChart.setOption(option);
    }

}

import * as echarts from 'echarts';


</script>