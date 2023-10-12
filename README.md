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

### Formulário
<details> <!-- Formulário -->
<summary>Detalhar</summary>

### **``POST`` /formularios/formulario**
<details>
<summary>Detalhar</summary>

> Endpoint para cadastro de formulários.
**Parâmetros**: N/A.
**Corpo da Requisição:** 
```
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
```
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