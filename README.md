# 🚀 End-to-End Java CI/CD Pipeline with Jenkins & Docker

An end-to-end CI/CD project that automates the complete deployment lifecycle of a Java web application — from a developer's GitHub commit to production deployment.

The project uses **Jenkins, Maven, Docker, Docker Hub, Tomcat, GitHub, and Linux** to implement a multi-environment CI/CD workflow with separate **Development, QA, and Production environments**.

---

## 📌 Project Overview

The objective of this project is to build a practical CI/CD pipeline where a developer only needs to push code to GitHub.

After a code change is committed and pushed:

```text
Developer
    ↓
GitHub
    ↓
Jenkins Webhook
    ↓
Maven Build & Test
    ↓
Docker Image Build
    ↓
Docker Hub
    ↓
DEV Deployment
    ↓
QA Deployment
    ↓
QAT Testing
    ↓
Manual Production Approval
    ↓
PRODUCTION Deployment
```

The pipeline automates the application delivery process while keeping a manual approval gate before production deployment.

---

## 🏗️ Architecture

```text
                         ┌──────────────┐
                         │   Developer  │
                         └──────┬───────┘
                                │
                           Git Commit
                                │
                                ▼
                         ┌──────────────┐
                         │    GitHub    │
                         └──────┬───────┘
                                │
                             Webhook
                                │
                                ▼
                    ┌──────────────────────┐
                    │    Jenkins Master    │
                    │                      │
                    │     Jenkinsfile      │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   DEV Environment    │
                    │                      │
                    │ Maven Build          │
                    │ Docker Build         │
                    │ Tomcat Container     │
                    └──────────┬───────────┘
                               │
                         Push Image
                               │
                               ▼
                    ┌──────────────────────┐
                    │      Docker Hub      │
                    │                      │
                    │ Versioned Images     │
                    │ v1 / v2 / v3 / ...   │
                    │                      │
                    │ Old versions kept    │
                    └──────────┬───────────┘
                               │
                          Pull Image
                               │
                               ▼
                    ┌──────────────────────┐
                    │    QA Environment    │
                    │                      │
                    │ Docker + Tomcat      │
                    │ QAT Testing          │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   Manual Approval    │
                    │                      │
                    │ Deploy to Production?│
                    └──────────┬───────────┘
                               │
                         APPROVED / YES
                               │
                               ▼
                    ┌──────────────────────┐
                    │ Production Environment│
                    │                      │
                    │ Docker + Tomcat      │
                    │ Approved Image       │
                    └──────────────────────┘
```

---

## 🔄 CI/CD Pipeline Workflow

### 1. Developer Push

A developer makes changes to the Java application and pushes the changes to GitHub.

```text
Developer → GitHub
```

The GitHub webhook automatically triggers the Jenkins pipeline.

---

### 2. Jenkins Pipeline

Jenkins receives the webhook and starts the pipeline defined in the `Jenkinsfile`.

The pipeline performs the required build, testing, Docker image creation, publishing, and deployment stages.

---

### 3. Maven Build

The Java application is built using Maven.

```bash
mvn clean package
```

The application package is generated for deployment.

---

### 4. Docker Image Creation

After the Maven build, Jenkins automatically builds a Docker image using the project's Dockerfile.

```bash
docker build
```

The Java application is packaged into a Docker container environment with Tomcat.

---

### 5. Docker Hub Push

Jenkins automatically pushes the generated Docker image to Docker Hub.

Images are automatically versioned instead of continuously overwriting a single image.

Example:

```text
myapp:1
myapp:2
myapp:3
myapp:4
```

Previous versions remain available for traceability and potential rollback.

---

### 6. DEV Deployment

The application is automatically deployed to the dedicated Development environment.

The application runs inside a Docker container using Tomcat.

```text
Docker Container
      ↓
Tomcat
      ↓
Java Application
```

---

### 7. QA Deployment

After the Dev deployment, the application is deployed to the separate QA environment.

The required Docker image is pulled and deployed using Docker and Tomcat.

The QA environment is used for QAT testing before production release.

---

### 8. Production Approval

After QA, the pipeline pauses at a manual approval stage.

```text
Deploy to Production?

       YES
        ↓
   Production

       NO
        ↓
 Pipeline Stops
```

This provides a release control before production deployment.

---

### 9. Production Deployment

After approval, Jenkins automatically continues the pipeline.

The approved/versioned Docker image is deployed to the Production environment running on a separate Linux host.

The Java application is then available through the production Tomcat container.

---

## 🐳 Docker Image Versioning

One of the important parts of this project is automated Docker image versioning.

For example:

```text
Version 1 → myapp:1
Version 2 → myapp:2
Version 3 → myapp:3
Version 4 → myapp:4
```

Older images are retained instead of being replaced.

This provides:

* Version traceability
* Identification of deployed releases
* Previous image availability
* Easier rollback to a previous version

---

## 🌍 Multi-Environment Deployment

The project uses separate Linux environments for:

| Environment | Purpose                            |
| ----------- | ---------------------------------- |
| DEV         | Application development/deployment |
| QA          | QAT testing                        |
| PROD        | Final production deployment        |

The application is promoted through the environments in sequence:

```text
DEV → QA → Approval → PROD
```

---

## 🛠️ Technologies Used

* **Jenkins** — CI/CD automation
* **Jenkinsfile** — Pipeline as code
* **Git** — Version control
* **GitHub** — Source code repository and webhook
* **Maven** — Java build and testing
* **Docker** — Containerization
* **Docker Hub** — Docker image repository
* **Tomcat** — Java web application server
* **Linux** — Deployment environments

---

## ⭐ Key Features

* Automated CI/CD pipeline
* GitHub webhook integration
* Jenkins pipeline automation
* Maven build and testing
* Automated Docker image creation
* Automated Docker Hub publishing
* Automated image versioning
* Previous Docker image versions retained
* Separate Dev, QA, and Production environments
* Dockerized Tomcat deployment
* QA testing stage
* Manual production approval gate
* Automated production deployment
* Multi-server Linux deployment architecture

---

## 📂 Project Structure

```text
.
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── src/
└── README.md
```

---

## 🚀 Pipeline Flow

```text
Code Change
     ↓
GitHub Push
     ↓
Jenkins Webhook
     ↓
SCM Checkout
     ↓
Maven Build & Test
     ↓
Docker Image Build
     ↓
Docker Hub Push
     ↓
DEV Deployment
     ↓
QA Deployment
     ↓
QAT Testing
     ↓
Manual Approval
     ↓
Production Deployment
```

---



## 🎯 What I Learned

Through this project, I gained practical experience in:

* Designing an end-to-end CI/CD workflow
* Jenkins pipeline development using Jenkinsfile
* Automating Java application builds with Maven
* Containerizing applications with Docker
* Publishing and versioning Docker images
* Managing multiple deployment environments
* Implementing a production approval gate
* Automating production deployments
* Understanding release promotion from Dev → QA → Production
* Working with Linux-based deployment environments

---

## 👨‍💻 Author

**Hemant Saini**

Aspiring DevOps Engineer
