<template>

    <v-app id="inspire">
        <v-content>

            <div>
                <v-toolbar color="primary">
                    <v-toolbar-title><h1>Gestion</h1></v-toolbar-title>

                    <div class="flex-grow-1"></div>


                </v-toolbar>
            </div>
            <v-container
                    class="fill-height"
                    fluid
            >
                <v-row
                        align="center"
                        justify="center"
                >
                    <v-col
                            cols="12"
                            sm="8"
                            md="4"
                    >
                        <v-card class="elevation-12">
                            <v-toolbar
                                    color="primary"
                                    dark
                                    flat
                            >
                                <v-toolbar-title>Identificacion</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field
                                            label="Usuario"
                                            name="login"
                                            prepend-icon="mdi-account"
                                            type="text"
                                            v-model="username"
                                    ></v-text-field>

                                    <v-text-field
                                            id="password"
                                            label="Clave"
                                            name="password"
                                            prepend-icon="mdi-lock"
                                            type="password"
                                            v-model="pass"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <div class="flex-grow-1"></div>
                                <v-btn color="primary" v-on:click="login()">Entrar</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
                <template>
                    <div class="text-center">
                        <v-dialog
                                v-model="dialog"
                                width="500"
                        >
                            <!--
                            <template v-slot:activator="{ on }">
                                <v-btn
                                        color="red lighten-2"
                                        dark
                                        v-on="on"
                                >
                                    Click Me
                                </v-btn>
                            </template>
                            -->
                            <v-card>
                                <v-card-title
                                        class="headline grey lighten-2"
                                        primary-title
                                >
                                    ERROR
                                </v-card-title>

                                <v-card-text>
                                    credenciales invalidas, porfavor intente nuevamente.
                                </v-card-text>

                                <v-divider></v-divider>

                                <v-card-actions>
                                    <div class="flex-grow-1"></div>
                                    <v-btn
                                            color="primary"
                                            text
                                            @click="dialog = false"
                                    >
                                        I accept
                                    </v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </div>
                </template>
                <Dialogo titulo="ERROR" mensaje="credenciales invalidas, porfavor intente nuevamente." :show="dialog"/>
                <Footer/>
            </v-container>

        </v-content>
    </v-app>
</template>
<script>
    import NavBar from "../components/core/NavBar";
    import Dialogo from "../components/core/Dialogo";
    // import Axios from 'axios';
    import axios from "../AxiosConfig";
    import Footer from "../components/core/Footer";

    export default {
        name: "Login",
        props: {
            source: String,
        },
        data: () => ({
            drawer: null,
            dialog: false,
            username: '',
            pass: ''
        }),
        component: {
            NavBar, Dialogo, Footer
        },
        methods: {
            login() {

                axios.post('/auth/login', {user: this.username, password: this.pass})
                    .then(request => this.loginSuccessful(request))
                    .catch(() => this.loginFailed())
            },
            loginSuccessful(req) {
                if (!req.data.token) {
                    this.loginFailed();
                    return
                }
                this.error = false;
                localStorage.token = req.data.token;
                this.$router.replace(this.$route.query.redirect || '/inicio');
            },
            loginFailed() {
                this.error = 'Login failed!'
                delete localStorage.token
            }
        }
    }
</script>

<style scoped>

</style>
