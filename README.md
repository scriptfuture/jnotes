##JNotes - Заметки на React + Redux, с бекэндом на Java (Spring Framework + PostgreSQL)

###Описание REST-API

###Спсок заметок

Получить первую страницу списка заметок
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
        },
        {
            "id": 4,
            "title": "Сбербанк России",
            "text": "Сбербанк России Москва Финансы 3 059 млрд р.",
            "tags": [{
                "id": 3,
                "name": "финансы"
            }]
        },
        {
            "id": 5,
            "title": "Российские железные дороги",
            "text": "Российские железные дороги Москва Транспорт 2 133 млрд р.",
            "tags": [{
                "id": 4,
                "name": "транспорт"
            }]
        },
        {
            "id": 6,
            "title": "ВТБ",
            "text": "ВТБ Москва Финансы 1 320 млрд р.",
            "tags": [{
                "id": 3,
                "name": "финансы"
            }]
        },
        {
            "id": 7,
            "title": "Ростех",
            "text": "Ростех Москва Инвестиции 1 266 млрд р.",
            "tags": [{
                "id": 5,
                "name": "инвестиции"
            }]
        },
        {
            "id": 8,
            "title": "Магнит",
            "text": "Магнит Краснодар Торговля 1 075 млрд р.",
            "tags": [{
                "id": 6,
                "name": "торговля"
            }]
        },
        {
            "id": 9,
            "title": "X5 Retail Group",
            "text": "X5 Retail Group Москва Торговля 1 034 млрд р.",
            "tags": [{
                "id": 6,
                "name": "торговля"
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

Получить страницу списка заметок по номеру станицы
```code
GET /api/notes?page={page}
```

Параметры
{page} - Номер страницы (Integer)

---

Получить первую страницу по id тега
```code
GET /api/notes/tag?tag={tag}
```

Параметры
{tag} - Номер тега (Integer)

---

Получить выборку по id тега и номуру страницы
```code
GET /api/notes/tag?page={page}&tag={tag}
```

Параметры
{page} - Номер страницы (Integer)
{tag} - Номер тега (Integer)

---

Получить список тегов
```code
GET /api/tags
```

---

Получить заметку по id (Integer)
```code
GET /api/notes/one?id={id}
```

Параметры
{id} - Номер заметки (Integer)

---

Создать заметку
```code
POST /api/notes/new?title={title}&text={text}&tags={tags}
```

Параметры
{title} - Заголовок заметки (String)
{text} - Текст заметки (String)
{tags} - Теги (String)

---

Редактировать заметку
```code
POST /api/notes/update?title={title}&text={text}&tags={tags}
```

Параметры
{title} - Заголовок заметки (String)
{text} - Текст заметки (String)
{tags} - Теги (String)

---

Редактировать заметку
```code
DELETE /api/notes/delete?id={id}
```

Параметры
{id} - Номер заметки (Integer)








