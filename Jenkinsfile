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
              sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=BankXP -Dsonar.projectName='Customer-Edge' -Dsonar.host.url=http://10.13.194.71:9001 -Dsonar.token=sqa_de75c641a2704a51be32122ad4d6c9763dd84508'
           }
    }
}