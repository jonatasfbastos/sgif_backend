# SGIF - Sistema de Gerenciamento do IFBA

# **📚 Rest API Documentation**
> **⚠ AVISO:** A documentação da API está em construção.
<details><!-- Rest API Documentation -->
<summary>Ver documentação da API</summary>

## **Versões**
<details><!-- VERSÕES -->
<summary>Ver versões da API</summary>

### **V1**
<details> <!-- V1 -->
<summary>Detalhar versão 1.0.1</summary>

> As sessões a seguir estão em ordem alfabética, e os endpoints dentro de cada sessão seguem a seguinte hierarquia de verbos: GET, POST, PUT, DELETE. Os dados presentes em 'parâmetros', 'corpo da requisição' e 'corpo da resposta' são apenas para fins de exemplo e não há garantia que eles estejam salvos na base de dados da API.

### Formulário
<details> <!-- Formulário -->
<summary>Detalhar</summary>

### **``POST`` /formularios/formulario**
<details>
<summary>Detalhar</summary>

> Endpoint para cadastro de formulários.
**Parâmetros**: N/A.
**Corpo da Requisição:** 
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