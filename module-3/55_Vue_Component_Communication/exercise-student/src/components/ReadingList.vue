<template>
  <div class="book-container">
    <book-card></book-card>
    <book-card></book-card>
    <book-card></book-card>
    <book-card></book-card>

  </div>
</template>

<script>


import BookCard from "./BookCard"

export default {
    name: 'reading-list',
    components: {
      BookCard
    },
    
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>