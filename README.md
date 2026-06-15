# Projeto Raízes do Nordeste

## Projeto destinado a criação do backend de uma rede de Multicanalidade onde o usuário tem a possibilidade de fazer seu pedido através de diferentes canais de atendimento podendo ser por exemplo: um APP ou pelo site na WEB.

## Linguagem utilizada
<img width="113" height="151" alt="image" src="https://github.com/user-attachments/assets/06f7b6bf-6921-467d-aef5-4e9d2cee9e59" />


## Banco de dados utilizado
<img width="141" height="99" alt="image" src="https://github.com/user-attachments/assets/4e7cbe20-eb6f-4335-bfd2-4a88a53d0a59" />


## Framework
<img width="238" height="98" alt="image" src="https://github.com/user-attachments/assets/1c03354d-60ca-474f-af2b-b71be5e04f8d" />

# IDE utilizada para programação do projeto
<img width="335" height="120" alt="image" src="https://github.com/user-attachments/assets/3e6369b5-0f72-4b47-9ed2-be6c2f76baa6" />



## Instruções para clonar repositório em sua máquina
Primeiramente deve-se clonar este repositório em sua máquina clicando em <>code e Download Zip. 
<img width="1365" height="649" alt="image" src="https://github.com/user-attachments/assets/8086b2a2-dcb8-47a7-a8b8-24e8b8d9a16c" />
logo após descompactar o arquivo e abri-lo na IDE IntelliJ IDEA.
<img width="1359" height="764" alt="image" src="https://github.com/user-attachments/assets/5d5a80cf-7f79-48ac-b8c9-938572100889" />


## Instruções para instalação das depêndencias
Ao abrir o projeto na IDE o gerenciador de depêndencia Maven se encarregará de fazer os downloads das depêndecias do projeto.

## Pré requisistos para rodar a aplicação
Ter instalado no seu equipamento o MySQL Workbench, colocar o username e password definido por você quando instalou o banco de dados.

<img width="310" height="175" alt="image" src="https://github.com/user-attachments/assets/6c2e9b46-f7fe-42cc-a81d-d995c25e0e5a" />

### Copie e cole estes scripts de configuração do banco de dados, do JPA e da variável de ambiente utilizada no projeto
```bash
spring.application.name=projeto-multidisciplinar

spring.jpa.hibernate.ddl-auto= update
spring.datasource.url= jdbc:mysql://localhost:3306/raizes_nordeste?createDatabaseIfNotExist=true
spring.datasource.username= root
spring.datasource.password= 1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

//debug = true

#JPA
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql= true
spring.jpa.open-in-view= true

server.port = 8081

//Variáveis de ambiente
api.security.token.secret=${JWT_SECRET:my-secret-key}
```

# Iniciando os testes 🚀
Para realização dos testes foi utilizado o Insomnia com a organização do projeto em pastas como na imagem abaixo:
<img width="283" height="162" alt="image" src="https://github.com/user-attachments/assets/db7fa2eb-762e-4154-86a5-283153827d59" />
### Link para download do Insomnia -> https://insomnia.rest/download

1. O primeiro usuário deve ser criado diretamente no banco de dados devido somente usuários com rule ADMIN conseguirem criar.
   
   Abra o MySQL Workbench e crie o primeiro usuário fictício como ADMIN utilizando a instrução SQL abaixo:
   ```bash
   insert into usuario values (1, "08975642398", "2026-05-28", "admin", "$2a$10$ieNhyVEhWjIPFM8fU57oUO2ylZgo0K1.lNkaoFjqgjRK0IgXtrgtO", "ADMIN", "35999856748");
   ```
2. Após o primeiro usuário cadastrado deve efetuar o login e obter o token (usuários devem estar logados para efetuar as requisições).
   Endpoint:
   ```bash
   POST /auth/login
   ```
   Pasta Insomnia:
   ```bash
   Auth/Login do usuário
   ```
   JSON para envio:
   ```bash
   {
	"cpf": "08975642398",
	"password": "1234"
    }
   ```
   Imagem do teste:
   <img width="1366" height="729" alt="image" src="https://github.com/user-attachments/assets/9d0220cd-7d3a-44d5-b686-54965a5d3967" />
   ## OBS.: APÓS O LOGIN O TOKEN DEVE SER UTILIZADO PARA AS DEMAIS ROTAS, PARA ADICIONÁ-LO IR EM Auth -> Bearer Token -> copiar o token gerado e colar no campo TOKEN como na imagem abaixo.
   <img width="1366" height="732" alt="image" src="https://github.com/user-attachments/assets/0c783724-b208-40dc-94ef-6210df1fed29" />


   
   
3. Criando dois produtos (CRIAR UM POR VEZ)
   
   Endpoint:
   ```bash
   POST /produtos
   ```
   Pasta Insomnia:
   ```bash
   Produtos/Cadastrar produto
   ```
   JSON para envio:
   ```bash
   {
	"nome": "x-salada",
	"precoUnitario": 20.00
    }
   ```
    Imagem do teste:
    <img width="1366" height="731" alt="image" src="https://github.com/user-attachments/assets/4ce08a11-d634-46d0-8a16-6b3026b77c2a" />

    Obs.: Repita o teste mudando os dados de envio do JSON para criar outro produto.
