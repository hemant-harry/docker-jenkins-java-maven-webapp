pipeline {
    
    agent {
        label "slave-node-1"
    }
    
    stages {
        stage('SCM') {
            steps {
                git 'https://github.com/hemant-harry/docker-jenkins-java-maven-webapp.git'
            }
        }
        stage('Deploy Step'){
            steps {
               sh 'mvn clean package'
            }
        }
        stage('Build Own Image') {
            steps {
                sh "sudo docker build -t sainihemant14/java-maven-app:${BUILD_NUMBER} ."
            }
            
        }
        
         stage('Push Image to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'hub-docker-passwd', variable: 'docker_hub_password')]) {
              sh "sudo docker login -u sainihemant14 -p ${docker_hub_password}"
}
            sh "sudo docker push sainihemant14/java-maven-app:${BUILD_NUMBER}"
                
               
           
            }
        }
        
        
        
        stage('Deploy to Dev Env') {
            steps{
                sh 'sudo docker rm -f javaapp'
                sh 'sudo docker run -d --name javaapp -p 8080:8080 sainihemant14/java-maven-app:${BUILD_NUMBER}'
            }
        }
        
        stage('Deploy to QA/Testing Env') {
            steps {
               sshagent(credentials: ['QA_ENV_KEY_SSH'], executable: '') {
           
           sh "ssh -o StrictHostKeyChecking=no ec2-user@3.221.155.0 sudo docker rm -f javaapp"
           sh "ssh ec2-user@3.221.155.0 sudo docker run -d --name javaapp -p 8080:8080 sainihemant14/java-maven-app:${BUILD_NUMBER}"
         
          }
            }
        }
        stage('QA/Testing...'){
            steps {
                retry(10) {
                sh 'curl -s http://34.228.21.201:8080/java-web-app/ | grep Jenkins'
            
                }
                }
        }
        
        stage('Approval'){
            steps {
                input(message: "Do You Want to Deploy on  Production..")
            }
        }
        
        stage('Deploy to Production') {
            steps {
                sshagent(credentials: ['QA_ENV_KEY_SSH'], executable: '') {
           
           sh "ssh -o StrictHostKeyChecking=no ec2-user@100.48.193.202 sudo docker rm -f javaapp"
           sh "ssh ec2-user@100.48.193.202 sudo docker run -d --name javaapp -p 8080:8080 sainihemant14/java-maven-app:${BUILD_NUMBER}"
         
          }
                
                
                
            }
        }
        
    }
    
    
    
}
