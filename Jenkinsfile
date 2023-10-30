pipeline {
    agent any
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
        stage('Build Image') {
                    steps {
                        script {
                            sh 'cp /Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile /Users/f1-imac/.jenkins/workspace/customer-edge/target'
                            sh 'docker build -t your-docker-image-name:tag -f target/Dockerfile /Users/f1-imac/.jenkins/workspace/customer-edge/target/'
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