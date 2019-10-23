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
                                <v-toolbar-title>Busqueda de alumnos</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>


                                    <v-text-field
                                            label="curso"
                                            name="curso"
                                            prepend-icon="mdi-lock"
                                            type="text"
                                            v-model="curso"
                                    ></v-text-field>
                                    <v-text-field
                                            label="Asignatura"
                                            name="asignatura"
                                            prepend-icon="mdi-lock"
                                            type="text"
                                            v-model="curso"
                                    ></v-text-field>
                                    <v-text-field
                                            label="Profesor"
                                            name="Nombre"
                                            prepend-icon="mdi-account"
                                            type="text"
                                            v-model="nombre"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions class="justify-center">
                                <Busqueda curso="curso" nombre="nombre"/>
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
    import Busqueda from "../components/ComponentesClase/Busqueda";
    export default {
        name: "Clases",
        components: {NavBar,Busqueda}
    }
</script>

<style scoped>

</style>
