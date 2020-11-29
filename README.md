Segurança:

​	Como o projeto, em seu primeiro ciclo de entrega, não possui nenhuma forma de autenticação ou dados sensíveis, optamos por não despender esforços iniciais em segurança. Entretanto, ao começar a lidar com informações que precisam de tal tratamento, a utilização das bibliotecas de segurança fornecidas pelo Spring será adotada.



Fluxo de Dados:

![inagro_endpoints_diagrams](/doc/inagro_endpoints_diagrams.jpg)



Documentação e Versionamento:

​	A escolha de adotar metodologias ágeis para o projeto faz a uso do GIT ideal. A ferramenta proporciona estruturas de versões simples e concisas. Em adição, a plataforma Heroku, onde o projeto está disponibilizado, possui facilitadores que ajudarão em casos de erros de versionamento.

​	Por se tratar de um produto, não de um projeto especificamente para um cliente, o InAgro passará por várias iterações de entregas. Essas entregas incrementais do sistema sempre serão acompanhadas de changelogs e diagramas que complementem os que já existiam anteriormente, entre outros possíveis facilitadores.

​	Uma segunda entrega já foi planejada, onde serão adicionados dados históricos da região selecionada para que o aplicativo, via inteligência artificial, consiga prever a chance de sucesso das possíveis condições climáticas somadas à chance de sucesso baseada na estação do ano.



Arquitetura:

- Servidor: Heroku
- Banco de Dados: PostgreSQL
- Stack utilizada: Kotlin e JavaScript
- Frameworks: Spring, React e Node.js
- Padrão de API: REST



Prototipação / MVP:

​	Criamos o protótipo do aplicativo InAgro disponível [clicando aqui](https://www.figma.com/proto/PQ6boqohAOXZGBkoTkTIEV/LandingPage) e o back-end que, inicialmente, possui os endpoints de retorna qual a estação atual, regiões cadastradas, região por ID, sementes por região e semente por ID

- Estação atual: "SPRING"

- Regiões cadastradas: 

  ```json
  [
      {
          "id": "c945a813-1f75-49e8-94ad-ec89dfdfd641",
          "name": "Campo Mourão",
          "state": "PR",
          "seeds": [
              {
                  "id": "865fa331-a2e5-4823-b0be-f7cc1793415c",
                  "name": "Soja",
                  "type": "Grão",
                  "successRateBySeason": {
                      "SUMMER": 60,
                      "FALL": 15,
                      "WINTER": 4,
                      "SPRING": 82
                  },
                  "successRateFromToday": 82
              },
              {
                  "id": "39030a3f-01b4-49ad-a2d7-346642a2c2a2",
                  "name": "Milho",
                  "type": "Grão",
                  "successRateBySeason": {
                      "SUMMER": 22,
                      "FALL": 57,
                      "WINTER": 8,
                      "SPRING": 90
                  },
                  "successRateFromToday": 90
              }
          ]
      },
      {
          "id": "e18e0714-c4c1-4ff7-b477-c8264d9e3a33",
          "name": "São Paulo - Capital",
          "state": "SP",
          "seeds": [
              {
                  "id": "64e9cc37-4210-4e6b-9fe2-98f765fc9d06",
                  "name": "Banana",
                  "type": "Fruta",
                  "successRateBySeason": {
                      "SUMMER": 80,
                      "FALL": 30,
                      "WINTER": 12,
                      "SPRING": 94
                  },
                  "successRateFromToday": 94
              }
          ]
      }
  ]
  ```

- Região por ID:

  ```json
  {
      "id": "c945a813-1f75-49e8-94ad-ec89dfdfd641",
      "name": "Campo Mourão",
      "state": "PR",
      "seeds": [
          {
              "id": "865fa331-a2e5-4823-b0be-f7cc1793415c",
              "name": "Soja",
              "type": "Grão",
              "successRateBySeason": {
                  "SUMMER": 60,
                  "FALL": 15,
                  "WINTER": 4,
                  "SPRING": 82
              },
              "successRateFromToday": 82
          },
          {
              "id": "39030a3f-01b4-49ad-a2d7-346642a2c2a2",
              "name": "Milho",
              "type": "Grão",
              "successRateBySeason": {
                  "SUMMER": 22,
                  "FALL": 57,
                  "WINTER": 8,
                  "SPRING": 90
              },
              "successRateFromToday": 90
          }
      ]
  }
  ```

- Buscar sementes por região:

  ```json
  [
      {
          "id": "865fa331-a2e5-4823-b0be-f7cc1793415c",
          "name": "Soja",
          "type": "Grão",
          "successRateBySeason": {
              "SUMMER": 60,
              "FALL": 15,
              "WINTER": 4,
              "SPRING": 82
          },
          "successRateFromToday": 82
      },
      {
          "id": "39030a3f-01b4-49ad-a2d7-346642a2c2a2",
          "name": "Milho",
          "type": "Grão",
          "successRateBySeason": {
              "SUMMER": 22,
              "FALL": 57,
              "WINTER": 8,
              "SPRING": 90
          },
          "successRateFromToday": 90
      }
  ]
  ```

- Buscar semente por ID:

  ```json
  {
      "regionName": "Campo Mourão",
      "regionState": "PR",
      "name": "Soja",
      "type": "Grão",
      "successRateBySeason": {
          "SUMMER": 60,
          "FALL": 15,
          "WINTER": 4,
          "SPRING": 82
      },
      "currentSuccessRate": 82
  }
  ```