4. Obter todos produtos cadastrados.
   
   Endpoint:
   ```bash
   GET /produtos
   ```
   Pasta Insomnia:
   ```bash
   Produtos/Obter todos produtos
   ```
   JSON para envio:
   ```bash
   {
    }
   ```
    Imagem do teste:
     <img width="1366" height="727" alt="image" src="https://github.com/user-attachments/assets/b08305c1-1307-4034-b75f-146151b4ec40" />
6. Atualizar produto.
   
   Endpoint:
   ```bash
   PUT /produtos?id={}
   ```
   Para colocar o id do produto que será alterado ir em PARAMS -> add -> e colocar name=id e o value=1
   <img width="401" height="527" alt="image" src="https://github.com/user-attachments/assets/c70e5f42-8bf4-4169-b117-cd85efa81ea7" />

   Pasta Insomnia:
   ```bash
   Produtos/Atualizar produto
   ```
   JSON para envio (colocar o campo e o valor que deseja mudar):
   ```bash
   	{
		"nome": "x-GALINHA"
	  }
   ```
    Imagem do teste:
   <img width="1366" height="729" alt="image" src="https://github.com/user-attachments/assets/b18f9816-dd24-4852-84b5-07bc95a51fd4" />
   Para verificar a atualização pode ir no endpoint de "Obter todos os produtos" e visualizar o produto que foi alterado.
7. Deletar produto.
   
   Endpoint:
   ```bash
   DELETE /produtos?id={}
   ```
   Para colocar o id do produto que será deletado ir em PARAMS -> add -> e colocar name=id e o value=1
   <img width="401" height="527" alt="image" src="https://github.com/user-attachments/assets/c70e5f42-8bf4-4169-b117-cd85efa81ea7" />

   Pasta Insomnia:
   ```bash
   Produtos/Deletar produto
   ```
   JSON para envio:
   ```bash
   	{
	  }
   ```
    Imagem do teste:
   <img width="1366" height="731" alt="image" src="https://github.com/user-attachments/assets/cbfd5ce9-e3e9-4fea-aae1-84a6eb3d59eb" />
   7. Criar pedido.
   
   Endpoint:
   ```bash
   POST /pedidos
   ```

   Pasta Insomnia:
   ```bash
   Pedido/Salvar pedido
   ```
   JSON para envio:
   ```bash
  	{
  	"usuarioId": 1,
  	"canalPedido": "WEB",
  	"itens": []
	}
   ```
   Imagem do teste:
   <img width="1366" height="731" alt="image" src="https://github.com/user-attachments/assets/c5fef218-3cea-4495-aaaf-8379623a6157" />
   Obs.: Vamos criar 2 pedidos para testar a rota de "Buscar por Unidade" logo abaixo, envie o mesmo JSON mudando somente a variável "canalPedido" com o valor "APP" por exemplo.

   8. Colocando ítem nos pedidos.
   
   Endpoint:
   ```bash
   POST /item
   ```

   Pasta Insomnia:
   ```bash
   Itens/Salvar item
   ```

	OBS.: ANTES DE CRIAR OS ÍTENS NOS PEDIDOS PODE-SE TESTAR TAMBÉM A ROTA "BUSCAR PEDIDOS" NA PASTA DO INSOMNIA CAMINHO -> PEDIDOS -> BUSCAR PEDIDOS, PARA CONSULTAR OS ID'S QUE SERÃO COLOCADOS NA VARIÁVEL "PEDIDOID" E CONSSULTAR TAMBÉM OS ID'S DOS PRODUTOS CADASTRADOS EM PRODUTOS -> OBTER TODOS PRODUTOS E COLOCAR NA VARIÁVEL PRODUTOID.
   
   JSON para envio:
   ```bash
  	{
    "quantidade": 2,
    "produtoId": 52,
    "pedidoId": 1
	}
   ```
   Imagem do teste:
   <img width="1366" height="729" alt="image" src="https://github.com/user-attachments/assets/516a96af-5636-40ff-a6c8-bf0c7112056e" />

   	OBS.: ATENTE A COLOCAR PELO MENOS UM ÍTEM NO OUTRO PEDIDO QUE FOI CRIADO PARA CONSULTAR A ROTA DE "PEDIDOS POR UNIDADE" LOGO ABAIXO.

   9. Consultando pedidos por unidade.
   
   Endpoint:
   ```bash
   GET /pedidos?canalPedido={}
   ```
   Pasta Insomnia:
   ```bash
   Pedidos/Buscar pedidos por unidade
   ```
      OBS.: EM "Params -> Add = adicione a variável e o valor como na imagem abaixo:
   <img width="410" height="565" alt="image" src="https://github.com/user-attachments/assets/ee6b4c31-32d9-4759-82c3-7557cf2a5678" />
   
   JSON para envio:
   ```bash
  	{
	}
   ```
   Imagem do teste:
   <img width="1366" height="728" alt="image" src="https://github.com/user-attachments/assets/d4987a4d-8350-41c3-b868-0a02466f9b30" />















