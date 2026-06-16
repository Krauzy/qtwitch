# qTwitch

Projeto de estudo inspirado em plataformas de streaming.

## Estrutura

- `backend`: API Java com Spring Boot.
- `frontend`: aplicacao Angular basica.
- `app`: pasta legada que ja existia no repositorio.

## Rodando o backend

```bash
cd backend
mvn spring-boot:run
```

Por padrao, a API sobe em `http://localhost:8080`.

Endpoints iniciais:

- `GET /api/health`
- `GET /api/streams`
- `GET /api/streams/{id}`

## Rodando o frontend

```bash
cd frontend
npm install
npm start
```

Por padrao, o Angular sobe em `http://localhost:4200` e usa o proxy local para enviar chamadas `/api` ao backend.
