pipeline {
    agent any

    environment {
            DOCKER_REGISTRY_CREDENTIALS = credentials('Harbor')
            DOCKER_IMAGE_NAME = 'customer-edge'
            DOCKERFILE_PATH = '/Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge'
            BUILD_NUMBER = currentBuild.number.toString()
        }

    tools {
            maven 'Maven'
            jdk 'jdk17'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube analysis') {
           steps {
              sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=BankXP -Dsonar.projectName="Customer-Edge" -Dsonar.host.url=http://10.13.194.71:9001 -Dsonar.token=sqa_de75c641a2704a51be32122ad4d6c9763dd84508'
           }
        }
        stage('Build Docker Image') {
                    steps {
                        script {
                            // Build the Docker image
                            sh "docker build -t $DOCKER_IMAGE_NAME -f $DOCKERFILE_PATH ."
                        }
                    }
        }
        stage('Push Docker Image to Registry') {
                    steps {
                        script {
                            // Authenticate with your Docker registry
                            withDockerRegistry(credentialsId: DOCKER_REGISTRY_CREDENTIALS, url: "https://10.13.194.56") {
                                // Push the Docker image to the registry
                                sh "docker push $DOCKER_IMAGE_NAME"
                            }
                          }
                    }
        }
    }
}