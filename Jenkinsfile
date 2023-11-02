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
                            sh 'cp /Users/f1-imac/bankxp/harbor-java17/harbor-customer-edge/Dockerfile /Users/f1-imac/.jenkins/workspace/edge-customer/target'
                            sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} -f target/Dockerfile /Users/f1-imac/.jenkins/workspace/edge-customer/target/"
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