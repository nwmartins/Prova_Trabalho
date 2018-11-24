
CREATE SEQUENCE public.pessoa_fisica_id_seq;

CREATE TABLE public.Pessoa_Fisica (
                id INTEGER NOT NULL DEFAULT nextval('public.pessoa_fisica_id_seq'),
                cpf VARCHAR(14) NOT NULL,
                rg VARCHAR(14),
                sexo VARCHAR(1),
                nm VARCHAR(60) NOT NULL,
                CONSTRAINT pessoa_fisica_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.pessoa_fisica_id_seq OWNED BY public.Pessoa_Fisica.id;

CREATE TABLE public.Funcionario (
                id INTEGER NOT NULL,
                dt_contratacao DATE,
                salario NUMERIC(5,2),
                CONSTRAINT funcionario_pk PRIMARY KEY (id)
);


CREATE SEQUENCE public.hospedagem_id_seq;

CREATE TABLE public.hospedagem (
                id INTEGER NOT NULL DEFAULT nextval('public.hospedagem_id_seq'),
                id_func INTEGER NOT NULL,
                dt_entrada DATE NOT NULL,
                dt_saida DATE NOT NULL,
                status VARCHAR(100) NOT NULL,
                vlr_tot NUMERIC(5,2) NOT NULL,
                obs VARCHAR(120),
                CONSTRAINT hospedagem_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.hospedagem_id_seq OWNED BY public.hospedagem.id;

CREATE SEQUENCE public.quarto_id_seq;

CREATE TABLE public.quarto (
                id INTEGER NOT NULL DEFAULT nextval('public.quarto_id_seq'),
                andar SMALLINT NOT NULL,
                status VARCHAR(100) NOT NULL,
                num_quarto SMALLINT NOT NULL,
                desc_1 VARCHAR(60),
                valor NUMERIC(5,2) NOT NULL,
                cap_pessoas INTEGER,
                CONSTRAINT quarto_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.quarto_id_seq OWNED BY public.quarto.id;

CREATE SEQUENCE public.reserva_id_seq;

CREATE TABLE public.reserva (
                id INTEGER NOT NULL DEFAULT nextval('public.reserva_id_seq'),
                id_quarto INTEGER NOT NULL,
                id_func INTEGER NOT NULL,
                status VARCHAR(100) NOT NULL,
                dt_reserva DATE NOT NULL,
                qtd_dias SMALLINT NOT NULL,
                dt_entrada DATE NOT NULL,
                CONSTRAINT reserva_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.reserva_id_seq OWNED BY public.reserva.id;

CREATE TABLE public.Cliente (
                id INTEGER NOT NULL,
                dt_cad DATE NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (id)
);


CREATE SEQUENCE public.hospedagem_cli_id_seq;

CREATE TABLE public.Hospedagem_Cli (
                id INTEGER NOT NULL DEFAULT nextval('public.hospedagem_cli_id_seq'),
                id_hospedagem INTEGER NOT NULL,
                id_quarto INTEGER NOT NULL,
                id_Cliente INTEGER NOT NULL,
                CONSTRAINT hospedagem_cli_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.hospedagem_cli_id_seq OWNED BY public.Hospedagem_Cli.id;

CREATE TABLE public.Reserva_Cli (
                id INTEGER NOT NULL,
                id_reserva INTEGER NOT NULL,
                id_Cliente INTEGER NOT NULL,
                CONSTRAINT reserva_cli_pk PRIMARY KEY (id)
);


ALTER TABLE public.Cliente ADD CONSTRAINT pessoa_fisica_cliente_fk1
FOREIGN KEY (id)
REFERENCES public.Pessoa_Fisica (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Funcionario ADD CONSTRAINT pessoa_fisica_funcionario_fk
FOREIGN KEY (id)
REFERENCES public.Pessoa_Fisica (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.hospedagem ADD CONSTRAINT funcionario_hospedagem_fk
FOREIGN KEY (id_func)
REFERENCES public.Funcionario (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reserva ADD CONSTRAINT funcionario_reserva_fk
FOREIGN KEY (id_func)
REFERENCES public.Funcionario (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Hospedagem_Cli ADD CONSTRAINT hospedagem_hospedagem_cli_fk
FOREIGN KEY (id_hospedagem)
REFERENCES public.hospedagem (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reserva ADD CONSTRAINT quarto_reserva_fk
FOREIGN KEY (id_quarto)
REFERENCES public.quarto (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Hospedagem_Cli ADD CONSTRAINT quarto_hospedagem_cli_fk
FOREIGN KEY (id_quarto)
REFERENCES public.quarto (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Reserva_Cli ADD CONSTRAINT reserva_reserva_cli_fk
FOREIGN KEY (id_reserva)
REFERENCES public.reserva (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Reserva_Cli ADD CONSTRAINT cliente_reserva_cli_fk
FOREIGN KEY (id_Cliente)
REFERENCES public.Cliente (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Hospedagem_Cli ADD CONSTRAINT cliente_hospedagem_cli_fk
FOREIGN KEY (id_Cliente)
REFERENCES public.Cliente (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;