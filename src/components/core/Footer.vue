<template>
    <v-footer padless  color="primary">
        <v-col
                class="text-center"
                cols="12"
                color="primary"
        >
            {{ new Date().getFullYear() }} — <strong>By: Ana Herrera Orozco</strong>
        </v-col>
    </v-footer>
</template>

<script>
    export default {
        name: "Footer"
    }
</script>

<style scoped>

</style>
