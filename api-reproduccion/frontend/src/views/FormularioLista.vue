<template>
  <div class="container">
    <div class="form-wrapper">
      <h2 class="form-title">Agregar Lista de Reproducción</h2>
      <form @submit.prevent="submitForm" class="form">
        <div class="input-group">
          <label for="nombre">Nombre de la Lista:</label>
          <input v-model="lista.nombre" id="nombre" type="text" placeholder="Nombre de la lista" required />
        </div>
        <div class="input-group">
          <label for="descripcion">Descripción:</label>
          <input v-model="lista.descripcion" id="descripcion" type="text" placeholder="Descripción de la lista" required />
        </div>

        <div v-for="(cancion, index) in lista.canciones" :key="index" class="song-group">
          <h3>Canción {{ index + 1 }}</h3>
          <div class="input-group">
            <label for="titulo">Título:</label>
            <input v-model="cancion.titulo" id="titulo" type="text" placeholder="Título de la canción" required />
          </div>
          <div class="input-group">
            <label for="artista">Artista:</label>
            <input v-model="cancion.artista" id="artista" type="text" placeholder="Artista" required />
          </div>
          <div class="input-group">
            <label for="album">Álbum:</label>
            <input v-model="cancion.album" id="album" type="text" placeholder="Álbum" required />
          </div>
          <div class="input-group">
            <label for="anno">Año:</label>
            <input v-model="cancion.anno" id="anno" type="text" placeholder="Año de lanzamiento" required />
          </div>
          <div class="input-group">
            <label for="genero">Género:</label>
            <input v-model="cancion.genero" id="genero" type="text" placeholder="Género" required />
          </div>
        </div>

        <div class="form-actions">
          <button type="button" @click="addCancion" class="btn secondary">Agregar Canción</button>
          <button type="submit" class="btn primary">Guardar Lista</button>
        </div>
      </form>

      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <p v-if="successMessage" class="success">{{ successMessage }}</p>

      <button @click="goToAgregarCancion" class="btn navigate">Ir a Agregar Canción</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      lista: {
        nombre: "",
        descripcion: "",
        canciones: [
          { titulo: "", artista: "", album: "", anno: "", genero: "" }
        ]
      },
      errorMessage: "",
      successMessage: ""
    };
  },
  methods: {
    submitForm() {
      // Mostrar el objeto lista en una ventana emergente (alert)
      //alert("Lista de reproducción que se enviará:\n" + JSON.stringify(this.lista, null, 2));

      axios
        .post("http://localhost:8080/api/lists", this.lista, {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then((response) => {
          this.successMessage = "Lista de reproducción agregada con éxito.";
          this.errorMessage = "";
        })
        .catch((error) => {
          this.errorMessage = "Hubo un error al agregar la lista de reproducción.";
          this.successMessage = "";
        });
    },
    addCancion() {
      this.lista.canciones.push({ titulo: "", artista: "", album: "", anno: "", genero: "" });
    },
    goToAgregarCancion() {
      this.$router.push('/formulario');
    }
  }
};
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

.song-group h3 {
  font-size: 18px;
  margin-bottom: 10px;
  color: #555;
}

.form-actions {
  display: flex;
  justify-content: space-between;
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

button.secondary {
  background-color: #007BFF;
  color: white;
}

button.secondary:hover {
  background-color: #0056b3;
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
