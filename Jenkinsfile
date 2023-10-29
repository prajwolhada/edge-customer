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
            dockerTool 'Docker'
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
                            docker build -t your-docker-image-name:tag -f /Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile .
                        }
                    }
                }

        stage('Push') {
                    steps {
                        script {
                            docker.withRegistry('https://your-registry-url', 'your-registry-credentials') {
                                dockerImage.push()
                            }
                        }
                    }
                }
    }
}