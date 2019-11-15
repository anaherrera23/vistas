<template>
    <v-app>
        <v-content>
            <NavBar/>
            <div class="row ">
                <div class="col-10 text-truncate mx-auto">


                    <h1>Clases</h1>
                    <v-divider></v-divider>
                    <br/>
                    <br/>
                    <v-row>
                        <v-card class="elevation-12 col-lg-12">
                            <v-toolbar
                                    color="primary"
                                    dark
                                    flat
                            >
                                <v-toolbar-title>Busqueda de clases</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>


                                    <v-select
                                            :items="['1', '2', '3', '4', '5', '6', '7', '8', '9']"
                                            label="Curso"
                                            name="curso"
                                            prepend-icon="mdi-school"
                                            type="text"
                                            v-model="curso"
                                    ></v-select>
                                    <v-select
                                            :items="['1', '2', '3', '4', '5', '6', '7', '8', '9']"
                                            label="Asignatura"
                                            name="asignatura"
                                            prepend-icon="mdi-book-open"
                                            type="text"
                                            v-model="asignatura"
                                    ></v-select>
                                    <v-select
                                            :items="['1', '2', '3', '4', '5', '6', '7', '8', '9']"
                                            label="Profesor"
                                            name="profesor"
                                            prepend-icon="mdi-account"
                                            type="text"
                                            v-model="profesor"
                                    ></v-select>
                                </v-form>
                            </v-card-text>
                            <v-card-actions class="justify-center">
                                <BusquedaClase />
                                <v-icon color="primary" dark @click="curso='', asignatura='' , profesor='' ">mdi-pencil-remove-outline mdi-36px</v-icon>
                                <Nuevo/>
                            </v-card-actions>
                        </v-card>
                    </v-row>

                </div>
            </div>
            <Footer/>
        </v-content>
    </v-app>
</template>

<script>
    import NavBar from '../components/core/NavBar';
    import BusquedaClase from "../components/ComponentesClase/Busqueda";
    import Nuevo from "../components/ComponentesClase/Nuevo";
    import Footer from "../components/core/Footer";
    export default {
        name: "Clases",
        components: {NavBar, BusquedaClase,Nuevo,Footer},
        data:() => ({
                curso: '',
                asignatura: '',
                profesor: ''
            })

    }
</script>

<style scoped>

</style>
