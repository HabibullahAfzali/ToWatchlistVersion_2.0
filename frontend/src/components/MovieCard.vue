<script setup>
import { ref, onBeforeMount } from 'vue';
import FilmDataService from "../services/FilmDataService";
import { useRouter } from 'vue-router';
import { genreColors } from '../GenreColors';
import '../assets/bg-colors.css';


const router = useRouter();

function navigateToEdit(id) {
  router.push({ name: 'EditCard', params: { id } });
}

const films = ref([]);

const getFilms = async () => {
  try {
    const response = await FilmDataService.getAll();
    films.value = response.data;
    
  } catch (error) {
    console.log(error);
  }
};

const deleteMovie = async (id) => {
  try {
    await FilmDataService.delete(id);
    await getFilms();
  } catch (error) {
    console.log(error);
  }
};

onBeforeMount(getFilms);

</script>

<template>
    <div id="card-container">
        <div v-for="film in films" :key="film.id" class="card text-center w-85 m-3">
            <div class="card-header">
                {{ film.title }}
            </div>
            <div :class="['card-body', genreColors[film.genre]]">
                <p class="card-text" id="year">{{ film.date }}</p>
                <p class="card-text" id="genre">{{ film.genre }}</p>
                <p class="card-text" id="whereToWatch">{{ film.whereToWatch }}</p>
            </div>
            <div class="card-footer text-muted d-flex justify-content-evenly">
                <button class="btn btn-primary" @click="navigateToEdit(film.id)">Edit</button>
                <a href="#" class="btn btn-danger" v-if="!film.editing" @click="deleteMovie(film.id)">Delete</a>
            </div>
            <div v-if="film.editing" class="card-footer text-muted d-flex justify-content-evenly">
                <input type="text" v-model="film.title" class="form-control">
                <input type="text" v-model="film.date" class="form-control">
                <input type="text" v-model="film.genre" class="form-control">
                <input type="text" v-model="film.whereToWatch" class="form-control">
            </div>
        </div>
    </div>
</template>

<style scoped>
    
  #card-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }

  .card {
    width: 300px;
  }

  .card-header, .card-footer {
    background-color: rgb(59, 59, 59);
    color: white;
  }

  
  

</style>



