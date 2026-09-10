# Diseño de Arquitecturas de Grandes Sistemas Software. Ejercicios prácticos de diseño

En este repositorio se encuentran varios proyectos que constituyen enunciados de ejercicios prácticos de diseño detallado de software, cuyo objetivo es que el alumno practique codificando soluciones de diseño que aplican principios y patrones de diseño clásicos, concreatamente los principios SOLID y los patrones de diseño GoF (Gang of Four).

Concretamente, el repositorio contiene varios proyecto Java (Maven), que el alumno debe desacargar mediante un clonado de este repositorio y crear sus soluciones y haciendo commit para poder trabajar tanto en el laboratorio como en casa.

## Ejercicios

- [1. SOLID](1_SOLID/README.md)

## Trabajo con Git y GitHub

Para trabajar con el respositorio se deberá:

### Crear repositorio en GitHub y clonar al PC local


1. Crear, si no se dispone de ella, una cuenta en [GitHub](https://github.com).

2. Crear en GitHub un repositorio PRIVADO vacío con nombre "dagss-practicas-patrones". Anotar la URL (ejemplo: https://github.com/pepeperez/dagss-practicas-patrones).

Ahora, en el PC o PCs, donde se vaya a trabajar:

1. Instalar el [cliente de git](https://git-scm.com) para trabajar en consola.

2. Clonar el respositorio vacío, por ejemplo (**modificar "pepeperez" por el usuario de GitHub**):

```bash
git clone https://github.com/pepeperez/dagss-practicas-patrones
cd ejercicios-dagss
```
3. Añadir el repositorio remoto donde el profesor sube y actualiza enunciados:
```bash
git remote add profesor https://github.com/DAGSS-ESEI/practicas-patrones.git
```

### Trabajo diario

Cada vez que se trabaje en los ejercicios, y **con frecuencia**, se debe hacer **commit** y **push** a tu repositorio en GitHub. Por ejemplo:

```bash
git add .
git commit -m "Introducida una interfaz y su implementación"
git push -u origin main # el -u es sólo necesario la primera vez
```

### Cuando el profesor publica nuevos ejercicios
En este caso es necesario traer los cambios del repositorio "profesor" y mezclarlos tras el último commit que tenemos.

1. No tener cambios locales sin commitear (*workspace limpio*)

2. Traer los nuevos enunciados/cambios que el profesor haya hecho.
```bash
git pull profesor main --no-rebase --no-edit
```
