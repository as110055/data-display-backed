<template>
    <div>
        <el-select v-model="value1" placeholder="请选择">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-select v-model="value2" placeholder="请选择">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-button type="primary" @click=compare()>搜索</el-button>
        <div id="main" style="width: 500px; height:400px"></div>
    </div>
</template>

<script>
import { Loading } from 'element-ui'


export default {
    name: "Third",
    data() {
        return {
            tableData: [],
            options: [],
            value1: '',
            value2: ''
        }
    },
    methods: {
        //加载获取国名列表
        load() {
            this.request.get("http://localhost:8081/country", {
            }).then(res => {
                for (var i = 0; i < res.length; i++) {
                    this.options.push({ value: res[i].name, label: res[i].name })
                }
            })
        },
        // 按钮事件，请求选择国家的信息
        compare() {
            var chartDom = document.getElementById('main');
            var myChart = echarts.init(chartDom);
            var option;
            option = {
                color: ['#67F9D8', '#FFE434'],
                title: {
                    text: ''
                },
                legend: {},
                radar: {
                    shape: 'circle',
                    indicator: [
                        { name: 'surfaceArea', max: 17080000 },
                        { name: 'population', max: 1300000000 },
                        { name: 'gnp', max: 8600000 },
                        { name: 'lifeExpectancy', max: 84 },
                    ]
                },
                series: [
                    {
                        name: '',
                        type: 'radar',
                        data: [
                            {
                                value: [],
                                name: '',
                                label: {}
                            },
                            {
                                value: [],
                                name: '',
                                label: {}
                            }
                        ]
                    }
                ]
            };
            this.request.get("http://localhost:8081/country/countryName", {
                params: {
                    name1: this.value1,
                    name2: this.value2
                }
            }).then(res => {

                console.log(res.data[0])
                // option.legend.data=[res.data[0].name, res.data[1].name]
                option.series[0].data[0] = {
                    value: [
                        res.data[0].surfaceArea,
                        res.data[0].population,
                        res.data[0].gnp,
                        res.data[0].lifeExpectancy
                    ],
                    name: res.data[0].name,
                    label: {
                        show: true,
                        formatter: function (params) {
                            return params.value;
                        }
                    }
                }
                option.series[0].data[1] = {
                    value: [
                        res.data[1].surfaceArea,
                        res.data[1].population,
                        res.data[1].gnp,
                        res.data[1].lifeExpectancy
                    ],
                    name: res.data[1].name,
                    label: {
                        show: true,
                        formatter: function (params) {
                            return params.value;
                        }
                    }
                }
                myChart.setOption(option)
            })
        }
    },
    created() {
        this.load()
    },

}

import * as echarts from 'echarts';
</script>