<template>
    <div class="Movies">
<!--        <button @click="loadMovies"></button>-->
        <ul>
            <!-- index作为第二个参数，用以标识下标 -->
            <li v-for="(item) in movies" :key='item'>
                <Movie :director="item.director" :movie_name="item.movie_name" :main_actor="item.main_actor"></Movie>
            </li>
        </ul>
    </div>

</template>

<script>
    import Movie from "@/components/Movie";

    export default {
        name: "Movies",
        components: {Movie},
        data() {
            return {
                movies: []
            };
        },
        mounted: function () {
            this.loadMovies();
        },
        methods: {
            loadMovies() {
                let _this = this;
                this.getRequest("http://localhost:12345/movies").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.movies = resp.data;
                        // console.log(_this.movies);
                    }
                })
            }
        },
    }
</script>

<style scoped>
    ul {
        list-style-type: none;
        padding: 0;
    }
</style>
