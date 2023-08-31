<script setup>
  import MovieCard from '../components/MovieCard.vue';
  import InputForm from '../components/InputForm.vue';
</script>


<template>

  <header>
    <img alt="Vue logo" class="logo" src="@/assets/image/logo.svg"/>
  </header>
  
  
    <InputForm/>
    
    <MovieCard/> 
  

  

</template>


<style scoped>
header{
  display: flex;
  justify-content: center;
}
.logo{
  width: 100%;
  height: 30vh;
}

</style>
