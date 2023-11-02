pipeline {
    agent any

    tools {
            maven 'Maven'
            jdk 'jdk17'
        }

    environment {
           IMAGE_NAME = 'dev-registry.f1soft.com/bankxp/customer-edge'
           BUILD_NUMBER = currentBuild.number.toString()
           REGISTRY_CREDENTIAL_ID = 'bankxp-harbor-credential'
           REGISTRY_URL = 'https://dev-registry.f1soft.com'
           DOCKER_FILE = '/Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile'
           JAR_FILE_DIRECTORY = '/Users/f1-imac/.jenkins/workspace/edge-customer/target'
           WORKLOAD_NAME = '/project/c-rlmgg:p-8dfsf/workload/deployment:bankxp-namespace:edge-customer'
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
                            sh "cp ${DOCKER_FILE} ${JAR_FILE_DIRECTORY}"
                            sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} -f target/Dockerfile ${JAR_FILE_DIRECTORY}"
                        }
                    }
        }

        stage('Push Image') {
               steps {
                        script {
                            withCredentials([string(credentialsId: 'bankxp-harbor-credential', variable: 'SECRET_TEXT')]) {
                                                            sh "docker login -u _ -p ${SECRET_TEXT} ${REGISTRY_URL}"
                            								sh "docker push ${IMAGE_NAME}:${BUILD_NUMBER}"
                               }
                        }
                    }
                }
        stage('Deploy To Rancher') {
                steps {
                        script {
                             deployToRancher("${IMAGE_NAME}:${BUILD_NUMBER}", "${WORKLOAD_NAME}")
                               }
                }
        }
    }
}

def deployToRancher(image, workload) {
    rancherRedeploy alwaysPull: true, credential: "bankxp-rancher", images: image, workload: workload
}