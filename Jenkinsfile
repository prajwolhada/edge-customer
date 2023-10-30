pipeline {
    agent any

    tools {
            maven 'Maven'
            jdk 'jdk17'
        }

    environment {
           IMAGE_NAME = 'dev-registry.f1soft.com/customer-edge'
           BUILD_NUMBER = currentBuild.number.toString()
           REGISTRY_CREDENTIAL_ID = 'bankxp-harbor-credential'
           REGISTRY_URL = 'https://dev-registry.f1soft.com'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Build Image') {
                    steps {
                        script {
                            sh 'cp /Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile /Users/f1-imac/.jenkins/workspace/customer-edge/target'
                            sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} -f target/Dockerfile /Users/f1-imac/.jenkins/workspace/customer-edge/target/"
                        }
                    }
                }

        stage('Push Image') {
                    steps {
                        script {
                            withCredentials([usernamePassword(credentialsId: ${REGISTRY_CREDENTIAL_ID}, passwordVariable: DOCKER_REGISTRY_PASSWORD, usernameVariable: DOCKER_REGISTRY_USERNAME)]) {
                                sh "docker login -u ${DOCKER_REGISTRY_USERNAME} -p ${DOCKER_REGISTRY_PASSWORD} ${REGISTRY_URL}"

                                // Push the Docker image to the registry
                                sh "docker push ${IMAGE_NAME}:${BUILD_NUMBER}"
                            }
                        }
                    }
                }
    }
}