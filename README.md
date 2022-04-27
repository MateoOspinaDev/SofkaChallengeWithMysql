# Sofka Challenge
### CONCURSO DE PREGUNTAS Y RESPUESTAS

El proyecto es el desarrollo del challenge de Sofka U para ingresar a la training league de desarrollo de software.
### Pasos para su ejecución

- Descargar el proyecto completo desde este repositorio como lo muestra la imagen:
 ![image](https://user-images.githubusercontent.com/98233607/165594775-796d7bce-b2f5-4c2a-a129-031b7c3e50d9.png)
- Como el proyecto se ejecuta por consola, debe abrirlo con un entorno desarrollo (preferiblemente IntelliJ IDEA).
- Importar y ejecutar el archivo "puntaje.sql" en un gestor de bases de datos como MySQL Workbench o phpMyAdmin.
- Modificar el archivo "config.properties con los datos de su entorno de ejecución. (Si ejecuta lo anterior sin hacer modificaciones, la propiedad "dbName" no deberá ser modificada)
- Ejectutar el metodo main del proyecto.
> Nota: Si no se realiza la correcta creación y conexión a la base de datos, la lógica del programa se ejectutará, pero el puntaje, lógicamente,  no se guardará .  

### Cumplimiento de las funcionalidades requeridas
**1) Configurar Juego**: El juego consta de 5 categorias con un nivel de dificultad especifico, cada categoria tiene 5 preguntas y cada pregunta tiene 5 opciones y entre ellas una es la correcta.

**Las categorias se dividen de la siguiente forma:** 

| Categoria | Nivel |
| ------ | ------ |
| Matemáticas básicas | 1 |
| Geografía básica | 2 |
| Historia básica | 3 |
| Informática básica | 4 |
| Programación básica | 5 |

**2) Iniciar el juego**: El juego se inicia cuando el programa se ejecuta. El usuario tiene la opci+on d eempezar a juar o ver el historico de los resultados. Si elije jugar, el programa escogerá una pregunta aleatoria de la categoría del primer nivel.

**3) Responder a la pregunta**: El usuario puede elegir la respuesta entre 5 opciones disponibles para cada pregunta.

**4) Aumentar de nivel**: Cada vez que el usuario responda bien una pregunta avanzará a la siguiente ronda donde se encontrará con una pregunta de una categoría de mayor dificultad.

**5) Acumular premio**: Cada vez que el usuario responda bien una pregunta obtendrá un punto y sabrá cuál es su puntaje en el momento. 

**6) Fin del juego voluntario o ganara ronda final**:En cada pregunta el usuario tendrá la oportunidad de retirarse del juego y conservar su puntaje o tratar de ganar hasta la ultima ronda donde obtendrá el máximo puntaje y se terminará el juego. 

**7) Fin del juego forzado**: si el usuario responde una pregunta de forma incorrecta, su puntaje será cero y el programa terminará.

**8) Persistencia de datos**:En el caso en que el usuario finalice exitosamente todo el juego, se retire antes de terminar o responda de forma incorrecta se realizará la persistencia de sus atos con el puntaje correspondiente.


