pipeline {
    agent any
    triggers {
      githubPush()
   }
    environment {
        DOCKER_IMAGE_NAME = 'calculator2'
        GITHUB_REPO_URL = 'https://github.com/rinkupareta/SPE-Mini-Project.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }
        stage('Execute test cases') {
            steps {
                script {
                    sh 'mvn clean test'
                }
            }
        }

        stage('Build pulled code') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', '9ff341d3-3602-49bd-89e3-9a3f0eb6d030') {
                    sh 'docker tag calculator2 rinkupareta/calculator2:latest'
                    sh 'docker push rinkupareta/calculator2'
                    }
                 }
            }
        }

    stage('Run Ansible Playbook') {
        steps {
            script {
            withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {
                ansiblePlaybook(
                    playbook: 'deploy.yml',
                    inventory: 'inventory'
                )
            }
        }
    }
    }
}
 post {
        always {
            cleanWs()
        }
      }
    }
