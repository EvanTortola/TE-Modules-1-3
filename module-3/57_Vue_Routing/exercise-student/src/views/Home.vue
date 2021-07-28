<template>
<div class="home">
    <h1>Home</h1>
    
 <new-releases-list />
<best-seller-list />
  
</div>

</template>

<script>
import NewReleasesList from "@/components/NewReleasesList.vue";
import BestSellerList from "@/components/BestSellerList.vue";


export default {
    components: {
        NewReleasesList,
        BestSellerLis
        
        
    }
        

}
</script>

<style>

</style>