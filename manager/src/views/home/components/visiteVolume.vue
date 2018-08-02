<template>
    <div style="width:100%;height:100%;" id="visite_volume_con"></div>
</template>

<script>
import echarts from 'echarts';
export default {
    name: 'visiteVolume',
    data () {
        return {
            //
        };
    },
    methods: {
        getVirtulData(year) {
            var date = +echarts.number.parseDate('2018-01-01');
            var end = +echarts.number.parseDate('2018-07-12');
            var dayTime = 3600 * 24 * 1000;
            var data = [];
            for (var time = date; time < end; time += dayTime) {
                data.push([
                    echarts.format.formatTime('yyyy-MM-dd', time),
                    Math.floor(Math.random() * 8)
                ]);
            }
            return data;
        }
    },
    mounted () {
        this.$nextTick(() => {
            let visiteVolume = echarts.init(document.getElementById('visite_volume_con'));
            let xAxisData = [];
            let data1 = [];
            let data2 = [];
            for (let i = 0; i < 20; i++) {
                xAxisData.push('类目' + i);
                data1.push((Math.sin(i / 5) * (i / 5 - 10) + i / 6) * 5);
                data2.push((Math.cos(i / 5) * (i / 5 - 10) + i / 6) * 5);
            }

            const option = {
                tooltip: {
                    position: 'top'
                },
                visualMap: {
                    type: 'continuous',
                    inRange: {
                        color: ['#eee', '#c6e48b', '#7bc96f', '#239a3b']
                    },
                    min: 0,
                    max: 10,
                    orient: 'horizontal',
                    left: 'center',
                    top: 'top'
                },

                 calendar: {
                    left: 20,
                    right: 20,
                    cellSize: ['auto', 'auto'],
                    range: '2018',
                    itemStyle: {
                        normal: {borderWidth: 0.5}
                    },
                    yearLabel: {show: false},
                    monthLabel: {nameMap: 'cn'},
                    dayLabel: {
                        firstDay: 1,
                        nameMap: 'cn'
                    }
                },

                series: {
                    type: 'heatmap',
                    coordinateSystem: 'calendar',
                    calendarIndex: 0,
                    backgroundColor: '#eee',
                    data: this.getVirtulData(2018),
                }
            };

            visiteVolume.setOption(option);

            window.addEventListener('resize', function () {
                visiteVolume.resize();
            });
        });
    }
};
</script>
