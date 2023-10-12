# SGIF - Sistema de Gerenciamento do IFBA

<details><!-- Rest API Documentation -->
<summary><h1>📚 Rest API Documentation</h1></summary>
    
> **⚠ AVISO:** A documentação da API está em construção.
> 
<details><!-- VERSÕES -->
<summary><h2>Versões</h2></summary>

<details> <!-- V1 -->
<summary><h2>Versão 1.0.1</h2></summary>

> As sessões a seguir estão em ordem alfabética, e os endpoints dentro de cada sessão seguem a seguinte hierarquia de verbos: GET, POST, PUT, DELETE. Os dados presentes em 'parâmetros', 'corpo da requisição' e 'corpo da resposta' são apenas para fins de exemplo e não há garantia que eles estejam salvos na base de dados da API.

<details> <!-- Formulário -->
<summary><h3>Formulário</h3></summary>

<details>
<summary><h3><code>POST</code> /formularios/formulario</h3></summary>

> Endpoint para cadastro de formulários.

**Parâmetros**: N/A. <br>
**Corpo da Requisição:**  <br>
```json
{
    "titulo" : "título do formulário",
    "descricao" : "descrição do formulário",
    "questoes" : [
        {
            "enunciado" : "enunciado 01",
            "respostas" : [
                {
                    "texto" : "conteúdo da resposta 01",
                    "usuario_login" : "login_do_usuario_01"
                },
                {
                    "texto" : "conteúdo da resposta 02",
                    "usuario_login" : "login_do_usuario_02"
                }
            ]
        }
    ]
}
```
**Corpo da Resposta:** 
```json
{
    "titulo" : "título do formulário",
    "descricao" : "descrição do formulário"
}
```

</details>

</details> <!-- Formulário -->

</details><!-- V1 -->

</details><!-- VERSÕES -->


</details><!-- Rest API Documentation -->
