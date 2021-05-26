<div style = "text-align:center">

# Seja bem vindo ao  ![LogoProjeto](/resource/images/LogoConsultCAR_50px.png "LogoProjeto") ConsultCAR

</div>
<div style="text-align:center">

### Olá! Somos a equipe Tetris responsáveis pelo desenvolvimento da solução ConsultCar.

</div>
<br>

# O Time :woman: :man:
<div class="time" style= "text-align:justify">
A equipe Tetris é composta pelos seguintes estudantes do 2º semestre de Banco de Dados pela FATEC de São José dos Campos:

- ***Product Owner***
  - [Alexia Karine Silva dos Santos](https://github.com/alexiakarine)
- ***Scrum Master***
  - [Jefferson Tavares de Araújo](https://github.com/jefferson-tavares-araujo)
- ***Team Dev :***
  - [Davi das Neves Machado](https://github.com/machadondavi)
  - [Gabriel Oliveira Sana](https://github.com/gabsana) 
  - [Nágella Nasser](https://github.com/nagellanasser) 
  - [Renata Garcia Nonato](https://github.com/RenataGarciaNonato)
  - [Valdiney José do Nascimento](https://github.com/Valdineynascimento)
</div>
<br>

# ![LogoProjeto](/resource/images/LogoConsultCAR_50px.png "LogoProjeto") ConsultCar

## Objetivo  ![Flecha](https://user-images.githubusercontent.com/81206214/119738780-9e2b4480-be57-11eb-91ab-5d68dd36b311.jpg)
<div class="motivacao" style= "text-align:justify" >
ConsultCar é uma ferramenta que tem o intuito de facilitar a importação, armazenamento e visualização de dados do Sistema Nacional de Cadastro Ambiental Rural.
</div>
<br>

## Requisitos funcionais :pencil:

- Banco de Dados com extensão espacial
- Importação e leitura de dados com extensão .shp
- Armazenamento do shapefile (polígono) da propriedade
- Leitura dos dados para classificações internas (Cód. IBGE, UF, etc)
  
<br>

## Funcionalidades :heavy_check_mark:

- Disponibilizar de forma organizada em tabela informações extraídas a partir da importação de arquivos adquiridos na plataforma do Sicar com extensão .shp 
<br>

## Público-alvo :dart:

<div class="publico-alvo" style= "text-align:justify">
Profissionais que tenham a necessidade de acesso de forma organizada aos dados do Cadastro  Ambiental Rural.
</div>
<br>

## Tecnologias utilizadas :computer:
<div class="tecnologias" style= "text-align:justify">

- Git
- GitHub
- Banco de Dados: PostgreSQL || pgAdmin4 ou DBeaver
- Extensão espacial para o banco de dados: PostGIS

</div>
<br>

## Entregas :email:
<div class="sprints" style= "text-align:justify">

- **SPRINT 1** :heavy_check_mark:
  - Definição da solução e suas funcionalidades
  - Desenvolvimento das _Users Stories_ do projeto
  - Idealização e desenvolvimento de protótipo [wireframe] da tela de importação de arquivos _**.CSV**_
<br><br>  

- **SPRINT 2** :heavy_check_mark:
  - Correção no plano de desenvolvimento da aplicação
  - Modelagem do Banco de Dados - MER
  - Desenvolvimento do Banco de Dados
  - Importação e visualização do arquivo Shapefile (.shp), no BD
<br><br>

- **SPRINT 3** :heavy_check_mark:
  - Desenvolvimento do script de descompactação dos arquivos *.zip
  - Correção da modelagem do Banco de Dados - MER (conceitual e lógico)
  - Geração e visualização de logs de descompactação
  - Criação do Banco de Dados com extensão espacial
  - Estruturação do banco de dados para futura população de dados shapefile
  - Conexão entre aplicação e o Banco de Dados 
<br><br> 

- **SPRINT 4** :heavy_check_mark:
  - Carga dos arquivos shapefiles no Banco de Dados
  - Ajustes de funcionalidades
<br><br> 
</div>

## Product Backlog :page_with_curl:

<div class="users-stories" style= "text-align:justify">

- ![Product Backlog](./resource/images/backlog.jpeg "Backlog - Necessidades do Cliente")
<br>  
</div>
<br>

## Users Stories :chart_with_upwards_trend:
<div class="users-stories" style= "text-align:justify">

- ![UsersStories](./resource/images/user_stories.jpeg "Users Stories")
<br>  
</div>
<br>

## Modelagem Entidade-Relacionamento - MER :pencil2:
<div class="mer" style= "text-align:justify">

- **Modelo Conceitual**
  
   ![MER_ModeloConceitual](./resource/images/Modelo_Conceitual_API.jpg "MER_Conceitual_ConsultCAR")
<br><br>

- **Modelo Lógico**
  
   ![MER_ModeloLogico](./resource/images/Modelo_Lógico_API.jpg "MER_Lógico_ConsultCAR")
<br><br>
</div>

## Wireframes :mortar_board:
<div class="wireframes" style= "text-align:justify">

- **01: Tela Inicial** *- atual*
  - ![Tela_Inicial](./resource/images/telas/aplicacao/Wireframe_telaPrincipal.jpeg "Tela Inicial Protótipo ConsultCAR")
<br><br>

  - *Tela Inicial Prevista - Sujeita a modificações* 
  - ![Tela_Inicial](./resource/images/frame_consultcar.png "Tela do Software ConsultCar")
<br><br>

- **02: Diretorio de entrada com arquivos ainda compactados**
  - ![DirCompact](./resource/images/telas/aplicacao/Wireframe_telaDirEntrada.arqComp.jpeg "Diretório com arquivos ainda compactados ConsultCAR")
<br><br>

- **03: Conexão com o Banco de Dados**
  - ![ConexaoBD](./resource/images/telas/aplicacao/Wireframe_telaConexaoBemSucedida.jpeg "Tela de confirmação de conexão com banco de dados ConsultCAR")
<br><br>

- **04: Log informando as atividades do Sistema**
  - ![Tela_LogSistema](./resource/images/telas/aplicacao/Wireframe_telaLog.jpeg "Tela de logs das atividades do Sistema ConsultCAR")
<br><br>

- **05: Diretorio de saída com arquivos descompactados**
  - ![DirCompact](./resource/images/telas/aplicacao/Wireframe_telaDirSaida.arqDescomp.jpeg "Diretório com arquivos descompactados ConsultCAR")
<br><br>

- **06: Arquivos gerados**
  - ![DiretoriosLogs](./resource/images/telas/aplicacao/Wireframe_telaArqLogGerados.jpeg "Diretório de arquivos gerados ConsultCAR")
<br><br>

### **Banco de Dados** :newspaper:
- **07: Banco de Dados criado com extensão espacial**
  - ![BancoDeDados](./resource/images/telas/bancoDeDados/Wireframe_BD.jpeg "Banco de Dados criado ConsultCAR")
<br><br>

- **08: Estrutura das colunas no Banco de Dados** 
  - ![BancoDeDados](./resource/images/telas/bancoDeDados/Wireframe_ColunasBD.jpeg "Banco de Dados estrutura colunas ConsultCAR")
<br><br>

- **09: Script de importação dos dados para popular o banco de dados**
  - ![BancoDeDados](./resource/images/telas/bancoDeDados/Wireframe_CodigoBD.jpeg "Banco de Dados parte do script ConsultCAR")
<br><br>

</div>

<br>
<!--
## Tela do Software :pager:
<div class="Modelo Conceitual" style= "text-align:justify">
 
<!-- ![Tela do Software](/resource/images/frame_consultcar.png "Tela do Software ConsultCar")

<br>  
</div>
<br>
-->


