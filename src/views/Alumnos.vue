<template xmlns="http://www.w3.org/1999/html">
    <v-app>
        <v-content>
            <NavBar/>
            <div class="row ">
                <div class="col-10 text-truncate mx-auto">


                    <h1>Alumnado</h1>
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
                                <v-toolbar-title>Busqueda de alumnos</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field
                                            label="Nombre"
                                            name="Nombre"
                                            prepend-icon="mdi-account"
                                            type="text"
                                            v-model="nombre"
                                    ></v-text-field>

                                    <v-select
                                            name="curso"
                                            prepend-icon="mdi-school"
                                            type="number"
                                            v-model="curso"
                                            :items="['1', '2', '3', '4', '5', '6', '7', '8', '9']"
                                            label="Curso"
                                    ></v-select>

                                    <v-checkbox
                                            v-model="checkbox"
                                            label="mostrar solo actuales"
                                            color="primary"
                                    ></v-checkbox>
                                </v-form>
                            </v-card-text>
                            <v-card-actions class="justify-center">
                                <BusquedaAlumnos :curso="curso" :nombre="nombre"/>
                                <v-icon color="primary" dark @click="nombre='', curso='', checkbox=false">mdi-pencil-remove-outline mdi-36px</v-icon>
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
    import Footer from "../components/core/Footer";
    import BusquedaAlumnos from "../components/ComponentesAlumnos/Busqueda";
    import Nuevo from "../components/ComponentesAlumnos/Nuevo";
    export default {
        name: "Alumnos",
        components: {NavBar,BusquedaAlumnos,Nuevo,Footer},
        methods: {
            buscar: function () {

            }
        }, data: () => ({
            nombre:"",
            curso:"",
            checkbox:false
        })
    }
</script>

<style scoped>

</style>
