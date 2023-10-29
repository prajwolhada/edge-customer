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
        stage('Build and Push Docker Image') {
                    steps {
                        script {
                            def registryUrl=

                            // Define your Docker image name and tag
                            def dockerImageName = 'customer-edge'
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