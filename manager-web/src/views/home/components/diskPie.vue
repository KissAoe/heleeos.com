<template>
    <div style="width:100%;height:100%;" id="disk_pie"></div>
</template>

<script>
import echarts from 'echarts';

export default {
    name: 'diskPie',
    data () {
        return {
            //
        };
    },
    mounted () {
        this.$nextTick(() => {
            var dataSourcePie = echarts.init(document.getElementById('disk_pie'));
            const option = {
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    orient: 'vertical',
                    left: 'right',
                    data: ['ios', 'android', 'pc', 'web', 'others']
                },
                series: [
                    {
                        name: '磁盘空间',
                        type: 'pie',
                        radius: '66%',
                        center: ['50%', '60%'],
                        data: [
                            {value: 150, name: '空余', itemStyle: {normal: {color: '#9bd598'}}},
                            {value: 50, name: '备份', itemStyle: {normal: {color: '#ffd58f'}}},
                            {value: 80, name: '程序', itemStyle: {normal: {color: '#abd5f2'}}},
                            {value: 20, name: '系统', itemStyle: {normal: {color: '#ab8df2'}}},
                            {value: 10, name: '其它', itemStyle: {normal: {color: '#e14f60'}}}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            dataSourcePie.setOption(option);
            window.addEventListener('resize', function () {
                dataSourcePie.resize();
            });
        });
    }
};
</script>
