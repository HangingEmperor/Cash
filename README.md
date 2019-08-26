# Simple Text Editor
Es un editor de texto que cumple sus funciones basicas como:
 <br>
 - Open: <i>Abrir un archivo de texto.</i>
 - Save: <i>Guarda un archivo y lo actualiza si ya estaba 
guardado.</i>
 - Save As: <i>Guarda un archivo las veces que desees con la 
extension deseada del archivo.</i>
 - Quit: <i>Salir del programa, si el archivo no se encuentra 
guardado, el programa preguntara al usuario si desea que 
se guarde, en caso de que ya este guardado el archivo y se
 hizo una modificacion pero no se guardo anteriormente, 
el programa no hara una pregunta si no que lo guardara
 automaticamente.</i>
<hr>
<h4> Funciones extra. </h4>
<p>El programa ademas de las funciones que incluye anteriormente
explicadas, tambien el editor nace con la idea de funcionar
como un interpretador en un lenguaje propio y exclusivo que
se ira realizando a lo largo del semestre, es decir, si se
codifica en el lenguaje adecuado, al pulsar el boton <i>Make</i>
va a dedicarse a interpretar el codigo escrito y hara un
archivo a lenguaje maquina, no sera un ejecutable, solo un
archivo traducido a lenguaje maquina.</p>

<hr>
<h3> Version 1.0 </h3>
La clase Depurate se dedica a eliminar todo comentario escrito
en el editor de texto, si se hace click en el boton <i>Make</i>
este creara un archivo <i>.pre</i> y eliminara todo lo que el
programa considere un comentario.
<hr>
<h3> Como codificar en Heavy</h3>
<h4> Version 1.0</h4>
Lenguaje de programacion con sintaxis de Rust pero con las 
librerias de Java.
<h5>Adds on</h5>
Heavy admite comentarios en linea y comentarios multinea, lo que no
esta admitido en Heavy son poner comentarios al final de una linea
de codigo, siempre se deben colocar al incio de la linea de codigo.
<br> <br>
Para comentario en linea: <br>
<code> // Esto es un comentario </code><br>
Par comentario en multilinea: <br>
<code>/* Esto <br>
        es un<br>
        comentario<br>
        multilinea<br>
        */
</code>