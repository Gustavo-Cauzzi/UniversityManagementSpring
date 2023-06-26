CREATE TABLE universidades
(
    cod_universidade serial PRIMARY KEY,
    des_universidade VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE cursos
(
    cod_curso        serial PRIMARY KEY,
    des_curso        VARCHAR(100) UNIQUE NOT NULL
);

create table disciplina
(
    cod_disciplina serial primary key,
    des_disciplina varchar(100)
);

create table disciplina_curso
(
    cod_disciplina_curso serial primary key,
    cod_curso            serial not null,
    cod_disciplina       serial not null,
    foreign key (cod_disciplina) references disciplina (cod_disciplina),
    foreign key (cod_curso) references cursos (Cod_curso)
);

CREATE TABLE alunos
(
    cod_aluno serial PRIMARY KEY,
    des_aluno VARCHAR(100) UNIQUE NOT NULL
);

create table alunos_disciplinas
(
    cod_disciplina_aluno serial primary key,
    cod_disciplina       serial not null,
    cod_aluno            serial not null,
    foreign key (cod_disciplina) references disciplina (cod_disciplina),
    foreign key (cod_aluno) references alunos (cod_aluno)
);

CREATE TABLE matriculas
(
    cod_matricula    serial primary key,
    cod_curso        serial NOT NULL,
    cod_aluno        serial NOT NULL,
    unique (cod_curso, cod_aluno),
    FOREIGN KEY (cod_curso)
        REFERENCES cursos (cod_curso),
    FOREIGN KEY (cod_aluno)
        REFERENCES alunos (cod_aluno)
);

CREATE TABLE universidade_curso (
    cod_universidade_curso serial primary key ,
    cod_universidade serial not null,
    cod_curso serial not null,
    unique (cod_curso, cod_universidade),
    CONSTRAINT universidade_curso_fk_curso FOREIGN KEY (cod_curso)
        REFERENCES cursos (cod_curso),
    CONSTRAINT universidade_curso_fk_universidade FOREIGN KEY (cod_universidade)
        REFERENCES universidades (cod_universidade)
)

/*
drop table universidade_curso ;
drop table disciplina_curso CASCADE;
drop table alunos_disciplinas CASCADE;
drop table universidades CASCADE;
drop table disciplina CASCADE;
drop table matriculas CASCADE;
drop table cursos CASCADE;
drop table alunos CASCADE;
 */