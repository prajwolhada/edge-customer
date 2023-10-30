pipeline {
    agent any
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
                            sh 'docker build -t testbankxp1 --file=/Users/f1-imac/jenkins_home/bankxp/harbor-java17/harbor-customer-edge/Dockerfile /Users/f1-imac/jenkins_home/workspace/customer-edge-pipeline
'
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