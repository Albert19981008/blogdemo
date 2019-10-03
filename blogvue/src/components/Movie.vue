<template>
    <div class="Movie">
        <el-button @click="loadMovieRandom" type="primary"> 随机加载一部电影</el-button>
        <!--        <button @click="loadMovieRandom"></button>-->
        <h3>Movie </h3>
        <h4>{{movie_name}}</h4>
        <h5>{{director}}</h5>
        <h5>{{main_actor}}</h5>
    </div>

</template>

<script>

    export default {
        name: "Movie",
        data() {
            return {};
        },
        props: {
            movie_name: String,
            director: String,
            main_actor: String
        },
        methods: {
            loadMovieRandom() {
                let _this = this;
                this.getRequest("http://localhost:12345/movie/random").then(resp => {
                    if (resp && resp.status === 200) {
                        const data = resp.data;
                        _this.movie_name = data.movie_name;
                        _this.director = data.director;
                        _this.main_actor = data.main_actor;
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
