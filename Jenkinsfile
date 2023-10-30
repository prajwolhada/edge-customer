pipeline {
    agent any
    tools {
            maven 'maven-3.8.8'
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
                            sh 'cp /var/jenkins_home/bankxp/harbor-java17/harbor-customer-edge/Dockerfile /var/jenkins_home/workspace/pipeline/target'
                            sh 'docker build -t your-docker-image-name:tag -f target/Dockerfile /var/jenkins_home/workspace/pipeline/target/'
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