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
        stage('Build and Push Docker Image') {
                    steps {
                        script {
                            def registryUrl=

                            // Define your Docker image name and tag
                            def dockerImageName = 'your-docker-image:latest'
                            def tag = currentBuild.number
                            def dockerImage = dockerImageName + ':' + 'tag'

                            // Build the Docker image
                            docker.build(dockerImage, '-f /Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile .')

                            // Tag the image with the registry URL and desired tag
                            def registryImage = "http://10.13.194.56/" + dockerImage
                            docker.image(dockerImage).push(registryImage)
                        }
                    }
                }
    }
}