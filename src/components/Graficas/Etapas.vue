<template>
    <div id="etapas" style="width: 500px; height: 400px;"></div>
</template>

<script>
    export default {
        name: "Etapas",
        methods: {
            grafico: function () {
                // create an instance of a pie chart
                var chartP = anychart.pie();
                // set the data
                chartP.data([
                    ["secundaria", 5],
                    ["bachillerato", 2],
                    ["primaria", 2]
                ]);
                // set chart title
                chartP.title("Etapas");
                // set the container element
                chartP.container("etapas");
                // initiate chart display
                chartP.draw();

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
