# Tarea2
Esta API proporciona endpoints para gestionar libros, incluyendo la creación y búsqueda por ID.

## Modificaciones Recientes

### Repositorio en Memoria

Se ha cambiado el repositorio a una implementación en memoria utilizando una lista de libros en lugar de una base de datos JPA.

- **`LibroRepository`**: Ahora utiliza una lista en memoria para almacenar los libros y proporciona métodos para buscar y guardar libros.
  - `getLibro(int id)`: Busca un libro por su ID en la lista.
  - `nuevoLibro(Libro libro)`: Guarda un libro en la lista, generando un ID si es necesario.

### Servicio y Controlador Actualizados

Los servicios y el controlador han sido actualizados para trabajar con el repositorio en memoria y manejar las excepciones adecuadamente.

- **`LibroService`**: Implementa métodos para buscar y guardar libros utilizando el repositorio en memoria.
  - `getLibro(int id)`: Utiliza el repositorio para buscar un libro por su ID.
  - `nuevoLibro(Libro libro)`: Utiliza el repositorio para guardar un libro.
  
- **`LibroController`**: Maneja las solicitudes HTTP y lanza la excepción `LibroException` si no se encuentra el libro.
  - `GET /libros/{id_libro}`: Devuelve un libro por su ID si existe.
  - `POST /libros`: Crea un nuevo libro y devuelve el estado `CREATED`.
  - `LibroException`: Excepción personalizada para manejar el caso de libro no encontrado.

### Excepción Personalizada

Se ha creado una excepción personalizada `LibroException` para manejar el caso en que no se encuentre un libro con el ID proporcionado.

- **`LibroException`**: Clase de excepción que se lanza cuando un libro no es encontrado.
  - `LibroException(String message)`: Constructor que acepta un mensaje para personalizar el error.

### Modelo de Datos

Se ha definido una clase `Libro` que representa la estructura de un libro con sus atributos.

- **`Libro`**: Clase que representa un libro con campos como ID, título, autor, etc.

## Uso

Puedes utilizar los endpoints proporcionados para gestionar libros:

- `GET /libros/{id_libro}`: Busca un libro por su ID.
- ![image](https://github.com/TheArgod/Tarea2/assets/170276394/16f78e23-ba99-4ca4-983f-2171cfdc18e9)
- En caso de que no encuentre ningún libro
- ![image](https://github.com/TheArgod/Tarea2/assets/170276394/68b71559-fe2a-4af6-a860-ea5403de9b7e)

- `POST /libro`: Crea un nuevo libro.
- ![image](https://github.com/TheArgod/Tarea2/assets/170276394/b4563b32-14f8-481e-8a2d-e553056e117e)

## Ejecución Local

1. Clona el repositorio.
2. Configura el entorno y la base de datos si es necesario (no aplicable en este caso de repositorio en memoria).
3. Ejecuta la aplicación Spring Boot.
