# Manual git

[Libro] (http://git-scm.com/book/es/)

## Crea un repositorio nuevo

Crea un directorio nuevo, ábrelo y ejecuta :

	git init

para crear un nuevo repositorio de git.

## Hacer checkout a un repositorio

Crea una copia local del repositorio ejecutando

	git clone /path/to/repository
	
Si utilizas un servidor remoto, ejecuta

	git clone https://github.com/efrengarcial/oms.git

## Flujo de trabajo

Tu repositorio local esta compuesto por tres "árboles" administrados por git.
El primero es tu `Directorio de trabajo` que contiene los archivos, 
el segundo es el `Index (stage)` que actua como una zona intermedia, 
y el último es el `HEAD` que apunta al último commit realizado.

![](http://rogerdudler.github.io/git-guide/img/trees.png)

