pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                echo '📦 A arquivar o pacote gerado...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build concluído com sucesso!'
        }
        failure {
            echo '❌ O build falhou.'
        }
    }
}
