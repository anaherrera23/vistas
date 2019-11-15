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
                    {{this.titulo}}
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

<script>
    export default {
        name: "Dialogo",
        props: {
            titulo: String,
            mensaje: String,
            show: Boolean

        },
        data: () => ({
            drawer: null,
            dialog: this.show
        }),
    }
</script>

<style scoped>

</style>