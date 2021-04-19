--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-18 18:18:04

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
-- TOC entry 5 (class 2615 OID 32768)
-- Name: myStore; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "myStore";


ALTER SCHEMA "myStore" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 32769)
-- Name: products; Type: TABLE; Schema: myStore; Owner: postgres
--

CREATE TABLE "myStore".products (
    "ID" integer NOT NULL,
    "PRODUCT_NAME" text NOT NULL,
    "DEVELOPER" text NOT NULL,
    "PUBLISHER" text NOT NULL,
    "PLATFORM" text NOT NULL,
    "DESCRIPTION" text NOT NULL,
    "PRICE" double precision NOT NULL
);


ALTER TABLE "myStore".products OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 32805)
-- Name: products_ID_seq; Type: SEQUENCE; Schema: myStore; Owner: postgres
--

ALTER TABLE "myStore".products ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "myStore"."products_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 208 (class 1259 OID 40962)
-- Name: users; Type: TABLE; Schema: myStore; Owner: postgres
--

CREATE TABLE "myStore".users (
    "ID" integer NOT NULL,
    "FIRST_NAME" text NOT NULL,
    "LAST_NAME" text NOT NULL,
    "EMAIL" text NOT NULL,
    "USER_NAME" text NOT NULL,
    "PASSWORD" text NOT NULL,
    "PHONE_NUMBER" text NOT NULL
);


ALTER TABLE "myStore".users OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 40960)
-- Name: users_ID_seq; Type: SEQUENCE; Schema: myStore; Owner: postgres
--

ALTER TABLE "myStore".users ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "myStore"."users_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2867 (class 2606 OID 32776)
-- Name: products orders_pkey; Type: CONSTRAINT; Schema: myStore; Owner: postgres
--

ALTER TABLE ONLY "myStore".products
    ADD CONSTRAINT orders_pkey PRIMARY KEY ("ID");


--
-- TOC entry 2869 (class 2606 OID 40969)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: myStore; Owner: postgres
--

ALTER TABLE ONLY "myStore".users
    ADD CONSTRAINT users_pkey PRIMARY KEY ("ID");


-- Completed on 2021-04-18 18:18:04

--
-- PostgreSQL database dump complete
--

