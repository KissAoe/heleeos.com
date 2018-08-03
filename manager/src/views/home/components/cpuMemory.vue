<template>
    <div style="width:100%;height:100%;" id="cpu_memory"></div>
</template>

<script>
import api from '@/libs/api';
import echarts from 'echarts';

const option = {
    tooltip: {
        formatter: '{a} <br/>{b} : {c}%'
    },
    series: [
        {
            name: 'CPU使用率',
            type: 'gauge',
            min: 0,
            max: 100,
            detail: {
                formatter: '{value}%',
                fontSize: 18,
                offsetCenter: [0, '50px']
            },
            data: [{value: 50, name: 'CPU使用率'}],
            center: ['25%', '50%'],
            radius: '80%',
            title: {
                offsetCenter: [0, '80px']
            },
            axisLine: {
                lineStyle: {
                    // color: [],
                    width: 20
                }
            },
            splitLine: {
                length: 20
            }
        },
        {
            name: '内存使用量',
            type: 'gauge',
            min: 0,
            max: 100,
            detail: {
                formatter: '{value}%',
                fontSize: 18,
                offsetCenter: [0, '50px']
            },
            data: [{value: 50, name: '内存使用量'}],
            center: ['75%', '50%'],
            radius: '80%',
            title: {
                offsetCenter: [0, '80px']
            },
            axisLine: {
                lineStyle: {
                    // color: [],
                    width: 20
                }
            },
            splitLine: {
                length: 20
            }
        }
    ]
};

export default {
    name: 'cpuMemory',
    mounted () {
        let userFlow = echarts.init(document.getElementById('cpu_memory'));

        var self = this;
        // setInterval(function(){
        //     api.ajax(api.getSystemInfo).then(function(response){
        //         var result = response.data;
        //         if(result.code == 200) {
        //             option.series[0].data[0].value = result.data.cpuLoad.toFixed(2) - 0;
        //             option.series[1].data[0].value = result.data.memoryUsed.toFixed(2) - 0;
        //         } else {
        //             self.$Message.error('加载信息失败,' + result.message);
        //         }
        //     });
        //     userFlow.setOption(option);
        // }, 2000);
        
        window.addEventListener('resize', function () {
            userFlow.resize();
        });
    }
};
</script>
