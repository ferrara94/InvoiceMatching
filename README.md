# 🔍 Invoice Matching
## Overview

The tool helps detect discrepancies such as missing items, overcharges, or delivery errors — improving reliability in order fulfillment and billing processes.

This application ensures accuracy between the delivery note and the corresponding invoice by automatically comparing:

- ✅ Items delivered vs items invoiced
- 📦 Quantities received vs quantities billed
- 💰 Prices and totals (if applicable)

---

## ℹ️ General Info

> ⚠️ **Note:**  
> Although both the **Front-end** and **Back-end** of this project were developed, they are **not integrated** due to time constraints.  
> 🔧 Each component works **independently** and can be run separately.  
> 📌 Be sure to check the corresponding sections below for basic instructions, guidelines, and important notices.


----

## Invoice Matching - FE

### Angular FrontEnd

#### 📦 Node Modules

To run the application, make sure to install the required packages using the following command, executed in the directory where the `package.json` file is located:

```
  npm install
```

---

#### ▶️ Run Front-End

To start the Angular Single Page Application (SPA), use the following command in the directory where the `package.json` file is located:

```
  ng serve
```

---

## How the UI should look like

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/74408efe-f766-4ef9-b1a6-199b700409b1)

You can have a look at a running example (screen recording) [here](https://github.com/ferrara94/InvoiceMatching/commit/770cc9775b46df7e8bb5c9684b0fa238ad02a7d1#r141029919)

Note that data are hard-coded; I created manually data structure which contains data. 

---

## Invoice Matching - BE
Spring Boot back-end for invoice matching purposes.

#### ▶️ Run Back-End

The project includes a **Spring Boot** application called **invoice**, intended to provide **REST APIs, services, and data processing logic** for the front-end (note: it is not currently connected).

You can run the back-end service in several ways:

- [ ] right click on project + run as Spring Boot App
- [ ] by command line lunch: mvn spring-boot:run

---

## 🗄️ Persistence Layer

The project includes a `Docker` directory containing a `docker-compose.yml` file, which can be used to spin up a **PostgreSQL** instance for local development and testing.

For database access during development, I used **DBeaver** as the SQL client.

> 🧪 **Note:**  
> The default database schema used for testing is: **_your_schema_name_here_**  
> (Replace with the actual schema name if needed)

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/d113c5fc-356b-4128-b306-705a8c8f13f0)

---

## ⚠️ Disclaimer

The **REST controllers** created in this project do **not include full error handling** — for example, they don’t prevent **duplicate record creation** or handle **server-side exceptions** robustly.

> 🧪 These endpoints are intended primarily for **basic CRUD testing purposes**.

**Persistence Note:**  
For testing the algorithm, it's recommended to configure a **minimal database setup**, with around **2 entries per entity** to keep things simple and focused.


![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/cbaa7201-bdcf-452b-9146-6ff871cf5e02)

![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/fb2e179c-e621-4a7e-9b37-dbbce35434a2)

---

## Technologies Used

### Backend
- SpringBoot 3.2.4
- Spring Data JPA
- Openjdk 17.0.10 2024-01-16
- OpenJDK Runtime Environment (build 17.0.10+7-Ubuntu-118.04.1)
- OpenJDK 64-Bit Server VM (build 17.0.10+7-Ubuntu-118.04.1, mixed mode, sharing)
- Docker

### Frontend
- Angular CLI: **12.2.18**
- Angular: **12.2.17**
- Node: **12.22.12**
- Package Manager: **npm 6.14.16**

---

## 🧪 Runtime / Demo Example

To test the algorithm or simulate real scenarios, you can:

- **Run the algorithm manually** after initializing the database with test data (see Disclaimer section).
- **Use Postman** or any other API client to send example requests to the available endpoints.

> 💡 Consider creating a small **Postman collection** with sample requests to speed up testing and demonstration. You can just use the collection in this repo.

- Postman example
  
![image](https://github.com/ferrara94/InvoiceMatching/assets/45211249/6752e05a-bde0-4486-aefd-01c9734be260)



