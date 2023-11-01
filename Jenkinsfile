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

        stage('Unit Test') {
             steps {
                        sh 'mvn test'
             }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
             }

        stage('SonarQube Analysis') {
             steps {
                      sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=BankXP -Dsonar.projectName="Customer-Edge" -Dsonar.host.url=http://10.13.194.71:9001 -Dsonar.token=sqa_de75c641a2704a51be32122ad4d6c9763dd84508'
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
                            withCredentials([usernamePassword(credentialsId: "${REGISTRY_CREDENTIAL_ID}", passwordVariable: 'DOCKER_REGISTRY_PASSWORD', usernameVariable: 'DOCKER_REGISTRY_USERNAME')]) {
                                sh "docker login -u ${DOCKER_REGISTRY_USERNAME} -p ${DOCKER_REGISTRY_PASSWORD} ${REGISTRY_URL}"

                                // Push the Docker image to the registry
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