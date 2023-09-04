<script setup>
import FilmDataService from '../services/FilmDataService';
import {reactive } from 'vue';
import {genres, whereToWatchOptions} from '../Options';

const film = reactive({
  id: null,
  title: "",
  date: "",
  genres: genres,
  selectedGenre: "",
  whereToWatchOptions: whereToWatchOptions,
  selectedWheretoWatch: "",
})

function saveFilm() {
  let data = {
    title: film.title,
    date: film.date,
    genre: film.selectedGenre,
    whereToWatch: film.selectedWheretoWatch
  };
    
  FilmDataService.create(data)
    .then(response => {
      film.id = response.data.id;
      console.log(response.data);
    })
    .catch(e => {
      console.log(e);
    });
}

</script>

<template>
  <form >
    <div class="main-container">
    <div class="form-group ">
      <!-- <label for="title">Title:</label> -->
      <input type="text" class="form-control" id="title" placeholder="Title" v-model="film.title">
    </div>

    <div class="form-group">
      <!-- <label for="date">Date</label> -->
      <input type="text" class="form-control" id="date" placeholder="Year" v-model="film.date">
    </div>

    <div class="form-group">
    <!--  <label for="genre">Genre</label> -->
      <select class="form-control" id="genre" v-model="film.selectedGenre">
        <option value="" disabled>Select a genre</option>
        <option v-for="genre in film.genres" :value="genre" :key="genre">{{ genre }}</option>
      </select>
    </div>

    <div class="form-group">
      <!-- <label for="whereToWatch">Where to Watch</label> -->
      <select class="form-control" id="whereToWatch" v-model="film.selectedWheretoWatch">
        <option value="" disabled>Select an option</option>
        <option v-for="whereToWatch in film.whereToWatchOptions" :value="whereToWatch" :key="whereToWatch">{{ whereToWatch }}</option>
      </select>
    </div>
      
    <div class="d-flex justify-content-center mt-2">
      <button type="submit" class="btn btn-warning" @click="saveFilm"> Add movie </button>
    </div>
  </div>
  </form>
</template>


<style scoped>
.main-container {
  width: 50%;
  margin: auto;
  padding: 1em;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  border-radius: 8px;

}

input,
select {
  width: 100%;
  text-align: center;
  margin-bottom: 1rem;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 1em;
  margin: 2em;
  
}
</style>
