<template>
    <v-app>

        <v-content>
            <NavBar/>
            <div class="row ">
                <div class="col-10 text-truncate mx-auto">
                    <h1>Inicio</h1>
                    <v-divider></v-divider>
                    <p class="text-left">Bienvenido a la herramienta de gestion de sophistas academia</p>
                </div>
            </div>
            <div class="row ">
                <div class="col-9 text-truncate mx-auto">
                    <h2>La academia en numeros</h2>
                    <v-divider></v-divider>
                </div>
            </div>
            <div class="col-9 text-truncate mx-auto">
                <v-row>

                    <Etapas/>
                    <AltasYBajas/>

                </v-row>
            </div>

            <Footer/>
        </v-content>
    </v-app>


</template>

<script>
    import NavBar from '../components/core/NavBar';
    import AltasYBajas from "../components/Graficas/AltasYBajas";
    import Etapas from "../components/Graficas/Etapas";
    import Footer from "../components/core/Footer";

    export default {
        name: "Inicio",
        components: {
            NavBar, Etapas, AltasYBajas, Footer

        }
    }
</script>

<style scoped>

</style>
