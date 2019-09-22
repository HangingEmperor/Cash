# IDE for Heavy
HeavyManage es un editor de texto que cumple sus 
funciones basicas como:

 - Open: Abrir un archivo de texto.
 - Save: Guarda un archivo y lo actualiza si ya estaba 
guardado.
 - Save As: Guarda un archivo las veces que desees con la 
extension deseada del archivo.
 - Quit: Salir del programa, si el archivo no se encuentra 
guardado, el programa preguntara al usuario si desea que 
se guarde, en caso de que ya este guardado el archivo y 
se hizo una modificacion pero no se guardo anteriormente, 
el programa no hara una pregunta si no que lo guardara
 automaticamente.

## Funciones extra
El programa ademas de las funciones que incluye anteriormente
explicadas, tambien el editor nace con la idea de funcionar
como un interpretador en un lenguaje propio y exclusivo que
se ira realizando a lo largo del semestre, es decir, si se
codifica en el lenguaje adecuado, al pulsar el boton Make
va a dedicarse a interpretar el codigo escrito y hara un
archivo a lenguaje maquina, no sera un ejecutable, solo un
archivo traducido a lenguaje maquina.

# Heavy Script Language 
## Version 1.1
En esta nueva version se han realizado modificacion grandes al
diseño planteado del lenguaje, pues ahora tendra un enfoque
mayormente hacia ser un lenguaje de programacion de tipo 
Scripting, tomando como base (O similitud) al lenguaje de 
Python, aunque se que existe Jython, la idea es diseñar algo
mas cercano a Java y este elimine las cosas que en Java son algo
tediosas y pulirlo a que sea algo mas comodo de programar, ademas
de que realizare una investigacion sobre que letras deberian ser
acomodadas para poder programar mas rapido y eficiente, potenciando
el lado de distintas manos. Esto es un lenguaje de programacion
experimental, no pretende ponerce en el mercado Open Source o 
resultar en esencia util, es un proyecto personal ligado a una
investigacion relacionado a como codificar correctamente en el
teclado.

### Funciones del lenguaje
#### Comentarios
Heavy admite comentarios en linea y comentarios multinea.
``` [java] 
// Esto es un comentario en linea

/* Esto es un
comentario multilinea */
```
Tambien es posible ponerlo entre las lineas del codigo (Aunque no
recomendaria este tipo de practica tan incomoda...).
```[java]
PRINT("Hola" /* Comentario aqui */)
VAR IN/* Comentario aqui */T X = 10 
```
Para ver mas sobre la clase Comments:  
[https://github.com/HangingEmperor/Heavy/blob/master/src/heavy_language/Comments/Depurate.java.](URL "Ver mas")

#### Excepciones

#### Compilacion
