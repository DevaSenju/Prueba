<template>
  <div class="container">
    <div class="form-wrapper">
      <h2 class="form-title">Agregar Canción</h2>
      <form @submit.prevent="submitForm" class="form">
        <div class="input-group">
          <label for="titulo">Título:</label>
          <input type="text" id="titulo" v-model="cancion.titulo" placeholder="Título de la canción" required />
        </div>

        <div class="input-group">
          <label for="artista">Artista:</label>
          <input type="text" id="artista" v-model="cancion.artista" placeholder="Artista" required />
        </div>

        <div class="input-group">
          <label for="album">Álbum:</label>
          <input type="text" id="album" v-model="cancion.album" placeholder="Álbum" required />
        </div>

        <div class="input-group">
          <label for="anno">Año:</label>
          <input type="text" id="anno" v-model="cancion.anno" placeholder="Año de lanzamiento" required />
        </div>

        <div class="input-group">
          <label for="genero">Género:</label>
          <input type="text" id="genero" v-model="cancion.genero" placeholder="Género" required />
        </div>

        <div class="form-actions">
          <button type="submit" class="btn primary">Agregar Canción</button>
        </div>
      </form>

      <button @click="goToLista" class="btn navigate">Ir a Agregar Lista</button>

      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <p v-if="successMessage" class="success">{{ successMessage }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const router = useRouter()

const cancion = ref({
  titulo: '',
  artista: '',
  album: '',
  anno: '',
  genero: ''
})

const errorMessage = ref('')
const successMessage = ref('')

const submitForm = async () => {
  try {
    // Hacemos la petición POST a la API para agregar la canción
    await axios.post('http://localhost:8080/api/canciones', cancion.value)
    successMessage.value = 'Canción agregada exitosamente'
    errorMessage.value = ''
    // Limpiar los campos después de enviar el formulario
    cancion.value = { titulo: '', artista: '', album: '', anno: '', genero: '' }
  } catch (error) {
    errorMessage.value = 'Hubo un error al agregar la canción'
    successMessage.value = ''
  }
}

// Función para redirigir al formulario de listas
const goToLista = () => {
  router.push('/formulario-lista') // Redirige a la ruta '/formulario-lista'
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Arial', sans-serif;
  background-color: #f7f7f7;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  padding: 20px;
}

.form-wrapper {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  padding: 40px;
  max-width: 500px;
  width: 100%;
}

.form-title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
  text-align: center;
}

.form {
  display: flex;
  flex-direction: column;
}

.input-group {
  margin-bottom: 15px;
}

.input-group label {
  font-size: 14px;
  color: #555;
  margin-bottom: 5px;
  display: block;
}

.input-group input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #f4f4f4;
}

.input-group input:focus {
  border-color: #4CAF50;
  background-color: #fff;
  outline: none;
}

.form-actions {
  display: flex;
  justify-content: center;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button.primary {
  background-color: #4CAF50;
  color: white;
}

button.primary:hover {
  background-color: #45a049;
}

button.navigate {
  background-color: #f0f0f0;
  color: #007BFF;
  width: 100%;
  margin-top: 20px;
}

button.navigate:hover {
  background-color: #d9d9d9;
}

.error {
  color: red;
  text-align: center;
  margin-top: 20px;
}

.success {
  color: green;
  text-align: center;
  margin-top: 20px;
}

/* Responsive design */
@media (max-width: 768px) {
  .form-wrapper {
    padding: 20px;
  }

  .form-title {
    font-size: 20px;
  }

  .input-group input {
    font-size: 14px;
  }

  button {
    font-size: 14px;
  }
}

@media (max-width: 480px) {
  .container {
    padding: 10px;
  }

  .form-wrapper {
    padding: 15px;
  }

  .form-title {
    font-size: 18px;
  }

  .input-group input {
    font-size: 12px;
  }

  button {
    font-size: 12px;
  }
}
</style>
