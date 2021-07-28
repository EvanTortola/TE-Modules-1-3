<template>
  <div class="book-container">
    <book-card class="book" v-for="book in allBooks" 
    v-bind:key="book.title" 
    v-bind:book="book"></book-card>
    

  </div>
</template>

<script>


import BookCard from "./BookCard"

export default {
    components: { BookCard },
    name: 'reading-list',
    computed: {
      allBooks() {
        return this.$store.state.books;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>