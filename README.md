## JNotes - Заметки на React + Redux, с бекэндом на Java (Spring Framework + PostgreSQL)


### Описание REST-API



### Список заметок

#### Получить первую страницу списка заметок
```code
GET /api/notes
```

Пример ответа
```Javascript
{
    "totalPages": 3,

    "notes": [

        {
            "id": 1,
            "title": "ЛУКОЙЛ",
            "text": "ЛУКОЙЛ Москва Нефть и газ 4 744 млрд р.",
            "tags": [{
                "id": 1,
                "name": "нефть"
            }, {
                "id": 2,
                "name": "газ"
            }]
        },
        {
            "id": 2,
            "title": "Газпром",
            "text": "Газпром Москва Нефть и газ 5 966 млрд р.",
            "tags": [{
                "id": 1,
                "name": "нефть"
            }, {
                "id": 2,
                "name": "газ"
            }]
        },
        {
            "id": 3,
            "title": "Роснефть",
            "text": "Роснефть Москва Нефть и газ 4 134 млрд р.",
            "tags": [{
                "id": 1,
                "name": "нефть"
            }, {
                "id": 2,
                "name": "газ"
            }]
        }

    ]
}
```

---

#### Получить страницу списка заметок по номеру станицы
```code
GET /api/notes?page={page}
```

Параметры
{page} - Номер страницы (Integer)

Пример ответа
```Javascript
{
    "totalPages": 3,

    "notes": [

        {
            "id": 11,
            "title": "Россети",
            "text": "Россети Москва Электроэнергетика 904 млрд р.",
            "tags": [{
                "id": 7,
                "name": "электроэнергетика"
            }]
        },
        {
            "id": 12,
            "title": "Интер РАО",
            "text": "Интер РАО Москва Электроэнергетика 868 млрд р.",
            "tags": [{
                "id": 7,
                "name": "электроэнергетика"
            }]
        },
        {
            "id": 13,
            "title": "Росатом",
            "text": "Росатом Москва Атомная промышленность 865 млрд р.",
            "tags": [{
                "id": 8,
                "name": "атомная промышленность"
            }]
        }
        
    ]
}
```

---

#### Получить первую страницу по id тега
```code
GET /api/notes/tag?tag={tag}
```

Параметры
* {tag} - Номер тега (Integer)

---

#### Получить выборку по id тега и номуру страницы
```code
GET /api/notes/tag?page={page}&tag={tag}
```

Параметры
* {page} - Номер страницы (Integer)
* {tag} - Номер тега (Integer)

---

#### Получить список тегов
```code
GET /api/tags
```

---

#### Получить заметку по id (Integer)
```code
GET /api/notes/one?id={id}
```

Параметры
* {id} - Номер заметки (Integer)

---

#### Создать заметку
```code
POST /api/notes/new?title={title}&text={text}&tags={tags}
```

Параметры
* {title} - Заголовок заметки (String)
* {text} - Текст заметки (String)
* {tags} - Теги (String)

---

#### Редактировать заметку
```code
POST /api/notes/update?title={title}&text={text}&tags={tags}
```

Параметры
* {title} - Заголовок заметки (String)
* {text} - Текст заметки (String)
* {tags} - Теги (String)

---

#### Удалить заметку
```code
DELETE /api/notes/delete?id={id}
```

Параметры
* {id} - Номер заметки (Integer)








