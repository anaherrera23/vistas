<template>
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

                                    <v-text-field
                                            label="curso"
                                            name="curso"
                                            prepend-icon="mdi-lock"
                                            type="number"
                                            v-model="curso"
                                    ></v-text-field>
                                    <v-checkbox
                                            v-model="checkbox"
                                            :rules="[v => !!v || 'You must agree to continue!']"
                                            label="mostrar solo actuales"
                                            required
                                            color="primary"
                                    ></v-checkbox>
                                </v-form>
                            </v-card-text>
                            <v-card-actions class="justify-center">
                                <BusquedaAlumnos :curso="curso" :nombre="nombre"/>
                                <v-btn color="primary">limpiar</v-btn>
                                <Nuevo/>
                            </v-card-actions>
                        </v-card>
                    </v-row>

                </div>
            </div>

        </v-content>
    </v-app>
</template>

<script>
    import NavBar from '../components/core/NavBar';
    import BusquedaAlumnos from "../components/ComponentesAlumnos/Busqueda";
    import Nuevo from "../components/ComponentesAlumnos/Nuevo";
    export default {
        name: "Alumnos",
        components: {NavBar,BusquedaAlumnos,Nuevo},
        methods: {
            buscar: function () {

            }
        }, data: () => ({
            nombre:"",
            curso:""
        })
    }
</script>

<style scoped>

</style>
