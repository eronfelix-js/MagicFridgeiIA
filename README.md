🍎 Magic Fridgei IA

Um sistema de controle de alimentos que permite cadastrar, listar, editar e excluir itens, com informações de validade e quantidade.
O backend foi desenvolvido em Java (Spring Boot) e o frontend em React.

📌 Funcionalidades

✅ Cadastro de alimentos com nome, categoria, quantidade e validade

✅ Listagem em tabela com todas as informações

✅ Edição e exclusão de alimentos

✅ Integração completa entre frontend (React) e backend (Spring Boot REST API)

✅ Validação de dados e formatação de datas

🛠️ Tecnologias Utilizadas
Backend

Java 17+

Spring Boot

Spring Data JPA (Hibernate)

Banco de dados: H2 (ou outro configurado)

Maven

⚙️ Como rodar o projeto
🔹 Clonar o repositório
git clone https://github.com/seu-usuario/food-inventory-system.git
cd food-inventory-system

🔹 Rodar o Backend
cd backend
./mvnw spring-boot:run


📡 Endpoints principais (Backend)

GET /foods → Lista todos os alimentos

POST /foods → Cadastra novo alimento

PUT /foods/{id} → Atualiza alimento

DELETE /foods/{id} → Remove alimento
