-- Table: public.notes

-- DROP TABLE public.notes;

CREATE TABLE public.notes
(
  id integer NOT NULL DEFAULT nextval('notes_id_seq'::regclass),
  title character varying(255),
  text character varying(512),
  CONSTRAINT notes_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.notes
  OWNER TO postgres;
  
- Table: public.tag_note

-- DROP TABLE public.tag_note;

CREATE TABLE public.tag_note
(
  tag_id integer NOT NULL,
  note_id integer NOT NULL,
  id integer NOT NULL DEFAULT nextval('tag_note_id_seq'::regclass),
  CONSTRAINT tag_note_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tag_note
  OWNER TO postgres;

-- Table: public.tags

-- DROP TABLE public.tags;

CREATE TABLE public.tags
(
  name character varying(512),
  id integer NOT NULL DEFAULT nextval('tags_id_seq'::regclass),
  CONSTRAINT tags_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tags
  OWNER TO postgres;

  