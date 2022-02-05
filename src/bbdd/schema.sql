--
-- PostgreSQL database dump
--
DROP DATABASE webjdbc;

CREATE DATABASE webjdbc;
-- Dumped from database version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: campeon; Type: TABLE; Schema: public; Owner: webuser
--

CREATE TABLE public.campeon (
    id smallint NOT NULL,
    nom character varying(20),
    rol character varying(20),
    historia text
);


ALTER TABLE public.campeon OWNER TO webuser;

--
-- Name: campeon_id_seq; Type: SEQUENCE; Schema: public; Owner: webuser
--

ALTER TABLE public.campeon ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.campeon_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: rol; Type: TABLE; Schema: public; Owner: webuser
--

CREATE TABLE public.rol (
    rol character varying(20) NOT NULL
);


ALTER TABLE public.rol OWNER TO webuser;

--
-- Data for Name: campeon; Type: TABLE DATA; Schema: public; Owner: webuser
--

COPY public.campeon (id, nom, rol, historia) FROM stdin;
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: webuser
--

COPY public.rol (rol) FROM stdin;
\.


--
-- Name: campeon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webuser
--

SELECT pg_catalog.setval('public.campeon_id_seq', 1, false);


--
-- Name: campeon campeon_pkey; Type: CONSTRAINT; Schema: public; Owner: webuser
--

ALTER TABLE ONLY public.campeon
    ADD CONSTRAINT campeon_pkey PRIMARY KEY (id);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: webuser
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol);


--
-- Name: campeon campeon_rol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webuser
--

ALTER TABLE ONLY public.campeon
    ADD CONSTRAINT campeon_rol_fkey FOREIGN KEY (rol) REFERENCES public.rol(rol);


--
-- PostgreSQL database dump complete
--

