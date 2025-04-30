pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      parallel {
        stage('Git Checkout') {
          steps {
            git 'https://github.com/ilayarajac515/Dev.git'
          }
        }

        stage('') {
          steps {
            echo 'bye'
          }
        }

      }
    }

    stage('Maven Build') {
      parallel {
        stage('Maven Build') {
          steps {
            sh 'mvn clean compile'
          }
        }

        stage('') {
          steps {
            echo 'poda bunda'
          }
        }

      }
    }

    stage('Maven Test') {
      steps {
        sh 'mvn test'
        sh 'mvn package'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        script {
          withSonarQubeEnv('sonar-scanner') {
            sh 'mvn sonar:sonar -Dsonar.projectKey=Dev'
          }
        }

      }
    }

    stage('Build Docker Image') {
      steps {
        script {
          sh 'docker build -t lateshipment .'
        }

      }
    }

    stage('Docker Login') {
      steps {
        script {
          withCredentials([usernamePassword(credentialsId: 'docker-cred1', usernameVariable: '${DOCKER_USER}', passwordVariable: '${DOCKER_PASS}')]) {
            sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
          }
        }

      }
    }

    stage('Docker Push') {
      steps {
        script {
          sh 'docker tag lateshipment:latest ${DOCKER_USER}/lateshipment:latest'
          sh 'docker push ${DOCKER_USER}/lateshipment:latest'
        }

      }
    }

    stage('Kubernetes deploy') {
      steps {
        script {
          withCredentials([file(credentialsId: 'kube-config', variable: 'KUBECONFIG')]) {
            sh 'kubectl apply -f deployment.yaml --kubeconfig=$KUBECONFIG'
            sh 'kubectl apply -f service.yaml --kubeconfig=$KUBECONFIG'
          }
        }

      }
    }

  }
  environment {
    DOCKER_USER = 'YOUR-DOCKER-USER'
    DOCKER_PASS = 'YOUR-DOCKER-PASS'
    SCANNER_HOME = 'sonar-scanner'
  }
  post {
    success {
      echo 'Build, Docker Image Push, and Kubernetes Deployment Successful!'
    }

    failure {
      echo 'Pipeline Failed!'
    }

  }
  triggers {
    githubPush()
  }
}