## JNotes - Заметки на React + Redux, с бекэндом на Java (Spring Framework + PostgreSQL)


В разработке... 

---

Frontend на основе [react-redux-notes](https://github.com/scriptfuture/react-redux-notes)


### Описание REST-API

Все примеры запросов в виде:
```code
{METHOD} {URL}?{PARAMS}
```
Где
* {METHOD} - Метод запроса GET/POST/DELETE
* {URL} - Путь запроса
* {PARAMS} - Параметры запроса

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
* {page} - Номер страницы (Integer)

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

```Javascript
{
    "tag": {
        "id": 1,
        "name": "нефть"
    },
    "totalPages": 2,
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
        },
        {
            "id": 10,
            "title": "Сургутнефтегаз",
            "text": "Сургутнефтегаз Сургут Нефть и газ 1 006 млрд р.",
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

#### Получить выборку по id тега и номуру страницы
```code
GET /api/notes/tag?page={page}&tag={tag}
```

Параметры
* {page} - Номер страницы (Integer)
* {tag} - Номер тега (Integer)

```Javascript
{
    "tag": {
        "id": 1,
        "name": "нефть"
    },
    "totalPages": 2,
    "notes": [

        {
            "id": 14,
            "title": "Транснефть",
            "text": "Транснефть Москва Нефть и газ 818 млрд р.",
            "tags": [{
                "id": 1,
                "name": "нефть"
            }, {
                "id": 2,
                "name": "газ"
            }]
        },
        {
            "id": 18,
            "title": "Татнефть",
            "text": "Татнефть Альметьевск Нефть и газ 580 млрд р.",
            "tags": [{
                "id": 1,
                "name": "нефть"
            }, {
                "id": 2,
                "name": "газ"
            }]
        },
        {
            "id": 20,
            "title": "НОВАТЭК",
            "text": "НОВАТЭК Москва Нефть и газ 537 млрд р.",
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

#### Получить список тегов
```code
GET /api/tags
```

```Javascript
{
    "tags": [{
            "id": 1,
            "name": "нефть"
        },
        {
            "id": 2,
            "name": "газ"
        },
        {
            "id": 3,
            "name": "финансы"
        },
        {
            "id": 4,
            "name": "транспорт"
        },
        {
            "id": 5,
            "name": "инвестиции"
        },
        {
            "id": 6,
            "name": "торговля"
        },
        {
            "id": 7,
            "name": "электроэнергетика"
        },
        {
            "id": 9,
            "name": "металлы"
        },
        {
            "id": 10,
            "name": "горная добыча"
        },
        {
            "id": 11,
            "name": "телекоммуникации"
        }
    ]
}
```

---

#### Получить заметку по id (Integer)
```code
GET /api/notes/one?id={id}
```

Параметры
* {id} - Номер заметки (Integer)

```Javascript
{
    "id": 8,
    "title": "Тестовый заголовок",
    "text": "Тестовое описание",
    "tags": [{
        "id": 1,
        "name": "нефть"
    }, {
        "id": 2,
        "name": "газ"
    }]
}
```

---

#### Создать заметку
```code
POST /api/notes/new?title={title}&text={text}&tags={tags}
```

Параметры
* {title} - Заголовок заметки (String)
* {text} - Текст заметки (String)
* {tags} - Теги (String)

```Javascript
{"msg": "ok"}
```

---

#### Редактировать заметку
```code
POST /api/notes/update?title={title}&text={text}&tags={tags}
```

Параметры
* {title} - Заголовок заметки (String)
* {text} - Текст заметки (String)
* {tags} - Теги (String)

```Javascript
{"msg": "ok"}
```

---

#### Удалить заметку
```code
DELETE /api/notes/delete?id={id}
```

Параметры
* {id} - Номер заметки (Integer)

```Javascript
{"msg": "ok"}
```








