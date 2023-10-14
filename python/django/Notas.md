# Notas

Django: El framework web mas popular de Python. Es gratis y Open Source.

- Es el más veloz
- Es seguro
- Es escalable

## Instalacion

<code>
pip install django
</code>

## Crear un proyecto

<code>
django-admin startproject mysite
</code>

## Archivos

[Resumen](https://static.platzi.com/media/user_upload/django%202022-01-20%20000754-c598777a-306b-4aa3-8305-167f46bbc07f.jpg)

- manage.py: Es un archivo que ayuda a interactuar con el proyecto.

  - Tiene comandos para correr el servidor, crear apps, etc.

- asgi.py: Es un archivo que ayuda a desplegar el proyecto en un servidor.
- wsgi.py: Es un archivo que ayuda a desplegar el proyecto en un servidor.

- settings.py: Es un archivo que contiene la configuracion del proyecto.

  - Contiene la configuracion de la base de datos, el lenguaje, el timezone, etc.

- urls.py: Es un archivo que contiene las urls del proyecto.

## Servidor de desarrollo

- Siempre trabajaremos en local
- Django nos provee un servidor de desarrollo

- Para correr el servidor de desarrollo usamos el comando:
  <code>
  python manage.py runserver 3000
  </code>

"You have 18 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions. Run 'python manage.py migrate' to apply them."

- No tenemos las tablas necesarias en la base de datos

"using settings 'premios_platzi_app.settings'": Usando la configuracion de premios_platzi_app

## Premios Platzi App

(Conceptos) Django:

- Proyectos: Conjunto de configuraciones y aplicaciones para un sitio en particular.
- Apps: Componentes de un proyecto. Son reutilizables en otros proyectos.

- Instagram: Proyecto

  - Feed: App
  - Stories: App
  - DM: App
  - Perfil: App
  - Buscar: App

- Premios Platzi App: Proyecto
  - Polls (Encuestas): App
  - Votaciones: App
  - Resultados: App

## Comandos

- Crear una app:
  <code>
  python manage.py startapp polls
  </code>

- Views: Sirve para crear vistas dentro de nuestra app

### Agregar una ruta

- urls.py: premios_platzi_app
  - Agregar una ruta:
    <code>
    path('polls/', include('polls.urls'))
    </code>
    El include debo importarlo desde django.urls
- urls.py: polls
  - Agregar una ruta:
    <code>
    path('', views.index, name='index')
    </code>
    El views debo importarlo desde . import views
    . significa que importe desde el mismo directorio

## settings.py

- DATABASES: Configuracion de la base de datos
  - ENGINE: Tipo de base de datos
    - django.db.backends.sqlite3: Base de datos por defecto
    - django.db.backends.postgresql: Base de datos de postgres
    - django.db.backends.mysql: Base de datos de mysql
    - django.db.backends.oracle: Base de datos de oracle
  - NAME: Nombre de la base de datos
    - BASE_DIR: Es una variable que contiene la ruta del proyecto
  - USER: Usuario de la base de datos
  - PASSWORD: Contraseña de la base de datos
  - HOST: Host de la base de datos
  - PORT: Puerto de la base de datos
- TIME_ZONE: Zona horaria

  - UTC: Tiempo universal coordinado
  - 'America/Argentina/Buenos_Aires': Hora de Argentina

- INSTALLED_APPS = [
  'django.contrib.admin', -> Admin de datos Django
  'django.contrib.auth', -> Autenticacion de Django
  'django.contrib.contenttypes', -> Formatos de archivos de Django
  'django.contrib.sessions', -> Sesiones de usuarios de Django
  'django.contrib.messages', -> Comunicaciones entre usuarios de Django
  'django.contrib.staticfiles', -> Archivos estaticos de Django
  ]

# ORM

**ORM**: Object Relational Mapping (Mapeador Objeto Relacional)
Nos permite interactuar con la base de datos a traves de objetos.

- Tabla → Clase
- Columnas → Atributos

## Migraciones

Migraciones: Son archivos que Django crea para poder interactuar con la base de datos.

<code>
python manage.py makemigrations <app> → Crea las migraciones de la app 
</code>

<code>
python manage.py migrate → Aplica las migraciones
</code>

# Consola interactiva de Django

<code>
python manage.py shell → Abre la consola interactiva de Django
</code>

## Object

<code>
from polls.models import Question, Choice → Importo los modelos
Question.objects.all() → Trae todos los objetos de la tabla Question
from django.utils import timezone → Sirve para crear objetos de tipo datetime
q = Question(question_text="What's new?", pub_date=timezone.now()) → Creo un objeto de tipo Question
q.save() → Guardo el objeto en la base de datos
</code>

# El método **str**

El método \_\_st\_\_ nos permite definir como se va a mostrar un objeto en la consola interactiva de Django.

Chequeamos si la fecha es mayor a 1 dia
<code>
return self.pub_date >= timezone.now() - datetime.timedelta(days=1)
</code>

# Filtrando objetos desde la shell

- Crear datos en una sola linea
  <code>
  Question(question_text="¿Quién es el mejor profesor de Platzi?", pub_date=timezone.now()).save()
  </code>

- Limpiar la consola interactiva
  <code>
  import os
  os.system('cls')
  </code>

- Metodo get: Trae un solo objeto
  <code>
  Question.objects.get(pk=1) → Trae el objeto con id 1
  </code>

- Errores
  - DoesNotExist: El objeto no existe
  - MultipleObjectsReturned: Existen varios objetos y no se puede devolver uno solo

# Metodo filter

- ObjectSet → Conjunto de objetos

- Buscar objetos con un texto en particular
  <code>
  Question.objects.filter(question_text\_\_startswith='¿Cuál') → Trae los objetos que empiezan con "¿Cuál"
  </code>

# Accediento al conjunto de respuestas

La tabla que tiene muchos, dentro de django establece un conjunto dentro de la tabla que contiene un elemento.
Por ejemplo:

- Question: Tiene muchas respuestas → choice_set
- Choice: Tiene una pregunta

<code>
q.choice_set.all() → Trae todas las respuestas de la pregunta q
</code>

Crear respuesta a partir de la pregunta
<code>
q.choice_set.create(choice_text="El curso Básico de Python", votes=0)
q.choice_set.count()
</code>

Buscamos las respuestas cuya fecha de la pregunta sea este año
<code>
Choice.objects.filter(question\_\_pub_date\_\_year=timezone.now().year)
</code>

# Admin de Django

Mucho cuidado con el admin de Django, ya que es una herramienta muy poderosa. Siempre debemos tener cuidado con los permisos que le damos a los usuarios.

- Crear un superusuario
  <code>
  python manage.py createsuperuser
  </code>

- Datos que pide
  - Username: Nombre de usuario
  - Email address: Email
  - Password: Contraseña

Es importante exponer nuestros modelos en el archivo admin.py de nuestra app (en este caso polls)

<code>
from .models import Question, Choice

# Register your models here.

admin.site.register([ Question, Choice ])
</code>

# ¿Qué son las views o vistas?

- M → Model (Modelo)
- T → Template (Plantilla)
- V → View (Vista)

**Modelo**: Es la representacion de una tabla en la base de datos.
**Plantilla**: Es la representacion de la interfaz de usuario.
**Vista**: Es la logica que conecta al modelo con la plantilla.

- Aplicaciones Web
  - Frontend
    - HTML
    - CSS
    - JavaScript
  - Backend
    - Django
    - Flask
    - FastAPI

Django nos permite una aplicación web completa, ya que nos permite crear el frontend y el backend. También existe Django Rest Framework, que nos permite crear una API, donde nos permite crear solo el backend.

- Django Web App
  - Frontend
    - Templates
  - Backend
    - Views
      - Función → Function Based Views
      - Clase → Generic Views

# Creando vistas

Se crean en el archivo views.py
Views: Es la lógica que devuelve la respuesta (endopoints)

Se pueden declarar parametros en los endpoints de la siguiente manera
<code>
def detail(request, question_id):
return HttpResponse("You're looking at question %s." % question_id)
</code>

En urls.py:
<code>
path('<int:question_id>/', views.detail, name='detail'),
</code>

El int:question_id es un parametro que se le pasa a la funcion detail

# Templates de Django

Se crea esta carpetas en nuestra app

- templates
  - polls → Nombre de la app
    - index.html → Nombre del template

Django Template System: Es un sistema de plantillas que nos permite crear plantillas HTML con Python.

Se puede utilizar la lógica de python en los templates de la siguiente manera:
<code>
{% if latest_question_list %}

<ul>
{% for question in latest_question_list %}
<li><a href="{% url 'polls:detail' question.id %}">{{ question.question_text }}</a></li>
{% endfor %}
</ul>
{% else %}
<p>No polls are available.</p>
{% endif %}
</code>

Example config:

"emmet.includeLanguages": {
"django-html": "html"
}

# Creando el template del home

- render → Renderiza un template
  - request → Petición
  - template → Template
  - context → Contexto (variable)

<code>
return render(request, 'polls/index.html', context)
</code>

get_object_or_404: Nos permite traer un objeto o un error 404

# Utilizar url para evitar el hard coding

- {% url 'polls:detail' question.id %} → Trae la url de la app polls con el nombre detail y el id de la pregunta

# Formularios: lo básico

- csrf_token → Token de seguridad
- forloop.counter → Contador de un for

# Creando la vista vote

- request.POST → Trae los datos del formulario (acceder al body)
- HttpResponseRedirec → Redirecciona a una url (es buena practica redireccionar despues de un POST)
- reverse → Trae la url de la app con el nombre detail y el id de la pregunta. Es la forma de evitar el hard coding (parecido a url que usamos en el html)

<code>
return HttpResponseRedirect(reverse('polls:results', args=(question_id,)))
</code>

# Creando la vista results

- pluralize → Pluraliza una palabra

<code>
{{ choice.choice_text }}: {{ choice.votes }} vote{{ choice.votes|pluralize}}
</code>

# Generic Views

Generic Vews o Class Based Views: Son vistas que nos provee Django para no repetir código.
DRY → Don't Repeat Yourself
Las generic views nos permiten reutilizar código.

Ejemplo: la vista "detail" es igual a la vista "results"

- List view → Muestra una lista de objetos
- Login view → Muestra el formulario de login
- Logout view → Muestra el formulario de logout
- Create View → Muestra el formulario de creación
- Update View → Muestra el formulario de actualización
- Profile View → Muestra el perfil del usuario

# Implementando Generic Views

- template_name → Nombre del template
- context_object_name → Nombre del objeto que se va a pasar al template
- model → Modelo que se va a utilizar
- Question.objects.order_by("-pub_date")[:5] → Trae los ultimos 5 objetos de la tabla Question ordenados por fecha de publicación

¿Cuando usar Generic views ?

Usar solo si podemos seguir el patrón:

- Cargar de la base de datos
- Generar template
- Mostrarlo

Si en la lógica debemos implementar cosas más complejas hay que utilizar Function views.

[Todas las Generic Views]('https://ccbv.co.uk/projects/Django/4.2/django.contrib.auth.views/LoginView/')
