<template>
    <v-app>
        <v-content>
            <NavBar/>
            <div class="row ">
                <div class="col-10 text-truncate mx-auto">


                    <h1>Mantenimiento de Tarifas</h1>
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
                                <v-toolbar-title>Tarifas Actuales</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-card-text>
                                        <v-data-table

                                                :headers="headers"
                                                :items="datos"
                                                sort-by="calories"
                                                class="elevation-0"
                                                height="220px"
                                        >
                                            <template v-slot:item.action="{ item }">
                                                <Datos/>
                                                <v-icon
                                                        small
                                                        class="mr-2"
                                                        @click="detailsItem(item)"
                                                >
                                                    mdi-account-card-details-outline mdi-24px
                                                </v-icon>

                                                <v-icon
                                                        small
                                                        class="mr-2"
                                                        @click="deleteItem(item)"
                                                >
                                                    mdi-book-open-page-variant mdi-24px
                                                </v-icon>

                                                <v-icon
                                                        small
                                                        class="mr-2"
                                                        @click="checkItem(item)"
                                                >
                                                    mdi-check-outline mdi-24px
                                                </v-icon>
                                                <v-icon
                                                        small
                                                        class="mr-2"
                                                        @click="checkItem(item)"
                                                >
                                                    mdi-close-outline mdi-24px
                                                </v-icon>
                                            </template>

                                        </v-data-table>
                                    </v-card-text>
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
    import NavBar from "../components/core/NavBar";
    import Footer from "../components/core/Footer";
    export default {

        name: "Mantenimiento_tarifas",
        components: {NavBar,Footer},
        data: () => ({
            drawer: null,
            dialog: false
        }),
        methods:{
            NavBar
        }
    }
</script>

<style scoped>

</style>