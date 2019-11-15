<template>
    <v-app>
        <v-content>
            <NavBar/>
            <div class="row ">
                <div class="col-10 text-truncate mx-auto">


                    <h1>Profesorado</h1>
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
                                <v-toolbar-title>Busqueda de profesores</v-toolbar-title>
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

                                    <v-text-field
                                            id="Nif"
                                            label="Nif"
                                            name="Nif"
                                            prepend-icon="mdi-lock"
                                            type="number"
                                            v-model="nif"
                                    ></v-text-field>

                                </v-form>
                            </v-card-text>
                            <v-card-actions class="justify-center">
                                 <BusquedaProfesores :nif="nif" :nombre="nombre"/>
                                <v-icon color="primary" dark @click="nombre='', nif=''">mdi-pencil-remove-outline mdi-36px</v-icon>
                                <Nuevo/>
                            </v-card-actions>
                        </v-card>
                    </v-row>

                </div>
            </div>
            <Dialogo titulo="" mensaje="" show=""/>
            <Footer/>
        </v-content>
    </v-app>
</template>

<script>
    import NavBar from '../components/core/NavBar';
    import BusquedaProfesores from "../components/ComponentesProfesor/Busqueda";
    import Nuevo from "../components/ComponentesProfesor/Nuevo";
    import Dialogo from "../components/core/Dialogo";
    import Footer from "../components/core/Footer";
    export default {
        name: "Profesores",
        components: {NavBar,BusquedaProfesores,Nuevo,Dialogo,Footer},
        methods: {
            buscar: function () {

            }
        }, data: () => ({
            nombre:"",
            nif:""
        })
    }

</script>

<style scoped>

</style>
