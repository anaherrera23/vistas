<template>
    <v-bottom-sheet v-model="sheet">
        <template v-slot:activator="{ on }">
            <v-btn
                    color="primary"
                    dark
                    v-on="on"
            >
                Buscar
            </v-btn>
        </template>
        <v-sheet class="text-left" height="400px">
            <v-row>
                <v-card class="elevation-12 col-lg-12">
                    <v-toolbar
                            color="primary"
                            dark
                            flat
                    >
                        <v-toolbar-title>Resultado de Busqueda</v-toolbar-title>
                        <div class="flex-grow-1"></div>

                    </v-toolbar>
                    <v-card-text>
                        <v-data-table

                                :headers="headers"
                                :items="datos"
                                sort-by="nif"
                                class="elevation-0"
                                height="220px"
                        >

                            <template v-slot:item.action="{ item }">
                                <Datos/>
                                <v-icon
                                        small
                                        class="mr-2"
                                        @click="deleteItem(item)"
                                >
                                    mdi-trash-can-outline mdi-24px
                                </v-icon>

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
                                        @click="calendarItem(item)"
                                >
                                    mdi-calendar-today mdi-24px
                                </v-icon>
                            </template>

                        </v-data-table>
                    </v-card-text>
                </v-card>
            </v-row>
        </v-sheet>
    </v-bottom-sheet>
</template>

<script>
    import Datos from "./Datos";
    import Axios from 'axios';

    export default {

        props: ['nombre', 'nif'],
        name: "BusquedaProfesores",
        data: () => ({
            sheet: false,
            dialog: true,
            headers: [
                {
                    text: 'Nombre',
                    align: 'left',
                    sortable: true,
                    value: 'nombre',
                },
                {text: 'Nif', value: 'nif'},
                {text: 'Correo', value: 'correo'},
                {text: 'Telefono', value: 'telefono'},
                {text: 'Actions', value: 'action', sortable: false},
            ],
            datos: []
        }),
        computed: {},

        watch: {
            dialog(val) {
                val || this.close()
            },
        },

        created() {
            this.initialize()
        },

        methods: {
            initialize() {
                Axios.get('http://192.168.43.97:8080/p/profesores').then(response => {
                    console.log(response);
                    this.datos = response.data;
                }).catch(e => {
                    console.log(e)
                });

            },

            detailsItem(item) {
                this.editedIndex = this.desserts.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },

            calendarItem(item) {

            },

            deleteItem(item) {
                const index = this.desserts.indexOf(item);
                confirm('Are you sure you want to delete this item?') && this.desserts.splice(index, 1)
            },


        },
        comments: {
            Datos
        }
    }
</script>

<style scoped>

</style>
