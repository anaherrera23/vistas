<template>
    <v-app>
        <v-content>

            <NavBar/>

            <Footer/>

        </v-content>
    </v-app>
</template>

<script>
    import NavBar from "../components/core/NavBar";
    import Footer from "../components/core/Footer";
    export default {

        name: "Mantenimiento_cursos",
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