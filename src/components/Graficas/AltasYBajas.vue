<template>
    <div id="altasybajas" style="width: 500px; height: 400px;"></div>
</template>

<script>
    export default {
        name: "AltasYBajas",
        methods: {
            grafico: function () {


                //grafica de barras
                // create data set on our data
                var dataSet = anychart.data.set([
                    ['Octubre', 1, 0],
                    ['Septiembre', 4, 1],
                    ['Agosto', 3, 0],
                    ['Julio', 2, 0]
                ]);

                // map data for the first series, take x from the zero column and value from the first column of data set
                var firstSeriesData = dataSet.mapAs({x: 0, value: 1});

                // map data for the second series, take x from the zero column and value from the second column of data set
                var secondSeriesData = dataSet.mapAs({x: 0, value: 2});

                // create column chart
                var chart = anychart.column();

                // turn on chart animation
                chart.animation(true);

                // set chart title text settings
                chart.title('Altas y bajas');

                // temp variable to store series instance
                var series;

                // helper function to setup label settings for all series
                var setupSeries = function (series, name) {
                    series.name(name);
                    series.selected()
                        .fill('#f48fb1 0.8')
                        .stroke('1.5 #c2185c');
                };

                // create first series with mapped data
                series = chart.column(firstSeriesData);
                series.xPointPosition(0.45);
                setupSeries(series, 'Altas');

                // create second series with mapped data
                series = chart.column(secondSeriesData);
                series.xPointPosition(0.25);
                setupSeries(series, 'Bajas');

                // set chart padding
                chart.barGroupsPadding(0.3);

                // format numbers in y axis label to match browser locale
                chart.yAxis().labels().format('${%Value}{groupsSeparator: }');

                // set titles for Y-axis
                chart.yAxis().title('# de altas y bajas');

                chart.xAxis().title('Mes');

                // turn on legend
                chart.legend()
                    .enabled(true)
                    .fontSize(13)
                    .padding([0, 0, 20, 0]);

                chart.interactivity().hoverMode('single');

                chart.tooltip().format('${%Value}{groupsSeparator: }');

                // set container id for the chart
                chart.container('altasybajas');

                // initiate chart drawing
                chart.draw();

            }
        },
        mounted()
        {
            this.grafico();
        }
    }
</script>

<style scoped>

</style>
