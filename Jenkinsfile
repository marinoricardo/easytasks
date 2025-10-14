pipeline {
    agent any

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
