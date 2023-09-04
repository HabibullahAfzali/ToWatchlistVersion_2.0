<script setup>
  import MovieCard from '../components/MovieCard.vue';
  import InputForm from '../components/InputForm.vue';
</script>
<template>
  <div class="main-container">
    <div class="header-container">
      <header>
        <img alt="Vue logo" class="logo" src="@/assets/image/logo.svg"/>
      </header>
    </div>
    <div class="content-container">
      <InputForm/> 
    </div>
      <div class="movie-card-container">
        <MovieCard/>
      </div>
  </div>
</template>
<style scoped>
body {
  margin: 0;
  padding: 0;
  overflow-x: hidden;
}
.main-container {
  position:fixed;
  top:0;
  left: 12rem;
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: auto;
  padding: 1em;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  border-radius: 8px;
  overflow-y: auto;
}
.header-container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1em;
  border-bottom: 5px solid #ccc;
}
.content-container {
justify-content: space-between;

}
.movie-card-container {
  overflow-y: auto; /* Add vertical scrollbar when content overflows */
  max-height: 30vh;
}
.logo {
  width: 100%;
  height: 20vh;
   box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
  border-radius: 8px;
}
body{
  overflow: hidden;
}
</style>
