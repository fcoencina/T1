 
 <h1 align="center"><b> README Tarea1_ELO329  </b></h1>
<br>

Version Java 17

Archivos que componen la tarea hasta la etapa 4:
 Archivos de código:
- AePlayWave.java, Central.java, Door.java, MagneticSensor.java, , Makefile, PIR.java, Persona.java, Sensor.java, Siren.java, Stage4.java, State.java, SwitchState.java, Window.java, Zona.java,, siren.wav
 Archivos de pueba
- config.txt, output.csv

Compilación:
 Para la compilación está el Makefile.
 Ejecución del Makefile:
  - *make* para compilar y crear los archivos
  - *make run* parar correr el programa
  - Al ejecutar el programa usted podrá ingresar los siguientes comandos por teclado:
    - k <a | p | d> // acción sobre el teclado para a: armar todo (all), p: armar perímetro d: desarmar. Al setear un alarma, por ejemplo 'ka', y deseas cambiar de alarma a 'kp', primero se debe desarmar la alarma para hacerlo
    - di <o | c> // con i en 0..(#_doors-1), por ejemplo d0 es la puerta principal. o: open, c: close
    - wi <o | c> // con i en 0..(#_windows-1), o: open, c: close
    - c <x> <y> // así se crea una nueva persona en la ubicación indicada.
    - pi < w| s | d | a> // con I en 0..#person-1, cada flecha desplaza la persona en 0.5 [m] // en esa dirección (norte, sur, este, oeste).

 


Integrantes:
- Francisco Encina 202030536-6
- Maximiliano Pozo 201930536-0
- Matías Torres 202030537-4
- José Beltrán 202030548-k


