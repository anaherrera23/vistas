<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-icon
                        color="primary" dark v-on="on"
                        small
                        class="mr-2"
                >
                    mdi-account-plus-outline mdi-36px
                </v-icon>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">Nuevo Alumno</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field label="Nombre*" required></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field label="Apellido 1*" required></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field
                                        label="Apellido 2"
                                ></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field label="Correo" v-model="email" :rules="emailRules"></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field label="Nif"></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                                <v-text-field label="Telefono"></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                                <v-select
                                        :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                                        label="Curso*"
                                        multiple
                                ></v-select>
                            </v-col>
                            <v-col cols="12" sm="6">
                                <v-checkbox
                                        label="repetidor*"
                                        v-model="checkbox"
                                        :rules="[v => !!v || 'seleccione el campo!']"
                                        required
                                        color="primary"
                                ></v-checkbox>
                            </v-col>
                            <template>
                                <v-container>
                                    <v-row>
                                        <v-col cols="12" lg="6">
                                            <v-menu
                                                    ref="menu1"
                                                    v-model="menu1"
                                                    :close-on-content-click="false"
                                                    transition="scale-transition"
                                                    offset-y
                                                    full-width
                                                    max-width="290px"
                                                    min-width="290px"
                                            >
                                                <template v-slot:activator="{ on }">
                                                    <v-text-field
                                                            v-model="dateFormatted"
                                                            label="fecha de alta"
                                                            prepend-icon="mdi-calendar"
                                                            @blur="date = parseDate(dateFormatted)"
                                                            v-on="on"
                                                    ></v-text-field>
                                                </template>
                                                <v-date-picker
                                                        v-model="date" no-title
                                                        @input="menu1 = false">

                                                </v-date-picker>
                                            </v-menu>
                                        </v-col>

                                        <v-col cols="12" lg="6">
                                            <v-menu
                                                    v-model="menu2"
                                                    :close-on-content-click="false"
                                                    transition="scale-transition"
                                                    offset-y
                                                    full-width
                                                    max-width="290px"
                                                    min-width="290px"
                                            >
                                                <template v-slot:activator="{ on }">
                                                    <v-text-field
                                                            v-model="computedDateFormatted"
                                                            label="fecha de baja"
                                                            prepend-icon="mdi-calendar"
                                                            readonly
                                                            v-on="on"
                                                    ></v-text-field>
                                                </template>
                                                <v-date-picker v-model="date" no-title
                                                               @input="menu2 = false"></v-date-picker>
                                            </v-menu>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </template>
                            <v-col cols="12">
                                <v-text-field label="Observaciones"></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <span class="headline">Responsable</span>
                            </v-col>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field label="Nombre*" required></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field label="Apellido 1*" required></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6" md="4">
                                <v-text-field label="Apellido 2"></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field label="*Correo" required v-model="email" :rules="emailRules"></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                                <v-text-field label="*Nif" required></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                                <v-text-field label="*Telefono" required></v-text-field>
                            </v-col>
                            <small>**Nota:  los datos del resposable se llenaran en caso de que sean necesario.</small>

                        </v-row>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <div class="flex-grow-1"></div>
                    <v-btn color="primary" text @click="dialog = false">Cancelar</v-btn>
                    <v-btn color="primary" text @click="nuevo()">Crear</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>

</template>

<script>
    export default {
        name: "NuevoProfesor",
        data: vm => ({
            date: new Date().toISOString().substr(0, 10),
            dateFormatted: vm.formatDate(new Date().toISOString().substr(0, 10)),
            menu1: false,
            menu2: false,
            email: '',
            dialog:false,
            emailRules: [
                v => !!v || 'E-mail is required',
                v => /.+@.+/.test(v) || 'E-mail must be valid',
            ],
        }),

        computed: {
            computedDateFormatted() {
                return this.formatDate(this.date)
            },
        },

        watch: {
            date(val) {
                this.dateFormatted = this.formatDate(this.date)
            },
        },

        methods: {
            formatDate(date) {
                if (!date) return null

                const [year, month, day] = date.split('-')
                return `${month}/${day}/${year}`
            },
            parseDate(date) {
                if (!date) return null

                const [month, day, year] = date.split('/')
                return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
            },
        },

    }


</script>

<style scoped>

</style>
