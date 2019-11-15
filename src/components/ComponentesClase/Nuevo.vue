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
                    <span class="headline">Nueva Clase</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12">
                                <v-select
                                        :items="[0,17,18,29,30,54]"
                                        label="curso*"
                                        required
                                ></v-select>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        :items="[0,17,18,29,30,54]"
                                        label="asignatura*"
                                        required
                                ></v-select>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        :items="[0,17,18,29,30,54]"
                                        label="profesor*"
                                        required
                                ></v-select>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        :items="[0,17,18,29,30,54]"
                                        label="tarifa*"
                                        required
                                ></v-select>
                            </v-col>
                            <template>
                                <v-row>
                                    <v-col>
                                        <v-sheet height="400">
                                            <v-calendar
                                                    ref="calendar"
                                                    :now="today"
                                                    :value="today"
                                                    :events="events"
                                                    color="primary"
                                                    type="week"
                                            >
                                                <!-- the events at the top (all-day) -->
                                                <template v-slot:day-header="{ date }">
                                                    <template v-for="event in eventsMap[date]">
                                                        <!-- all day events don't have time -->
                                                        <div
                                                                v-if="!event.time"
                                                                :key="event.title"
                                                                class="my-event"
                                                                @click="open(event)"
                                                                v-html="event.title"
                                                        ></div>
                                                    </template>
                                                </template>
                                                <!-- the events at the bottom (timed) -->
                                                <template v-slot:day-body="{ date, timeToY, minutesToPixels }">
                                                    <template v-for="event in eventsMap[date]">
                                                        <!-- timed events -->
                                                        <div
                                                                v-if="event.time"
                                                                :key="event.title"
                                                                :style="{ top: timeToY(event.time) + 'px', height: minutesToPixels(event.duration) + 'px' }"
                                                                class="my-event with-time"
                                                                @click="open(event)"
                                                                v-html="event.title"
                                                        ></div>
                                                    </template>
                                                </template>
                                            </v-calendar>
                                        </v-sheet>
                                    </v-col>
                                </v-row>
                            </template>

                        </v-row>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <div class="flex-grow-1"></div>
                    <v-btn color="primary" text @click="dialog = false">Cancelar</v-btn>
                    <v-btn color="primary" text @click="dialog = false">Crear</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>

</template>

<script>
    export default {
        name: "Nuevo",
        data: () => ({
            dialog: false,
            today: '2019-01-08',
            events: [
                {
                    name: 'Wekly Meeting',
                    start: '2019-01-07 09:00',
                    end: '2019-01-07 10:00',
                },
                {
                    name: 'Thomas\' Birthday',
                    start: '2019-01-10',
                },
                {
                    name: 'Mash Potatoes',
                    start: '2019-01-09 12:30',
                    end: '2019-01-09 15:30',
                },
            ],
        }),
        mounted () {
            this.$refs.calendar.scrollToTime('08:00')
        },
    }



</script>

    <style scoped>
    .my-event {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        border-radius: 2px;
        background-color: #1867c0;
        color: #ffffff;
        border: 1px solid #1867c0;
        font-size: 12px;
        padding: 3px;
        cursor: pointer;
        margin-bottom: 1px;
        left: 4px;
        margin-right: 8px;
        position: relative;
    }

    .my-event.with-time {
        position: absolute;
        right: 4px;
        margin-right: 0px;
    }
    </style>
