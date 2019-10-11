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
                                <v-toolbar-title>Login form</v-toolbar-title>
                                <div class="flex-grow-1"></div>


                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field
                                            label="Login"
                                            name="login"
                                            prepend-icon="mdi-account"
                                            type="text"
                                    ></v-text-field>

                                    <v-text-field
                                            id="password"
                                            label="Password"
                                            name="password"
                                            prepend-icon="mdi-lock"
                                            type="password"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <div class="flex-grow-1"></div>
                                <v-btn color="primary" v-on:click="inicio">Login</v-btn>
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
            </v-container>
        </v-content>
    </v-app>
</template>
<script>
    import NavBar from "../components/core/NavBar";

    export default {
        name: "Login",
        props: {
            source: String,
        },
        data: () => ({
            drawer: null,
            dialog: true
        }),
        comments: {
            barra: NavBar
        },
        methods: {
            inicio: function (event) {
                this.$router.replace('/inicio');
            }
        }
    }
</script>

<style scoped>

</style>