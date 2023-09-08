<script setup>
import { ref, onMounted } from 'vue';
import FilmDataService from "../services/FilmDataService";
import { genres, whereToWatchOptions } from '../Options'
import { useRoute } from 'vue-router';
import '../assets/bg-colors.css';


const films = ref([]);
const filmId = ref(null);
const route = useRoute();

const getFilmById = async (id) => {
  try {
    const response = await FilmDataService.getFilmById(id);
    return response.data;
  } catch (error) {
    console.error(error);
  }
};

const getFilms = async () => {
  if (filmId.value) {
    const filmData = await getFilmById(filmId.value);
    if (filmData) {
      films.value.push(filmData);
    }
  }
};

const saveChanges = async (film) => {
  try {
    console.log('film.genre', film.genre)
    console.log('film.whereToWatch', film.whereToWatch)
    await FilmDataService.update(film.id, {
      title: film.title,
      date: film.date,
      genre: film.genre,
      whereToWatch: film.whereToWatch,
    });
    film.editing = false;
  } catch (error) {
    console.log('Error updating film:', error);
  }
};
const startEditing = (film) => {
  film.editing = true;
};

onMounted(() => {
  // Capture the filmId from the route parameter
  const id = route.params.id;
  if (id) {
    filmId.value = id;
    getFilms();
  }
});
</script>

<template>
  <div class="main-container">
    <div class="justify-content-start p-1">
      <RouterLink to="/">
        <button type="button" class="btn btn-dark">Go Back</button>
      </RouterLink>
    </div>
    <h2>Edit Film</h2>
    <div v-for="film in films" :key="film.id" class="card text-center w-80  m-3">
      <div class="card-header">{{ film.title }}</div>
      <div class="card-body">
        <p class="card-text" id="year">{{ film.date }}</p>
        <p class="card-text" id="genre">{{ film.genre }}</p>
        <p class="card-text" id="whereToWatch">{{ film.whereToWatch }}</p>
      </div>
      <div class="card-footer text-muted d-flex justify-content-evenly">
        <button v-if="!film.editing" class="btn btn-primary" @click="startEditing(film)">
          Edit
        </button>
        <button v-else class="btn btn-primary" @click="saveChanges(film)">
          Save
        </button>
      </div>

      <div v-if="film.editing" class="card-footer text-muted d-flex justify-content-evenly">
        <div class="edit-form">
          <input type="text" v-model="film.title" class="form-control">
          <input type="text" v-model="film.date" class="form-control">
          <select v-model="film.genre" class="form-control">
            <!-- Loop through genres and bind selected value to film.genre -->
            <option v-for="genre in genres" :value="genre" :key="genre">{{ genre }}</option>
          </select>
          <select v-model="film.whereToWatch" class="form-control">
            <!-- Loop through whereToWatchOptions and bind selected value to film.whereToWatch -->
            <option v-for="option in whereToWatchOptions" :value="option" :key="option">{{ option }}</option>
          </select>
        </div>
      </div>
    </div>
  </div>
</template>

  

<style scoped>
.main-container {
  top: 2;
  left: 12rem;
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: auto;
  padding: 1em;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  border-radius: 8px;
  overflow-y: auto;
  max-height: 90vh;
}

h2 {
  text-align: center;
  font-size: 3rem;
  color: bisque;
  text-shadow: 0 0 10px rgba(19, 16, 16, 0.99);
}

.card-header,
.card-footer {
  background-color: rgb(59, 59, 59);
  color: white;

}

.edit-form {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  gap: 16px;
  margin-bottom: 2rem;
}

input,
select {
  text-align: center;

}
</style>
  
  