--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

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

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: InternetKullanicisi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."InternetKullanicisi" (
    id integer,
    kullanici_adi character varying NOT NULL,
    sifre character varying NOT NULL,
    ad_soyad character varying NOT NULL,
    yetki boolean
);


ALTER TABLE public."InternetKullanicisi" OWNER TO postgres;

--
-- Data for Name: InternetKullanicisi; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."InternetKullanicisi" VALUES (1, 'rabiaabdioglu', '123456', 'Rabia Abdioğlu', true);
INSERT INTO public."InternetKullanicisi" VALUES (2, 'ayseyilmaz', '654321', 'Ayşe Yılmaz', true);
INSERT INTO public."InternetKullanicisi" VALUES (3, 'kadirdeniz', '123456', 'Kadir Deniz', NULL);
INSERT INTO public."InternetKullanicisi" VALUES (4, 'hasancevher', '123456', 'Hasan Cevher', NULL);


--
-- PostgreSQL database dump complete
--

