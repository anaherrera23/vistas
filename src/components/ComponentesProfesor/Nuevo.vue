    <template>
        <v-row justify="center">
            <v-dialog v-model="dialog" persistent max-width="600px">
                <template v-slot:activator="{ on }">
                    <v-icon
                            color="primary" dark v-on="on"
                            small
                            class="mr-2"
                    >
                        mdi-account-plus-outline    mdi-36px
                    </v-icon>
                </template>
                <v-card>
                    <v-card-title>
                        <span class="headline">Nuevo Profesor</span>
                    </v-card-title>
                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col cols="12" sm="6" md="4">
                                    <v-text-field label="Nombre*" v-model="nombre" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6" md="4">
                                    <v-text-field label="Apellido 1*" v-model="apellido1" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6" md="4">
                                    <v-text-field
                                            label="Apellido 2"
                                            v-model="apellido2"
                                    ></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field label="Nif*" v-model="nif" required></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field label="Correo*" v-model="correo" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field label="Telefono*" v-model="telefono" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field label="Titulacion" v-model="titulacion"></v-text-field>
                                </v-col>
                            </v-row>
                        </v-container>
                        <small>* indica campo obligatorio</small>
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
    import Axios from 'axios';
    export default {
        name: "Nuevo",
        data: () => ({
            dialog: false,
            nombre:'',
            apellido1: '',
            apellido2:'',
            nif:'',
            telefono:'',
            correo:'',
            titulacion:'',
        }),
        methods: {
            nuevo() {
                this.dialog = false;
                Axios.post('http://192.168.43.97:8080/p/profesores',{
                    nombre:this.nombre,
                    apellido1:this.apellido1,
                    apellido2:this.apellido2,
                    nif:this.nif,
                    telefono:this.telefono,
                    correo:this.correo,
                    titulacion:this.titulacion
                }).then(response => {
                   // console.log(response);

                }).catch(e => {
                    console.log(e)

                });

            },
        }
    }
</script>

<style scoped>

</style>
