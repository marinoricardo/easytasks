pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }

    environment {
        SERVICE_NAME = 'EasyTasks'
        SERVICE_PATH = 'C:\\Services\\EasyTasks'
        NSSM_PATH = 'C:\\Services\\nssm.exe'
        BACKUP_PATH = 'C:\\Services\\EasyTasks\\backup'
    }

    stages {
        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo '📦 Deploy iniciado...'

                // Criar pasta de backup se não existir
                bat """
                powershell -Command "if (!(Test-Path '${BACKUP_PATH}')) { New-Item -ItemType Directory -Path '${BACKUP_PATH}' }"
                """

                // Backup do jar antigo com timestamp
                bat """
                powershell -Command "\$date = Get-Date -Format 'yyyyMMdd_HHmmss'; Copy-Item -Path '${SERVICE_PATH}\\\\easytasks.jar' -Destination '${BACKUP_PATH}\\\\easytasks_\$date.jar' -Force"
                """

                // Parar serviço
                bat "'${NSSM_PATH}' stop '${SERVICE_NAME}'"

                // Copiar novo jar
                bat "powershell -Command \"Copy-Item -Path 'target\\\\*.jar' -Destination '${SERVICE_PATH}\\\\easytasks.jar' -Force\""

                // Reiniciar serviço
                bat "'${NSSM_PATH}' start '${SERVICE_NAME}'"
            }
        }
    }

    post {
        success {
            echo '✅ Build e deploy concluídos com sucesso!'
        }
        failure {
            echo '❌ O build ou deploy falhou.'
        }
    }
}
