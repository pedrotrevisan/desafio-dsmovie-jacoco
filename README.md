# Desafio DSMovie Jacoco — Testes Unitários

Projeto desenvolvido como desafio do curso **Java Spring Expert** da [DevSuperior](https://devsuperior.com.br), com foco na implementação de testes unitários de camada de serviço e cobertura de código com Jacoco.

## Sobre o projeto

O DSMovie é um sistema de filmes e avaliações. A visualização é pública, as alterações são restritas a ADMIN e qualquer usuário autenticado pode registrar notas. Este desafio implementa **15 testes unitários** cobrindo os três services principais.

## Tecnologias utilizadas

- Java
- Spring Boot 3
- Spring Data JPA
- Spring Security + OAuth2 + JWT
- JUnit 5
- Mockito
- Jacoco (cobertura de código)
- H2 Database
- Maven

## Testes implementados

### MovieServiceTests (9 testes)
- `findAllShouldReturnPagedMovieDTO`
- `findByIdShouldReturnMovieDTOWhenIdExists`
- `findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`
- `insertShouldReturnMovieDTO`
- `updateShouldReturnMovieDTOWhenIdExists`
- `updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`
- `deleteShouldDoNothingWhenIdExists`
- `deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`
- `deleteShouldThrowDatabaseExceptionWhenDependentId`

### ScoreServiceTests (2 testes)
- `saveScoreShouldReturnMovieDTO`
- `saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId`

### UserServiceTests (4 testes)
- `authenticatedShouldReturnUserEntityWhenUserExists`
- `authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`
- `loadUserByUsernameShouldReturnUserDetailsWhenUserExists`
- `loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`

## Como executar os testes

```bash
git clone https://github.com/pedrotrevisan/desafio-dsmovie-jacoco.git
cd desafio-dsmovie-jacoco
./mvnw test
```

Relatório Jacoco gerado em: `target/site/jacoco/index.html`

## Autor

**Pedro Henrique Trevisan**

[![GitHub](https://img.shields.io/badge/GitHub-pedrotrevisan-black)](https://github.com/pedrotrevisan)
