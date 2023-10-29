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
        stage('Build Docker Image') {
                    steps {
                        script {
                            // Build the Docker image
                            sh "docker build -t $DOCKER_IMAGE_NAME -f $DOCKERFILE_PATH ."
                        }
                    }
                }
    }
}