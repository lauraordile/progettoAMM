/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *NomeUtente: ammdb 
 *Password: l.ordile
 * Author:  Laura
 * Created: 9-mag-2017
 */

CREATE TABLE Utente (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    dataNascita DATE,
    frasePresentazione VARCHAR(250),
    urlFoto VARCHAR(200),
    password VARCHAR(30),
    email VARCHAR(30)
);

CREATE TABLE TipoUrl (
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nomeTipo VARCHAR(20)
);

CREATE TABLE Gruppo (
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(50),
    amministratore INTEGER,
    FOREIGN KEY (amministratore) REFERENCES Utente(id)
);

CREATE TABLE UtentePerGruppo (
   gruppo INTEGER,
   FOREIGN KEY (gruppo) REFERENCES Gruppo(id),
   utente INTEGER,
   FOREIGN KEY (utente) REFERENCES Utente(id),
   PRIMARY KEY (gruppo, utente)
);

CREATE TABLE Post (
   id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
   testo VARCHAR(350),
   url VARCHAR(200),
   tipo INTEGER,
   FOREIGN KEY (tipo) REFERENCES TipoUrl(id),
   utente INTEGER,
   FOREIGN KEY (utente) REFERENCES Utente(id)
);

INSERT INTO Utente (id, nome,cognome , dataNascita, FrasePresentazione,urlFoto, password, email)
VALUES (
    default,
    'Donald',
    'Fauntleroy Duck',
    '1934-06-09',
    'Ciao a tutti sono Paperino!',
    'immagini/papero.png',
    '1234',
    'DonaldFauntleroyDuck@gmail.com'
    ),(
    default,
    'Minerva',
    'Mouse',
    '1928-05-15',
    'Ciao a tutti sono Minnie!',
    'immagini/Minnie.png',
    '5678',
    'MinervaMouse@gmail.com'
    ),(
    default,
    'Mickey',
    'Mouse',
    '1928-11-18',
    'Ciao a tutti sono Topolino!',
    'immagini/mouse.jpg',
    '91011',
    'MickeyMouse@gmail.com'
    ),(
    default,
    'Daisy',
    'Duck',
    '1940-06-07',
    'Ciao a tutti sono Topolino!',
    'immagini/Paperina.png',
    '1213',
    'DaisyDuck@gmail.com'
    );

INSERT INTO TipoUrl (id, nomeTipo)
VALUES (
    default,
    'NULL'
    ),(
    default,
    'IMAGE'
    ),(
    default,
    'LINK'
    );

INSERT INTO POST (id, testo,url,tipo,utente)
VALUES (
    default,
    'Qua qua qua qua qua.... qua',
    '',
    1,
    1
    ),(
    default,
    'Ciao a tutti!oggi io e Minnie siamo andati a comprare tanto formaggio, siamo proprio tanto golosi.',
    'immagini/formaggi.png',
    2,
    3
    ),(
    default,
    'Ciao ragazze!! oggi posto un video di me e della mia amica paperina. Bacini.',
    'https://www.youtube.com/watch?v=B7V5mZcUarc',
    3,
    2
    );

INSERT INTO GRUPPO (id, nome,amministratore)
VALUES (
    default,
    'Topolini',
    2 ),(
    default,
    'Paperini',
    1 );

INSERT INTO UTENTEPERGRUPPO (gruppo, utente)
VALUES (
    1,
    2),(
    1,
    3 ),(
    2,
    1),(
    2,
    4);