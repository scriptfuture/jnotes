PGDMP     8                    v            notes    10.5    10.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16384    notes    DATABASE     �   CREATE DATABASE notes WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE notes;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12278    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16387    notes    TABLE     z   CREATE TABLE public.notes (
    id integer NOT NULL,
    title character varying(255),
    text character varying(512)
);
    DROP TABLE public.notes;
       public         postgres    false    3            �            1259    16385    notes_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.notes_id_seq;
       public       postgres    false    197    3            �           0    0    notes_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.notes_id_seq OWNED BY public.notes.id;
            public       postgres    false    196            �            1259    16415    tag_note    TABLE     u   CREATE TABLE public.tag_note (
    tag_id integer NOT NULL,
    note_id integer NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.tag_note;
       public         postgres    false    3            �            1259    16418    tag_note_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tag_note_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tag_note_id_seq;
       public       postgres    false    3    200            �           0    0    tag_note_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.tag_note_id_seq OWNED BY public.tag_note.id;
            public       postgres    false    201            �            1259    16397    tags    TABLE     W   CREATE TABLE public.tags (
    name character varying(512),
    id integer NOT NULL
);
    DROP TABLE public.tags;
       public         postgres    false    3            �            1259    16403    tags_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tags_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.tags_id_seq;
       public       postgres    false    198    3            �           0    0    tags_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.tags_id_seq OWNED BY public.tags.id;
            public       postgres    false    199            �           2604    16390    notes id    DEFAULT     d   ALTER TABLE ONLY public.notes ALTER COLUMN id SET DEFAULT nextval('public.notes_id_seq'::regclass);
 7   ALTER TABLE public.notes ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            �           2604    16420    tag_note id    DEFAULT     j   ALTER TABLE ONLY public.tag_note ALTER COLUMN id SET DEFAULT nextval('public.tag_note_id_seq'::regclass);
 :   ALTER TABLE public.tag_note ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    200            �           2604    16405    tags id    DEFAULT     b   ALTER TABLE ONLY public.tags ALTER COLUMN id SET DEFAULT nextval('public.tags_id_seq'::regclass);
 6   ALTER TABLE public.tags ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198            y          0    16387    notes 
   TABLE DATA               0   COPY public.notes (id, title, text) FROM stdin;
    public       postgres    false    197   u       |          0    16415    tag_note 
   TABLE DATA               7   COPY public.tag_note (tag_id, note_id, id) FROM stdin;
    public       postgres    false    200   �       z          0    16397    tags 
   TABLE DATA               (   COPY public.tags (name, id) FROM stdin;
    public       postgres    false    198   �       �           0    0    notes_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.notes_id_seq', 4, true);
            public       postgres    false    196            �           0    0    tag_note_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.tag_note_id_seq', 6, true);
            public       postgres    false    201            �           0    0    tags_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.tags_id_seq', 9, true);
            public       postgres    false    199            �           2606    16395    notes notes_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.notes
    ADD CONSTRAINT notes_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.notes DROP CONSTRAINT notes_pkey;
       public         postgres    false    197            �           2606    16426    tag_note tag_note_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.tag_note
    ADD CONSTRAINT tag_note_pk PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tag_note DROP CONSTRAINT tag_note_pk;
       public         postgres    false    200            �           2606    16414    tags tags_pk 
   CONSTRAINT     J   ALTER TABLE ONLY public.tags
    ADD CONSTRAINT tags_pk PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.tags DROP CONSTRAINT tags_pk;
       public         postgres    false    198            y   6   x�3��730435"�Ȓ�����ܤ|.#�*0�L.�"8��!�=... �f4      |   (   x�3�4�4�2�4�4�2�&@ҌӔˈӔӌ+F��� Lh8      z   G   x�+NK)NIKI+�4�*��M`lS3
�B� �f\E%� �ic���8-������t��%W� �$     