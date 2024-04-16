# General Info 
Note that even if I created both the Frontend and Backend, they are not connected each other (lack of time).

They both work separately.

Check below, in each appropriate sections, basic instructions, some guide lines and "warnings".

----

# Invoice Matching - FE
Angular FrontEnd for Invoice Matching Purpose

----
#### > node modules

To run the application, remember to install needed packages (node modules) with the command
```
  npm install
```
where the *package.json* is located. 

---
#### > Versions and dependencies

- Angular CLI: **12.2.18**
- Node: **12.22.12**
- Package Manager: **npm 6.14.16**
- OS: **linux x64**
- Angular: **12.2.17**

---

#### > run front-end

Start Angular SPA with the command 
```
  ng serve
```
where the *package.json* is located. 

---

#### > How the UI should look like

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/74408efe-f766-4ef9-b1a6-199b700409b1)

You can have a look at a running example (screen recording) [here](https://github.com/ferrara94/InvoiceMatching/commit/770cc9775b46df7e8bb5c9684b0fa238ad02a7d1#r141029919)

Note that data are hard-coded; I created manually data structure which contains data. 

---

# Invoice Matching - BE

Spring BE for Invoice Matching Purpose

----

#### > Versions and dependencies

- openjdk 17.0.10 2024-01-16
- OpenJDK Runtime Environment (build 17.0.10+7-Ubuntu-118.04.1)
- OpenJDK 64-Bit Server VM (build 17.0.10+7-Ubuntu-118.04.1, mixed mode, sharing)
- SpringBoot 3.2.4

#### > run back-end

In the project exists a **SpringBoot** project called **invoice**.

This project is used to provide (ideally it should but is not ready connected and not working properly) **Rest APIs, Services and Elaboration** to the Front-end; 

To run back-end service there are several ways:

- [ ] right click on project + run as Spring Boot App
- [ ] by command line lunch: mvn spring-boot:run

---

#### > Persistence Layer

In the project exists a **Docker** directory where it is located the **docker-compose** file.

It can be use to generate a PostgreSQL instace.

For my testing time I used DBeaver as client and the database schema is 

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/d113c5fc-356b-4128-b306-705a8c8f13f0)

#### > Disclaimer 

**Rest Controllers** I created dont't check for errors like **creation of duplicate record** or don't manage **server errors**.

We should use them, If you don't mind me asking, for **crud testing purpose**. 

**Persistence side**: I suggest to create basic configuration to test the algorithm; I would say 2 lines for each entity.


![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/cbaa7201-bdcf-452b-9146-6ff871cf5e02)

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/fb2e179c-e621-4a7e-9b37-dbbce35434a2)

Then I can explain in more detail what is missing and so on... 

---

#### > Runtime of the algorithm

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/6752e05a-bde0-4486-aefd-01c9734be260)



