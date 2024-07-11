# Controle de contatos

## Objetivo

O projeto de controle de contatos tem por objetivo, colocar em pratica todo o conhecimento visto em aula.

---

## Ferramentas e Tecnologias

- **Java**
    - Linguagem de programação orientada a objetos.

- **Spring Boot**
    - Ferramenta que facilita e agiliza o desenvolvimento de aplicativos da web .

- **Github**
    - Gerenciador de repositório de software baseado em git.


- **Supabase (PostegreSQL)**
    - Plataforma de banco de dados SQL Na nuvem.

---

## Base de Dados

Como base de dados do projeto, foi utilizado o PostegreSQL.

### Informações de Conexão

- **Host:** jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com
- **Porta:** 5432
- **Database name:** postgres
- **Caso não funcione o banco de dados em nuvem, siga as informações abaixo**
1. recomendado uso do Docker, execute uma imagem do postgres
2. mudando as configurações no aplication.properties
   1. mudar o host,porta e colocar a senha escolhida
   2. mudar a propriedade de: spring.jpa.hibernate.ddl-auto=update PARA: spring.jpa.hibernate.ddl-auto=drop-and-create

### informações de execução local
1. Clone ou baixe o projeto em sua maquina,
2. Verifique se na estrutura está configurado o java18
3. Aperte no botão play e execute.
4. A aplicação será executada na porta 8081
### Swagger 
  
  **Local:** http://localhost:8081/swagger-ui/index.html/
  