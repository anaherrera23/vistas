<template>
    <v-bottom-sheet v-model="sheet">
        <template v-slot:activator="{ on }">
            <v-icon
                    color="primary" dark v-on="on"
                    small
                    class="mr-2"
                    @click="deleteItem(item)"
            >
                mdi-account-search-outline mdi-36px
            </v-icon>
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
                </v-card>
            </v-row>
        </v-sheet>
    </v-bottom-sheet>
</template>

<script>
    import Datos from "./Datos";
    export default {
        props: ['nombre', 'curso'],
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
                {text: 'Curso', value: 'curso'},
                {text: 'Responsable', value: 'responsable'},
                {text: 'Fecha Alta', value: 'fechaA'},
                {text: 'Fecha Baja', value: 'fechaB'},
                {text: 'Acciones', value: 'action', sortable: false},
            ],
            datos: [],
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
                this.datos = [
                    {
                        nombre: 'jesus manuel',
                        curso: '1334235235',
                        responsable: "arc@gmail.com",
                        fechaA: '30101020',
                        fechaB: '30101020'
                    }
                ]
            },

            editItem(item) {
                this.editedIndex = this.desserts.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },

            deleteItem(item) {
                const index = this.desserts.indexOf(item);
                confirm('Are you sure you want to delete this item?') && this.desserts.splice(index, 1)
            },


        },
    }
</script>

<style scoped>

</style>
