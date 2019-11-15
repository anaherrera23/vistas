<template>
    <div>
        <v-toolbar color="primary">
            <v-divider
                    class="mx-4"
                    vertical
            ></v-divider>
            <v-toolbar-title><h1>Gestion</h1></v-toolbar-title>
            <v-divider
                    class="mx-4"
                    vertical
            ></v-divider>
            <div class="flex-grow-1"></div>

            <v-toolbar-items>
                <v-btn text v-on:click="inicio">Inicio</v-btn>
                <v-divider
                        class="mx-4"
                        vertical
                ></v-divider>
                <v-btn text v-on:click="profesores">Profesores</v-btn>
                <v-divider
                        class="mx-4"
                        vertical
                ></v-divider>
                <v-btn text v-on:click="alumnos">Alumnos</v-btn>
                <v-divider
                        class="mx-4"
                        vertical
                ></v-divider>
                <v-btn text v-on:click="clases">Clases</v-btn>
                <v-divider
                        class="mx-4"
                        vertical
                ></v-divider>
                <v-menu>
                    <template :elevation="0" v-slot:activator="{ on }">
                        <v-btn
                                color="primary"
                                dark
                                v-on="on">Mantenimiento
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item  @click="mantenimientoC">
                            <v-list-item-title>Mantenimiento de Cursos</v-list-item-title>
                        </v-list-item>
                        <v-list-item @click="mantenimientoA">
                            <v-list-item-title>Mantenimiento de Asignaturas</v-list-item-title>
                        </v-list-item>
                        <v-list-item @click="mantenimientoT">
                            <v-list-item-title>Mantenimiento de Tarifas</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>


            </v-toolbar-items>


        </v-toolbar>
    </div>
</template>

<script>
    export default {
        name: "NavBar",
        methods: {
            inicio: function (event) {
                this.$router.replace('/inicio');
            },
            profesores: function (event) {
                this.$router.replace('/profesores');
            },
            alumnos: function (event) {
                this.$router.replace('/alumnos');
            },
            clases: function (event) {
                this.$router.replace('/clases');
            },
            mantenimientoC: function (event) {
                this.$router.replace('/mantenimientoC');
            },
            mantenimientoA: function (event) {
                this.$router.replace('/mantenimientoA');
            },
            mantenimientoT: function (event) {
                this.$router.replace('/mantenimientoT');
            }

        }, data: () => ({
            items: [

            ],
        })
    }
</script>

<style scoped>

</style>
