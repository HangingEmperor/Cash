# IDE for Cash
CashEditor es un editor de texto que cumple sus 
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

# Cash Script Language 
**_Cash es un lenguaje de programacion de tipo Script, que pretende
ser divertido a la hora de programar_** colocando ciertas referencias 
musicales al mundo del rock y country, entre otros que quiza
en un futuro decida añadir (No estoy seguro). Cash toma como 
base (O similitud) al lenguaje de **_Python_**; Aunque se que
 existe _**Jython**_, la idea es diseñar algo mas cercano a **_Java_** y 
 este elimine las cosas que en **_Java_** son algo
tediosas y pulirlo a que sea algo mas comodo de programar, ademas
de que realizare una investigacion sobre que letras deberian ser
acomodadas para poder programar mas rapido y eficiente, potenciando
el lado de distintas manos. Esto es un lenguaje de programacion
experimental, no pretende ponerce en el mercado Open Source o 
resultar en esencia util, es un proyecto personal ligado a una
investigacion relacionado a como codificar correctamente en el
teclado.

## Version 1.2
En esta nueva version se ha optado por cambiar el nombre y 
hacerlo algo mas divertido ademas de agregar ciertas referencias
a la musica.

### Funciones del lenguaje
#### Comentarios
Cash admite comentarios en linea y comentarios multinea.
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
>Para ver mas sobre la clase Comments:  
>[https://github.com/HangingEmperor/Cash/blob/master/src/cash_language/Comments](URL "Ver mas")

#### Variables
En Cash Scripting, las variables se declaran colocando al inicio
de la linea de codigo la instruccion **VAR** y despues el **TIPO** de
variable que se desea crear, y despues el **NOMBRE de la VARIABLE**, 
y despues el signo de asignacion **=** y su inicializacion con el valor
asignado acorde al tipo de variable indicado.  **_Es importante recalcar 
el hecho que todas las variables se deben inicializar,
no se puede crear una variable sin inicializarla._**
```[java]
VAR [TIPO DE VARIABLE] [NOMBRE DE VARIABLE] = [ASIGNACION]
```
##### Boolean
Las variables de tipo _booleano_ solo tienen dos tipos de inicializarse: **TRUE** o **FALSE**.
```[java]
VAR BOOLEAN boolean = TRUE
```
##### Enteros
Las variables de tipo entero solo
permite valores enteros, no permiten puntos o comas en la inicializacion, ademas
de que solo admite numeros.
```[java]
VAR INT integer = 10
```
##### Punto flotante
Las variables de tipo punto flotante solo
permite valores flotantes, permite puntos o comas en la inicializacion, solo se permite
agregar numeros en la inicializacion.
```[java]
VAR FLOAT float = 10.02
```
##### Caracter
Las variables de tipo caracter solo permiten **UN** valor acord al ASCII Americano.
```[java]
VAR CHAR character = 'J'
```
##### Cadena
Las variables de tipo cadenas solo **VALORES** permiten acordes al ASCII Americano.
```[java]
VAR STRING string = "Johnny Cash"
```
> Mas informacion sobre el ASCII Americano:  
> [http://www.columbia.edu/kermit/ascii.html](URL "Ver mas")
#### Operadores logicos
##### NOT
```[java]
IF ( NOT (x > 4) ) {
    // Si la condicion es verdadera, entonces se vuelve falsa.
}
```
##### OR
```[java]
IF ( x < 2 OR x > 4 ) {
    // Si alguno de los dos es verdadero, entonces es verdadero.
}
```
##### AND
```[java]
IF ( x < 2 AND x > 4 ) {
    // Si los dos son verdaderos, entonces es verdadero.
}
```

#### Impresiones
```[java]
PRINT("Hola")
```

#### Condiciones
##### Condicion Simple
```[java]
IF ( x > 3 ) {
    // Code
}
```
##### Condicion Sino
```[java]
IF ( x > 4 ) {
    // Code
} ELSE {
    // Code
}
```
##### Condicion Sino si
```[java]
IF ( x > 5 ) {
    // Code
} ELIF ( x < 2) {
    // Code
}
```

#### Excepciones
##### InvalidCharacterException
##### InvalidCommentaryException
##### InvalidQuotationMarkException
>Para ver mas sobre las clases Exceptions: 
>[https://github.com/HangingEmperor/Cash/tree/master/src/cash_language/Exceptions](URL "Ver mas")

#### Generar
Cash es un lenguaje que funciona como Script, por lo tanto no
pasa por un proceso de compilacion, si no de interpretado, asi
que se genera un archivo .cash, puede hacerse desde el boton
make del editor o simplemente generarse a aparte (En una futura
adicion por consola).
>Para ver mas sobre la clase Compiler:  
>[https://github.com/HangingEmperor/Cash/tree/master/src/cash_language/Compiler](URL "Ver mas")