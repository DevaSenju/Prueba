<template>
  <div>
    <h1>Bienvenido al sistema de reproducción</h1>
    <p>¿Qué te gustaría hacer?</p>
    <button @click="goToFormulario">Agregar Canción</button>
    <button @click="goToFormularioLista">Agregar Lista de Reproducción</button>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  methods: {
    goToFormularioCancion() {
      this.$router.push("/formulario");
    },
    goToFormularioLista() {
      this.$router.push("/formulario-lista");
    }
  }
}
</script>
