# Diseño de Arquitecturas de Grandes Sistemas Software. Ejercicios prácticos de diseño

En este repositorio se encuentran varios proyectos que constituyen enunciados de ejercicios prácticos de diseño detallado de software, cuyo objetivo es que el alumno practique codificando soluciones de diseño que aplican principios y patrones de diseño clásicos, concretamente los principios SOLID y los patrones de diseño GoF (Gang of Four).

Concretamente, el repositorio contiene varios proyectos Java (Maven), que el alumno debe descargar mediante un clonado de este repositorio y crear sus soluciones haciendo commit para poder trabajar tanto en el laboratorio como en casa.

## Entorno de trabajo

Para realizar los ejercicios necesitas:

- **JDK 21**.
- **Visual Studio Code** con la extensión [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).

Abre en VSCode la **carpeta raíz** del repositorio clonado (*File → Open Folder…*), **no** la carpeta de cada ejercicio. Así VSCode detecta todos los proyectos Maven del repositorio y los muestra en la misma ventana.

## Ejercicios

- [1. SOLID](1_SOLID/README.md)
- [2. Patrones de diseño GoF (I)](2_GOF/README.md)
- [3. Patrones de diseño GoF (II)](3_GOF/README.md)

## Trabajo con Git y GitHub

Para trabajar con el repositorio se deberá:

### Crear repositorio en GitHub y clonar al PC local


1. Crear, si no se dispone de ella, una cuenta en [GitHub](https://github.com).

2. Crear en GitHub un repositorio PRIVADO vacío con nombre "dagss-practicas-patrones". Debe quedar **totalmente vacío**: no marcar "Add a README", ni añadir `.gitignore` ni licencia (si tiene contenido inicial, el primer `git pull` del profesor fallará por *historias no relacionadas*). Anotar la URL (ejemplo: https://github.com/pepeperez/dagss-practicas-patrones).

Ahora, en el PC o PCs, donde se vaya a trabajar:

1. Instalar el [cliente de git](https://git-scm.com) para trabajar en consola.

2. Clonar el repositorio vacío, por ejemplo (**modificar "pepeperez" por el usuario de GitHub**):

```bash
git clone https://github.com/pepeperez/dagss-practicas-patrones
cd dagss-practicas-patrones
```
3. Añadir el repositorio remoto donde el profesor sube y actualiza enunciados:
```bash
git remote add profesor https://github.com/DAGSS-ESEI/practicas-patrones.git
```
4. Traer los enunciados iniciales del repositorio del profesor:
```bash
git pull profesor main --no-rebase --no-edit
```

### Trabajo diario

Cada vez que se trabaje en los ejercicios, y **con frecuencia**, se debe hacer **commit** y **push** a tu repositorio en GitHub. Por ejemplo:

```bash
git add .
git commit -m "Introducida una interfaz y su implementación"
git push -u origin HEAD # el -u es sólo necesario la primera vez; HEAD empuja la rama actual (main o master)
```

### Cuando el profesor publica nuevos ejercicios
En este caso es necesario traer los cambios del repositorio "profesor" y mezclarlos tras el último commit que tenemos.

1. No tener cambios locales sin commitear (*workspace limpio*)

2. Traer los nuevos enunciados/cambios que el profesor haya hecho.
```bash
git pull profesor main --no-rebase --no-edit
```
