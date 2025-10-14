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
        bat '''
        powershell -Command "if (!(Test-Path 'C:\\Services\\EasyTasks')) { New-Item -ItemType Directory -Path 'C:\\Services\\EasyTasks' }; Copy-Item -Path target\\*.jar -Destination C:\\Services\\EasyTasks\\easytasks.jar -Force"
        '''
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
