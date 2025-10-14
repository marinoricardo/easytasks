pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME' // mesmo nome configurado no Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                echo '📦 A arquivar o pacote gerado...'
                // Copiar o .jar gerado para C:\Services\EasyTasks
                bat 'copy /Y target\\*.jar C:\\Services\\EasyTasks\\easytasks.jar'
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
